package com.countryflags.api.model;

import java.util.List;

public class Continent {


	private String continent;

    private List<CountryFlag> countries;
    
    public Continent(String continent, List<CountryFlag> countries) {
    	this.continent=continent;
    	this.countries=countries;
	}
    public Continent() {
    	
	}

	

    public String getContinent ()
    {
        return continent;
    }

    public void setContinent (String continent)
    {
        this.continent = continent;
    }

    public List<CountryFlag> getCountries ()
    {
        return countries;
    }

    public void setCountries (List<CountryFlag> countries)
    {
        this.countries = countries;
    }

    @Override
    public String toString()
    {
        return " [continent = "+continent+", countries = "+countries+"]";
    }

  
	
}
