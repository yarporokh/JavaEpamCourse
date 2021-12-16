package com.company.finalTask.BLL;

import java.io.Serializable;
import java.util.ArrayList;

public class Country extends Template implements Serializable {
    public ArrayList<City> cities= new ArrayList<>();

    private String capital;

    public Country() {}

    public Country(String name, String uniqueID) {
        super(name, uniqueID);
    }

    public void setCapital(String city) {
        this.capital = city;
    }

    @Override
    public String toString() {
        int population = 0;
        StringBuilder citiesList = new StringBuilder();
        for (City city: cities){
            population += city.getPopulation();
            citiesList.append(city.getName()).append(" ");
        }

        return "Country: " + this.getName() + "\nCapital: " + capital + "\nPopulation: " + population + "\nUniqueID: "+ getUniqueID() +"\nCities: " + citiesList;
    }
}
