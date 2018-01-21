package com.pengdaijun.demo.springmvc.generic.service;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

import com.pengdaijun.demo.springmvc.generic.entity.IBaseModel;

public interface IBaseService<T extends IBaseModel, ID extends Serializable> {
	public T getById(ID id);

	public List<T> findAll();

	public List<T> findList(Map<Object, Object> params);
}
