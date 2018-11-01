package com.example.digital.cookordie;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;


/**
 * A simple {@link Fragment} subclass.
 */
public class RecyclerRecipe extends Fragment {
    private static final String KEY_TITULO = "titulo";
    private static final String KEY_IMAGE = "foto";



    public RecyclerRecipe() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view= inflater.inflate(R.layout.fragment_recycler_recipe, container, false);


        List<Receta> recetas;
        RecyclerView recyclerView = view.findViewById(R.id.recyclerReceta);
        DAORecetas daoRecetas = new DAORecetas();
        recetas = daoRecetas.obtenerRecetas();


        recyclerView.setHasFixedSize(true);

        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getContext(), LinearLayoutManager.VERTICAL, false);
        recyclerView.setLayoutManager(layoutManager);

        Adapter recyclerAdapter= new Adapter(recetas);
        recyclerView.setAdapter(recyclerAdapter);

        return view;
    }

}