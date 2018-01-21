package com.pengdaijun.demo.springmvc.generic.controller;

import java.io.Serializable;
import java.util.List;
import java.util.Map;
import java.util.stream.Stream;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.pengdaijun.demo.springmvc.generic.entity.IBaseModel;
import com.pengdaijun.demo.springmvc.generic.service.IBaseService;

public abstract class AbstractBaseController<T extends IBaseModel, ID extends Serializable> {
	@Autowired
	IBaseService<T, ID> baseService;

	/**
	 * 查询单个对象
	 * 
	 * @param id
	 * @return
	 */
	@GetMapping(value = "/{id}")
	public final HttpEntity<T> findById(@PathVariable ID id) {
		T model = baseService.getById(id);
		return new ResponseEntity<T>(model, HttpStatus.OK);
	}

	/**
	 * 查找所有对象
	 * 
	 * @return
	 */
	@GetMapping()
	public final HttpEntity<List<T>> findAll() {
		List<T> list = baseService.findAll();
		return new ResponseEntity<List<T>>(list, HttpStatus.OK);
	}

	/**
	 * 分页查找
	 * 
	 * @param model
	 * @param pageIndex
	 * @param pageSize
	 * @param total
	 * @param OrderBy
	 * @param ascending
	 * @return
	 */
	@GetMapping(params = { "model", "pageIndex", "pageSize", "total", "orderBy", "ascending" })
	public final HttpEntity<Page<T>> queryForPage(@RequestParam T model, @RequestParam int pageIndex,
			@RequestParam int pageSize, @RequestParam int total, @RequestParam String OrderBy,
			@RequestParam Boolean ascending) {
		return null;// TODO
	}

	/**
	 * 查找关联对象
	 * 
	 * @param id
	 * @param refEntity
	 * @param refId
	 * @return
	 */
	@GetMapping(value = "{id}/{refEntity:[a-z-]+}/{refId:[\\d]+}")
	public final HttpEntity<T> findRelationalOne(@PathVariable ID id, @PathVariable String refEntity,
			@PathVariable Long refId) {
		System.out.println("/" + id + "/" + refEntity + "/" + refId);
		return null;// TODO
	}

	/**
	 * 根据字段查找对象集
	 * 
	 * @param params
	 * @return
	 */
	@GetMapping(value = "/search")
	public final HttpEntity<List<T>> findList(@RequestParam Map<Object, Object> params) {
		return new ResponseEntity<List<T>>(baseService.findList(params), HttpStatus.OK);
	}

	/**
	 * 更新对象
	 * 
	 * @param model
	 * @return
	 */
	@PutMapping(value = "/{id}")
	public HttpEntity<T> update(@RequestParam T model) {
		return null; // TODO
	}

	/**
	 * 新建对象
	 * 
	 * @param model
	 * @return
	 */
	@PostMapping()
	public HttpEntity<T> add(@RequestParam T model) {
		return null; // TODO
	}

	/**
	 * 删除对象
	 * 
	 * @param id
	 * @return
	 */
	@DeleteMapping(value = "/{id}")
	public HttpEntity<T> delete(@PathVariable ID id) {
		return null; // TODO
	}

	@GetMapping(params = { "$top" })
	public HttpEntity<Stream<T>> top(@RequestParam long $top) {
		List<T> models = baseService.findAll();
		Stream<T> stream = models.stream().limit($top);
		return new ResponseEntity<Stream<T>>(stream, HttpStatus.OK);
	}
	
}
