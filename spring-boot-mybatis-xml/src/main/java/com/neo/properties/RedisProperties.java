package com.neo.properties;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Component
@ConfigurationProperties(prefix="spring.redis") //配置文件里属性的key的前缀
//@PropertySource("classpath:redis-dev.properties") //指定的配置文件
public class RedisProperties {
    
    private static String database;
    
    private static String host;
    
    private static String port;
    
    private static String password;
    
    private static String poolMaxActive;
    
    private static String poolMaxWait;
    
    private static String poolMaxIdle;
    
    private static String poolMinIdle;
    
    private static String timeout;

	public static String getDatabase() {
		return database;
	}

	public void setDatabase(String database) {
		this.database = database;
	}

	public static String getHost() {
		return host;
	}

	public void setHost(String host) {
		this.host = host;
	}

	public static String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public static String getPoolMaxActive() {
		return poolMaxActive;
	}

	public void setPoolMaxActive(String poolMaxActive) {
		this.poolMaxActive = poolMaxActive;
	}

	public static String getPoolMaxWait() {
		return poolMaxWait;
	}

	public void setPoolMaxWait(String poolMaxWait) {
		this.poolMaxWait = poolMaxWait;
	}

	public static String getPoolMaxIdle() {
		return poolMaxIdle;
	}

	public void setPoolMaxIdle(String poolMaxIdle) {
		this.poolMaxIdle = poolMaxIdle;
	}

	public static String getPoolMinIdle() {
		return poolMinIdle;
	}

	public void setPoolMinIdle(String poolMinIdle) {
		this.poolMinIdle = poolMinIdle;
	}

	public static String getTimeout() {
		return timeout;
	}

	public void setTimeout(String timeout) {
		this.timeout = timeout;
	}

	public static String getPort() {
		return port;
	}

	public void setPort(String port) {
		this.port = port;
	}
	
	
 
}