package com.neo.json;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * 但是我发现这种bean注入的方式，当controller返回中文字符串json格式时，支持不是太好，
 * 浏览器会出现乱码。也不知道是什么原因，因此还是使用的是第一种方式。
 * @author kongml
 * @date 2019年4月22日
 * @version 1.0.1
 */
@SpringBootApplication
public class App {

	// SpringBoot配置自定义json解析
//	@Bean
//	public HttpMessageConverters fastJsonHttpMessageConventers() {
//		FastJsonHttpMessageConverter converter = new FastJsonHttpMessageConverter();
//		List<MediaType> mediaTypes = new ArrayList<>();
//		// 中文编码
//		mediaTypes.add(MediaType.APPLICATION_JSON_UTF8);
//
//		FastJsonConfig config = new FastJsonConfig();
//		config.setSerializerFeatures(SerializerFeature.PrettyFormat);
//
//		// fasejson的支持类型
//		converter.setSupportedMediaTypes(mediaTypes);
//		// fastjson的配置对象
//		converter.setFastJsonConfig(config);
//		HttpMessageConverter<?> converter1 = converter;
//		return new HttpMessageConverters(converter1);
//	}

	/*
	 * @Override public void
	 * configureMessageConverters(List<HttpMessageConverter<?>> converters) {
	 * WebMvcConfigurer.super.configureMessageConverters(converters);
	 * //创建fastjson转换器实例 FastJsonHttpMessageConverter converter = new
	 * FastJsonHttpMessageConverter(); //配置对象 FastJsonConfig config = new
	 * FastJsonConfig(); List<MediaType> mediaTypes = new ArrayList<>(); //中文编码
	 * MediaType mediaType = MediaType.APPLICATION_JSON_UTF8;
	 * mediaTypes.add(mediaType);
	 * config.setSerializerFeatures(SerializerFeature.PrettyFormat);
	 * converter.setSupportedMediaTypes(mediaTypes);
	 * converter.setFastJsonConfig(config); converters.add(converter); }
	 */
	public static void main(String[] args) {
		SpringApplication.run(App.class, args);
	}
}
