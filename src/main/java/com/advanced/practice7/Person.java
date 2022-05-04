package com.advanced.practice7;

import java.util.Date;

public class Person {
    private int id;
    private String fullname;
    private Date date;

    public Person(int id, String fullname, Date date) {
        this.id = id;
        this.fullname = fullname;
        this.date = date;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFullname() {
        return fullname;
    }

    public void setFullname(String fullname) {
        this.fullname = fullname;
    }

    public Date getDate() {
        return date;
    }

    public void setData(Date date) {
        this.date = date;
    }

    @Override
    public String toString() {
        return "Person{" +
                "id=" + id +
                ", fullname='" + fullname + '\'' +
                ", data='" + date + '\'' +
                '}';
    }
}
