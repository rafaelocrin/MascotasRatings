package com.zocrosfera.ratingmascotas.pojo;

/**
 * Created by rafaelocrin on 16/11/16.
 */

public class Mascota {

    private int id;
    private String nombre;
    private String rating;
    private int foto;

    public Mascota(){

    }

    public Mascota(String nombre, String rating, int foto){
        this.nombre = nombre;
        this.rating = rating;
        this.foto = foto;
    }

    public String getRating() {
        return rating;
    }

    public void setRating(String rating) {
        this.rating = rating;
    }

    public int getFoto() {
        return foto;
    }

    public void setFoto(int foto) {
        this.foto = foto;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

}
