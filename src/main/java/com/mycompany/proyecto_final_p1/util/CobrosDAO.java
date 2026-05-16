/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.proyecto_final_p1.util;

import com.mycompany.proyecto_final_p1.model.Cobros;
import java.sql.SQLException;
import com.mycompany.proyecto_final_p1.util.Conexion;
import java.sql.Connection;
import java.sql.PreparedStatement;
import javax.swing.JOptionPane;

/**
 *
 * @author Chriss
 */
public class CobrosDAO {
    
    public int realizarCobro(Cobros cobros){
        
    try{
          Connection con = Conexion.getConexion();
          String sql = "INSERT INTO cobros(monto, fechaInicio, fechaLimite, createdBy) values (?,?,?,?)";
          
          PreparedStatement ps = con.prepareStatement(sql);
          ps.setInt(1, cobros.getMonto());
          ps.setDate(2, cobros.getFechaInicio());
          ps.setDate(3, cobros.getFechaLimite());
          ps.setInt(4, cobros.getCreatedBy());
          
          ps.executeUpdate();
          JOptionPane.showMessageDialog(null, "Datos guardados", "Cobros", JOptionPane.INFORMATION_MESSAGE);
          return 1;
          
    }catch(SQLException e){
        System.out.println(e.getMessage());
        JOptionPane.showMessageDialog(null, "No se guardaron los datos", "Cobros", JOptionPane.INFORMATION_MESSAGE);
    }
         return -1;
  }
}  
