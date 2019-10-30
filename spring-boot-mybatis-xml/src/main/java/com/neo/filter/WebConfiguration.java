package com.neo.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;

import org.apache.catalina.filters.RemoteIpFilter;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class WebConfiguration {
    @Bean
    public RemoteIpFilter remoteIpFilter() {
        return new RemoteIpFilter();
    }
    
    @Bean
    public FilterRegistrationBean testFilterRegistration() {
        FilterRegistrationBean registration = new FilterRegistrationBean();
        registration.setFilter(new MyFilter());
        registration.addUrlPatterns("/*");
        registration.addInitParameter("paramName", "paramValue");
        registration.setName("MyFilter");
        registration.setOrder(1);
        return registration;
    }
    
	/**
	 * 针对整个容器
	 * @author kongml
	 * @date 2019年4月22日
	 * @version 1.0.1
	 */
    public class MyFilter implements Filter {
		@Override
		public void destroy() {
			System.out.println("WebConfiguration.MyFilter.destroy()");
		}

		@Override
		public void doFilter(ServletRequest srequest, ServletResponse sresponse, FilterChain filterChain)
				throws IOException, ServletException {
			System.out.println("************************************************************************");
			System.out.println("WebConfiguration.MyFilter.doFilter()");
			HttpServletRequest request = (HttpServletRequest) srequest;
			System.out.println("this is MyFilter,url :"+request.getRequestURI());
			System.out.println("request.getLocalAddr()="+request.getLocalAddr());
			System.out.println("获取到的IP为："+getIPAddress(request));
			System.out.println("************************************************************************");
			filterChain.doFilter(srequest, sresponse);
		}

		/**
		 * 项目启动的时候加载
		 */
		@Override
		public void init(FilterConfig arg0) throws ServletException {
			System.out.println("WebConfiguration.MyFilter.init()");
		}
		
		public String getIPAddress(HttpServletRequest request) {
		    String ip = null;

		    //X-Forwarded-For：Squid 服务代理
		    String ipAddresses = request.getHeader("X-Forwarded-For");

		    if (ipAddresses == null || ipAddresses.length() == 0 || "unknown".equalsIgnoreCase(ipAddresses)) {
		        //Proxy-Client-IP：apache 服务代理
		        ipAddresses = request.getHeader("Proxy-Client-IP");
		    }

		    if (ipAddresses == null || ipAddresses.length() == 0 || "unknown".equalsIgnoreCase(ipAddresses)) {
		        //WL-Proxy-Client-IP：weblogic 服务代理
		        ipAddresses = request.getHeader("WL-Proxy-Client-IP");
		    }

		    if (ipAddresses == null || ipAddresses.length() == 0 || "unknown".equalsIgnoreCase(ipAddresses)) {
		        //HTTP_CLIENT_IP：有些代理服务器
		        ipAddresses = request.getHeader("HTTP_CLIENT_IP");
		    }

		    if (ipAddresses == null || ipAddresses.length() == 0 || "unknown".equalsIgnoreCase(ipAddresses)) {
		        //X-Real-IP：nginx服务代理
		        ipAddresses = request.getHeader("X-Real-IP");
		    }

		    //有些网络通过多层代理，那么获取到的ip就会有多个，一般都是通过逗号（,）分割开来，并且第一个ip为客户端的真实IP
		    if (ipAddresses != null && ipAddresses.length() != 0) {
		        ip = ipAddresses.split(",")[0];
		    }

		    //还是不能获取到，最后再通过request.getRemoteAddr();获取
		    if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ipAddresses)) {
		        ip = request.getRemoteAddr();
		    }
		    return ip;
		}

    }
}