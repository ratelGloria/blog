package com.example.demo.redis;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.stereotype.Service;

import java.util.Map;
import java.util.concurrent.TimeUnit;

@Service
public class IRedisServiceImp implements IRedisService {

    @Autowired
    private StringRedisTemplate stringRedisTemplate;

    @Autowired
    private RedisTemplate redisTemplate;



    @Override
    public void setValue(String key, Map<String, Object> value) {
        ValueOperations valueOperations = redisTemplate.opsForValue();
        valueOperations.set(key,value);
//        redisTemplate.expire(key,1, TimeUnit.HOURS);
    }

    @Override
    public void setValue(String key, String value) {
        ValueOperations valueOperations = redisTemplate.opsForValue();
        valueOperations.set(key,value);
//        redisTemplate.expire(key,1, TimeUnit.HOURS);

    }

    @Override
    public void setValue(String key, Object value) {
        ValueOperations valueOperations = redisTemplate.opsForValue();
        valueOperations.set(key,value);
//        redisTemplate.expire(key,1, TimeUnit.HOURS);
    }

    @Override
    public Object getMapValue(String key) {
        ValueOperations valueOperations = redisTemplate.opsForValue();
        return valueOperations.get(key);
    }

    @Override
    public Object getValue(String key) {
        ValueOperations valueOperations = redisTemplate.opsForValue();
        return valueOperations.get(key);
    }
}
