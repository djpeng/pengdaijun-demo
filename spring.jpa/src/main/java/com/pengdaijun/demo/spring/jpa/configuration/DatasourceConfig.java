package com.pengdaijun.demo.spring.jpa.configuration;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.ImportResource;

@Configuration
@ImportResource(locations = { "datasource.xml" })
public class DatasourceConfig {

}
