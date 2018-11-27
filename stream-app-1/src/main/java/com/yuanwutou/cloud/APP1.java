package com.yuanwutou.cloud;

import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.cloud.stream.messaging.Processor;
import org.springframework.messaging.handler.annotation.SendTo;

import java.util.Date;

@EnableBinding(value = {Processor.class})
public class APP1 {

    @StreamListener(Processor.INPUT)
    @SendTo(Processor.OUTPUT)
    public Object receiveFromInput(Date date){
        System.out.println("Receive :"+date);
        return "From Input Channel Return - "+date;
    }

}
