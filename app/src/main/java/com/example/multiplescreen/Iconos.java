package com.example.multiplescreen;

public class Iconos {

    private int foto;
    private String titulo;


    public Iconos(int foto, String titulo) {
        this.foto = foto;
        this.titulo = titulo;
    }

    public int getFoto() {
        return foto;
    }

    public String getTitulo() {
        return titulo;
    }



    public void setFoto(int foto, String titulo, String descrip) {
        this.foto = foto;
        this.titulo = titulo;
    }
}