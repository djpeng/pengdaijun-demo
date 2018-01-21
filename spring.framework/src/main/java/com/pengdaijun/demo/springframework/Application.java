package com.pengdaijun.demo.springframework;

import java.io.IOException;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.boot.autoconfigure.orm.jpa.HibernateJpaAutoConfiguration;

//@ImportResource("/integration.xml")
//@EnableAsync
//@EntityScan(basePackages={"com.pengdaijun.spring"})  
@SpringBootApplication(exclude={DataSourceAutoConfiguration.class,HibernateJpaAutoConfiguration.class})
public class Application {
	public static void main(String[] args) throws IOException {
		SpringApplication app = new SpringApplication(Application.class);
		app.run(args);
		System.out.println("spring boot has started..................!!");
	}
}
