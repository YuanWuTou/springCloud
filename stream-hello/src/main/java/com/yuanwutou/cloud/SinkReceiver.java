package com.yuanwutou.cloud;

import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.cloud.stream.messaging.Sink;
import org.springframework.messaging.handler.annotation.SendTo;

@EnableBinding(value={Sink.class,SinkSender.class})
public class SinkReceiver {

    @StreamListener(Sink.INPUT)
    @SendTo(SinkSender.OUT)
    public Object processInput(Object payload){
        System.out.println("--------"+payload+"--------");
        return payload;
    }

    @StreamListener(SinkSender.OUT)
    public void receive(Object payload){
        System.out.println("receive from sinkSenderOut "+payload);
    }
}
