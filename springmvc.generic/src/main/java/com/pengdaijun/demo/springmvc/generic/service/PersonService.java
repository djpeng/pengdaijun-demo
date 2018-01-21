package com.pengdaijun.demo.springmvc.generic.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pengdaijun.demo.springmvc.generic.dao.IPersonDao;
import com.pengdaijun.demo.springmvc.generic.entity.PersonModel;

@Service
public class PersonService extends AbstractBaseService<PersonModel, Long> implements IPersonService {

	@Autowired
	IPersonDao personDao;

	@Override
	public void customeSvcMethod1(PersonModel model) {
		personDao.customeDaoMethod1(model);
	}

	@Override
	public PersonModel customeSvcMehtod2() {
		return personDao.customeDaoMehtod2();
	}

}
