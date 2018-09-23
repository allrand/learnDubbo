package com.auvgo.provider.Service.Impl;

import com.auvgo.api.DemoService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
public class DemoServiceImpl implements DemoService {
    private final Logger logger = LoggerFactory.getLogger(getClass());

    private Map<String, Object> kvmap = new HashMap<String, Object>();

    @Override
    public Object getValue(String key) {
        logger.info("key: {}", key);
        if (key == null || key.equals(""))
            throw new IllegalArgumentException("key is null!");

        return kvmap.get(key);

    }
    @Override
    public void setValue(String key, Object value) {
        logger.info("key: {} value: {}", key, value);
        if (key == null || key.equals(""))
            throw new IllegalArgumentException("key is null!");
        if (value == null)
            throw new IllegalArgumentException("value is null!");

        kvmap.put(key, value);
    }
    @Override
    public void delValue(String key) {

    }
    @Override
    public void updateValue(String key, Object value) {

    }
}
