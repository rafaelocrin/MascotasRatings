package com.zocrosfera.ratingmascotas.presentador;

import android.content.Context;

import com.zocrosfera.ratingmascotas.db.ConstructorMascotas;
import com.zocrosfera.ratingmascotas.fragmento.IMascotasFragmentView;
import com.zocrosfera.ratingmascotas.pojo.Mascota;

import java.util.ArrayList;

/**
 * Created by rafaelocrin on 1/12/16.
 */

public class MascotasViewFragmentPresenter implements IMascotasViewFragmentPresenter {

    private IMascotasFragmentView IMascotasFragmentView;
    private Context context;
    private ConstructorMascotas constructorMascotas;
    private ArrayList<Mascota> mascotas;

    public MascotasViewFragmentPresenter(IMascotasFragmentView IMascotasFragmentView, Context context){
        this.IMascotasFragmentView = IMascotasFragmentView;
        this.context = context;
        obtenerMascotasBaseDatos();
    }

    @Override
    public void obtenerMascotasBaseDatos() {
        constructorMascotas = new ConstructorMascotas(context);
        mascotas = constructorMascotas.obtenerDatos();
        mostrarMascotasRV();
    }

    @Override
    public void mostrarMascotasRV() {
        IMascotasFragmentView.inicializarAdaptadorRV(IMascotasFragmentView.crearMascotaAdaptador(mascotas));
        IMascotasFragmentView.generarLinearLayoutVertical();
    }
}
