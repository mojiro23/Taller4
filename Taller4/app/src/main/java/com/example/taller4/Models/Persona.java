package com.example.taller4.Models;

import java.io.Serializable;

public class Persona implements Serializable {

    private String name;
    private String lastname;
    private String email;
    private String phonenumber;


    public Persona(String name, String lastname, String email, String phonenumber) {
        this.name = name;
        this.lastname = lastname;
        this.email = email;
        this.phonenumber = phonenumber;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhonenumber() {
        return phonenumber;
    }

    public void setPhonenumber(String phonenumber) {
        this.phonenumber = phonenumber;
    }
}
