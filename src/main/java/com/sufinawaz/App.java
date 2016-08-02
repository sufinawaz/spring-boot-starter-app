package com.sufinawaz;

import com.sufinawaz.filter.ProfilingFilter;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.boot.web.servlet.ServletContextInitializer;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import java.util.TimeZone;

@EnableAutoConfiguration
@ServletComponentScan
@ComponentScan
@Configuration
public class App implements ServletContextInitializer {
    @Override
    public void onStartup(ServletContext context) throws ServletException {
        TimeZone.setDefault(TimeZone.getTimeZone("UTC"));
        context.addFilter("profilingFilter", ProfilingFilter.class);
    }

    public static void main(String[] args) throws Exception {
        //// simpler:
        // SpringApplication.run(App.class, args);

        // use builder
        new SpringApplicationBuilder()
            .sources(App.class)
            .run(args);
    }
}
