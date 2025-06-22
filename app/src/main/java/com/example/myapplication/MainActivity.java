package com.example.myapplication;

import android.os.Bundle;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.google.android.material.bottomnavigation.BottomNavigationView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        // Setup Bottom Navigation
        BottomNavigationView bottomNavigation = findViewById(R.id.bottom_navigation);
        bottomNavigation.setOnItemSelectedListener(item -> {
            int itemId = item.getItemId();
            if (itemId == R.id.nav_home) {
                Toast.makeText(this, "Home selected", Toast.LENGTH_SHORT).show();
                return true;
            } else if (itemId == R.id.nav_friends) {
                Toast.makeText(this, "Friends selected", Toast.LENGTH_SHORT).show();
                return true;
            } else if (itemId == R.id.nav_settings) {
                Toast.makeText(this, "Settings selected", Toast.LENGTH_SHORT).show();
                return true;
            } else if (itemId == R.id.nav_tools) {
                Toast.makeText(this, "Tools selected", Toast.LENGTH_SHORT).show();
                return true;
            }
            return false;
        });

        // Set default selection
        bottomNavigation.setSelectedItemId(R.id.nav_home);
    }
}