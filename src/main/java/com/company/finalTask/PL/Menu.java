package com.company.finalTask.PL;

import com.company.finalTask.BLL.City;
import com.company.finalTask.BLL.Country;
import com.company.finalTask.DAL.XmlSerialize;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.UUID;

public class Menu {
    ArrayList<Country> countries = new ArrayList<>();
    public BufferedReader br = br = new BufferedReader(new InputStreamReader(System.in));

    public void start() throws IOException {
        while (true) {

            countries = XmlSerialize.load();
            reloadInfo();
            System.out.println("""
                    1 - Country menu
                    2 - Cities menu
                    3 - Search by ID
                    0 - Exit the program
                    """);
            System.out.print("Choose: ");
            String choice = br.readLine();

            if (choice.equals("0")) {
                XmlSerialize.save(countries);
                break;
            } else if (choice.equals("1"))
                countriesLayer();
            else if (choice.equals("2"))
                citiesLayer();
            else if (choice.equals("3"))
                searchLayer();
        }
    }

    private void searchLayer() throws IOException {
        System.out.print("Enter id of object: ");
        String id = br.readLine();
        if (id.length() != 8) {
            System.out.println("Invalid ID. Length of id should be 8.");
        } else {
            for (Country country : countries) {
                if (country.getUniqueID().equals(id)){
                    System.out.println(country);
                    br.readLine();
                    break;
                }
                for (City city : country.cities) {
                    if (city.getUniqueID().equals(id)){
                        System.out.println(city);
                        br.readLine();
                        break;
                    }
                }
            }
            System.out.println("The object with this ID was not found.");
        }
    }

    private void citiesLayer() throws IOException {

        Country country = null;
        showCountriesList();
        System.out.print("Choose coutry: ");
        try {
            int countryChoice = Integer.parseInt(br.readLine());
            country = countries.get(countryChoice - 1);
        } catch (IndexOutOfBoundsException | NumberFormatException e) {
            System.out.println("Invalid value");
            citiesLayer();
        }
        while (true) {
            System.out.println("""
                    1 - Show cities list
                    2 - Show info
                    3 - Add city
                    4 - Remove city
                    5 - Edit city
                    0 - Back
                    """);
            String choice = br.readLine();
            if (choice.equals("0")) {
                XmlSerialize.save(countries);
                break;
            } else if (choice.equals("1")) {
                showCitiesList(country);
                br.readLine();
            } else if (choice.equals("2")) {
                cityInfo(country);
            } else if (choice.equals("3")) {
                addCity(country);
            } else if (choice.equals("4")) {
                removeCity(country);
            } else if (choice.equals("5")) {
                editCity(country);
            }
        }
    }

    private void editCity(Country country) throws IOException {
        showCitiesList(country);
        System.out.print("Choose city: ");
        int index = 0;
        try {
            index = Integer.parseInt(br.readLine());
            cityEditor(country.cities.get(index - 1));
        } catch (IndexOutOfBoundsException | NumberFormatException e) {
            System.out.println("Invalid value");
        }

    }

    private void cityEditor(City city) throws IOException {
        System.out.println("""
                1 - Edit name
                2 - Edit population
                """);
        System.out.print("Choose: ");
        String editChoice = br.readLine();
        if (editChoice.equals("1")) {
            System.out.print("Enter new name: ");
            String prevName = city.getName();
            String name = br.readLine();


            city.setName(name);

            if (city.getName() == null) {
                System.out.println("Invalid name. Didn't change");
                city.setName(prevName);
            }
        } else if (editChoice.equals("2")) {
            try {
                System.out.print("Enter population: ");
                int population = Integer.parseInt(br.readLine());
                city.setPopulation(population);
            } catch (NumberFormatException e) {
                System.out.println("Invalid value");
            }
        }
    }

    private void removeCity(Country country) throws IOException {
        showCitiesList(country);
        System.out.print("Choose city: ");
        int index = 0;
        try {
            index = Integer.parseInt(br.readLine());
            country.cities.remove(index - 1);
        } catch (IndexOutOfBoundsException | NumberFormatException e) {
            System.out.println("Invalid value");
        }
    }

    private void addCity(Country country) throws IOException {
        try {
            System.out.print("Enter the name: ");
            String name = br.readLine();

            for (City city : country.cities) {
                if (city.getName().equals(name)) {
                    System.out.println("A city with that name already exists in this country");
                    addCity(country);
                    return;
                }
            }

            System.out.print("Enter population: ");
            int population = Integer.parseInt(br.readLine());

            System.out.print("Is the city the capital?\nyes if yes, something else if no: ");
            String isCapital = br.readLine();

            country.cities.add(new City(name, UUID.randomUUID().toString().substring(0, 8), population, isCapital, country.getName()));
            if (country.cities.get(country.cities.size() - 1).getIsCapital().equals("yes")) {
                for (int i = 0; i <= country.cities.size() - 2; i++) {
                    country.cities.get(i).setIsCapital("no");
                }
            }
        } catch (NumberFormatException e) {
            System.out.println("Invalid value");
            country.cities.remove(country.cities.size() - 1);

        }
    }

    private void cityInfo(Country country) throws IOException {
        showCitiesList(country);
        if (country.cities.size() == 0)
            return;

        System.out.print("Choose city: ");
        int index = 0;
        try {
            index = Integer.parseInt(br.readLine());
            System.out.println(country.cities.get(index - 1).toString());
            br.readLine();
        } catch (IndexOutOfBoundsException | NumberFormatException e) {
            System.out.println("Invalid value");
        }
    }

    private void showCitiesList(Country country) throws IOException {
        if (country.cities.size() == 0) {
            System.out.println("Cities are null");
        } else {
            int index = 1;
            for (City city : country.cities) {
                System.out.println(index++ + ". " + city.getName());
            }
        }
    }

    private void countriesLayer() throws IOException {
        while (true) {
            System.out.println("""
                    1 - Show countries list
                    2 - Show info
                    3 - Add country
                    4 - Remove country
                    5 - Edit country
                    0 - Back
                    """);
            String choice = br.readLine();
            if (choice.equals("0")) {
                XmlSerialize.save(countries);
                break;
            } else if (choice.equals("1")) {
                showCountriesList();
                br.readLine();
            } else if (choice.equals("2")) {
                countryInfo();
            } else if (choice.equals("3")) {
                addCountry();
            } else if (choice.equals("4")) {
                removeCountry();
            } else if (choice.equals("5")) {
                editCountry();
            }
        }
    }

    private void editCountry() throws IOException {
        showCountriesList();
        System.out.print("Choose country: ");
        int index = 0;
        try {

            index = Integer.parseInt(br.readLine());
            if (index > countries.size() || index < 1) {
                throw new IndexOutOfBoundsException();
            }
            System.out.print("Enter new name: ");
            String name = br.readLine();
            countries.get(index - 1).setName(name);

        } catch (IndexOutOfBoundsException | NumberFormatException e) {
            System.out.println("Invalid value");
        }
    }

    private void removeCountry() throws IOException {
        showCountriesList();
        System.out.print("Choose country: ");
        int index = 0;
        try {
            index = Integer.parseInt(br.readLine());
            countries.remove(index - 1);
        } catch (IndexOutOfBoundsException | NumberFormatException e) {
            System.out.println("Invalid value");
        }
    }

    private void addCountry() throws IOException {
        System.out.print("Print a name of new country: ");
        String name = br.readLine();
        String id = UUID.randomUUID().toString().substring(0, 8);
        countries.add(new Country(name, id));
        if (countries.get(countries.size() - 1).getName() == null) {
            countries.remove(countries.size() - 1);
            System.out.println("Invalid name");
            addCountry();
        }
    }

    private void countryInfo() throws IOException {
        showCountriesList();
        System.out.print("Choose country: ");
        int index = 0;
        try {
            index = Integer.parseInt(br.readLine());
            System.out.println(countries.get(index - 1).toString());
            br.readLine();
        } catch (IndexOutOfBoundsException | NumberFormatException e) {
            System.out.println("Invalid value");
        }
    }

    private void showCountriesList() throws IOException {
        if (countries.size() == 0) {
            System.out.println("Countries are null");
            countriesLayer();
        } else {
            int index = 1;
            for (Country country : countries) {
                System.out.println(index++ + ". " + country.getName());
            }
        }
    }

    private void reloadInfo() {
        for (Country country : countries) {
            for (City city : country.cities) {
                if (city.getIsCapital().equals("yes")) {
                    country.setCapital(city.getName());
                    break;
                }
                city.setCountry(country.getName());
            }
        }
    }
}
