package com.pengdaijun.demo.springmvc.generic;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.ImportResource;

@Configuration
@ImportResource(locations = { "datasource.xml" })
public class DatasourceConfig {

}
