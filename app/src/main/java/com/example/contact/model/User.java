package com.example.contact.model;

public class User {
    private String name;
    private String number;
    private long id;
    int image;

    public User(String name, String number){
        this.name = name;
        this.number = number;
    }

    public User(long id, String name, String number, int image){
        this.name = name;
        this.number = number;
        this.image = image;
        this.id = id;
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

    public long getId() {
        return id;
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
