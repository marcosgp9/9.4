package com.example.a94;

import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class ModificarContacto extends AppCompatActivity {


    EditText eTNombre,eTTelefono;
    String sNombreModificar, sTelefonoModificar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_modificar);



        eTNombre= (EditText) findViewById(R.id.eTNombreModificar);
        eTTelefono= (EditText) findViewById(R.id.etTelefonoModificar);

    }

    public void modificar(View view){
        AdminSQLite admin = new AdminSQLite(this, "administracion", null, 1);
        SQLiteDatabase baseDeDatos = admin.getWritableDatabase();

        int cantidad;

        sNombreModificar = eTNombre.getText().toString();
        sTelefonoModificar = eTTelefono.getText().toString();

        if(!sNombreModificar.isEmpty() && !sTelefonoModificar.isEmpty()){

            cantidad = admin.modificar(sNombreModificar, sTelefonoModificar, baseDeDatos);

            if(cantidad == 1){
                Toast.makeText(this, "Articulo modificado correctamente", Toast.LENGTH_SHORT ).show();

            }else{

                Toast.makeText(this, " El articulo no existe", Toast.LENGTH_SHORT).show();
            }

        }else{
            Toast.makeText(this,"Debes llenar todos los campos", Toast.LENGTH_SHORT).show();
        }

    }




}
