package com.example.contact;

public class User {
    String name;
    String number;
    int image;

    public User(String name, String number){
        this.name = name;
        this.number = number;
    }

    public User(String name, String number, int image){
        this.name = name;
        this.number = number;
        this.image=image;
    }

    public String getName() {
        return name;
    }

    public String getNumber() {
        return number;
    }

    public int getImage() {
        return image;
    }

    public void setImage(int image) {
        this.image = image;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setNumber(String number) {
        this.number = number;
    }
}
