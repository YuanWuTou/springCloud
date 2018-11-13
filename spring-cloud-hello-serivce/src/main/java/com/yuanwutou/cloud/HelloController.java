package com.yuanwutou.cloud;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.serviceregistry.Registration;
import org.springframework.web.bind.annotation.*;


@RestController
public class HelloController {
    @Autowired
    private Registration registration;

    @RequestMapping(value = "/hello", method= RequestMethod.GET)
    public String index() {
        System.out.println("/hello, host:" + registration.getHost() + ",service_id:" +
                registration.getServiceId()+"666666");
        return "Hello World";
    }

    @RequestMapping(value = "/getUser/{id}", method= RequestMethod.GET)
    public String getUser(@PathVariable String id) {
        System.out.println("/getId, host:" + registration.getHost() + ",service_id:" +
                registration.getServiceId()+"   "+id);
        return User.id +"------"+User.name;
    }

    @RequestMapping(value = "/updateUser", method= RequestMethod.GET)
    public void updateUser() {
        System.out.println("/getId, host:" + registration.getHost() + ",service_id:" +
                registration.getServiceId()+"更新");
        User.id = "2";
        User.name = "yuanwutouu";
        System.out.println(User.id +"-------------"+User.name);
    }

}
