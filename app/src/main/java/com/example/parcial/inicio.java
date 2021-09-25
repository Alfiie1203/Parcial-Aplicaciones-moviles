package com.example.parcial;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Dialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.ArrayList;

public class inicio extends AppCompatActivity {
    clientes nuevoCliente;
    serviceClientes serviceClientes;
    adaptador adaptador;
    ArrayList<clientes> lista;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_inicio);

        serviceClientes = new serviceClientes(this);
        lista=serviceClientes.listar();
        adaptador = new adaptador(this,lista,serviceClientes);
        Button agregarH = (Button) findViewById(R.id.botonHemo);


        agregarH.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Dialog dialogo=new Dialog(inicio.this);
                dialogo.setTitle("Nuevo registro");
                dialogo.setCancelable(true);
                dialogo.setContentView(R.layout.activity_hemo);
                dialogo.show();
                final EditText cedula = (EditText) dialogo.findViewById(R.id.cedulaHemoglobina);
                final EditText nombre = (EditText) dialogo.findViewById(R.id.nombreHemoglobina);
                final EditText apellido = (EditText) dialogo.findViewById(R.id.apellidoHemoglobina);
                final EditText edad = (EditText) dialogo.findViewById(R.id.edadHemoglobina);
                final EditText sintoma = (EditText) dialogo.findViewById(R.id.sintomaHemoglobina);
                Button guardar=(Button)dialogo.findViewById(R.id.agregarhemo);
                guardar.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        try {
                            nuevoCliente= new clientes(Integer.parseInt(cedula.getText().toString()),
                                    nombre.getText().toString(),
                                    apellido.getText().toString(),
                                    Integer.parseInt(edad.getText().toString()),
                                    sintoma.getText().toString(),
                                    null,null);

                            serviceClientes.insertar(nuevoCliente);
                            lista=serviceClientes.listar();
                            adaptador.notifyDataSetChanged();
                            dialogo.dismiss();
                        }catch (Exception e){
                            Toast.makeText(getApplication(),"ERROR",Toast.LENGTH_SHORT).show();
                        }
                    }
                });





            }
        });




    }
}