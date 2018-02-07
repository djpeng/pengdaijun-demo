package com.pengdaijun.demo.spring.swagger.autoconfig;

import org.springframework.boot.autoconfigure.condition.ConditionalOnClass;
import org.springframework.context.annotation.Configuration;

import com.pengdaijun.demo.spring.swagger.autoconfig.config.SwaggerConfig;

@Configuration
@ConditionalOnClass({ SwaggerConfig.class })
public class SwaggerAutoConfiguration {
}
