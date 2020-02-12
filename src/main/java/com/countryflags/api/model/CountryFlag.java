package com.countryflags.api.model;

public class CountryFlag {
	
	private String name;
    private String flag;

    public CountryFlag() {
    }
    public CountryFlag(String name, String flag) {
        this.name = name;
        this.flag = flag;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getFlag() {
        return flag;
    }

    public void setFlag(String flag) {
        this.flag = flag;
    }

    @Override
    public String toString() {
        return "{" + "\"name\": \"" + name + "\", \"flag\": \"" + flag + "\"} ";
    }

}
