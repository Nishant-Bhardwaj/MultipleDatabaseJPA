package com.application.covid;

import com.application.covid.Models.db1.Laptop;
import com.application.covid.repo.db1.LaptopRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import javax.annotation.PostConstruct;

@SpringBootApplication
public class MultiDBApplication {

	@Autowired
	LaptopRepo laptopRepo1;

	@Autowired
	com.application.covid.repo.db2.LaptopRepo laptopRepo2;

	public static void main(String[] args) {
		SpringApplication.run(MultiDBApplication.class, args);
	}

	@PostConstruct
	public void test(){
		Laptop laptop1 = Laptop.builder()
				.size("1")
				.rom("rom1")
				.ram("ram1")
				.processor("process1")
				.price(10L)
				.build();

		laptopRepo1.save(laptop1);

		System.out.println("Laptop 1 = " + laptopRepo1.findAll());
	}

	@PostConstruct
	public void test2(){

		com.application.covid.Models.db2.Laptop laptop2
				= com.application.covid.Models.db2.Laptop.builder()
				.size("2")
				.rom("rom2")
				.ram("ram2")
				.processor("process2")
				.price(10L)
				.build();

		laptopRepo2.save(laptop2);
		System.out.println("Laptop 2 = " + laptopRepo2.findAll());
	}


}
