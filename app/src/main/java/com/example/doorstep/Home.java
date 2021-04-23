package com.example.doorstep;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.bottomnavigation.BottomNavigationView;

public class Home extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.home);

        BottomNavigationView bottomNavigationView = (BottomNavigationView)
                findViewById(R.id.bottom_navigation);

        bottomNavigationView.setOnNavigationItemSelectedListener(
                new BottomNavigationView.OnNavigationItemSelectedListener() {
                    @Override
                    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                        switch (item.getItemId()) {
                            case R.id.action_shoppingcart:
                                Toast.makeText(getApplicationContext(), "Cart", Toast.LENGTH_SHORT).show();
                                break;
                            case R.id.action_search:
                                Toast.makeText(getApplicationContext(), "Search", Toast.LENGTH_SHORT).show();
                                break;
                            case R.id.action_profile:
                                Intent inentProfile = new Intent(Home.this, ProfileActivity.class);
                                startActivity(inentProfile);
                                break;
                        }
                        return true;
                    }
                });


    }
}
