package com.sf.springdemo.config;

import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

@Configurable
@EnableWebMvc
@ComponentScan("com.sf.springdemo")
public class DemoAppConfig {

}
