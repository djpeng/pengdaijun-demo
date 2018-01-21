package com.pengdaijun.demo.spring.framework.shiro;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

@Transactional
@Component(value = "userService")
public interface UserService<User> extends JpaRepository<User, Integer> {
}
