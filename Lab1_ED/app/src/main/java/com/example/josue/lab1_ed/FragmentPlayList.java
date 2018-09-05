package com.example.josue.lab1_ed;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.Switch;
import android.widget.Toast;

import java.util.ArrayList;



public class FragmentPlayList extends Fragment {

    //Declaracion del Diccionario de Uso Global
    Biblioteca ObjBiblioteca = new Biblioteca();
    //Se crea la lista que recibira las canciones en formato Cancion para la busqueda y otros usos.
    ArrayList<Cancion> Rockola = ObjBiblioteca.DevolucionDeObjetosPlayList();
    //Se crea la ListView a Usar
    ListView Lista;
    Button Ordenar;
    Switch Sw;
    RadioButton btnNombre;
    RadioButton btnDuracion;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        //Creamos un Objeto Tipo view para acceder a la vista del MainActivity desde este
        View view = inflater.inflate(R.layout.fragment_fragment_play_list, container, false);
        //Le Asignamos a la Lista la Vista
        Lista = view.findViewById(R.id.PlayListView);
        //Creamos el Adaptador enviandole los parametros
        final CancionAdapter Adaptador = new CancionAdapter(getActivity(),Rockola);
        //Lo Asignamos
        Lista.setAdapter(Adaptador);
        //Lo Habilitamos para Filtrar
        Lista.setTextFilterEnabled(true);
        Ordenar = view.findViewById(R.id.btnOrdenar);
        Sw = view.findViewById(R.id.sw);
        btnNombre = view.findViewById(R.id.rbtnNombre);
        btnDuracion = view.findViewById(R.id.rbtnDuracion);
        Ordenar.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){

                if (btnDuracion.isChecked()&& btnNombre.isChecked() == true)
                {
                    Toast.makeText(getActivity(),"NO PUEDE SELECCIONAR 2 PARAMETROS" ,Toast.LENGTH_SHORT).show();
                    btnNombre.setChecked(false);
                    btnDuracion.setChecked(false);
                }
                else if(btnNombre.isChecked() == true)
                {

                    if(Sw.isChecked() == true)
                    {
                        CancionAdapter AdaptadorL = new CancionAdapter(getActivity(),ObjBiblioteca.OrdenarPorNombre("Ascendente"));
                        Lista.setAdapter(AdaptadorL);
                        Lista.setTextFilterEnabled(true);

                    }else if (Sw.isChecked() == false)
                    {
                        CancionAdapter AdaptadorL = new CancionAdapter(getActivity(),ObjBiblioteca.OrdenarPorNombre("Descendente"));
                        Lista.setAdapter(AdaptadorL);
                        Lista.setTextFilterEnabled(true);
                    }

                }else if(btnDuracion.isChecked() == true)
                {
                    if(Sw.isChecked() == true)
                    {
                       CancionAdapter AdaptadorL = new CancionAdapter(getActivity(),ObjBiblioteca.OrdenarPorDuracion("Ascendente"));
                        Lista.setAdapter(AdaptadorL);
                        Lista.setTextFilterEnabled(true);

                    }else if (Sw.isChecked() == false)
                    {
                        CancionAdapter AdaptadorL = new CancionAdapter(getActivity(),ObjBiblioteca.OrdenarPorDuracion("Descendente"));
                        Lista.setAdapter(AdaptadorL);
                        Lista.setTextFilterEnabled(true);
                    }
                }

            }
        });
       return view;
    }
}
