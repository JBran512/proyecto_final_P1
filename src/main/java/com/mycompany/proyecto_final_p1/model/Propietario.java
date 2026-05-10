package com.mycompany.proyecto_final_p1.model; // Verifica que diga .model

public class Propietario {
    //09/05/2026 By Angel Cinto - "Agregan campos necesarios para la clase Propietario"
    private String nombre;
    private String telefono;
    private String correo;
    private int numeroCasa;
    //09/05/2026 By Angel Cinto
    // CONSTRUCTOR 1: El que recibe todo (Generado con Alt+Insert)
    public Propietario(String nombre, String telefono, String correo, int numeroCasa) {
        this.nombre = nombre;
        this.telefono = telefono;
        this.correo = correo;
        this.numeroCasa = numeroCasa;
    }
    // CONSTRUCTOR 2: El vacío (Para procesos automáticos)
    public Propietario() {
    }
}
