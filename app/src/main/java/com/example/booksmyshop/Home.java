package com.example.booksmyshop;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class Home extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        Button thriller = findViewById(R.id.thriller);
        thriller.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(Home.this, Thriller.class);
                startActivity(i);
            }
        });

        Button fantasy = findViewById(R.id.fantasy);
        fantasy.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(Home.this, Fantacy.class);
                startActivity(i);
            }
        });

        // Set click listeners for the payment buttons
        setPaymentButtonListeners();
    }

    private void setPaymentButtonListeners() {
        Button pay1 = findViewById(R.id.pay1);
        Button pay2 = findViewById(R.id.pay2);
        Button pay3 = findViewById(R.id.pay3);
        Button pay4 = findViewById(R.id.pay4);
        Button pay5 = findViewById(R.id.pay5);
        Button mystery = findViewById(R.id.mystery);

        pay1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Start PaymentProcess activity
                startActivity(new Intent(Home.this, ProductDescription.class));
            }
        });

        pay2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Start PaymentProcess activity
                startActivity(new Intent(Home.this, ProductDescription.class));
            }
        });

        pay3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Start PaymentProcess activity
                startActivity(new Intent(Home.this, ProductDescription.class));
            }
        });

        pay4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Start PaymentProcess activity
                startActivity(new Intent(Home.this, ProductDescription.class));
            }
        });

        pay5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Start PaymentProcess activity
                startActivity(new Intent(Home.this, ProductDescription.class));
            }
        });

        mystery.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Start PaymentProcess activity
                startActivity(new Intent(Home.this, Mystery.class));
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        super.onCreateOptionsMenu(menu);
        createMenu(menu);
        return true;
    }

    private void createMenu(Menu menu) {
        MenuItem mnu1 = menu.add(0, 0, 0, "Profile");
        mnu1.setAlphabeticShortcut('a');

        MenuItem mnu2 = menu.add(0, 1, 1, "Sell book");
        mnu2.setAlphabeticShortcut('b');

        MenuItem mnu3 = menu.add(0, 2, 2, "Your Orders");
        mnu3.setAlphabeticShortcut('c');

        MenuItem mnu4 = menu.add(0, 3, 3, "About");
        mnu4.setAlphabeticShortcut('d');
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case 0:
                // Handle item 1 click
                Toast.makeText(this, "Profile", Toast.LENGTH_SHORT).show();
                Intent i = new Intent(getApplicationContext(), Profile.class);
                startActivity(i);
                return true;
            case 1:
                // Handle item 2 click
                Toast.makeText(this, "You Can sell the Book", Toast.LENGTH_SHORT).show();
                Intent j = new Intent(getApplicationContext(), crudoperation.class);
                startActivity(j);
                return true;
            case 2:
                // Handle item 3 click
                Toast.makeText(this, "Your Orders", Toast.LENGTH_SHORT).show();
                Intent k = new Intent(getApplicationContext(), OrderDetails.class);
                startActivity(k);
                return true;
            case 3:
                // Handle item 3 click
                Toast.makeText(this, "About", Toast.LENGTH_SHORT).show();
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }
}
