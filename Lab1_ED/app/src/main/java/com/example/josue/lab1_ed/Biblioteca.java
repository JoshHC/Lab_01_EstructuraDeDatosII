package com.example.josue.lab1_ed;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class Biblioteca {
    //Se crea un Diccionario de Canciones para posteriormente utilizarlo para la busqueda.
    public Map<String, Cancion> ListadeCanciones;
    static public Map<String, Cancion> PlayList = new TreeMap<String,Cancion>();

    public Biblioteca()
    {
        //Se inicializa el Diccionario y se agregan las canciones.
        ListadeCanciones = new TreeMap<String,Cancion>();
        ListadeCanciones.put("Be Happy",new Cancion("Be Happy","Bob Marley",2.35));
        ListadeCanciones.put("Wrecking Ball",new Cancion("Wrecking Ball","Miley Cirus",2.50));
        ListadeCanciones.put("Break Free",new Cancion("Break Free","Ariana Grande",3.35));
        ListadeCanciones.put("Sorry",new Cancion("Sorry","Justin Bieber",4.35));
        ListadeCanciones.put("Chandelier",new Cancion("Chandelier","Sia",1.30));
        ListadeCanciones.put("Mercy",new Cancion("Mercy","Shawn Mendez",5.00));
        ListadeCanciones.put("Shape of You",new Cancion("Shape of You","Ed Sheeran",5.35));
        ListadeCanciones.put("we Don't Talk Anymore",new Cancion("We Don't Talk Anymore","Charlie Puth",3.15));
        ListadeCanciones.put("Hymn For the Weekend",new Cancion("Hymn For The Weekend","Coldplay",4.25));
        ListadeCanciones.put("Thunder",new Cancion("Thunder","Imagine Dragons",3.55));
        ListadeCanciones.put("No Tears Left to Cry",new Cancion("No Tears Left to Cry","Ariana Grande",2.12));
        ListadeCanciones.put("One Kiss",new Cancion("One Kiss","Dua Lipa",3.05));
        ListadeCanciones.put("Havana",new Cancion("Havana","Camila Cabello",4.05));
        ListadeCanciones.put("Back To You",new Cancion("Back To You","Selena Gomez",1.20));
        ListadeCanciones.put("New Rules",new Cancion("New Rules","Dua Lipa",5.30));
        ListadeCanciones.put("PassionFruit",new Cancion("PassionFruit","Drake",2.40));
        ListadeCanciones.put("Stay",new Cancion("Stay","Alessia Cara",2.02));
        ListadeCanciones.put("Something Just Like This",new Cancion("Something Just Like This","Coldplay",2.15));
        ListadeCanciones.put("Closer",new Cancion("Closer","The Chainsmokers",3.25));
        ListadeCanciones.put("Treat You Better",new Cancion("Treat You Better","Shawn Mendez",5.55));
    }

    //Devuelve un Listado de las canciones en formato String para mostrarlas en el ListText
    public List<String> Devolucion ()
    {
        List<String> Listado = new ArrayList<>();
        for (Cancion s : ListadeCanciones.values()) {
            String Duracion = s.Duracion.toString().replace(".",":");
            Listado.add("Nombre: "+s.Nombre+" Artista: "+s.Artista+" Duracion: "+Duracion);
        }
        return Listado;
    }
    //Devuelve un Listado de las canciones en formato de tipo Cancion para la busqueda y otros usos.
    public ArrayList<Cancion> DevolucionDeObjetos ()
    {
        ArrayList<Cancion> Listado = new ArrayList<>();
        for (Cancion s : ListadeCanciones.values()) {
            Listado.add(s);
        }
        return Listado;
    }
    //Devuelve un Listado de las canciones en formato String para mostrarlas en el ListText
    public List<String> DevolucionPlayList ()
    {
        List<String> Listado = new ArrayList<>();
        for (Cancion s : PlayList.values()) {
            Listado.add("Nombre: "+s.Nombre+" Artista: "+s.Artista+" Duracion: "+s.Duracion);
        }
        return Listado;
    }
    //Devuelve un Listado de las canciones en formato de tipo Cancion para la busqueda y otros usos.
    public ArrayList<Cancion> DevolucionDeObjetosPlayList ()
    {
        ArrayList<Cancion> Listado = new ArrayList<>();
        for (Cancion s : PlayList.values()) {
            Listado.add(s);
        }
        return Listado;
    }
    public void llenarPlayList(Cancion NuevaCancion)
    {
        PlayList.put(NuevaCancion.Nombre.toString(), new Cancion(NuevaCancion.Nombre,NuevaCancion.Artista,NuevaCancion.Duracion));
    }

     public ArrayList<Cancion> OrdenarPorDuracion(String Orden)
     {
        ArrayList<Cancion> cancionporduracion = new ArrayList<Cancion>(PlayList.values());

        if(Orden == "Ascendente") {
            Collections.sort(cancionporduracion, new Comparator<Cancion>() {
                public int compare(Cancion o1, Cancion o2) {
                    return o1.getDuracioni() - o2.getDuracioni();
                }
            });
        }else if (Orden == "Descendente")
        {
            Collections.reverse(cancionporduracion);
        }
         return cancionporduracion;
     }

     public ArrayList<Cancion> OrdenarPorNombre(String Orden)
     {
         ArrayList<Cancion> cancionpornombre = new ArrayList<Cancion>(PlayList.values());

         if(Orden == "Ascendente") {
             Collections.sort(cancionpornombre, new ComparadorNombres());
         }else if (Orden == "Descendente")
         {
             Collections.sort(cancionpornombre, new ComparadorNombres());
             Collections.reverse(cancionpornombre);
         }
         return cancionpornombre;
     }


}

    class ComparadorNombres implements Comparator<Cancion> {
    public int compare(Cancion a, Cancion b) {
        return a.getNombre().compareTo(b.getNombre());
    }
}
