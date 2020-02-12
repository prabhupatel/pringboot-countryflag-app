package com.countryflags.api.repository;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.countryflags.api.model.Continent;

@Repository
public class ContinentRepository {
	
	static public List <Continent> continents = new ArrayList<Continent>(); 
	
	public List<Continent> getAllContinentAndCountyAndFlag(){
		return continents;
	}
	
	

}
