package com.zocrosfera.ratingmascotas.db;

import android.content.ContentValues;
import android.content.Context;

import com.zocrosfera.ratingmascotas.R;
import com.zocrosfera.ratingmascotas.pojo.Mascota;

import java.util.ArrayList;

/**
 * Created by rafaelocrin on 1/12/16.
 */

public class ConstructorMascotas {

    private Context context;
    private ArrayList<Mascota> Mascotas;

    public ConstructorMascotas(Context context) {
        this.context = context;
    }

    public ArrayList<Mascota> obtenerDatos(){

        BaseDatos db = new BaseDatos(context);
        insertarMascotas(db);
        return db.obtenerMascotas();
    }

    public void insertarMascotas(BaseDatos db){

        ContentValues contentValues = new ContentValues();
        contentValues.put(ConstantesBaseDatos.TABLE_MASCOTA_NOMBRE, "Duke");
        contentValues.put(ConstantesBaseDatos.TABLE_MASCOTA_RATING, 1);
        contentValues.put(ConstantesBaseDatos.TABLE_MASCOTA_FOTO, R.drawable.foxy);
        db.insertarMascota(contentValues);


        ContentValues contentValues1 = new ContentValues();
        contentValues1.put(ConstantesBaseDatos.TABLE_MASCOTA_NOMBRE, "Rex");
        contentValues1.put(ConstantesBaseDatos.TABLE_MASCOTA_RATING, 1);
        contentValues1.put(ConstantesBaseDatos.TABLE_MASCOTA_FOTO, R.drawable.dog);
        db.insertarMascota(contentValues1);


        ContentValues contentValues2 = new ContentValues();
        contentValues2.put(ConstantesBaseDatos.TABLE_MASCOTA_NOMBRE, "Menphis");
        contentValues2.put(ConstantesBaseDatos.TABLE_MASCOTA_RATING, 1);
        contentValues2.put(ConstantesBaseDatos.TABLE_MASCOTA_FOTO, R.drawable.lion);
        db.insertarMascota(contentValues2);


        ContentValues contentValues3 = new ContentValues();
        contentValues3.put(ConstantesBaseDatos.TABLE_MASCOTA_NOMBRE, "Bear");
        contentValues3.put(ConstantesBaseDatos.TABLE_MASCOTA_RATING, 1);
        contentValues3.put(ConstantesBaseDatos.TABLE_MASCOTA_FOTO, R.drawable.panda);
        db.insertarMascota(contentValues3);


        ContentValues contentValues4 = new ContentValues();
        contentValues4.put(ConstantesBaseDatos.TABLE_MASCOTA_NOMBRE, "Papito");
        contentValues4.put(ConstantesBaseDatos.TABLE_MASCOTA_RATING, 1);
        contentValues4.put(ConstantesBaseDatos.TABLE_MASCOTA_FOTO, R.drawable.tucano);
        db.insertarMascota(contentValues4);

//        ContentValues contentValues5 = new ContentValues();
//        contentValues5.put(ConstantesBaseDatos.TABLE_MASCOTA_NOMBRE, "Tete");
//        contentValues5.put(ConstantesBaseDatos.TABLE_MASCOTA_RATING, 1);
//        contentValues5.put(ConstantesBaseDatos.TABLE_MASCOTA_FOTO, R.drawable.elephant);
//        db.insertarMascota(contentValues5);
//
//        ContentValues contentValues6 = new ContentValues();
//        contentValues6.put(ConstantesBaseDatos.TABLE_MASCOTA_NOMBRE, "Lulu");
//        contentValues6.put(ConstantesBaseDatos.TABLE_MASCOTA_RATING, 1);
//        contentValues6.put(ConstantesBaseDatos.TABLE_MASCOTA_FOTO, R.drawable.batty);
//        db.insertarMascota(contentValues6);
    }

    public void darLikeAlMascota(Mascota mascota){
        BaseDatos db = new BaseDatos(context);
        ContentValues contentValues = new ContentValues();

        int ratings = obtenerLikesMascota(mascota);

        contentValues.put(ConstantesBaseDatos.TABLE_MASCOTA_ID, mascota.getId());
        contentValues.put(ConstantesBaseDatos.TABLE_MASCOTA_RATING, ratings + 1);
        db.updateMascota(contentValues);
    }

    public int obtenerLikesMascota(Mascota mascota){
        BaseDatos db = new BaseDatos(context);
        return db.obtenerLikesMascota(mascota);
    }
}
