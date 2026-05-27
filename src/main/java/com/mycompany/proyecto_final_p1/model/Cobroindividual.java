/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.proyecto_final_p1.model;

/**
 *
 * @author Chriss
 */
public class Cobroindividual {
    private int id_casa;
    private int numero_casa;
    

    public Cobroindividual() {
    }

    public Cobroindividual(int id_casa, int numero_casa) {
        this.id_casa = id_casa;
        this.numero_casa = numero_casa;
    }

    public int getId_casa() {
        return id_casa;
    }

    public void setId_casa(int id_casa) {
        this.id_casa = id_casa;
    }

    public int getNumero_casa() {
        return numero_casa;
    }

    public void setNumero_casa(int numero_casa) {
        this.numero_casa = numero_casa;
    }
    
     @Override
    public String toString() {
        return "Casa " + numero_casa;
    }
    
}
