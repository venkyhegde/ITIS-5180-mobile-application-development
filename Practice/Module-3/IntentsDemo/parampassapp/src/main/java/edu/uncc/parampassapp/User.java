package edu.uncc.parampassapp;

import java.io.Serializable;

public class User implements Serializable {

    private String name;
    private double age;

    public User(String name, double age) {
        this.name = name;
        this.age = age;
    }

    @Override
    public String toString() {
        return "User (" +
                "name: '" + name + '\'' +
                ", age: " + age +
                ')';
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getAge() {
        return age;
    }

    public void setAge(double age) {
        this.age = age;
    }
}
