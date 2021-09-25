package com.example.parcial;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class adaptador extends BaseAdapter {
    ArrayList<clientes> lista;
    serviceClientes serviceClientes;
    clientes clientes;
    Activity activity;
    int id=0;

    public adaptador(Activity activity, ArrayList<clientes> lista, serviceClientes serviceClientes){
        this.lista=lista;
        this.activity=activity;
        this.serviceClientes=serviceClientes;

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Override
    public int getCount() {
        return lista.size();
    }

    @Override
    public clientes getItem(int i) {
        clientes = lista.get(i);
        return null;
    }

    @Override
    public long getItemId(int i) {
        clientes = lista.get(i);
        return clientes.getId();
    }

    @Override
    public View getView(int posicion, View view, ViewGroup viewGroup) {
        View v= view;
        if (v==null){
            LayoutInflater li =(LayoutInflater) activity.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            v=li.inflate(R.layout.activity_item,null);
        }
        clientes = lista.get(posicion);
        TextView cedula=(TextView) v.findViewById(R.id.ca);
        TextView nombre=(TextView) v.findViewById(R.id.nombre);
        TextView apellido=(TextView) v.findViewById(R.id.apellido);
        TextView edad=(TextView) v.findViewById(R.id.edad);
        TextView sintoma=(TextView) v.findViewById(R.id.sintoma);
        EditText examenHemo=(EditText) v.findViewById(R.id.examenHemo);
        EditText examenAnemia=(EditText) v.findViewById(R.id.examenAnemia);
        Button editar = (Button) v.findViewById(R.id.editar);
        Button eliminar = (Button) v.findViewById(R.id.eliminar);
        cedula.setText(""+clientes.getCedula());
        nombre.setText(clientes.getNombre());
        apellido.setText(clientes.getApellido());
        edad.setText(""+clientes.getEdad());
        sintoma.setText(clientes.getSintoma());
        examenHemo.setText(clientes.getNivelGlusemia());
        examenAnemia.setText(clientes.getNivelAnemia());
        editar.setTag(posicion);
        eliminar.setTag(posicion);
        editar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //Dialogo Editar
                int pos= Integer.parseInt(view.getTag().toString());
                Dialog dialogo=new Dialog(activity);
                dialogo.setTitle("Editar registro");
                dialogo.setCancelable(true);
                dialogo.setContentView(R.layout.editar);
                dialogo.show();
                final EditText cedula = (EditText) dialogo.findViewById(R.id.cedulaEditar);
                final EditText nombre = (EditText) dialogo.findViewById(R.id.nombreEditar);
                final EditText apellido = (EditText) dialogo.findViewById(R.id.apellidoEditar);
                final EditText edad = (EditText) dialogo.findViewById(R.id.edadEditar);
                final EditText sintoma = (EditText) dialogo.findViewById(R.id.sintomaEditar);
                final EditText nivelGlusemia = (EditText) dialogo.findViewById(R.id.nivelhemoglobinaEditar);
                final EditText nivelAnemia = (EditText) dialogo.findViewById(R.id.nivelanemiaEditar);
                Button guardar=(Button)dialogo.findViewById(R.id.botonEditar);
                clientes = lista.get(pos);
                setId(clientes.getId());
                cedula.setText(""+clientes.getCedula());
                nombre.setText(clientes.getNombre());
                apellido.setText(clientes.getApellido());
                edad.setText(""+clientes.getEdad());
                sintoma.setText(clientes.getSintoma());
                nivelGlusemia.setText(clientes.getNivelGlusemia());
                nivelAnemia.setText(clientes.getNivelAnemia());
                guardar.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        try {
                            clientes= new clientes(getId(),Integer.parseInt(cedula.getText().toString()),
                                    nombre.getText().toString(),
                                    apellido.getText().toString(),
                                    Integer.parseInt(edad.getText().toString()),
                                    sintoma.getText().toString(),
                                    nivelGlusemia.getText().toString(),
                                    nivelAnemia.getText().toString());

                            serviceClientes.editar(clientes);
                            lista=serviceClientes.listar();
                            notifyDataSetChanged();
                            dialogo.dismiss();
                        }catch (Exception e){
                            Toast.makeText(activity,"ERROR",Toast.LENGTH_SHORT).show();
                        }
                    }
                });
            }
        });



        eliminar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //Dialogo Eliminar
                int pos= Integer.parseInt(view.getTag().toString());
                clientes=lista.get(pos);
                setId(clientes.getId());
                AlertDialog.Builder del=new AlertDialog.Builder(activity);
                del.setMessage("Estas seguro de eliminar registro");
                del.setCancelable(false);
                del.setPositiveButton("SI", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        serviceClientes.eliminar(clientes.getCedula());
                        lista = serviceClientes.listar();
                        notifyDataSetChanged();
                    }
                });
                del.setNegativeButton("NO", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {

                    }
                });
                del.show();
            }
        });
        return v;
    }
}
