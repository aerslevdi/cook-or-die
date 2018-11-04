package com.example.digital.cookordie;


import android.app.SearchManager;
import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.SearchView;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.View;
import android.view.ViewGroup;
import android.support.v7.widget.Toolbar;

import java.util.ArrayList;
import java.util.List;


/**
 * A simple {@link Fragment} subclass.
 */
public class RecyclerRecipe extends Fragment implements Adapter.AdapterListener,  com.example.digital.cookordie.Adapter.SearchListener {



    private RecyclerListener recyclerListener;
    private SearchView searchView;

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
        Toolbar toolbar = view.findViewById(R.id.toolbar);
        ((AppCompatActivity)getActivity()).setSupportActionBar(toolbar);


        recyclerView.setHasFixedSize(true);

        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getContext(), LinearLayoutManager.VERTICAL, false);
        recyclerView.setLayoutManager(layoutManager);

        final Adapter recyclerAdapter= new Adapter(recetas, this, recetas);
        recyclerView.setAdapter(recyclerAdapter);
        setHasOptionsMenu(true);






        return view;
    }
    @Override
    public void onCreateOptionsMenu(Menu menu, MenuInflater inflater) {
        inflater.inflate(R.menu.menu_main, menu);
        SearchManager searchManager = (SearchManager) getContext().getSystemService(Context.SEARCH_SERVICE);
        searchView = (SearchView) menu.findItem(R.id.action_search);
        searchView.setSearchableInfo(searchManager.getSearchableInfo(getActivity().getComponentName()));
        searchView.setMaxWidth(Integer.MAX_VALUE);

        // listening to search query text change
        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                // filter recycler view when query submitted
                .getFilter().filter(query);
                return false;
            }

            @Override
            public boolean onQueryTextChange(String query) {
                // filter recycler view when text is changed
                Adapter.getFilter().filter(query);
                return false;
            }
        });
    }



    @Override
    public void recibir(Receta receta, Integer posicion) {
        recyclerListener.enviar(receta, posicion);
    }
        //SEARCHBAR



    @Override
    public void recetaSeleccion(Receta receta) {

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
