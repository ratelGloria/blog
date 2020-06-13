package com.example.demo.controller;


import com.example.demo.pojo.Item;
import com.example.demo.service.ItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.validation.beanvalidation.SpringConstraintValidatorFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ItemController {


    @Autowired
    private ItemService itemService;

    @GetMapping(value = "/item/{id}")
    public Item getItemById(@PathVariable(value = "id",required = false) Integer id){
int[] a = new int[]{2,3};
         return itemService.getItem(id);
    }

}
