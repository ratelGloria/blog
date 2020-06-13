package com.example.demo.dao;

import com.example.demo.pojo.Blogs;
import org.apache.ibatis.annotations.Mapper;


import java.util.List;

@Mapper
public interface BlogsMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table blogs
     *
     * @mbggenerated
     */
    int insert(Blogs record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table blogs
     *
     * @mbggenerated
     */
    List<Blogs> selectAll();

    int addMessage(Blogs blogs);
}