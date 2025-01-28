package com.build.ecom_project;

import com.build.ecom_project.model.Product;
import com.build.ecom_project.repo.ProductRepo;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.List;

@SpringBootApplication
public class EcomProjectApplication {


	public static void main(String[] args) {
		SpringApplication.run(EcomProjectApplication.class, args);
	}



}
