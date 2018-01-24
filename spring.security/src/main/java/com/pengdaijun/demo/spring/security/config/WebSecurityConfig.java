package com.pengdaijun.demo.spring.security.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

	@Autowired
	public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
		auth.inMemoryAuthentication().withUser("user").password("password").roles("USER");
	}

	@Override
	public void configure(WebSecurity web) throws Exception {
		web.ignoring()
				// Spring Security should completely ignore URLs starting with
				// /resources/
				.antMatchers("/resources/**");
	}

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.authorizeRequests().antMatchers("/public/**").permitAll().anyRequest().hasRole("USER").and()
				// Possibly more configuration ...
				.formLogin() // enable form based log in
				// .loginPage("/login") //指定登录页面，不指定默认使用/login界面
				// set permitAll for all URLs associated with Form Login
				.permitAll();

		http.authorizeRequests()	//http.authorizeRequests()方法有多个子节点，每个macher按照他们的声明顺序执行。
			.antMatchers("/resources/**", "/signup", "/about").permitAll()	//任何用户都可以访问URL以"/resources/", equals "/signup", 或者 "/about"开头的URL。
			.antMatchers("/admin/**").hasRole("ADMIN")	//以 "/admin/" 开头的URL只能由拥有 "ROLE_ADMIN"角色的用户访问。请注意我们使用 hasRole 方法，没有使用 "ROLE_" 前缀。
			.antMatchers("/db/**").access("hasRole('ADMIN') and hasRole('DBA')")	//任何以"/db/" 开头的URL需要用户同时具有 "ROLE_ADMIN" 和 "ROLE_DBA"。和上面一样我们的 hasRole 方法也没有使用 "ROLE_" 前缀.
			.anyRequest().authenticated()	//尚未匹配的任何URL要求用户进行身份验证
			.and()
				// ...
			.formLogin();
		
//		http.logout()                                                                
//			.logoutUrl("/my/logout")                                                 
//			.logoutSuccessUrl("/my/index")                                           
//			.logoutSuccessHandler(logoutSuccessHandler)                              
//			.invalidateHttpSession(true)                                             
//			.addLogoutHandler(logoutHandler)                                         
//			.deleteCookies(cookieNamesToClear)                                       
//			.and()
	}

	@Override
	protected void configure(AuthenticationManagerBuilder auth) {
		try {
			auth.inMemoryAuthentication().withUser("user").password("password").roles("USER").and().withUser("admin")
					.password("password").roles("USER", "ADMIN");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}