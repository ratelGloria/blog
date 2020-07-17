package com.example.demo.redis;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.PropertyAccessor;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.aspectj.lang.annotation.Before;
import org.springframework.cache.CacheManager;
import org.springframework.cache.annotation.CachingConfigurerSupport;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.cache.RedisCacheManager;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.data.redis.serializer.Jackson2JsonRedisSerializer;
import org.springframework.data.redis.serializer.StringRedisSerializer;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.web.multipart.MultipartResolver;
import org.springframework.web.multipart.commons.CommonsMultipartResolver;

/**
 * @Configuration 用于定义配置类，可替换xml配置文件，被注解的内部包含有一个或多有被@Bean注解的方法，
 * 这些方法将被AnntationConfigApplicationContext或AnnontationConfigWebApplication类进行扫描，并用于构建bean定义，初始化Spring容器
 * 1.@Comfoguration不能是final类型
 * 2.@Configuration不能是匿名类
 * 3.嵌套的Configuration必须是静态类
 */

@Configuration
@EnableScheduling
public class RedisConfig extends CachingConfigurerSupport {
    /**
     * 选择redis作为默认缓存工具
     * @param redisTemplate
     * @return
    * */

//    public CacheManager cacheManager(RedisTemplate redisTemplate){
//        RedisCacheManager redisCacheManager = new RedisCacheManager();
//        return redisCacheManager;
//    }

    /**
     * retemplate相关配置
     * @param factory
     * @return
     * 这个地方是关键，如果不写依旧会报找不到redistemplate，写上之后就可以正常跑了，具体明天再看，今天有点晚了
     *
     * 2020.07.01 啊，继续昨天的写，这个Factory是用来创建链接的，比如之前的mysql创建数据库链接也是用Factory
     * 比较好记的解释就是Redis连接工厂会生成到Redis数据库服务器的连接
     */
    @Bean
    public RedisTemplate<String, Object> redisTemplate(RedisConnectionFactory factory) {

        RedisTemplate<String, Object> template = new RedisTemplate<>();
        // 配置连接工厂
        template.setConnectionFactory(factory);

        //使用Jackson2JsonRedisSerializer来序列化和反序列化redis的value值（默认使用JDK的序列化方式）
        Jackson2JsonRedisSerializer jacksonSeial = new Jackson2JsonRedisSerializer(Object.class);

        ObjectMapper om = new ObjectMapper();
        // 指定要序列化的域，field,get和set,以及修饰符范围，ANY是都有包括private和public
        om.setVisibility(PropertyAccessor.ALL, JsonAutoDetect.Visibility.ANY);
        // 指定序列化输入的类型，类必须是非final修饰的，final修饰的类，比如String,Integer等会跑出异常
        om.enableDefaultTyping(ObjectMapper.DefaultTyping.NON_FINAL);
        jacksonSeial.setObjectMapper(om);

        // 值采用json序列化
        template.setValueSerializer(jacksonSeial);
        //使用StringRedisSerializer来序列化和反序列化redis的key值
        template.setKeySerializer(new StringRedisSerializer());

        // 设置hash key 和value序列化模式
        template.setHashKeySerializer(new StringRedisSerializer());
        template.setHashValueSerializer(jacksonSeial);
        template.afterPropertiesSet();

        return template;
    }

    @Bean
    public ValueOperations<String,Object> valueOperations(RedisTemplate<String,Object> redisTemplate){
        return redisTemplate.opsForValue();
    }


    @Bean(name = "multipartResolver")
     public MultipartResolver multipartResolver(){
 CommonsMultipartResolver resolver = new CommonsMultipartResolver();
 // resolver.setDefaultEncoding("UTF-8");  
 // resolver.setResolveLazily(true);// resolveLazily属性启用是为了推迟文件解析，以在在UploadAction中捕获文件大小异常  
 // resolver.setMaxInMemorySize(40960);  
 resolver.setMaxUploadSize(10 * 1024 * 1024);// 上传文件大小 5M 5*1024*1024  
  return resolver;
 }

}
