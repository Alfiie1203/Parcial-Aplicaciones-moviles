package com.example.parcial;

public class clientes {
    int id;
    int cedula;
    String nombre;
    String apellido;
    int edad;
    String sintoma;
    String nivelGlusemia;
    String nivelAnemia;

    public clientes() {
    }

    public clientes(int cedula, String nombre, String apellido, int edad, String sintoma, String nivelGlusemia, String nivelAnemia) {
        this.cedula = cedula;
        this.nombre = nombre;
        this.apellido = apellido;
        this.edad = edad;
        this.sintoma = sintoma;
        this.nivelGlusemia = nivelGlusemia;
        this.nivelAnemia = nivelAnemia;
    }

    public clientes(int id, int cedula, String nombre, String apellido, int edad, String sintoma, String nivelGlusemia, String nivelAnemia) {
        this.id = id;
        this.cedula = cedula;
        this.nombre = nombre;
        this.apellido = apellido;
        this.edad = edad;
        this.sintoma = sintoma;
        this.nivelGlusemia = nivelGlusemia;
        this.nivelAnemia = nivelAnemia;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getCedula() {
        return cedula;
    }

    public void setCedula(int cedula) {
        this.cedula = cedula;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public String getSintoma() {
        return sintoma;
    }

    public void setSintoma(String sintoma) {
        this.sintoma = sintoma;
    }

    public String getNivelGlusemia() {
        return nivelGlusemia;
    }

    public void setNivelGlusemia(String nivelGlusemia) {
        this.nivelGlusemia = nivelGlusemia;
    }

    public String getNivelAnemia() {
        return nivelAnemia;
    }

    public void setNivelAnemia(String nivelAnemia) {
        this.nivelAnemia = nivelAnemia;
    }
}
