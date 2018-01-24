package com.pengdaijun.demo.spring.security.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.pengdaijun.demo.spring.security.entity.PersonModel;

@Repository
public interface PersonRepository extends CrudRepository<PersonModel, Long> {

}
