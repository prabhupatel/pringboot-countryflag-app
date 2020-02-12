package com.countryflags.api.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.countryflags.api.model.Continent;
import com.countryflags.api.model.CountryFlag;
import com.countryflags.api.service.CountyFlagServiceImpl;
import com.google.gson.Gson;

@RestController
public class CountryFlagController {

	@Autowired
	CountyFlagServiceImpl countyFlagServiceImpl;

	

	@RequestMapping(value = "/countries/flags", method = RequestMethod.GET, produces = {MediaType.APPLICATION_JSON_VALUE })
	String getCountriesFlags(	@RequestParam(required = false) String continent,
								@RequestParam(required = false) List<String> countries
								) throws Exception {

		List<Continent> continents=null;
		List<CountryFlag> CountryFlags = null;
		String response = null;
		Gson gson = new Gson();
	
		// Based on query parameter, find the continents, country and flag list
		if (continent != null && countries==null) {
			CountryFlags= countyFlagServiceImpl.getCountriesAndFlagByContinent(continent);
			response = gson.toJson(CountryFlags);
		} else if (continent != null && countries!=null) {
			CountryFlags=countyFlagServiceImpl.getFlagByCountries(continent,countries);
			response = gson.toJson(CountryFlags);
		} else {
			continents = countyFlagServiceImpl.getAllContinentAndCountyAndFlag();
			response = gson.toJson(continents);
		}

		return response;
	}

}
