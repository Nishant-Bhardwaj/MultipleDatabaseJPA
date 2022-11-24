package com.application.covid;

import com.application.covid.Modles.db1.Laptop;
import com.application.covid.repo.db1.LaptopRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import javax.annotation.PostConstruct;

@SpringBootApplication
public class MultiDBApplication {

	@Autowired
	Laptop laptop1;

	@Autowired
	LaptopRepo laptopRepo1;

	@Autowired
	com.application.covid.Modles.db2.Laptop laptop2;

	@Autowired
	com.application.covid.repo.db2.LaptopRepo laptopRepo2;

	public static void main(String[] args) {
		SpringApplication.run(MultiDBApplication.class, args);
	}

	@PostConstruct
	public void test(){
		laptopRepo1.save(laptop1);
		System.out.println("Laptop 1 = " + laptopRepo1.findAll());
	}

	@PostConstruct
	public void test2(){
		laptopRepo2.save(laptop2);
		System.out.println("Laptop 2 = " + laptopRepo2.findAll());
	}


}
