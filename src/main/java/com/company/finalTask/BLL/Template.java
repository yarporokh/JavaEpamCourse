package com.company.finalTask.BLL;

import java.io.Serializable;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Template implements Serializable {
    private String uniqueID;
    private String name;

    public Template(){}

    public Template(String name, String uniqueID) {
        setName(name);
        setUniqueID(uniqueID);
    }

    public void setName(String name) {
        String regex = "^[A-Z][a-z]+$|^[A-Z]{2,}$|^[A-Z][a-z]+ [A-Z][a-z]+$";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(name);
        if (matcher.matches())
            this.name = name;
     }

    public String getUniqueID() {
        return uniqueID;
    }

    public String getName() {
        return name;
    }

    public void setUniqueID(String uniqueID) {
        this.uniqueID = uniqueID;
    }
}
