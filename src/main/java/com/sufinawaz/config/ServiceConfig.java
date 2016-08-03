package com.sufinawaz.config;

import com.sufinawaz.rest.BaseRest;
import com.sufinawaz.service.BaseService;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan(basePackageClasses = {BaseService.class, BaseRest.class})
public class ServiceConfig {

}
