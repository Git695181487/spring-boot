package com.neo.annotation;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringBootConfiguration;
import org.springframework.context.annotation.Bean;

@SpringBootConfiguration
public class CommonProperties {
	@Value("${appKey}")
	private String appKey;
	@Value("${appSecret}")
	private String appSecret;
	@Value("${bucket}")
	private String bucket;
	@Value("${endPoint}")
	private String endPoint;

	@Bean
	public Aliyun aliyun() {
		return Aliyun.options().setAppKey(appKey)
				.setAppSecret(appSecret)
				.setBucket(bucket)
				.setEndPoint(endPoint)
				.build();
	}
}
