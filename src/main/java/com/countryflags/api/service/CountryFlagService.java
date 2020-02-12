package com.countryflags.api.service;

import java.util.List;

import com.countryflags.api.model.Continent;
import com.countryflags.api.model.CountryFlag;


public interface CountryFlagService {
	
	 List<Continent> getAllContinentAndCountyAndFlag();
	 List<CountryFlag> getCountriesAndFlagByContinent(String continent);
	 List<CountryFlag> getFlagByCountries(String continent, List<String> countries);

}
