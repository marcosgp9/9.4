package com.example.a94;



import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import java.util.ArrayList;
import java.util.LinkedList;

public class ConsultarUsuario extends AppCompatActivity {

    ArrayList<Contacte> listaContactos;

    private RecyclerView.LayoutManager layoutManager;
    private LinkedList<Contacte> mWorldLinked = new LinkedList<>();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_consultar);

        conseguirContactos();

        for(int i = 0; i < listaContactos.size(); i++){
            String nombre = listaContactos.get(i).getNombre();
        }


        final RecyclerView mRecyclerView = (RecyclerView) findViewById(R.id.recyclerview);
        for(int i = 0; i < listaContactos.size(); i++){
            this.mWorldLinked.add(listaContactos.get(i));
        }

        RecyclerView.Adapter mAdapter = new WordListAdapter(this, mWorldLinked);
        mRecyclerView.setAdapter(mAdapter);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(this));


    }

    public void conseguirContactos(){
        AdminSQLite admin = new AdminSQLite(this, "administracion", null, 1);
        listaContactos = admin.conseguirListaContactos();


    }

    public void listarContactos(){

        for(int i = 0; i < listaContactos.size(); i++){
            String nombre = listaContactos.get(i).getNombre();
        }


        final RecyclerView mRecyclerView = (RecyclerView) findViewById(R.id.recyclerview);
        for(int i = 0; i < listaContactos.size(); i++){
            this.mWorldLinked.add(listaContactos.get(i));
        }

        RecyclerView.Adapter mAdapter = new WordListAdapter(this, mWorldLinked);
        mRecyclerView.setAdapter(mAdapter);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(this));

    }



}