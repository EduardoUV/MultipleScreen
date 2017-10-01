package com.example.multiplescreen.fragmento;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.multiplescreen.Iconos;
import com.example.multiplescreen.interfaz.OnIconSelected;
import com.example.multiplescreen.R;
import com.example.multiplescreen.adaptador.AdaptadorIconos;

import java.util.ArrayList;

public class FragmentIco extends Fragment {

    ArrayList<Iconos> listaIco;
    RecyclerView recyclerIconos;

    ////////////////////////////////////////////// agrege esto

    OnIconSelected listener;


    //////////////////////////////////////////// agrege esto

    public void onAttach(Context context) { //onAttack solo en el fragment
        super.onAttach(context);

        if (context instanceof OnIconSelected) {
            listener = (OnIconSelected) context;
        } else {
            throw new ClassCastException("Error");
        }
    }

////////////////////////////////////////////////////////////

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment, container, false);

        listaIco = new ArrayList<>();

        recyclerIconos = (RecyclerView) view.findViewById(R.id.recyclerview);
        recyclerIconos.setLayoutManager(new GridLayoutManager(getContext(),2));

        //recyclerIconos.setLayoutManager(new LinearLayoutManager(getActivity()));

        llenarIconos();

        //////////////////////////////////// Aqui tenia problemas....

        AdaptadorIconos adapter = new AdaptadorIconos(listaIco, listener);

        //////////////////////////////////////////////////////////////

        recyclerIconos.setAdapter(adapter);


        return view;
    }


    private void llenarIconos() {

        String[] list = getResources().getStringArray(R.array.names);
        String[] img = getResources().getStringArray(R.array.images);

     //   for(int i = 0 ; i<img.length ; i++){

       //     listaIco.add(new Iconos(img[i], list[i])); //aqui cambie

        //}
        listaIco.add(new Iconos(R.drawable.cereal_guy,list[0]));
        listaIco.add(new Iconos(R.drawable.f_yeah,list[1]));
        listaIco.add(new Iconos(R.drawable.forever_alone, list[2]));
        listaIco.add(new Iconos(R.drawable.freddie_mercury, list[3]));
        listaIco.add(new Iconos(R.drawable.lol_guy, list[4]));
        listaIco.add(new Iconos(R.drawable.neil_degrasse_tyson, list[5]));
        listaIco.add(new Iconos(R.drawable.oh_crap, list[6]));
        listaIco.add(new Iconos(R.drawable.okay, list[7]));
        listaIco.add(new Iconos(R.drawable.rage_guy, list[8]));
        listaIco.add(new Iconos(R.drawable.troll_face, list[9]));
        listaIco.add(new Iconos(R.drawable.y_u_no_guy, list[10]));
        listaIco.add(new Iconos(R.drawable.yao_ming, list[11]));


    }


}
