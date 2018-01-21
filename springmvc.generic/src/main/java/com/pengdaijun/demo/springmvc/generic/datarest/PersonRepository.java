package com.pengdaijun.demo.springmvc.generic.datarest;

import java.util.List;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.pengdaijun.demo.springmvc.generic.entity.PersonModel;

@RepositoryRestResource(collectionResourceRel = "people", path = "people")
public interface PersonRepository extends PagingAndSortingRepository<PersonModel, Long> {

	List<PersonModel> findByLastName(@Param("name") String name);

}