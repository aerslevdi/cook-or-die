package com.example.digital.cookordie;

import android.support.annotation.NonNull;
import android.support.design.widget.NavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;

public class MainActivity extends AppCompatActivity {

    private DrawerLayout drawerMenu;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //FRAGMENTS
        final RecyclerRecipe recyclerRecipe = new RecyclerRecipe();
        final AboutUs aboutUs = new AboutUs();

        drawerMenu = findViewById(R.id.drawerContainer);
        NavigationView navigationView = findViewById(R.id.navigationView);

        //LISTENER

        navigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                drawerMenu.closeDrawers();
                switch (item.getItemId()){
                    case R.id.recetas:
                        reemplazarFragment(recyclerRecipe);
                        return true;
                    case R.id.about:
                        reemplazarFragment(aboutUs);
                        return true;


                }
                return false;
            }
        });
    }
    private void reemplazarFragment(Fragment fragment){
        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.frameLayout, fragment);
        fragmentTransaction.commit();
    }
}
