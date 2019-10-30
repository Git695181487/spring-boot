package com.neo.rabbitmq.many;

import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Component
@RabbitListener(queues = "neo")
public class NeoReceiver1 {

	public static int count = 0;
	
    @RabbitHandler
    public void process(String neo) throws Exception {
        System.out.println("Receiver 1接收到的信息为: " + neo);
        count++;
        if(count == 30){
        	Thread.sleep(5000);
        }
    }

}
