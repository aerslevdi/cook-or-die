package com.example.digital.cookordie;

import android.content.Intent;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import java.util.List;

public class RecipeView extends AppCompatActivity {



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recipe_view);

        final RecetaView recetaView = new RecetaView();

        List<Receta> datos;
        List<Fragment> fragments;
        DAORecetas daoRecetas = new DAORecetas();
        datos = daoRecetas.obtenerRecetas();

        fragments = recetaView.fabricaLista(datos);


        ViewPager viewPager = findViewById(R.id.viewPager);
        ViewPagerAdapter adapter = new ViewPagerAdapter(getSupportFragmentManager(),fragments, datos);
        viewPager.setAdapter(adapter);

        Intent intent = getIntent();
        Bundle bundle = intent.getExtras();
        recetaView.setArguments(bundle);

    }
}
