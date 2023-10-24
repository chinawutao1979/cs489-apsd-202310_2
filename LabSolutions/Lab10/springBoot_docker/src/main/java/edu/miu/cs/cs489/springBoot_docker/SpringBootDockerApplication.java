package edu.miu.cs.cs489.springBoot_docker;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SpringBootDockerApplication {

	public static void main(String[] args) {

		System.out.println("my spring boot app docker test!!!");
		SpringApplication.run(SpringBootDockerApplication.class, args);
	}

}
