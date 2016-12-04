package com.zocrosfera.ratingmascotas.fragmento;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.zocrosfera.ratingmascotas.R;
import com.zocrosfera.ratingmascotas.adaptador.MascotasAdaptador;
import com.zocrosfera.ratingmascotas.pojo.Mascota;

import java.util.ArrayList;


/**
 * A simple {@link Fragment} subclass.
 */
public class PerfilMascotasFragment extends Fragment {

    public PerfilMascotasFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_mascotas_perfil, container, false);
    }

}
