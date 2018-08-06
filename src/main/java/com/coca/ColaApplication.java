package com.coca;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.context.annotation.Configuration;

@SpringBootApplication
@Configuration
@MapperScan("com.coca.mapper")
@ServletComponentScan
public class ColaApplication {

	public static void main(String[] args) {
		SpringApplication.run(ColaApplication.class, args);
	}
}
