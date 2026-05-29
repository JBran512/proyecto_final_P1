/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.proyecto_final_p1.model;

/**
 *
 * @author Admin
 */
// esta clase controla la sesion activa almacenando los datos de quien inicio sesion
public class Sesion {
    //estos atributos se guardan en la memoria mientras la app este siendo ejecutada
    private static int idUsuario;
    private static String nombreUsuario;
    
    public static int getIdUsuario() {
        return idUsuario;
    }
    
    public static void setIdUsuario(int id) {
        idUsuario = id;
    }
    public static String getNombreUsuario() {
        return nombreUsuario;
    }
    
    public static void setNombreUsuario(String nombre) {
        nombreUsuario = nombre;
    }
}
