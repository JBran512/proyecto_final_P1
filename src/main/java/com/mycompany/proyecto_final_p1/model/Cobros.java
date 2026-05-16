/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.proyecto_final_p1.model;

import java.sql.Date;

/**
 *
 * @author Chriss
 */
public class Cobros {
    private int monto;
    private Date fechaInicio;
    private Date fechaLimite;
    private int createdBy;

    public Cobros(int monto, Date fechaInicio, Date fechaLimite, int createdBy) {
        this.monto = monto;
        this.fechaInicio = fechaInicio;
        this.fechaLimite = fechaLimite;
        this.createdBy = createdBy;
    }

    public Cobros() {
    }
    
    

    public int getMonto() {
        return monto;
    }

    public void setMonto(int monto) {
        this.monto = monto;
    }

    public Date getFechaInicio() {
        return fechaInicio;
    }

    public void setFechaInicio(Date fechaInicio) {
        this.fechaInicio = fechaInicio;
    }

    public Date getFechaLimite() {
        return fechaLimite;
    }

    public void setFechaLimite(Date fechaLimite) {
        this.fechaLimite = fechaLimite;
    }

    public int getCreatedBy() {
        return createdBy;
    }

    public void setCreatedBy(int createdBy) {
        this.createdBy = createdBy;
    }

    
     
}
