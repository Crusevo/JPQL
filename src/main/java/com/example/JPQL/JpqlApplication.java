package com.example.JPQL;

import com.example.JPQL.Models.User;
import com.example.JPQL.Services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import java.util.List;


@SpringBootApplication
public class JpqlApplication implements CommandLineRunner {



	public static void main(String[] args) {
		SpringApplication.run(JpqlApplication.class, args);
	}
 


	@Override
	public void run(String... args) throws Exception {




	}
}
