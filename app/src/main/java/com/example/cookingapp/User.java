package com.example.cookingapp;

public class User {

    public String firstName, lastName, email, address, cardName, description,cardNumber, cardExpiration;
    public boolean client, chef, administrator;
    public Menu menu;

    public User(){

    }

    public User(String firstName, String lastName, String email, String address, boolean client,boolean chef,boolean administrator, String cardName,
                String description, String cardNumber, String cardExpiration, Menu menu){
        this.firstName = firstName;
        this.lastName = lastName;
        this.address = address;
        this.email = email;
        this.client = client;
        this.chef = chef;
        this.administrator = administrator;
        this.cardName = cardName;
        this.description = description;
        this.cardNumber = cardNumber;
        this.cardExpiration = cardExpiration;
        this.menu = menu;

    }
}
