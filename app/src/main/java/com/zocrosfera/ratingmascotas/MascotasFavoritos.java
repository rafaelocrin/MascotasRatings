package com.zocrosfera.ratingmascotas;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;

import com.zocrosfera.ratingmascotas.adaptador.MascotasAdaptador;
import com.zocrosfera.ratingmascotas.pojo.Mascota;

import java.util.ArrayList;

public class MascotasFavoritos extends AppCompatActivity {

    ArrayList<Mascota> mascotas;
    private RecyclerView listaContactos;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mascotas_favoritos);

        Toolbar toolbar = (Toolbar) findViewById(R.id.miActionBar);
        setSupportActionBar(toolbar);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);

        listaContactos = (RecyclerView)findViewById(R.id.rvFavoritos);

        LinearLayoutManager llm = new LinearLayoutManager(this);
        llm.setOrientation(LinearLayoutManager.VERTICAL);

        listaContactos.setLayoutManager(llm);
        inicializarListaContatos();
        inicializarAdaptador();

        //getSupportActionBar().setDefaultDisplayHomeAsUpEnabled(true);
    }


    public void inicializarAdaptador(){
        MascotasAdaptador adaptador = new MascotasAdaptador(mascotas, this);
        listaContactos.setAdapter(adaptador);
    }

    public void inicializarListaContatos(){
        mascotas = new ArrayList<Mascota>();
        mascotas.add(new Mascota("Zion", "3", R.drawable.dog));
        mascotas.add(new Mascota("Zorrito", "5", R.drawable.foxy));
        mascotas.add(new Mascota("Brown", "4", R.drawable.lion));
        mascotas.add(new Mascota("NinjaX", "2", R.drawable.panda));
        mascotas.add(new Mascota("Pisquila", "5", R.drawable.tucano));
    }

}
