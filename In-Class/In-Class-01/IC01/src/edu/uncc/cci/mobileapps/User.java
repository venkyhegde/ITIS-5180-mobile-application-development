package edu.uncc.cci.mobileapps;

import java.util.Objects;

/**
 * @author venky
 */
public class User {
    private String firstname;
    private String lastname;
    private int age;
    private String email;

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public int getAge() {
        return age;
    }

    @Override public boolean equals(Object o) {
        if ( this == o ) return true;
        if ( !(o instanceof User) ) return false;
        User user = ( User ) o;
        return getAge () == user.getAge () &&
                getFirstname ().equals (user.getFirstname ()) &&
                getLastname ().equals (user.getLastname ()) &&
                getEmail ().equals (user.getEmail ()) &&
                getGender ().equals (user.getGender ()) &&
                getCity ().equals (user.getCity ()) &&
                getState ().equals (user.getState ());
    }

    @Override public int hashCode() {
        return Objects
                .hash (getFirstname (), getLastname (), getAge (), getEmail (), getGender (), getCity (), getState ());
    }

    @Override public String toString() {
        return "User{" +
                "firstname='" + firstname + '\'' +
                ", lastname='" + lastname + '\'' +
                ", age=" + age +
                ", email='" + email + '\'' +
                ", gender='" + gender + '\'' +
                ", city='" + city + '\'' +
                ", state='" + state + '\'' +
                '}';
    }

    public void setAge(int age) {
        this.age = age;
    }

    private String gender;
    private String city;
    private String state;

}
