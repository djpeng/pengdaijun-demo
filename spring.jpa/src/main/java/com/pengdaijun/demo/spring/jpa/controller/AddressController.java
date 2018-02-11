package com.pengdaijun.demo.spring.jpa.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.fasterxml.jackson.annotation.JsonFormat.Value;
import com.pengdaijun.demo.spring.jpa.dao.AddressDao;
import com.pengdaijun.demo.spring.jpa.entity.AddressModel;
import com.pengdaijun.demo.spring.jpa.exception.ControllerIllegalArgumentFormatException;

@RestController
@RequestMapping("/addresses")
public class AddressController extends BaseController<AddressModel> {
	@Autowired
	private AddressDao addressDao;

	@GetMapping("no")
	public AddressModel getByNo(@PathVariable Long no) {
		if (no == 100) {
			throw new ControllerIllegalArgumentFormatException("传入参数格式不对：" + no);
		}
		return addressDao.getOne(no);
	}

	/**
	 * 异常处理一：本Controller类中有效
	 * 使用@ExceptionHandlerannotation 实现在配置的Controller中拦截并处理异常
	 * 
	 * @param request
	 * @param ex
	 * @return
	 */
	@ExceptionHandler(ControllerIllegalArgumentFormatException.class)
	public ModelAndView handleUserNotFoundException(HttpServletRequest request, Exception ex) {
		logger.error("Requested URL=" + request.getRequestURL());
		logger.error("Exception Raised=" + ex);

		ModelAndView modelAndView = new ModelAndView();
		modelAndView.addObject("exception", ex);
		modelAndView.addObject("url", request.getRequestURL());
		modelAndView.setViewName("error");
		return modelAndView;
	}
}
