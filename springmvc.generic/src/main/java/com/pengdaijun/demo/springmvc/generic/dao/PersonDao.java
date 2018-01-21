package com.pengdaijun.demo.springmvc.generic.dao;

import org.springframework.stereotype.Repository;

import com.pengdaijun.demo.springmvc.generic.entity.PersonModel;

@Repository
public class PersonDao extends AbstractBaseDao<PersonModel, Long> implements IPersonDao {
	public PersonDao() {
		super();
		setTableName("person_t");
	}

	@Override
	public void customeDaoMethod1(PersonModel model) {
		System.out.println("PersonDao.customeMethod1()");
	}

	@Override
	public PersonModel customeDaoMehtod2() {
		PersonModel model = new PersonModel();
		model.setFirstName("keqiang");
		model.setLastName("li");
		model.setId(3L);
		return model;
	}

}