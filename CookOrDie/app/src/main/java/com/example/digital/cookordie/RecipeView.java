package com.example.digital.cookordie;

import android.content.Intent;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import java.util.ArrayList;
import java.util.List;

public class RecipeView extends AppCompatActivity {
    public static final String KEY_POS = "posicion";



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recipe_view);


        List<Receta> datos;
        DAORecetas daoRecetas = new DAORecetas();
        datos = daoRecetas.obtenerRecetas();


        ViewPager viewPager = findViewById(R.id.viewPager);
        ViewPagerAdapter adapter = new ViewPagerAdapter(getSupportFragmentManager(), datos);
        viewPager.setAdapter(adapter);

        Intent intent = getIntent();
        Bundle bundle = intent.getExtras();
        Integer posicion = bundle.getInt(KEY_POS);




        viewPager.setCurrentItem(posicion);

    }
}
