/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.awt.List;
import java.util.ArrayList;

/**
 *
 * @author kamimuraf
 */
public class Book {
    private String titulo, autor, data, comentario, nota, idioma;
    private int situacao;
    private ArrayList<String> tags = new ArrayList<>();

    public Book(String titulo, String autor, String data, String comentario, String nota, String idioma, int situacao) {
        this.titulo = titulo;
        this.autor = autor;
        this.data = data;
        this.comentario = comentario;
        this.nota = nota;
        this.idioma = idioma;
        this.situacao = situacao;
        int paginas;
    }

    public int getSituacao() {
        return situacao;
    }

    public void setSituacao(int situacao) {
        this.situacao = situacao;
    }
    
    
    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getAutor() {
        return autor;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    public String getComentario() {
        return comentario;
    }

    public void setComentario(String comentario) {
        this.comentario = comentario;
    }

    public String getNota() {
        return nota;
    }

    public void setNota(String nota) {
        this.nota = nota;
    }

    public String getIdioma() {
        return idioma;
    }

    public void setIdioma(String idioma) {
        this.idioma = idioma;
    }

    public int getSituação() {
        return situacao;
    }

    public void setSituação(int situação) {
        this.situacao = situação;
    }

    public ArrayList<String> getTags() {
        return tags;
    }

    public void setTags(ArrayList<String> tags) {
        this.tags = tags;
    }
    
    
    
    
}
