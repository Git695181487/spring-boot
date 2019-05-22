package com.neo.rabbitmq.topic;

import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class TopicSender {

	@Autowired
	private AmqpTemplate rabbitTemplate;

	public void send() {
		String context = "hi, i am message all";
		System.out.println("Sender : " + context);
		//向topicExchange交换机中已发送消息，交换机就会按topic.1规则发送到对应的队列中
		this.rabbitTemplate.convertAndSend("topicExchange", "topic.1", context);
	}

	public void send1() {
		String context = "hi, i am message 1";
		System.out.println("Sender : " + context);
		//向topicExchange交换机中已发送消息，交换机就会按topic.message规则发送到对应的队列中
		this.rabbitTemplate.convertAndSend("topicExchange", "topic.message", context);
	}

	public void send2() {
		String context = "hi, i am messages 2";
		System.out.println("Sender : " + context);
		//向topicExchange交换机中已发送消息，交换机就会按topic.messages规则发送到对应的队列中
		this.rabbitTemplate.convertAndSend("topicExchange", "topic.messages", context);
	}

}