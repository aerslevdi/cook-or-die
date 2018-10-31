package com.example.digital.cookordie;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

public class Adapter extends RecyclerView.Adapter<Adapter.RecetaViewHolder>{

    private List<Receta> recetas;

    //CONSTRUCTOR


    public Adapter(List<Receta> recetas) {
        this.recetas = recetas;
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

    public interface AdapterListener {
        void recibir (Receta receta);
    }

    class RecetaViewHolder extends RecyclerView.ViewHolder{

        private ImageView imagen;
        private TextView titulo;

        public RecetaViewHolder(View itemView) {
            super(itemView);
            titulo = itemView.findViewById(R.id.tituloReceta);
            imagen = itemView.findViewById(R.id.imageReceta);

        }
        public void cargar (Receta receta){
            titulo.setText(receta.getTitulo());
            imagen.setImageResource(receta.getFoto());
        }
    }
}
