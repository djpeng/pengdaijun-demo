package com.pengdaijun.demo.springmvc.generic.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.pengdaijun.demo.springmvc.generic.entity.AddressModel;

@RestController
@RequestMapping(value = "/addresses")
public class AddressController extends AbstractBaseController<AddressModel, Long> {

}
