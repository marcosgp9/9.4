package com.example.a94.utilidades;

import com.example.a94.Contacte;

import java.util.ArrayList;

public class utilidades {

    // CONSTANTES CAMPOS TABLA USUARIO
    public static String TABLA_USUARIO = "usuario";
    public static String CAMPO_NOMBRE = "nombre";
    public static String CAMPO_TELEFONO = "telefono";
    public static ArrayList<Contacte> listaContactos;

    public static final String crearTablaUsuario = "CREATE TABLE "+TABLA_USUARIO+"("+CAMPO_NOMBRE+" TEXT, "+CAMPO_TELEFONO+" TEXT)";

}
