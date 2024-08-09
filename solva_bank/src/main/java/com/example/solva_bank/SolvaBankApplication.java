package com.example.solva_bank;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
public class SolvaBankApplication {
	public static void main(String[] args) {
		SpringApplication.run(SolvaBankApplication.class, args);
	}

}
