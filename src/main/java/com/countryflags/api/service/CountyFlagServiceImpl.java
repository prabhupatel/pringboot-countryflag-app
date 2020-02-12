package com.countryflags.api.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.countryflags.api.model.Continent;
import com.countryflags.api.model.CountryFlag;
import com.countryflags.api.repository.ContinentRepository;



@Service
public class CountyFlagServiceImpl implements CountryFlagService {
	
	@Autowired
	ContinentRepository continentRepository;
	

	@Override
	public List<Continent> getAllContinentAndCountyAndFlag() {
		return continentRepository.getAllContinentAndCountyAndFlag();
	}

	@Override
	public List<CountryFlag> getCountriesAndFlagByContinent(String continent) {
		
			return getCountriesFlag(continent,null);
		
		
	}

	private List<CountryFlag> getCountriesFlag(String continent,List<String> countries) {
		List<Continent> continents = continentRepository.getAllContinentAndCountyAndFlag();
		
		
		List<CountryFlag> countriesFlag = new ArrayList<CountryFlag>();
		for(Continent continentName : continents) {
			if(continentName.getContinent().equalsIgnoreCase(continent)) {
				if(countries==null) {
					countriesFlag = continentName.getCountries();
				}else {
					for(CountryFlag countriesFlagPersisted : continentName.getCountries())  {
						if(countries.contains(countriesFlagPersisted.getName())) {
							countriesFlag.add(countriesFlagPersisted);
						}
						
					}
				}
			}
		}
		return countriesFlag;
	}

	@Override
	public List<CountryFlag> getFlagByCountries(String continent, List<String> countries){
		return getCountriesFlag(continent,countries);
	}

	

}
