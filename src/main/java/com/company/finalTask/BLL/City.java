package com.company.finalTask.BLL;

import java.io.Serializable;

public class City extends Template implements Serializable {

    private int population;
    private String country;
    private String isCapital;

    public City() {
    }

    public City(String name, String uniqueID, int population, String isCapital, String country) {
        super(name, uniqueID);
        setPopulation(population);
        setIsCapital(isCapital);
        setCountry(country);
    }

    public void setPopulation(int population) {

        if (population < 20000) {
            System.out.println("Population should be more than 19999");
            this.population = 20000;
        } else {
            this.population = population;
        }
    }

    public int getPopulation() {
        return population;
    }

    public void setIsCapital(String isCapital) {
        if (isCapital.equals("yes"))
            this.isCapital = "yes";
        else
            this.isCapital = "no";
    }

    public String getIsCapital() {
        return isCapital;
    }

    public String getCountry() {
        return country;
    }


    public void setCountry(String country) {
        this.country = country;
    }

    @Override
    public String toString() {
        return "\nCity: " + this.getName() + "\nCountry: " + this.getCountry() + "\nPopulation: " + this.population + "\nIs capital: " + this.getIsCapital() + "\nUnique ID: " + this.getUniqueID();
    }
}
