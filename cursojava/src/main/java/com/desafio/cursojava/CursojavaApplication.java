package com.desafio.cursojava;

import com.desafio.cursojava.principal.Main;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class CursojavaApplication implements CommandLineRunner {

	public static void main(String[] args) {

		SpringApplication.run(CursojavaApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		Main programa = new Main();
		programa.exibeMenu();
	}
}
