package com.example.demo.pojo;

import java.util.Date;

public class Blogs {
    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column blogs.id
     *
     * @mbggenerated
     */
    private Integer id;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column blogs.titile
     *
     * @mbggenerated
     */
    private String titile;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column blogs.create_time
     *
     * @mbggenerated
     */
    private Date createTime;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column blogs.update_time
     *
     * @mbggenerated
     */
    private Date updateTime;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column blogs.author
     *
     * @mbggenerated
     */
    private String author;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column blogs.if_deleted
     *
     * @mbggenerated
     */
    private String ifDeleted;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column blogs.content
     *
     * @mbggenerated
     */
    private String content;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column blogs.id
     *
     * @return the value of blogs.id
     *
     * @mbggenerated
     */
    public Integer getId() {
        return id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column blogs.id
     *
     * @param id the value for blogs.id
     *
     * @mbggenerated
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column blogs.titile
     *
     * @return the value of blogs.titile
     *
     * @mbggenerated
     */
    public String getTitile() {
        return titile;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column blogs.titile
     *
     * @param titile the value for blogs.titile
     *
     * @mbggenerated
     */
    public void setTitile(String titile) {
        this.titile = titile == null ? null : titile.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column blogs.create_time
     *
     * @return the value of blogs.create_time
     *
     * @mbggenerated
     */
    public Date getCreateTime() {
        return createTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column blogs.create_time
     *
     * @param createTime the value for blogs.create_time
     *
     * @mbggenerated
     */
    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column blogs.update_time
     *
     * @return the value of blogs.update_time
     *
     * @mbggenerated
     */
    public Date getUpdateTime() {
        return updateTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column blogs.update_time
     *
     * @param updateTime the value for blogs.update_time
     *
     * @mbggenerated
     */
    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column blogs.author
     *
     * @return the value of blogs.author
     *
     * @mbggenerated
     */
    public String getAuthor() {
        return author;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column blogs.author
     *
     * @param author the value for blogs.author
     *
     * @mbggenerated
     */
    public void setAuthor(String author) {
        this.author = author == null ? null : author.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column blogs.if_deleted
     *
     * @return the value of blogs.if_deleted
     *
     * @mbggenerated
     */
    public String getIfDeleted() {
        return ifDeleted;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column blogs.if_deleted
     *
     * @param ifDeleted the value for blogs.if_deleted
     *
     * @mbggenerated
     */
    public void setIfDeleted(String ifDeleted) {
        this.ifDeleted = ifDeleted == null ? null : ifDeleted.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column blogs.content
     *
     * @return the value of blogs.content
     *
     * @mbggenerated
     */
    public String getContent() {
        return content;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column blogs.content
     *
     * @param content the value for blogs.content
     *
     * @mbggenerated
     */
    public void setContent(String content) {
        this.content = content == null ? null : content.trim();
    }
}