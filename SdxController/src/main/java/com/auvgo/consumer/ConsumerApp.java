package com.auvgo.consumer;

import com.auvgo.api.DemoService;
import com.auvgo.api.UserService;
import com.auvgo.entity.User;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.List;

public class ConsumerApp {
    /**
     * To get ipv6 address to work, add
     * System.setProperty("java.net.preferIPv6Addresses", "true");
     * before running your application.
     */
    public static void main(String[] args) {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext(new String[]{"META-INF/spring/dubbo-consumer.xml"});
        context.start();

        UserService userService = (UserService) context.getBean("userService"); // get remote service proxy
        DemoService demoService = (DemoService) context.getBean("demoService");

        demoService.setValue("UserName", "ConsumerApp");
        Object value = demoService.getValue("UserName");
        System.out.println(value);

        try {
            List<User> users = null;
            users = userService.getUsers();
            if (users != null)
                users.forEach(user -> System.out.println(user.getId() + "," + user.getUsername() + "," + user.getAddress()));
            else
                System.out.println("user list is null");
            User user = new User();
            user.setSex("1");
            user.setAddress("SH");
            user.setUsername("BB");
//            userService.addUser(user);
            user.setId(51);
//            user.setUsername("new name");
//            userService.updateUser(user);

            userService.delUser(user);
        } catch (Exception ex) {
            System.out.println(ex.toString());
        }


    }
}
