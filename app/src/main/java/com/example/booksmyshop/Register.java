package com.example.booksmyshop;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;

public class Register extends AppCompatActivity {

    private EditText editTextName, editTextEmail, editTextMobile, editTextPassword;
    private Button registerButton;
    private TextView loginLink;
    private DatabaseHelper databaseHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        // Initialize views and database helper
        editTextName = findViewById(R.id.editTextName);
        editTextEmail = findViewById(R.id.editTextEmail);
        editTextMobile = findViewById(R.id.editTextMobile);
        editTextPassword = findViewById(R.id.editTextPassword);
        registerButton = findViewById(R.id.registerButton);
        loginLink = findViewById(R.id.login);
        databaseHelper = new DatabaseHelper(this); // Instantiate the databaseHelper

        // Set onClickListener for Register button
        registerButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Get user input
                String name = editTextName.getText().toString().trim();
                String email = editTextEmail.getText().toString().trim();
                String mobile = editTextMobile.getText().toString().trim();
                String password = editTextPassword.getText().toString().trim();

                // Add user to database
                long result = databaseHelper.addUser(name, email, mobile, password);

                if (result != -1) {
                    // Registration successful
                    Toast.makeText(Register.this, "Registration successful!", Toast.LENGTH_SHORT).show();
                    // Clear input fields after registration
                    editTextName.setText("");
                    editTextEmail.setText("");
                    editTextMobile.setText("");
                    editTextPassword.setText("");
                } else {
                    // Registration failed
                    Toast.makeText(Register.this, "Registration failed. Please try again.", Toast.LENGTH_SHORT).show();
                }
            }
        });

        // Set onClickListener for Login link
        loginLink.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Navigate to Login activity
                Intent intent = new Intent(Register.this, Login.class);
                startActivity(intent);
            }
        });
    }
}
