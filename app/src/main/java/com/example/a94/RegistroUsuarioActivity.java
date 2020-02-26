package com.example.a94;

import android.content.ContentValues;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.a94.utilidades.utilidades;

public class RegistroUsuarioActivity extends AppCompatActivity {

    EditText campoNombre,campoTelefono;
    String nombreGuardar, telefonoGuardar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registro_usuarios);


        campoNombre= (EditText) findViewById(R.id.campoNombre);
        campoTelefono= (EditText) findViewById(R.id.campoTelefono);

    }

    public void onClick(View view) {

        registrarUsuarios();

    }




    private void registrarUsuarios() {
        AdminSQLite admin =new AdminSQLite(this,"administracion",null,1);
        SQLiteDatabase db = admin.getWritableDatabase();

        nombreGuardar = campoNombre.getText().toString();
        telefonoGuardar = campoTelefono.getText().toString();

        admin.guardarContacto(db, nombreGuardar, telefonoGuardar);

        Toast.makeText(getApplicationContext(),"Id Registro: "+ nombreGuardar,Toast.LENGTH_SHORT).show();
        db.close();
    }

}
