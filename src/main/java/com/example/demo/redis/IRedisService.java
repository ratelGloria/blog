package com.example.demo.redis;

import java.util.Map;

public interface IRedisService {

    void setValue(String key, Map<String,Object> value);

    void setValue(String key,String value);

    void setValue(String key,Object value);

    Object getMapValue(String key);

    Object getValue(String key);


    void setValueString(String key, String value);

    Object getValueString(String key);
}
