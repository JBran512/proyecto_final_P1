/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.proyecto_final_p1.model;

/**
 *
 * @author Admin
 */
public class Casa {
    //atributos de la casa, mapeo de la base de datos
    private int idCasa;
    private int numeroCasa;
    private int idPropietario;
    private int idCondominio;
    private int createdBy;
    private int updatedBy;


    // Constructor para insertar, ID casa es generado automaticamente por la base de datos
    public Casa(int numeroCasa, int idPropietario, int idCondominio) {
        this.numeroCasa = numeroCasa;
        this.idPropietario = idPropietario;
        this.idCondominio = idCondominio;
    }

    // Constructor vacío para procesos automáticos
    public Casa() {
    }

    // Getters y Setters
    public int getIdCasa() {
        return idCasa;
    }

    public void setIdCasa(int idCasa) {
        this.idCasa = idCasa;
    }

    public int getNumeroCasa() {
        return numeroCasa;
    }

    public void setNumeroCasa(int numeroCasa) {
        this.numeroCasa = numeroCasa;
    }

    public int getIdPropietario() {
        return idPropietario;
    }

    public void setIdPropietario(int idPropietario) {
        this.idPropietario = idPropietario;
    }

    public int getIdCondominio() {
        return idCondominio;
    }

    public void setIdCondominio(int idCondominio) {
        this.idCondominio = idCondominio;
    }
    
    public int getCreatedBy(){
        return createdBy;
    }
    public void setCreatedBy(int createdBy){
        this.createdBy = createdBy;
    }
    public int getUpdatedBy() {
        return updatedBy;
    }

    public void setUpdatedBy(int updatedBy) {
        this.updatedBy = updatedBy;
    }
}
