package com.example.digital.cookordie;


import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;


/**
 * A simple {@link Fragment} subclass.
 */
public class RecetaView extends Fragment {
    public static final String KEY_TITULO = "titulo";
    public static final String KEY_IMAGE = "foto";
    public static final String KEY_INGREDIENTES = "ingredientes";
    public static final String KEY_PREPARACION = "preparacion";

    public static RecetaView fabrica(Receta dato){

        RecetaView fragment = new RecetaView();

        Bundle bundle = new Bundle();

        bundle.putString(RecetaView.KEY_TITULO, dato.getTitulo());
        bundle.putInt(RecetaView.KEY_IMAGE, dato.getFoto());
        bundle.putString(RecetaView.KEY_INGREDIENTES, dato.getIngredientes());
        bundle.putString(RecetaView.KEY_PREPARACION, dato.getPreparacion());

        fragment.setArguments(bundle);

        return fragment;
    }


    public RecetaView() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view  = inflater.inflate(R.layout.fragment_receta_view, container, false);

        // Obtengo el bundle
        Bundle bundle = getArguments();
        // Datos
        String titulo = bundle.getString(KEY_TITULO);
        Integer imagen = bundle.getInt(KEY_IMAGE);
        String ingredientes = bundle.getString(KEY_INGREDIENTES);
        String preparacion= bundle.getString(KEY_PREPARACION);

        // Busco componentes
        TextView tituloView = view.findViewById(R.id.tituloView);
        ImageView imageView = view.findViewById(R.id.imagenView);
        TextView ingredientesView = view.findViewById(R.id.ingredientesView);
        TextView preparacionView = view.findViewById(R.id.preparacionView);



        // Seteo los datos
        tituloView.setText(titulo);
        imageView.setImageResource(imagen);
        ingredientesView.setText(ingredientes);
        preparacionView.setText(preparacion);


        return view;
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
    }
}
