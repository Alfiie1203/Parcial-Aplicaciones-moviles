package com.example.parcial;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;

public class listar extends AppCompatActivity {
    serviceClientes serviceClientes;
    clientes clientes;
    adaptador adaptador;
    ArrayList <clientes> lista;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_listar);
        serviceClientes= new serviceClientes(this);
        lista=serviceClientes.listar();
        adaptador = new adaptador(this,lista,serviceClientes);
        ListView list=(ListView) findViewById(R.id.listarTodo);
        list.setAdapter(adaptador);
        list.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {

            }
        });

    }
}