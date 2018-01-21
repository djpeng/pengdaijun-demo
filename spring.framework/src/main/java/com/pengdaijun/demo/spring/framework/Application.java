package com.pengdaijun.demo.spring.framework;

import java.io.IOException;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.boot.autoconfigure.orm.jpa.HibernateJpaAutoConfiguration;
import org.springframework.context.annotation.ImportResource;
import org.springframework.scheduling.annotation.EnableAsync;

//@ImportResource("/integration.xml")
@EnableAsync
@EntityScan(basePackages={"com.pengdaijun.demo.spring.framework"})  
@SpringBootApplication(exclude={DataSourceAutoConfiguration.class,HibernateJpaAutoConfiguration.class})
public class Application {
	public static void main(String[] args) throws IOException {
		SpringApplication app = new SpringApplication(Application.class);
		app.run(args);
		System.out.println("spring boot has started..................!!");
	}
}
