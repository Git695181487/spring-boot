package com.neo.rabbitmq.helllo;

import java.util.Date;

import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class HelloSender {

	@Autowired
	private AmqpTemplate rabbitTemplate;

	/**
	 * 向hello队列发送消息
	 */
	public void send() {
		String context = "hello " + new Date();
		System.out.println("Sender : " + context);
		this.rabbitTemplate.convertAndSend("hello", context);
		//第一个交换机，第二个路由Key,第三个是消息内容
		rabbitTemplate.convertAndSend("testTopicExchange","key1.a.c.key2", " this is  RabbitMQ!");
	}
	/**
	 * 向hello队列发送消息
	 */
	public void send(String context) {
		context = "Spring boot neo queue ****** " + context;
		System.out.println("Sender : " + context);
		this.rabbitTemplate.convertAndSend("hello", context);
	}

}