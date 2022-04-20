package com.example.demo;

import org.springframework.boot.SpringApplication;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.boot.autoconfigure.jdbc.DataSourceTransactionManagerAutoConfiguration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@EnableJpaRepositories(basePackages = "com.example.*")
@EntityScan(basePackages = "com.example.*")
@SpringBootApplication(scanBasePackages="com.example.*")//exclude = { DataSourceAutoConfiguration.class, DataSourceTransactionManagerAutoConfiguration.class} )
public class OnlineFoodDelivery1Application {

	public static void main(String[] args) {
		SpringApplication.run(OnlineFoodDelivery1Application.class, args);
	}

}
