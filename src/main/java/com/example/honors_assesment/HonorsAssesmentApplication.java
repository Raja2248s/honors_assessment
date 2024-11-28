package com.example.honors_assesment;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class})
public class HonorsAssesmentApplication {

	public static void main(String[] args) {
		SpringApplication.run(HonorsAssesmentApplication.class, args);
	}

}
