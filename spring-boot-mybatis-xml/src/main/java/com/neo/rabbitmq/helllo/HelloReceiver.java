package com.neo.rabbitmq.helllo;

import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Component
@RabbitListener(queues = "hello")
/**
 * 监听hello队列消息
 */
public class HelloReceiver {

    @RabbitHandler
    public void process(String hello) {
    	System.out.println("接收到生产者发来的消息为+++++++++++++++++++++++++++++++++++++++++++");
        System.out.println("Receiver  : " + hello);
    }

}