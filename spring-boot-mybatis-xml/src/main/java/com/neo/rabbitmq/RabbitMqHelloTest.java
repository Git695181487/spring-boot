package com.neo.rabbitmq;

import java.util.Random;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.neo.rabbitmq.fanout.FanoutSender;
import com.neo.rabbitmq.helllo.HelloSender;
import com.neo.rabbitmq.many.NeoSender1;
import com.neo.rabbitmq.many.NeoSender2;
import com.neo.rabbitmq.model.User;
import com.neo.rabbitmq.object.ObjectSender;
import com.neo.rabbitmq.topic.TopicSender;

@RunWith(SpringRunner.class)
@SpringBootTest
public class RabbitMqHelloTest {

	@Autowired
	private HelloSender helloSender;
	
	@Autowired
	private NeoSender1 neoSender;
	
	@Autowired
	private NeoSender2 neoSender2;
	
	@Autowired
	private ObjectSender objectSender;
	
	@Autowired
	private TopicSender topicSender;

	@Autowired
	private FanoutSender sender;
	

	/**
	 * 测试消息发送和接收
	 */
	@Test
	public void hello() throws Exception {
		helloSender.send();
	}
	
	/**
	 * 测试一个生产者对多个消费者
	 */
	@Test
	public void oneToMany() throws Exception {
		for (int i=0;i<100;i++){
			neoSender.send(i);
		}
	}
	/**
	 * 测试多生产者对多个消费者 
	 */
	@Test
	public void manyToMany() throws Exception {
		
		for(int k = 0; k < 50; k++){
			Thread.sleep(3000);	
			for (int i=0;i<new Random().nextInt(100);i++){
				neoSender.send(i);
				neoSender2.send(i);
			}
		}
	}
	
	/**
	 * 测试发送对象
	 */
	@Test
	public void sendOject() throws Exception {
		User user=new User();
		user.setName("neo");
		user.setPass("123456");
		objectSender.send(user);
	}
	
	
	@Test
	public void topic() throws Exception {
		topicSender.send();
	}

	@Test
	public void topic1() throws Exception {
		topicSender.send1();
	}

	@Test
	public void topic2() throws Exception {
		topicSender.send2();
	}
	

	@Test
	public void fanoutSender() throws Exception {
		sender.send();
	}
	

}