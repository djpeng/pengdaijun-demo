package com.pengdaijun.demo.spring.jpa.exception;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.HandlerExceptionResolver;
import org.springframework.web.servlet.ModelAndView;

/**
 * 异常处理方案二：HandlerExceptionResolver + WebMvcConfigurerAdapter
 * 实现HandlerExceptionResolver接口，进行全局的异常拦截，使用时需要在MVCExceptionConfiguration中初始化异常处理器
 * 
 * @author Administrator
 *
 */
public class ServiceHandlerExceptionResolver implements HandlerExceptionResolver {

	@Override
	public ModelAndView resolveException(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse,
			Object object, Exception exception) {
		exception.printStackTrace();
		Throwable rex = exception;
		if (rex instanceof ControllerIllegalArgumentFormatException) {
			httpServletResponse.setStatus(400);
		}
		return new ModelAndView();
	}

}
