package com.fivepoints.spring.models;

import javax.persistence.*;

@Entity
@Table
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    private String firstName;
    private String lastName;
    private String email;
    private String password;

    public User(){}

    public User(String firstName, String lastName,String email,String password) {
            this.firstName=firstName;
            this.firstName=lastName;
            this.email=email;
            this.password=password;
    }
    public int getId() {
        return this.id;
    }
    public String getFirstName() {
        return this.firstName;
    }
    public String getLastName() {
        return this.lastName;
    }
    public String getEmail() {
        return this.email;
    }
    public String getPassword() {
        return this.password;
    }

    public void setFirstName(String firstName) {
        this.firstName=firstName;
    }
    public void setLastName(String lastName) {
        this.lastName=lastName;
    }
    public void setEmail(String email) {
        this.email=email;
    }
    public void setPassword(String password) {
        this.password=password;
    }
}
