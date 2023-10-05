package com.api1.ap1;

import com.api1.ap1.model.Funcionario;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@SpringBootApplication
public class Ap1Application {

	public static void main(String[] args) {
		SpringApplication.run(Ap1Application.class, args);
	}


}
