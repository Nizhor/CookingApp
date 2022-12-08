package com.example.cookingapp;

import android.content.Intent;
import android.os.Bundle;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import  androidx.appcompat.app.AppCompatActivity;


import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.FirebaseDatabase;

public class RegisterUser extends AppCompatActivity implements View.OnClickListener {

    private TextView banner, registerUser;
    private EditText editTextFirstName, editTextLastName, editTextEmail, editTextPassword, editTextAddress, editCardName, editDescription, editCardNumber, editCardExpiration;
    private CheckBox editClient, editChef;


    private ProgressBar progressBar;

    private FirebaseAuth mAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register_user);

        mAuth = FirebaseAuth.getInstance();

        banner = (TextView) findViewById(R.id.banner);
        banner.setOnClickListener(this);

        registerUser = (Button) findViewById(R.id.registerUser);
        registerUser.setOnClickListener(this);

        editTextFirstName = (EditText) findViewById(R.id.firstName);
        editTextLastName = (EditText) findViewById(R.id.lastName);
        editTextAddress = (EditText) findViewById(R.id.address);
        editTextEmail = (EditText) findViewById(R.id.email);
        editTextPassword = (EditText) findViewById(R.id.password);

        editClient = (CheckBox) findViewById(R.id.checkBox2);
        editChef = (CheckBox) findViewById(R.id.checkBox3);

        editCardName = (EditText) findViewById(R.id.cardName);
        editDescription = (EditText) findViewById(R.id.chefDescription);

        editCardNumber = (EditText) findViewById(R.id.cardNumber);
        editCardExpiration = (EditText) findViewById(R.id.cardExpiration);




        progressBar = (ProgressBar) findViewById(R.id.progressBar);
    }


    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.banner:
                startActivity(new Intent(this, MainActivity.class));
                break;
            case R.id.registerUser:
                registerUser();
                break;
        }
    }

    private void registerUser() {
        String email = editTextEmail.getText().toString().trim();
        String password = editTextPassword.getText().toString().trim();
        String firstName = editTextFirstName.getText().toString().trim();
        String lastName = editTextLastName.getText().toString().trim();
        String address = editTextAddress.getText().toString().trim();
        boolean client = editClient.isChecked();
        boolean chef = editChef.isChecked();
        boolean administrator = false;
        Menu menu = new Menu();

        String cardName = editCardName.getText().toString().trim();
        String description = editDescription.getText().toString().trim();
        String cardNumber = editCardNumber.getText().toString().trim();
        String cardExpiration = editCardExpiration.getText().toString().trim();




        if(firstName.isEmpty()){
            editTextFirstName.setError("First name is required!");
            editTextFirstName.requestFocus();
            return;
        }

        if(lastName.isEmpty()){
            editTextLastName.setError("Last name is required!");
            editTextLastName.requestFocus();
            return;
        }
        if(address.isEmpty()){
            editTextAddress.setError("Address is required!");
            editTextAddress.requestFocus();
            return;
        }

        if(email.isEmpty()){
            editTextEmail.setError("Email is required!");
            editTextEmail.requestFocus();
            return;
        }

        if(!Patterns.EMAIL_ADDRESS.matcher(email).matches()){
            editTextEmail.setError("Please provide valid email!");
            editTextEmail.requestFocus();
            return;
        }



        if(password.isEmpty()){
            editTextPassword.setError("Password is required!");
            editTextPassword.requestFocus();
            return;
        }

        if(password.length() < 6){
            editTextPassword.setError("Min password length should be 6 characters!");
            editTextPassword.requestFocus();
            return;
        }


        if(client == chef){
            editChef.setError("You can only select one option");
            editChef.requestFocus();
            return;
        }

        if(client ==true){
            if(cardNumber.isEmpty()){
                editCardNumber.setError("Card number is required!");
                editCardNumber.requestFocus();
                return;
            }
            if(cardNumber.length()<16){
                editCardNumber.setError("Card number is too short!");
                editCardNumber.requestFocus();
                return;
            }
            if(cardExpiration.length()<4){
                editCardNumber.setError("Card number is too short!");
                editCardNumber.requestFocus();
                return;
            }
            if(cardName.isEmpty()){
                editCardName.setError("Card name is required!");
                editCardName.requestFocus();
                return;
            }
            if(cardExpiration.isEmpty()){
                editCardExpiration.setError("Card expiration date is required!");
                editCardExpiration.requestFocus();
                return;
            }


        }

        if(chef == true){
            if(description.isEmpty()){
                editDescription.setError("Description is required!");
                editDescription.requestFocus();
                return;
            }

        }





        progressBar.setVisibility(View.VISIBLE);
        mAuth.createUserWithEmailAndPassword(email,password)
                .addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {

                        if(task.isSuccessful()){
                            User user = new User(firstName, lastName, email, address, client,chef,administrator,
                                    cardName, description, cardNumber, cardExpiration, menu);

                            FirebaseDatabase.getInstance().getReference("Users")
                                    .child(FirebaseAuth.getInstance().getCurrentUser().getUid())
                                    .setValue(user).addOnCompleteListener(new OnCompleteListener<Void>() {
                                        @Override
                                        public void onComplete(@NonNull Task<Void> task) {

                                            if(task.isSuccessful()){
                                                Toast.makeText(RegisterUser.this, "User has been registered successfully!", Toast.LENGTH_LONG).show();
                                                progressBar.setVisibility(View.GONE);

                                                //redirect to login layout!!
                                            }else{
                                                Toast.makeText(RegisterUser.this, "Failed to register! Try again!", Toast.LENGTH_LONG).show();
                                                progressBar.setVisibility(View.GONE);

                                            }
                                        }
                                    });
                        }else{
                            Toast.makeText(RegisterUser.this, "Failed to register! Try again!", Toast.LENGTH_LONG).show();
                            progressBar.setVisibility(View.GONE);
                        }
                    }
                });

    }
}
