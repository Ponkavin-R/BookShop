package com.example.booksmyshop;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class Home extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        TextView t1=(TextView) findViewById(R.id.sellbook);
        t1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i=new Intent(Home.this, crudoperation.class);
                startActivity(i);
            }
        });

        Button thriller=(Button) findViewById(R.id.thriller);
        thriller.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i=new Intent(Home.this, Thriller.class);
                startActivity(i);
            }
        });

        Button fantacy=(Button) findViewById(R.id.fantasy);
        fantacy.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i=new Intent(Home.this, Fantacy.class);
                startActivity(i);
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

        MenuItem mnu2 = menu.add(0, 1, 1, "Setting");
        mnu2.setAlphabeticShortcut('b');

        MenuItem mnu3 = menu.add(0, 2, 2, "About");
        mnu3.setAlphabeticShortcut('c');
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case 0:
                // Handle item 1 click
                Toast.makeText(this, "Profile", Toast.LENGTH_SHORT).show();
                Intent i=new Intent(getApplicationContext(), Profile.class);
                startActivity(i);
                return true;
            case 1:
                // Handle item 2 click
                Toast.makeText(this, "Item 2 clicked", Toast.LENGTH_SHORT).show();
                return true;
            case 2:
                // Handle item 3 click
                Toast.makeText(this, "Item 3 clicked", Toast.LENGTH_SHORT).show();
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }
}