package com.auvgo.provider;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class ProviderApp {
    public static void main(String[] args) throws Exception {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext(new String[]{"META-INF/spring/dubbo-provider.xml","application-context.xml"});
        context.start();
        System.in.read();
    }
}
