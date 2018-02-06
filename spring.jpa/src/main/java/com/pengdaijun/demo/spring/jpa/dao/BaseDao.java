package com.pengdaijun.demo.spring.jpa.dao;

import java.io.Serializable;

import org.springframework.data.jpa.repository.JpaRepository;

import com.pengdaijun.demo.spring.jpa.entity.BaseModel;

public interface BaseDao<T extends BaseModel> extends JpaRepository<T, Serializable> {

}
