package com.pengdaijun.demo.spring.jpa.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.pengdaijun.demo.spring.jpa.dao.BaseDao;
import com.pengdaijun.demo.spring.jpa.entity.BaseModel;

public class BaseController<T extends BaseModel> {
	protected final Logger logger = LoggerFactory.getLogger(this.getClass());
	@Autowired
	private BaseDao<T> dao;

	@GetMapping
	public final List<T> list() {
		return dao.findAll();
	}

	@PostMapping
	public T create(@RequestBody T entity) {
		return dao.save(entity);
	}

	@PutMapping(value = "{id}")
	public T update(@PathVariable(value = "id") long id, @RequestBody T entity) {
		return dao.save(entity);
	}

	@DeleteMapping(value = "{id}")
	public void delete(@PathVariable(value = "id") long id) {
		dao.delete(id);
	}

	@GetMapping(value = "{id}")
	public T get(@PathVariable(value = "id") long id) {
		return dao.getOne(id);
	}
}
