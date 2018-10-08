package com.auvgo.consumer;

import com.auvgo.api.DemoService;
import com.auvgo.api.UserService;
import com.auvgo.entity.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.List;

public class ConsumerApp {
    final static Logger logger = LoggerFactory.getLogger(ConsumerApp.class);
    /**
     * To get ipv6 address to work, add
     * System.setProperty("java.net.preferIPv6Addresses", "true");
     * before running your application.
     */
    public static void main(String[] args) throws Exception {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext(new String[]{"META-INF/spring/dubbo-consumer.xml", "application-context.xml"});
//        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext(new String[]{"application-context.xml"});
        context.start();

        UserService userService = (UserService) context.getBean("userService"); // get remote service proxy


        try {
            List<User> users = null;
            users = userService.getUsers();
            if (users != null)
                users.forEach(user -> System.out.println(user.getId() + "," + user.getUsername() + "," + user.getAddress()));
            else
                System.out.println("user list is null");

            User u = userService.getUser(1);
            System.out.println(u.toString());

//            userService.addUser(user);
//            user.setId(51);
//            user.setUsername("new name");
//            userService.updateUser(user);

//            userService.delUser(user);
        } catch (Exception ex) {
            System.out.println(ex.toString());
        }


        System.in.read(); // press any key to exit

    }
}
