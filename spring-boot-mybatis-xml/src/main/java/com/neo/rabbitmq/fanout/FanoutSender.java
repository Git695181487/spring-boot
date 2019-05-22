package com.neo.rabbitmq.fanout;

import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class FanoutSender {

	@Autowired
	private AmqpTemplate rabbitTemplate;

	public void send() {
		String context = "hi, fanout msg ";
		System.out.println("Sender : " + context);
		//向交换机fanoutExchange发送一条消息，换机fanoutExchange就会把消息发送到绑定自己的队列中去
		this.rabbitTemplate.convertAndSend("fanoutExchange","", context);
	}

}