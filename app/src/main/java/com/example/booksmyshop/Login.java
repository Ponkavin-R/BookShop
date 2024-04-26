package com.example.booksmyshop;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;

public class Login extends AppCompatActivity {

    private EditText editTextEmail, editTextPassword;
    private Button loginButton;
    private TextView registerLink;
    private DatabaseHelper databaseHelper; // Declare the databaseHelper variable

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        // Initialize views and database helper
        editTextEmail = findViewById(R.id.editTextEmail);
        editTextPassword = findViewById(R.id.editTextPassword);
        loginButton = findViewById(R.id.LoginButton);
        registerLink = findViewById(R.id.tlogin);
        databaseHelper = new DatabaseHelper(this); // Instantiate the databaseHelper

        // Set onClickListener for Login button
        loginButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Get user input
                String email = editTextEmail.getText().toString().trim();
                String password = editTextPassword.getText().toString().trim();

                // Check if user exists in the database
                boolean loginSuccessful = databaseHelper.checkUser(email, password);

                if (loginSuccessful) {
                    // Login successful
                    Toast.makeText(Login.this, "Login successful!", Toast.LENGTH_SHORT).show();
                    // Redirect to main activity or any other activity you want
                    // For example:
                     Intent intent = new Intent(Login.this, Home.class);
                     startActivity(intent);
                } else {
                    // Login failed
                    Toast.makeText(Login.this, "Invalid email or password. Please try again.", Toast.LENGTH_SHORT).show();
                }
            }
        });

        // Set onClickListener for Register link
        registerLink.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Navigate to Register activity
                Intent intent = new Intent(Login.this, Register.class);
                startActivity(intent);
            }
        });
    }
}
