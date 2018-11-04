package com.example.digital.cookordie;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Filter;
import android.widget.Filterable;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class Adapter extends RecyclerView.Adapter<Adapter.RecetaViewHolder> implements Filterable {

    private List<Receta> recetas;
    private AdapterListener adapterListener;
    private List<Receta> recetasFiltered;


    //CONSTRUCTOR


    public Adapter(List<Receta> recetas,AdapterListener adapterListener, List<Receta> recetasFiltered) {

        this.recetas = recetas;
        this.adapterListener = adapterListener;
        this.recetasFiltered = recetas;
    }

    @NonNull
    @Override
    public Adapter.RecetaViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        Context context = parent.getContext();
        LayoutInflater layoutInflater = LayoutInflater.from(context);
        View view = layoutInflater.inflate(R.layout.card_receta, parent, false);
        RecetaViewHolder recetaViewHolder = new RecetaViewHolder(view);
        return recetaViewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull Adapter.RecetaViewHolder holder, int position) {
        Receta receta = recetas.get(position);
        holder.cargar(receta);
    }

    @Override
    public int getItemCount() {
        return recetas.size();

    }

    @Override
    public Filter getFilter() {
        return new Filter() {
            @Override
            protected FilterResults performFiltering(CharSequence constraint) {
                String respuesta = constraint.toString();
                if (respuesta.isEmpty()){
                    recetasFiltered = recetas;
                } else {
                    List<Receta>filter = new ArrayList<>();
                    for (Receta receta : recetas){
                        if (receta.getTitulo().toLowerCase().contains(respuesta.toLowerCase())){
                            filter.add(receta);
                        }
                    }
                   recetasFiltered = filter;

                }
                FilterResults filterResults = new FilterResults();
                filterResults.values = recetasFiltered;
                return filterResults;
            }

            @Override
            protected void publishResults(CharSequence constraint, FilterResults results) {
            recetasFiltered = (ArrayList<Receta>)results.values;
            notifyDataSetChanged();
            }
        };
    }

    //INTERFACE-SEARCH
    public interface SearchListener {
        void recetaSeleccion (Receta receta);
    }

    //VIEWHOLDER
    class RecetaViewHolder extends RecyclerView.ViewHolder{

        private ImageView imagen;
        private TextView titulo;

        public RecetaViewHolder(View itemView) {
            super(itemView);
            titulo = itemView.findViewById(R.id.tituloReceta);
            imagen = itemView.findViewById(R.id.imageReceta);
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                    Receta receta = recetas.get(getAdapterPosition());
                   adapterListener.recibir(receta, getAdapterPosition());


                }
            });


        }


        public void cargar (Receta receta){
            titulo.setText(receta.getTitulo());
            imagen.setImageResource(receta.getFoto());
        }
    }
    public interface AdapterListener {
        void recibir(Receta receta, Integer posicion);
    }
}
