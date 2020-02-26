package com.example.a94;

import android.content.ContentValues;
import android.content.Context;


import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.widget.Toast;

import com.example.a94.utilidades.utilidades;

import java.util.ArrayList;

public class AdminSQLite extends SQLiteOpenHelper {



    public AdminSQLite(Context context, String name, SQLiteDatabase.CursorFactory factory, int version){
        super(context, name, factory, version);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("CREATE TABLE contactos(nombre text, telefono text)");
        //db.execSQL(utilidades.crearTablaUsuario);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        //db.execSQL("DROP TABLE IF EXISTS usuarios");
        //onCreate(db);
    }

    public ArrayList<Contacte> conseguirListaContactos() {
        ArrayList<Contacte> listaPlaneta = new ArrayList<Contacte>();
        String query = "SELECT * FROM contactos";
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery(query, null);
        if (cursor.moveToFirst()) {
            do {
                Contacte contacto = new Contacte();
                contacto.setNombre(cursor.getString(0));
                contacto.setTelefono(cursor.getString(1));
                listaPlaneta.add(contacto);
            } while (cursor.moveToNext());
        }
        return listaPlaneta;
    }


    public void guardarContacto(SQLiteDatabase baseDeDatos, String nombre, String telefono){

        ContentValues registro = new ContentValues();

        registro.put("nombre", nombre);
        registro.put("telefono", telefono);

        baseDeDatos.insert("contactos", null, registro);
        baseDeDatos.close();
    }

    public int borrarContacto(SQLiteDatabase baseDeDatos, String nombre){
        String[] array = new String[1];
        array[0] = nombre;
        int cantidad = baseDeDatos.delete("contactos", "nombre=?", array);
        baseDeDatos.close();

        return cantidad;

    }

    public int modificar(String nombre, String telefono, SQLiteDatabase baseDeDatos){

        String[] array = new String[1];
        array[0] = nombre;

        ContentValues registro = new ContentValues();

        registro.put("telefono", telefono);

        int cantidad = baseDeDatos.update("contactos", registro, "nombre=?", array);
        baseDeDatos.close();

        return cantidad;
    }


}