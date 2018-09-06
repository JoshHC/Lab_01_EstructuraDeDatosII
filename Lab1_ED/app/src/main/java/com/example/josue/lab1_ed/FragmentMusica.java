package com.example.josue.lab1_ed;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.SearchView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;



public class FragmentMusica extends Fragment {

    //Declaracion del Diccionario de Uso Global
    Biblioteca ObjBiblioteca = new Biblioteca();
    //Se crea la Lista que recibira las canciones en formato string para mostrarlas en el ListText
    List<String> NuevaLista = ObjBiblioteca.Devolucion();
    //Se crea la lista que recibira las canciones en formato Cancion para la busqueda y otros usos.
    ArrayList<Cancion> Rockola = ObjBiblioteca.DevolucionDeObjetos();
    //Se crea la ListView a Usar
    ListView Lista;
    //Se crea un Objeto Tipo SearchView para la Barra de Busqueda
    SearchView Buscador;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        //Creamos un Objeto Tipo view para acceder a la vista del MainActivity desde este
        View view = inflater.inflate(R.layout.fragment_fragment_musica, container, false);
        //Le Asignamos a la Lista la Vista
        Lista = view.findViewById(R.id.ListaParaMostrar);
        //Creamos el Adaptador enviandole los parametros
        final CancionAdapter Adaptador = new CancionAdapter(getActivity(),Rockola);
        //Lo Asignamos
        Lista.setAdapter(Adaptador);
        //Lo Habilitamos para Filtrar
        Lista.setTextFilterEnabled(true);

        //Se le asigna la vista al Buscador
        Buscador = view.findViewById(R.id.searchView);
        //Lo Programamos para Filtrar.
        Buscador.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                return false;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                if (TextUtils.isEmpty(newText)) {
                    Lista.clearTextFilter();
                } else {
                    Lista.setFilterText(newText);
                }
                return true;
            }
        });
        //Se declara la funcion para que capte el evento OnClick
        Lista.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                ObjBiblioteca.llenarPlayList(Rockola.get(position));
                Toast.makeText(getActivity(),Rockola.get(position).Nombre + " HA SIDO AÑADIDA A TU PLAYLIST" ,Toast.LENGTH_SHORT).show();
            }
        });
        return view;
    }

    @Override
    public void onCreateOptionsMenu(Menu menu, MenuInflater inflater) {
        // Do something that differs the Activity's menu here
        super.onCreateOptionsMenu(menu, inflater);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
    }
}
