package com.zocrosfera.ratingmascotas;

import android.content.Intent;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;

import com.zocrosfera.ratingmascotas.adaptador.PageAdapter;
import com.zocrosfera.ratingmascotas.fragmento.PerfilMascotasFragment;
import com.zocrosfera.ratingmascotas.fragmento.MascotasFragment;
import com.zocrosfera.ratingmascotas.menu.AboutActivity;
import com.zocrosfera.ratingmascotas.menu.FormularioActivity;
import com.zocrosfera.ratingmascotas.pojo.Mascota;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    ArrayList<Mascota> mascotas;
    private RecyclerView listaContactos;

    private Toolbar toolbar;
    private TabLayout tabLayout;
    private ViewPager viewPager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        toolbar = (Toolbar) findViewById(R.id.toolbar);
        tabLayout = (TabLayout) findViewById(R.id.tabLayout);
        viewPager = (ViewPager) findViewById(R.id.viewPager);

        setupViewPager();

        if (toolbar != null)
        {
            setSupportActionBar(toolbar);
        }

//        listaContactos = (RecyclerView)findViewById(R.id.rvContactos);
//
//        LinearLayoutManager llm = new LinearLayoutManager(this);
//        llm.setOrientation(LinearLayoutManager.VERTICAL);
//
//        listaContactos.setLayoutManager(llm);
//        inicializarListaContatos();
//        inicializarAdaptador();
    }


    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        switch (item.getItemId()){
            case R.id.mAbout:
                Intent intent = new Intent(this, AboutActivity.class);
                startActivity(intent);
                break;
            case R.id.mFormulario:
                Intent intent2 = new Intent(this, FormularioActivity.class);
                startActivity(intent2);
                break;
        }

        return true;
//        if (item.getItemId() == R.id.mAbout) {
//            irAlFavoritosActivity();
//            return true;
//        }
//        else
//            // If we got here, the user's action was not recognized.
//            // Invoke the superclass to handle it.
//            return super.onOptionsItemSelected(item);

    }

    public void irAlFavoritosActivity(){
        Intent intent = new Intent(this, MascotasFavoritos.class);
        startActivity(intent);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu_opciones, menu);
        return true;
    }

    private ArrayList<Fragment> agregarFragments(){
        ArrayList<Fragment> fragments = new ArrayList<Fragment>();
        fragments.add(new MascotasFragment());
        fragments.add(new PerfilMascotasFragment());

        return fragments;
    }
    public void setupViewPager(){
        viewPager.setAdapter(new PageAdapter(getSupportFragmentManager(), agregarFragments()));
        tabLayout.setupWithViewPager(viewPager);

        tabLayout.getTabAt(0).setIcon(R.drawable.ic_dog_house);
        tabLayout.getTabAt(1).setIcon(R.drawable.ic_dog_favoritos);
    }
}
