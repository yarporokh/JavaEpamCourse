package com.company.finalTask.DAL;

import com.company.finalTask.BLL.Country;

import java.beans.XMLDecoder;
import java.beans.XMLEncoder;
import java.io.*;
import java.util.ArrayList;

public class XmlSerialize {
    public static void save(ArrayList<Country> countries) {
        try (XMLEncoder xmlEncoder = new XMLEncoder(new BufferedOutputStream(
                new FileOutputStream("serial.xml")))) {
            xmlEncoder.writeObject(countries);
            xmlEncoder.flush();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    public static ArrayList<Country> load() {
        ArrayList<Country> countries = new ArrayList<>();
        try (XMLDecoder xmlDecoder = new XMLDecoder(new BufferedInputStream(
                new FileInputStream("serial.xml")))) {
            countries = (ArrayList<Country>)xmlDecoder.readObject();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        return countries;
    }
}
