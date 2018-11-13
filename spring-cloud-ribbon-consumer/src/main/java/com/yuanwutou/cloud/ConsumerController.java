package com.yuanwutou.cloud;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCollapser;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;

@RestController
public class ConsumerController {

    @Autowired
    HelloService helloService;

    @RequestMapping(value = "/ribbon-consumer",method = RequestMethod.GET)
    public String helloConsumer () {
        return helloService.hellService();
    }

    @RequestMapping(value = "/ribbon-consumer-getUser/{id}",method = RequestMethod.GET)
    public String getUserConsumer (@PathVariable String id) {
        System.out.println( helloService.getUser(id));
        helloService.updateUser();
        System.out.println(helloService.getUser(id));
        return helloService.getUser(id);
    }

    @RequestMapping(value = "/ribbon-consumer-updateUser",method = RequestMethod.GET)
    public void updateUserConsumer () {
        helloService.updateUser();
    }


    @RequestMapping(value = "/ribbon-consumer-testCombindRequest",method = RequestMethod.GET)
    @ResponseBody
    public void findUserRequest () throws ExecutionException, InterruptedException {
        Future<User> f1 =  helloService.find("1");
        Future<User> f2 = helloService.find("2");
        Future<User> f3 = helloService.find("3");
        User user1 = f1.get();
        User user2 = f2.get();
        User user3 = f3.get();
        System.out.println(user1.getName());
        System.out.println(user2.getName());
        System.out.println(user3.getName());
    }

    @RequestMapping(value = "/ribbon-consumer-testCombindGlobe/{id}",method = RequestMethod.GET)
    @ResponseBody
    public void findUserRequest (@PathVariable String id) throws ExecutionException, InterruptedException {
        Future<User> f1 =  helloService.find(id);
        User user = f1.get();
        System.out.println(user.getName());
    }
}
