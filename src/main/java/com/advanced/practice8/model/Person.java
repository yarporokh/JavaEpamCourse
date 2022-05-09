package com.advanced.practice8.model;

import java.util.Date;
import java.util.Objects;

public class Person {
    private int id;
    private String fullname;
    private Date date;

    public Person(int id, String fullname, Date date) {
        this.id = id;
        this.fullname = fullname;
        this.date = date;
    }

    public Person() {

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

    public void setDate(Date date) {
        this.date = date;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Person person = (Person) o;
        return id == person.id && Objects.equals(fullname, person.fullname) && Objects.equals(date, person.date);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, fullname, date);
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