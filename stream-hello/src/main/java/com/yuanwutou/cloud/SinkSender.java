package com.yuanwutou.cloud;

import org.springframework.cloud.stream.annotation.Output;
import org.springframework.cloud.stream.messaging.Sink;
import org.springframework.messaging.MessageChannel;

public interface SinkSender {

    String OUT = "sinkSenderOut";

    @Output(SinkSender.OUT)
    MessageChannel output();

}
