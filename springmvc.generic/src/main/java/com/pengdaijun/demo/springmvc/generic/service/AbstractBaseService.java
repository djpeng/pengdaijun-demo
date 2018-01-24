package com.pengdaijun.demo.springmvc.generic.service;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Service;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.pengdaijun.demo.springmvc.generic.dao.IBaseDao;
import com.pengdaijun.demo.springmvc.generic.entity.IBaseModel;

@Service
@Lazy
public class AbstractBaseService<T extends IBaseModel, ID extends Serializable> implements IBaseService<T, ID> {
	protected Logger LOG = Logger.getLogger(this.getClass());

	@Autowired
	IBaseDao<T, ID> baseDao;

	@Override
	public final T getById(ID id) {
		return baseDao.findById(id);
	}

	@Override
	public final List<T> findAll() {
		return baseDao.findAll();
	}

	@Override
	public final List<T> findList(Map<Object, Object> params) {
		JSONObject jsonObject = JSONObject.parseObject(JSON.toJSONString(params));
		return baseDao.findByParams(jsonObject);
	}

}
