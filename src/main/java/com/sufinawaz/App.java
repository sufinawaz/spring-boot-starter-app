package com.sufinawaz;

import com.sufinawaz.config.ServiceConfig;
import com.sufinawaz.filter.ProfilingFilter;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.boot.web.servlet.ServletContextInitializer;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import java.util.TimeZone;

@EnableAutoConfiguration
@ServletComponentScan
@Import({ServiceConfig.class})
@Configuration
public class App implements ServletContextInitializer {
    @Override
    public void onStartup(ServletContext context) throws ServletException {
        TimeZone.setDefault(TimeZone.getTimeZone("UTC"));
        context.addFilter("profilingFilter", ProfilingFilter.class);
    }

    public static void main(String[] args) throws Exception {
        SpringApplication.run(App.class, args);
    }
}
