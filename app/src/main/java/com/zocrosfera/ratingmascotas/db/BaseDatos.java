package com.zocrosfera.ratingmascotas.db;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import com.zocrosfera.ratingmascotas.pojo.Mascota;

import java.util.ArrayList;

/**
 * Created by rafaelocrin on 2/12/16.
 */

public class BaseDatos extends SQLiteOpenHelper {

    private Context context;

    public BaseDatos(Context context) {

        super(context, ConstantesBaseDatos.DATABASE_NAME, null, ConstantesBaseDatos.DATABASE_VERSION);
        this.context = context;
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String queryCrearTablaContacto = "CREATE TABLE " + ConstantesBaseDatos.TABLE_MASCOTA + "(" +
                ConstantesBaseDatos.TABLE_MASCOTA_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
                ConstantesBaseDatos.TABLE_MASCOTA_NOMBRE + " TEXT, " +
                ConstantesBaseDatos.TABLE_MASCOTA_FOTO + " INTEGER, " +
                ConstantesBaseDatos.TABLE_MASCOTA_RATING + " TEXT " +
                ")";

        db.execSQL(queryCrearTablaContacto);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXIST " + ConstantesBaseDatos.TABLE_MASCOTA);
        onCreate(db);
    }

    public ArrayList<Mascota> obtenerMascotas(){
        ArrayList<Mascota> mascotas = new ArrayList<>();

        String query = "SELECT * FROM " + ConstantesBaseDatos.TABLE_MASCOTA;
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor registros = db.rawQuery(query, null);

        while (registros.moveToNext()){
            Mascota mascotaActual = new Mascota();
            mascotaActual.setId(registros.getInt(0));
            mascotaActual.setNombre(registros.getString(1));
            mascotaActual.setRating(registros.getString(3));
            mascotaActual.setFoto(registros.getInt(2));
            mascotas.add(mascotaActual);
        }

        db.close();
        return mascotas;
    }

    public ArrayList<Mascota> obtenerMascotasPontuados(){
        ArrayList<Mascota> mascotas = new ArrayList<>();

        String query = "SELECT TOP 5 " + ConstantesBaseDatos.TABLE_MASCOTA_RATING +
                " FROM " + ConstantesBaseDatos.TABLE_MASCOTA +
                " ORDER BY " + ConstantesBaseDatos.TABLE_MASCOTA_RATING + " DESC ";

        SQLiteDatabase db = this.getReadableDatabase();
        Cursor registros = db.rawQuery(query, null);

        while (registros.moveToNext()){
            Mascota mascotaActual = new Mascota();
            mascotaActual.setId(registros.getInt(0));
            mascotaActual.setNombre(registros.getString(1));
            mascotaActual.setRating(registros.getString(2));
            mascotaActual.setFoto(registros.getInt(3));
            mascotas.add(mascotaActual);
        }

        db.close();
        return mascotas;
    }

    public void insertarMascota(ContentValues contentValues){
        SQLiteDatabase db = getWritableDatabase();
        db.insert(ConstantesBaseDatos.TABLE_MASCOTA, null, contentValues);
        db.close();
    }

    public void updateMascota(ContentValues contentValues){
        SQLiteDatabase db = getWritableDatabase();
        db.update(ConstantesBaseDatos.TABLE_MASCOTA,contentValues,
                ConstantesBaseDatos.TABLE_MASCOTA_ID + "=" + contentValues.getAsString(ConstantesBaseDatos.TABLE_MASCOTA_ID),
                null);
        db.insert(ConstantesBaseDatos.TABLE_MASCOTA, null, contentValues);
        db.close();
    }

    public int obtenerLikesMascota(Mascota mascota){
        int likes = 0;

        String query = "SELECT " + ConstantesBaseDatos.TABLE_MASCOTA_RATING + " AS RATING" +
                " FROM " + ConstantesBaseDatos.TABLE_MASCOTA +
                " WHERE " + ConstantesBaseDatos.TABLE_MASCOTA_ID + " = " + mascota.getId();
        SQLiteDatabase db = getReadableDatabase();
        Cursor registros = db.rawQuery(query, null);

        if (registros.moveToNext()){
            likes = registros.getInt(0);
        }

        db.close();

        return likes;

    }

//    public void insertarLikeContacto(ContentValues contentValues){
//        SQLiteDatabase db = getWritableDatabase();
//        db.insert(ConstantesBaseDatos.TABLE_LIKES_CONTACT, null, contentValues);
//        db.close();
//    }

//    public int obtenerLikesContacto(Contacto contacto){
//        int likes = 0;
//
//        String query = "SELECT COUNT (" + ConstantesBaseDatos.TABLE_LIKES_CONTACT_NUMERO_LIKES + ") " +
//                "FROM " + ConstantesBaseDatos.TABLE_LIKES_CONTACT +
//                " WHERE " + ConstantesBaseDatos.TABLE_LIKES_CONTACT_ID_CONTACTO + " = " + contacto.getId();
//        SQLiteDatabase db = getReadableDatabase();
//        Cursor registros = db.rawQuery(query, null);
//
//        if (registros.moveToNext()){
//            likes = registros.getInt(0);
//        }
//
//        db.close();
//
//        return likes;
//
//    }
}
