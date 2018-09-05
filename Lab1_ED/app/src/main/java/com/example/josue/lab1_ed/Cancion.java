package com.example.josue.lab1_ed;

public class Cancion {

    //Se declaran las variables
    public String Nombre = "";
    public String Artista = "";
    public Double Duracion = 0.0;



    //Se inicializa el constructor
    public Cancion(String nombre, String artista, Double duracion){

        this.Nombre = nombre;
        this.Artista = artista;
        this.Duracion = duracion;
    }

    public String getNombre() {
        return Nombre;
    }

    public void setNombre(String nombre) {
        Nombre = nombre;
    }

    public String getArtista() {
        return Artista;
    }

    public void setArtista(String artista) {
        Artista = artista;
    }

    public String getDuracion() {
        String DuracionString = Duracion.toString().replace(".",":");
        return DuracionString;
    }

    public int getDuracioni() {
        return Duracion.intValue();
    }

    public void setDuracion(Double duracion) {
        Duracion = duracion;
    }

}
