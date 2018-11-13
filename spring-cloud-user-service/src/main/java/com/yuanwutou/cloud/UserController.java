package com.yuanwutou.cloud;

import com.netflix.discovery.util.StringUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.serviceregistry.Registration;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@RestController
public class UserController {
    @Autowired
    private Registration registration;

    @RequestMapping(value = "/user", method= RequestMethod.GET)
    public String getUser() {
        System.out.println("/hello, host:" + registration.getHost() + ",service_id:" +
                registration.getServiceId());
        return "Hello World";
    }

    @RequestMapping(value = "/users/{ids}", method= RequestMethod.GET)
    @ResponseBody
    public List<User> getUsers(@PathVariable String ids) {
        System.out.println("/users, host:" + registration.getHost() + ",service_id:" +
                registration.getServiceId()+ids.toString());
        List<User> users = new ArrayList<User>();
        users.add(new User("1","yuanwutou1"));
        users.add(new User("2","yuanwutou2"));
        users.add(new User("3","yuanwutou3"));
        System.out.println("开始批量处理请求并返回值");
        return users;
    }


}
