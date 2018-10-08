package com.auvgo.consumer.controller;

import com.auvgo.api.UserService;
import com.auvgo.consumer.entity.LayuiResult;
import com.auvgo.entity.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.util.Collections;
import java.util.List;


@Controller
@RequestMapping("/user")
public class ListController {
    private final Logger logger = LoggerFactory.getLogger(getClass());

    @Autowired
    private UserService userService;

    @RequestMapping("/list")
    public String getlist(Model model) {

        return "list";
    }

    @RequestMapping("/listdata")
    @ResponseBody
    public LayuiResult<User> getUsers(Integer page, Integer limit, User user) {
        LayuiResult<User> result = new LayuiResult<>();
        List<User> users = userService.getUsers();

        logger.info("getUsers page:{} user:{} ", page, user.toString());
        if (user.getId() != null && user.getId() > 0) {
            User u = userService.getUser(user.getId());
            logger.info("u info: {}", u);
            result.setData(Collections.singletonList(u));
        } else {
            result.setData(users);
        }

        logger.info(result.toString());
        return result;
    }

    @RequestMapping(value = "/add", method = RequestMethod.GET)
    public String add() {
        return "add";
    }

    /**
     * 1, consumes = "application/json"
     * @RequestMapping(method = RequestMethod.POST, produces = "application/json", value = "/register")
     * public Map<String, String> register(Model uiModel,
     *   @RequestBody User user,
     *   HttpServletRequest httpServletRequest)
     * @param user
     * @return
     */
    @RequestMapping(value = "/adduser", method = RequestMethod.POST, produces = "application/json")
    @ResponseBody
    public LayuiResult<User> addUser(@RequestBody User user) {//RequestBody->RequestParam
        LayuiResult result = new LayuiResult<>();
        logger.info("addUser user:{} ", user.toString());
        if (user.getUsername() == null){
            result.setMsg("参数错误");
            result.setCode(500);
            return result;
        }

        userService.addUser(user);

        List<User> users = userService.getUsers();
        result.setData(users);
        result.setCode(0);
        result.setMsg("添加成功");
        return result;
    }
    @RequestMapping(value = "/edit", method = RequestMethod.GET)
    public String edit() {
        return "edit";
    }

    @RequestMapping("/modify")
    @ResponseBody
    public LayuiResult<User> modifyUser(Integer page, Integer limit, User user) throws UnsupportedEncodingException {
        LayuiResult<User> result = new LayuiResult<>();
        logger.info("modifyuser page:{} user:{} ", page, user.toString());
        if (user == null || user.getId() == null) {
            logger.error("param user is null.");
            result.setCode(500);
            result.setMsg("参数错误");
            return result;
        }
        user.setUsername(URLDecoder.decode(user.getUsername(), "UTF-8"));
        user.setAddress(URLDecoder.decode(user.getAddress(), "UTF-8"));
        userService.updateUser(user);
        result.setCode(0);
        List<User> users = userService.getUsers();
        result.setData(users);
        result.setMsg("修改成功");
        return result;
    }

    @RequestMapping("/deluser")
    @ResponseBody
    public LayuiResult<User> deleteUser(Integer page, Integer limit, User user) {
        LayuiResult<User> result = new LayuiResult<>();
        logger.info("deleteUser page:{} user:{} ", page, user.toString());
        userService.delUser(user);
        result.setCode(0);
        List<User> users = userService.getUsers();
        result.setData(users);
        return result;
    }
}
