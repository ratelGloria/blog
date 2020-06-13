package com.example.demo.pojo;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.sql.Date;

@ComponentScan
public class Item {

    private int id;

    private String name;

    private BigDecimal price;

    private Date create_time;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public Date getCreate_time() {
        return create_time;
    }

    public void setCreate_time(Date create_time) {
        this.create_time = create_time;
    }

    public Item(int id, String name, BigDecimal price, Date create_time) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.create_time = create_time;
    }

    public Item() {

    }
}
