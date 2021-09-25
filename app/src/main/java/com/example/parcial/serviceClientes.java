package com.example.parcial;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import java.util.ArrayList;

public class serviceClientes {
    SQLiteDatabase sqLiteDatabase; //cx
    ArrayList<clientes> lista = new ArrayList<clientes>();
    clientes clientes; //c
    Context context; //ct
    String nombreBD = "BDClinica";
    String tabla = "CREATE TABLE IF NOT EXISTS clientes(id integer primary key autoincrement, " +
            "cedula integer, nombre text, apellido text, edad integer, sintoma text, nivelGlusemia text, nivelAnemia text)";

    //constructor (aqui se crea la tabla)
    public serviceClientes(Context context) {
        this.context = context;
        sqLiteDatabase = context.openOrCreateDatabase(nombreBD, Context.MODE_PRIVATE , null);
        sqLiteDatabase.execSQL(tabla);
    }

    // Servicios:

    public boolean insertar(clientes clientes) {
        ContentValues contenedor=new ContentValues();
        contenedor.put("cedula",clientes.getCedula());
        contenedor.put("nombre",clientes.getNombre());
        contenedor.put("apellido",clientes.getApellido());
        contenedor.put("edad",clientes.getEdad());
        contenedor.put("sintoma",clientes.getSintoma());
        contenedor.put("nivelGlusemia",clientes.getNivelGlusemia());
        contenedor.put("nivelAnemia",clientes.getNivelAnemia());
        return (sqLiteDatabase.insert("clientes",null,contenedor))>0;
    }

    public boolean eliminar(int id) {

        return (sqLiteDatabase.delete("clientes","cedula="+id,null))>0;
    }

    public boolean editar(clientes clientes) {
        ContentValues contenedor=new ContentValues();
        contenedor.put("cedula",clientes.getCedula());
        contenedor.put("nombre",clientes.getNombre());
        contenedor.put("apellido",clientes.getApellido());
        contenedor.put("edad",clientes.getEdad());
        contenedor.put("sintoma",clientes.getSintoma());
        contenedor.put("nivelGlusemia",clientes.getNivelGlusemia());
        contenedor.put("nivelAnemia",clientes.getNivelAnemia());
        return (sqLiteDatabase.update("clientes",contenedor, "cedula="+clientes.getCedula(),null))>0;
    }

    public ArrayList<clientes> listar() {
        lista.clear();
        Cursor cursor = sqLiteDatabase.rawQuery("SELECT* FROM clientes;",null);
        if (cursor != null && cursor.getCount()>0){
            cursor.moveToFirst();
            do {
                lista.add(new clientes(
                        cursor.getInt(1),
                        cursor.getString(2),
                        cursor.getString(3),
                        cursor.getInt(4),
                        cursor.getString(5),
                        cursor.getString(6),
                        cursor.getString(7)));
            }while (cursor.moveToNext());
        }

        return lista;
    }

    public clientes ver(int id) {
        Cursor cursor = sqLiteDatabase.rawQuery("SELECT* FROM clientes;",null);
        cursor.moveToPosition(id);
        clientes=new clientes(cursor.getInt(0),
                cursor.getString(1),
                cursor.getString(2),
                cursor.getInt(3),
                cursor.getString(4),
                cursor.getString(5),
                cursor.getString(6));
        return clientes;
    }



}
