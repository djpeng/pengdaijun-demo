package com.pengdaijun.demo.springmvc.generic.controller;

import static org.springframework.hateoas.mvc.ControllerLinkBuilder.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.Link;
import org.springframework.hateoas.Resource;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.pengdaijun.demo.springmvc.generic.entity.PersonModel;
import com.pengdaijun.demo.springmvc.generic.service.IPersonService;

@RestController
@RequestMapping(value = "/persons")
public class PersonController extends AbstractBaseController<PersonModel, Long> {
	@Autowired
	IPersonService personService;

	@RequestMapping(value = "/custome/method1")
	public HttpEntity<PersonModel> customeMethod_1() {
		PersonModel model = personService.customeSvcMehtod2();
		return new ResponseEntity<PersonModel>(model, HttpStatus.OK);
	}

	@RequestMapping(value = "/custome/method2")
	public HttpEntity<Resource<PersonModel>> customeMethod_2() {
		PersonModel model = personService.customeSvcMehtod2();
		Link link = linkTo(methodOn(PersonController.class).customeMethod_2()).withSelfRel();
		Resource<PersonModel> resource = new Resource<PersonModel>(model, link);
		return new ResponseEntity<Resource<PersonModel>>(resource, HttpStatus.OK);
	}
	
}
