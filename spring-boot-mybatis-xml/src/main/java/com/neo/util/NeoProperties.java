package com.neo.util;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

@Configuration
@PropertySource("classpath:my.properties")//先加载该文件的值，后加载主配置文件里的值
public class NeoProperties {
	@Value("${com.neo.name}")
	private String name;
	@Value("${com.neo.password}")
	private String password;

	public String getName() {
		return name;
	}

	public String getPassword() {
		return password;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setPassword(String password) {
		this.password = password;
	}

}