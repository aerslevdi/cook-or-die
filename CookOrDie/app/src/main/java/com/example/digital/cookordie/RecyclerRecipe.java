package com.example.digital.cookordie;


import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;


/**
 * A simple {@link Fragment} subclass.
 */
public class RecyclerRecipe extends Fragment implements Adapter.AdapterListener {



    private RecyclerListener recyclerListener;
    private List<Receta> recetas = (new DAORecetas().obtenerRecetas());
    private List<Receta> recetasFiltered = new ArrayList<>(recetas);
    private Adapter recyclerAdapter= new Adapter(recetas, this);

    public RecyclerRecipe() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view= inflater.inflate(R.layout.fragment_recycler_recipe, container, false);




        RecyclerView recyclerView = view.findViewById(R.id.recyclerReceta);


        EditText searchBar = view.findViewById(R.id.searchBox);
        searchBar.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                filter(s.toString());
            }
        });


        recyclerView.setHasFixedSize(true);

        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getContext(), LinearLayoutManager.VERTICAL, false);
        recyclerView.setLayoutManager(layoutManager);


        recyclerView.setAdapter(recyclerAdapter);

        return view;
    }

    private void filter(String query){
        ArrayList<Receta> filteredList = new ArrayList<>();
        for (Receta receta: recetasFiltered){
            if (receta.getTitulo().toLowerCase().contains(query.toLowerCase())){
                filteredList.add(receta);
            }
        }
        recyclerAdapter.filterList(filteredList);
        recetas = new ArrayList<>(filteredList);
    }

    @Override
    public void recibir(Receta receta, Integer posicion) {
        recyclerListener.enviar(receta, posicion);
    }

    //INTERFAZ
    public interface RecyclerListener {
        void enviar(Receta receta, Integer posicion);
    }

    //ON ATTACH

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        this.recyclerListener = (RecyclerListener) context;
    }

}
