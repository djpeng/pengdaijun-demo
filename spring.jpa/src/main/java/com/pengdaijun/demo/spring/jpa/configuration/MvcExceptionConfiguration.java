package com.pengdaijun.demo.spring.jpa.configuration;

import java.util.List;

import org.springframework.web.servlet.HandlerExceptionResolver;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

import com.pengdaijun.demo.spring.jpa.exception.ServiceHandlerExceptionResolver;

public class MvcExceptionConfiguration extends WebMvcConfigurerAdapter {

	// 需要在MVCConfiguration中初始化异常处理器
	@Override
	public void configureHandlerExceptionResolvers(List<HandlerExceptionResolver> exceptionResolvers) {
		exceptionResolvers.add(new ServiceHandlerExceptionResolver());
	}

}
