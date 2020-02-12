package com.countryflags.api.rest;



import static org.junit.Assert.assertNotNull;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import com.countryflags.api.model.Continent;
import com.countryflags.api.model.CountryFlag;
import com.countryflags.api.service.CountyFlagServiceImpl;




public class CountryFlagControllerTest {
	@InjectMocks
	CountryFlagController controller ;
    List<Continent> continents;
    Continent continent1;
    List<CountryFlag> countries1 ;
    
    @Mock
    CountyFlagServiceImpl countyFlagServiceImpl;
    
    @Before
    public void init() {
        MockitoAnnotations.initMocks(this);
    }

    @Before
    public void setUp() {
       
    	 CountryFlag country1 = new CountryFlag("Nigeria", "🇳🇬");
    	 CountryFlag country2 = new CountryFlag("Ethiopia", "🇳🇪");

    	 CountryFlag country3 = new CountryFlag("USA","🇺🇸");
    	 CountryFlag country4 = new CountryFlag("Brazil", "🇧🇷");

         List<CountryFlag> countries1 = new ArrayList<>();
         countries1.add(country1);
         countries1.add(country2);
         List<CountryFlag> countries2 = new ArrayList<>();
         countries2.add(country3);
         countries2.add(country4);
         Continent continent1 = new Continent("Africa", countries1);
         Continent continent2 = new Continent("America", countries2);
         
         continents = new ArrayList<>();
         continents.add(continent1);
         continents.add(continent2);

    }

    @Test
	public void testGetAllCountries() throws Exception {
        System.out.println("testGetAllCountries");
        when(countyFlagServiceImpl.getAllContinentAndCountyAndFlag()).thenReturn(continents);
        String countries = controller.getCountriesFlags(null,null);
        
        assertNotNull(countries);
	}

    @Test
	public void testFilterCountriesByContinent() throws Exception {
    	System.out.println("testGetAllCountries");
    	when(countyFlagServiceImpl.getCountriesAndFlagByContinent("Africa")).thenReturn(countries1);
        String countries = controller.getCountriesFlags("Africa",null);
        
        assertNotNull(countries);
	}
    
    @Test
   	public void testFilterCountriesByContinentAndCountries() throws Exception {
    	List<String> givenCountries = new ArrayList<String>();
    	givenCountries.add("Nigeria");
    	givenCountries.add("Ethiopia");
       	System.out.println("testGetAllCountries");
       	when(countyFlagServiceImpl.getFlagByCountries("Africa",givenCountries)).thenReturn(countries1);
           String countries = controller.getCountriesFlags("Africa",givenCountries);
           
           assertNotNull(countries);
   	}
    
    }
