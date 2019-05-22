package com.neo.json;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * 自定义JSON解析 Spring Boot 中 RestController 返回的字符串默认使用 Jackson 引擎，它也提供了工厂类，我们可以自定义
 * JSON 引擎。 其次，在 WebConfig 类重写 configureMessageConverters 方法
 * 
 * @author kongml
 * @date 2019年4月23日
 * @version 1.0.1
 */
@SpringBootApplication
public abstract class MainApp implements WebMvcConfigurer {
//	@Override
//	public void configureMessageConverters(List<HttpMessageConverter<?>> converters) {
//		// WebMvcConfigurer.super.configureMessageConverters(converters);
//
//		/*
//		 * 1.需要先定义一个convert转换消息的对象； 
//		 * 2.添加fastjson的配置信息，比如是否要格式化返回的json数据
//		 * 3.在convert中添加配置信息 
//		 * 4.将convert添加到converters中
//		 */
//		// 1.定义一个convert转换消息对象
//		FastJsonHttpMessageConverter fastConverter = new FastJsonHttpMessageConverter();
//		// 2.添加fastjson的配置信息，比如：是否要格式化返回json数据
//		FastJsonConfig fastJsonConfig = new FastJsonConfig();
//		fastJsonConfig.setSerializerFeatures(SerializerFeature.PrettyFormat);
//		fastConverter.setFastJsonConfig(fastJsonConfig);
//		converters.add(fastConverter);
//	}


}

