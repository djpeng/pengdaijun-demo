package com.pengdaijun.demo.spring.jpa.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.pengdaijun.demo.spring.jpa.dao.PersonDao;
import com.pengdaijun.demo.spring.jpa.entity.PersonModel;

@RestController
@RequestMapping("/persons")
public class PersonController extends BaseController<PersonModel> {
	@Autowired
	PersonDao personDao;

	@GetMapping("custome/{id}")
	public final PersonModel custome(@PathVariable Long id) {
		return personDao.findOne(id);
	}
}
