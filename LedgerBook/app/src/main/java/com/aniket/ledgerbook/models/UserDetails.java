package com.aniket.ledgerbook.models;

public class UserDetails {
    String name,email,phone;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public String getPhone() {
        return phone;
    }

    public UserDetails(String name, String email, String phone){
        this.name = name;
        this.email = email;
        this.phone = phone;
    }
    public UserDetails(){

    }

}
