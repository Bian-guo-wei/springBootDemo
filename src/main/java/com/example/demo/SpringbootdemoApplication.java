package com.example.demo;

import com.example.demo.website.interceptor.RandomCodeServlet;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class SpringbootdemoApplication {

	@Bean
	public ServletRegistrationBean servletRegistrationBean(){
		return new ServletRegistrationBean(new RandomCodeServlet(),"*.RandomCode");
	}

	public static void main(String[] args) {
		SpringApplication.run(SpringbootdemoApplication.class, args);
	}

}
