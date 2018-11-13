package com.yuanwutou.cloud;

import com.netflix.discovery.util.StringUtil;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCollapser;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import com.netflix.hystrix.contrib.javanica.cache.annotation.CacheKey;
import com.netflix.hystrix.contrib.javanica.cache.annotation.CacheRemove;
import com.netflix.hystrix.contrib.javanica.cache.annotation.CacheResult;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.Future;

@Service
public class HelloService {

    @Autowired
    RestTemplate restTemplate;


    @HystrixCommand(fallbackMethod = "helloFallBack")
    public String hellService(){
        return restTemplate.getForEntity("http://HELLO-SERVICE/hello", String.class) .getBody();
    }

    public String helloFallBack(){
        return "error";
    }

    @CacheResult(cacheKeyMethod = "getUserByIdCacheKey")
    @HystrixCommand(commandKey = "getUser",groupKey = "userGroup",threadPoolKey = "getUserThread")
    public String getUser(String id){
        return restTemplate.getForEntity("http://HELLO-SERVICE/getUser/{1}",String.class,id).getBody();
    }

    private String getUserByIdCacheKey(String id) {
        return id;
    }


    public ResponseEntity<String> updateUser(){
        return restTemplate.getForEntity("http://HELLO-SERVICE/updateUser",String.class);
    }

    @HystrixCollapser(batchMethod= "findAll", scope = com.netflix.hystrix.HystrixCollapser.Scope.GLOBAL,collapserProperties = {
            @HystrixProperty(name="timerDelayInMilliseconds", value = "10000")
    })
    public Future<User> find(String id){
        return null;
    }

    @HystrixCommand
    public List<User> findAll(List<String> ids){
        User[] users = restTemplate.getForObject("http://USER-SERVICE/users/{1}",User[].class, StringUtils.join(ids,","));
        return Arrays.asList(users);
    }

}
