package com.example.hopper;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import android.widget.Toast;

import com.example.hopper.fragments.PostsFragment;
import com.example.hopper.fragments.MapFragment;
import com.google.android.gms.maps.GoogleMap;


public class MainActivity extends AppCompatActivity {

    private BottomNavigationView bottomNavigationView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        final FragmentManager fragmentManager = getSupportFragmentManager();


        bottomNavigationView = findViewById(R.id.bottom_navigation);

        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                Fragment fragment = null;
                switch (item.getItemId()) {
                    case R.id.action_home:
                        fragment = new PostsFragment();
                        Toast.makeText(MainActivity.this, "Home!", Toast.LENGTH_SHORT).show();
                        break;
                    case R.id.action_map:
                        fragment = new MapFragment();
                        Toast.makeText(MainActivity.this, "Navigation!", Toast.LENGTH_SHORT).show();
                     break;
//                    case R.id.action_profile:
//                        fragment = new ProfileFragment();
//                        Toast.makeText(MainActivity.this, "Profile!", Toast.LENGTH_SHORT).show();
                    default:
                        break;
                }
                fragmentManager.beginTransaction().replace(R.id.flContainer, fragment).commit();
                return true;
            }
        });
        // Set default selection
        bottomNavigationView.setSelectedItemId(R.id.action_home);

    }


}
