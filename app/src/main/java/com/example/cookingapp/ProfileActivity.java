package com.example.cookingapp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class ProfileActivity extends AppCompatActivity {

    private FirebaseUser user;
    private DatabaseReference reference;

    private String userID;

    private Button logout;
    private Button viewComplaints;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);

        logout = (Button) findViewById(R.id.signOut);

        logout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                FirebaseAuth.getInstance().signOut();
                startActivity(new Intent(ProfileActivity.this, MainActivity.class));
            }
        });

        user = FirebaseAuth.getInstance().getCurrentUser();
        reference = FirebaseDatabase.getInstance().getReference("Users");
        userID = user.getUid();

        final TextView greetingTextView = (TextView) findViewById(R.id.textView);

        reference.child(userID).addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                User userProfile = snapshot.getValue(User.class);

                if(userProfile!=null){
                    Boolean client = userProfile.client;
                    Boolean chef = userProfile.chef;
                    Boolean administrator = userProfile.administrator;


                    if(client == true){
                        greetingTextView.setText("Welcome Client");
                    }

                    if(chef == true){
                        greetingTextView.setText("Welcome Chef");

                        startActivity(new Intent(ProfileActivity.this, ChefProfileActivity.class));

                    }
                    if(administrator == true){
                        greetingTextView.setText("Welcome Administrator");

                        viewComplaints = (Button) findViewById(R.id.viewComplaints);
                        viewComplaints.setVisibility(View.VISIBLE);

                        viewComplaints.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View view) {
                                startActivity(new Intent(ProfileActivity.this, ComplaintsList.class));
                            }
                        });

                    }

                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {
                Toast.makeText(ProfileActivity.this,"Something wrong happened", Toast.LENGTH_LONG).show();
            }
        });
    }

    private void openChefProfileActivity() {
        Intent intent = new Intent(ProfileActivity.this, ChefProfileActivity.class);
        startActivity(intent);
    }
}