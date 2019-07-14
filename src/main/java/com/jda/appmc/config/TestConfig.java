package com.jda.appmc.config;

import java.text.ParseException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import com.jda.appmc.services.DBService;


@Configuration
@Profile("dev")
public class TestConfig {

	@Autowired
	private DBService dbService;
	
	
	@Bean
	public boolean instantiateDatabase() throws ParseException {
		dbService.InstantiateTestDataBase();
		return true;
	}
	

}