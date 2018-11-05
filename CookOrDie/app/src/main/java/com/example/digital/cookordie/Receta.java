package com.example.digital.cookordie;

public class Receta {
    //ATRIBUTOS

    private String titulo;
    private Integer foto;
    private String ingredientes;
    private String preparacion;

    //CONSTRUCTOR


    public Receta(String titulo, Integer foto, String ingredientes, String preparacion) {
        this.titulo = titulo;
        this.foto = foto;
        this.ingredientes = ingredientes;
        this.preparacion = preparacion;
    }

    //GETTER/SETTER


    public String getTitulo() {
        return titulo;
    }

    public Integer getFoto() {
        return foto;
    }

    public String getIngredientes() {
        return ingredientes;
    }

    public String getPreparacion() {
        return preparacion;
    }

    //METODOS


    @Override
    public String toString() {
        return "Receta{" +
                "title='" + titulo + '\'' +
                ", foto=" + foto + '\'' +
                ", ingredientes='" + ingredientes + '\''
                + ", preparacion='" + preparacion +
                '}';
    }
}
