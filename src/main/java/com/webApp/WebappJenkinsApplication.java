package com.webApp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class WebappJenkinsApplication /* extends SpringBootServletInitializer */ {
	public static void main(String[] args) {
        SpringApplication.run(WebappJenkinsApplication.class, args);
    }

//    @Override
//    protected SpringApplicationBuilder configure(SpringApplicationBuilder builder) {
//        return builder.sources(WebappJenkinsApplication.class);
//    }

}
