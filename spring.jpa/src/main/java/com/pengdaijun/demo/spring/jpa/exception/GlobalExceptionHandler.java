package com.pengdaijun.demo.spring.jpa.exception;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * 异常处理方案三：全局异常处理
 * 使用@ControllerAdviceannotation类里定义@ExceptionHandler，
 * 对项目中所有Controller中带有@ExceptionHandler注释的方法拦截并进行处理异常
 * 
 * @author Administrator
 *
 */
@ControllerAdvice
public class GlobalExceptionHandler {
	private static final Logger logger = LoggerFactory.getLogger(GlobalExceptionHandler.class);

	@ExceptionHandler(SQLException.class)
	public String handleSQLException(HttpServletRequest request, Exception ex) {
		logger.info("SQLException Occured:: URL=" + request.getRequestURL());
		return "database_error";
	}

	@ResponseStatus(value = HttpStatus.NOT_FOUND, reason = "IOException occured")
	@ExceptionHandler(IOException.class)
	public void handleIOException() {
		logger.error("IOException handler executed");
		// returning 404 error code
	}

	/**
	 * 输入参数仅有exception
	 * 
	 * @ExceptionHandler public String handleException(UserNotFoundException
	 *                   exception) { return "errorView"; }
	 */
}