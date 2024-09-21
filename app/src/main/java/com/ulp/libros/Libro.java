package com.ulp.libros;

import java.io.Serializable;

public class Libro implements Serializable {
    private String titulo;
    private String autor;
    private int anio;
    private String genero;
    private String descripcion;
    private int foto;

    public Libro(String titulo, String autor, int anio, String genero, String descripcion, int foto) {
        this.titulo = titulo;
        this.autor = autor;
        this.anio = anio;
        this.genero = genero;
        this.descripcion = descripcion;
        this.foto = foto;
    }

    public String getTitulo() {
        return titulo;
    }

    public String getAutor() {
        return autor;
    }

    public int getAnio() {
        return anio;
    }

    public String getGenero() {
        return genero;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public int getFoto() {
        return foto;
    }
}
