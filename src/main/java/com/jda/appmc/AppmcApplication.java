package com.jda.appmc;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.jda.appmc.domain.Categoria;
import com.jda.appmc.repositories.CategoriaRepository;



@SpringBootApplication
public class AppmcApplication implements CommandLineRunner {
	
	@Autowired
	private CategoriaRepository categoriaRepository;

	public static void main(String[] args) {
		SpringApplication.run(AppmcApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub
		
		Categoria cat1 = new Categoria(null, "Informatica");
		Categoria cat2 = new Categoria(null, "Escritorio");
		Categoria cat3 = new Categoria(null, "Cosinha");
		
		categoriaRepository.saveAll(Arrays.asList(cat1,cat2,cat3));
		
	}

}
