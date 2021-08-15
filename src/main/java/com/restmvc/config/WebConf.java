package com.restmvc.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;


@Configuration
@ComponentScan(basePackages ="com.restmvc")
@EnableWebMvc
public class WebConf {
	
	// No View Resolver for rest api 
}
