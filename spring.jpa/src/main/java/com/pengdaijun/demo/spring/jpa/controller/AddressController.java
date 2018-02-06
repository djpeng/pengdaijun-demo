package com.pengdaijun.demo.spring.jpa.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.pengdaijun.demo.spring.jpa.entity.AddressModel;

@RestController
@RequestMapping("/addresses")
public class AddressController extends BaseController<AddressModel>{

}
