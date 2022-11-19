package com.example.cookingapp;

public class User {

    public String firstName, lastName, email, address, cardName, description,cardNumber, cardExpiration;
    public boolean client, chef, administrator, userSuspended;




    public User(){

    }

    public User(String firstName, String lastName, String email, String address, boolean client,boolean chef,boolean administrator, boolean userSuspended, String cardName,
                String description, String cardNumber, String cardExpiration){
        this.firstName = firstName;
        this.lastName = lastName;
        this.address = address;
        this.email = email;
        this.client = client;
        this.chef = chef;
        this.administrator = administrator;
        this.userSuspended = userSuspended;
        this.cardName = cardName;
        this.description = description;
        this.cardNumber = cardNumber;
        this.cardExpiration = cardExpiration;

    }

}
