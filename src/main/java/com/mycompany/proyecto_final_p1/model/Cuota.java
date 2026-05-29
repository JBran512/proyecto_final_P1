/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.proyecto_final_p1.model;

/**
 *
 * @author Admin
 */
//degfine la couta establecida para un periodo especifico
public class Cuota {
    private int idCuota;
    private int mes;
    private int anio;
    private int monto;
    private int createdBy;
    //inicia y registra una nueva couta periodica
    public Cuota(int mes, int anio, int monto){
        this.mes = mes;
        this.anio = anio;
        this.monto = monto;
    }
    
    public Cuota() {
    }

    public int getIdCuota() {
        return idCuota;
    }

    public void setIdCuota(int idCuota) {
        this.idCuota = idCuota;
    }
    
    public int getMes(){
        return mes;
    }
    
    public void setMes(int mes){
        this.mes = mes;
    }
    //metodos de acceso
    public int getAnio(){
        return anio;
    }
    
    public void setAnio(int anio){
        this.anio = anio;
    }
    
    public int getMonto(){
        return monto;
    }
    
    public void setMonto(int monto){
        this.monto = monto;
    }
    
    public int getCreatedBy(){
        return createdBy;
    }
    
    public void setCreatedBy(int createdBy){
        this.createdBy = createdBy;
    }
    
}
