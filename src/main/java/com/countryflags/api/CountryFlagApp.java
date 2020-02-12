package com.countryflags.api;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.util.ResourceUtils;

import com.countryflags.api.model.Continent;
import com.countryflags.api.repository.ContinentRepository;
import com.fasterxml.jackson.databind.ObjectMapper;

@SpringBootApplication
public class CountryFlagApp implements CommandLineRunner{

	public static void main(String[] args) {
		SpringApplication.run(CountryFlagApp.class, args);

	}
	
	public void run(String[] args) throws IOException {

        //create ObjectMapper instance
        ObjectMapper objectMapper = new ObjectMapper();

        File file = ResourceUtils.getFile("classpath:continents.json");
        BufferedReader br = new BufferedReader(new FileReader(file));
        String line;
        while ((line = br.readLine()) != null) {
          System.out.println(line);
        }
        Continent[] continent = objectMapper.readValue(file, Continent[].class);
       // Continent continent = objectMapper.readValue(ResourceUtils.getFile("classpath:config/sample.txt")), Continent.class);
       
        if(ContinentRepository.continents.isEmpty()) {
        	ContinentRepository.continents.addAll(Arrays.asList(continent));
        }
        
    }

}
