package com.neo;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.neo.mapper")
public class Application {

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}
	
	/**
	 * 配置JSP视图解析器
	 * 如果没有配置视图解析器。Spring会使用BeanNameViewResolver，通过查找ID与逻辑视图名称匹配且实现了View接口的beans
	 * @return
	 */
//	@Bean
//	public InternalResourceViewResolver setupViewResolver() {
//		InternalResourceViewResolver resolver = new InternalResourceViewResolver();
//		/** 设置视图路径的前缀 */
//		resolver.setPrefix("/WEB-INF/jsp/");
//		/** 设置视图路径的后缀 */
//		resolver.setSuffix(".jsp");
//		return resolver;
//	}
	
}
