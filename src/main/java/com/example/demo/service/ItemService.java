package com.example.demo.service;

import com.example.demo.pojo.Item;
import javafx.scene.input.DataFormat;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.sql.Date;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.HashMap;

@Service
public class ItemService {


//    @Autowired
//    private Item item;

    public static final HashMap<Integer,Item> MAP = new HashMap<Integer,Item>();

//    public static Date d = new Date();

    static{
        Date date = new Date(123456789);
        MAP.put(1,new Item(1,"商品1", BigDecimal.valueOf(10.00), date));
        MAP.put(2,new Item(2,"商品2", BigDecimal.valueOf(20.00), date));
        MAP.put(3,new Item(3,"商品3", BigDecimal.valueOf(30.00), date));
        MAP.put(4,new Item(4,"商品4", BigDecimal.valueOf(40.00), date));
        MAP.put(5,new Item(5,"商品5", BigDecimal.valueOf(50.00), date));
    }

    public Item getItem(Integer id){

        return MAP.get(id);

    }

}
