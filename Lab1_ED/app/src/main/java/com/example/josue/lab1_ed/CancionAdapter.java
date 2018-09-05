package com.example.josue.lab1_ed;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Filter;
import android.widget.Filterable;
import android.widget.TextView;

import java.util.ArrayList;

public class CancionAdapter extends BaseAdapter implements Filterable {

    protected Activity activity;
    protected ArrayList<Cancion> items;
    protected ArrayList<Cancion> orig;


    public CancionAdapter(Activity activity, ArrayList<Cancion> items) {
        this.activity = activity;
        this.items = items;
    }


    public void clear() {
        items.clear();
    }

    public void addAll(ArrayList<Cancion> Cancion) {
        for (int i =0; i < Cancion.size(); i++) {
            items.add(Cancion.get(i));
        }
    }


    @Override
    public int getCount() {
        return items.size();
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    public Filter getFilter() {
        return new Filter(){
            @Override
            protected FilterResults performFiltering(CharSequence constraint) {
                final FilterResults oReturn = new FilterResults();
                final ArrayList<Cancion> results = new ArrayList<Cancion>();
                if (orig == null)
                    orig = items;
                if (constraint != null) {
                    if (orig != null && orig.size() > 0) {
                        for (final Cancion g : orig) {
                            if (g.getNombre().toLowerCase()
                                    .contains(constraint.toString()))
                                results.add(g);
                        }
                    }
                    oReturn.values = results;
                }
                return oReturn;
            }

            @SuppressWarnings("unchecked")
            @Override
            protected void publishResults(CharSequence constraint,
                                          FilterResults results) {
                items = (ArrayList<Cancion>) results.values;
                notifyDataSetChanged();
            }
        };
    }

    public void notifyDataSetChanged() {
        super.notifyDataSetChanged();
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        View v = convertView;

        if (convertView == null) {
            LayoutInflater inf = (LayoutInflater) activity.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            v = inf.inflate(R.layout.formato, null);
        }

        Cancion dir = items.get(position);

        TextView Nombre = (TextView) v.findViewById(R.id.Nombre);
        Nombre.setText(dir.getNombre());
        TextView Duracion = (TextView) v.findViewById(R.id.Duracion);
        Duracion.setText("Duración: "+dir.getDuracion());
        TextView Artista = (TextView) v.findViewById(R.id.Artista);
        Artista.setText("Artista: "+dir.getArtista());

        return v;
    }
}
