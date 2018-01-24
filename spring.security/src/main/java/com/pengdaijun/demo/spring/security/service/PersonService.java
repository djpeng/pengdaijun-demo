package com.pengdaijun.demo.spring.security.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pengdaijun.demo.spring.security.entity.PersonModel;
import com.pengdaijun.demo.spring.security.repository.PersonRepository;

@Service
public class PersonService implements IPersonService {

	@Autowired
	PersonRepository personRepository;

	public PersonModel get(Long id) {
		return personRepository.findOne(id);
	}

}
