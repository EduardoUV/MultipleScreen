package com.example.multiplescreen.adaptador;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.GridLayout;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.multiplescreen.Iconos;
import com.example.multiplescreen.interfaz.OnIconSelected;
import com.example.multiplescreen.R;

import java.util.ArrayList;
import java.util.ResourceBundle;

import static android.app.PendingIntent.getActivity;


public class AdaptadorIconos extends RecyclerView.Adapter<AdaptadorIconos.ViewHolderIconos> {

    ArrayList<Iconos> listIconos;
    OnIconSelected listener;     /////////////////////////////////// agrege esto
    Context context;

    public AdaptadorIconos(ArrayList<Iconos> listIconos, OnIconSelected listener) {

        this.listIconos = listIconos;
        this.listener = listener;  //////////////////////////////////////// agrege esto

    }

    @Override
    public ViewHolderIconos onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_icons, null, false);

        return new ViewHolderIconos(view);
    }


    @Override
    public void onBindViewHolder(final ViewHolderIconos holder, final int position) {


        holder.textotitulo.setText(listIconos.get(position).getTitulo());
        holder.i.setImageResource(listIconos.get(position).getFoto()); //aqui cambie

////////////////////////////////////////////////////// agregando lo del profe
/*
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                listener.onIconItemSelected(listIconos.get(position).getTitulo());

            }
        });

*/
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String text = listIconos.get(position).getTitulo();
                int icon = listIconos.get(position).getFoto();

                listener.onIconItemSelectedDetails(icon,text);
            }
        });

////////////////////////////////////////////////////////


    }

    @Override
    public int getItemCount() {

        return listIconos.size();
    }




    public class ViewHolderIconos extends RecyclerView.ViewHolder {

        TextView textotitulo;
        ImageView i;


        public ViewHolderIconos(View itemView) {
            super(itemView);

            i = (ImageView) itemView.findViewById(R.id.img_xml);
            textotitulo = (TextView) itemView.findViewById(R.id.idtitulo);


        }
    }
}