package com.example.nhom10;

import androidx.annotation.NonNull;
import android.os.Bundle;
import android.view.MenuItem;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationBarView;


public class MainActivity extends AppCompatActivity {
    Fragment fragment;
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
        //load fragment
        BottomNavigationView mnBottom = (BottomNavigationView) findViewById(R.id.navMenu);
        fragment = new HomeFragment();
        loadFragment(fragment);
        mnBottom.setOnItemSelectedListener(new NavigationBarView.OnItemSelectedListener() {


            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                int id = item.getItemId();
                if (id == R.id.mnHome) {
                    fragment = new HomeFragment();
                    loadFragment(fragment);
                    return true;
                } else if (id == R.id.mnShop) {
                    fragment = new ShopFragment();
                    loadFragment(fragment);
                    return true;
                } else if (id == R.id.mnFavorite) {
                    fragment = new FavoriteFragment();
                    loadFragment(fragment);
                    return true;
                } else if (id == R.id.mnBag) {
                    fragment = new CartFragment();
                    loadFragment(fragment);
                    return true;
                } else if (id == R.id.mnProfile) {
                    fragment = new ProfileFragment();
                    loadFragment(fragment);
                    return true;
                } else
                    return false;
            }
        });
    }
    void loadFragment(Fragment fragment){
        FragmentTransaction fmTran = getSupportFragmentManager().beginTransaction();
        fmTran.replace(R.id.main_fragment, fragment);
        fmTran.addToBackStack(null);
        fmTran.commit();
    }
}