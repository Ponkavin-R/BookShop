package com.example.booksmyshop;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Get a reference to the Get Started button
        Button getStartedButton = findViewById(R.id.buttonGetStarted);
        // Set OnClickListener to the button
        getStartedButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Create an Intent to navigate to the next activity
                Intent intent = new Intent(MainActivity.this, Register.class);
                startActivity(intent);
                // Finish current activity if needed
                finish();
            }
        });
    }
}
