package com.mycompany.proyecto_final_p1.model;

public class Propietario {
    //09/05/2026 By Angel Cinto - "Agregan campos necesarios para la clase Propietario"
    private int idPropietario;
    private String nombre;
    private String telefono;
    private String correo;
    //09/05/2026 By Angel Cinto
    // CONSTRUCTOR 1: El que recibe todo (Generado con Alt+Insert)
    public Propietario(String nombre, String telefono, String correo) {
        this.nombre = nombre;
        this.telefono = telefono;
        this.correo = correo;
    }
    // CONSTRUCTOR 2: El vacío (Para procesos automáticos)
    public Propietario() {
    }

    // Getters y Setters
    public int getIdPropietario() {
        return idPropietario;
    }

    public void setIdPropietario(int idPropietario) {
        this.idPropietario = idPropietario;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }
}
