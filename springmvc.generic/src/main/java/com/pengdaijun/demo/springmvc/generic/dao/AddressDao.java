package com.pengdaijun.demo.springmvc.generic.dao;

import org.springframework.stereotype.Repository;

import com.pengdaijun.demo.springmvc.generic.entity.AddressModel;

@Repository
public class AddressDao extends AbstractBaseDao<AddressModel, Long> {
	public AddressDao() {
		super();
		setTableName("address_t");
	}
}
