package com.pengdaijun.demo.spring.security.controller;

import static org.springframework.hateoas.mvc.ControllerLinkBuilder.linkTo;
import static org.springframework.hateoas.mvc.ControllerLinkBuilder.methodOn;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.Link;
import org.springframework.hateoas.Resource;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.pengdaijun.demo.spring.security.entity.PersonModel;
import com.pengdaijun.demo.spring.security.service.IPersonService;

@RestController
@RequestMapping(value = "/persons")
public class PersonController {
	@Autowired
	IPersonService personService;

	@RequestMapping(value = "/{id}")
	public HttpEntity<PersonModel> get(@PathVariable Long id) {
		PersonModel model = personService.get(id);
		return new ResponseEntity<PersonModel>(model, HttpStatus.OK);
	}

}
