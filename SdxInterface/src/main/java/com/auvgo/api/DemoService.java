package com.auvgo.api;

public interface DemoService {
    Object getValue(String key);
    void setValue(String key, Object value);
    void delValue(String key);
    void updateValue(String key, Object value);
}
