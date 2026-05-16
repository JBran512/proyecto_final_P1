/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.proyecto_final_p1.model;
import java.util.ArrayList;

public class Condominio {

    // 16/05/2026 By Adrianna - "Se agrega administración de casas"

    private int idCondominio;
    private String nombreCondominio;
    private ArrayList<Casa> listaCasas;

    // Constructor vacío
    public Condominio() {

        listaCasas = new ArrayList<>();

        // Crear automáticamente las 30 casas
        for (int i = 1; i <= 30; i++) {

            Casa casa = new Casa();

            casa.setNumeroCasa(i);

            listaCasas.add(casa);
        }
    }

    // Constructor con parámetros
    public Condominio(int idCondominio, String nombreCondominio) {
        this.idCondominio = idCondominio;
        this.nombreCondominio = nombreCondominio;
        this.listaCasas = new ArrayList<>();
    }

    // Getters y Setters
    public int getIdCondominio() {
        return idCondominio;
    }

    public void setIdCondominio(int idCondominio) {
        this.idCondominio = idCondominio;
    }

    public String getNombreCondominio() {
        return nombreCondominio;
    }

    public void setNombreCondominio(String nombreCondominio) {
        this.nombreCondominio = nombreCondominio;
    }

    public ArrayList<Casa> getListaCasas() {
        return listaCasas;
    }

    public void setListaCasas(ArrayList<Casa> listaCasas) {
        this.listaCasas = listaCasas;
    }

    // Método para agregar casas
    public void agregarCasa(Casa casa) {
        listaCasas.add(casa);
    }

    // Método para buscar casa por número
    public Casa buscarCasa(int numeroCasa) {

        for (Casa casa : listaCasas) {

            if (casa.getNumeroCasa() == numeroCasa) {
                return casa;
            }
        }

        return null;
    }
}
