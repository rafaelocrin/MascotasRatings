package com.zocrosfera.ratingmascotas.fragmento;

import com.zocrosfera.ratingmascotas.adaptador.MascotasAdaptador;
import com.zocrosfera.ratingmascotas.pojo.Mascota;

import java.util.ArrayList;

/**
 * Created by rafaelocrin on 1/12/16.
 */

public interface IMascotasFragmentView {

    public void generarLinearLayoutVertical();

    public MascotasAdaptador crearMascotaAdaptador(ArrayList<Mascota> mascotas);

    public void inicializarAdaptadorRV(MascotasAdaptador adaptador);
}
