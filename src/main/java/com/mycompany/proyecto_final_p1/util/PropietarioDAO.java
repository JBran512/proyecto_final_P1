/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.proyecto_final_p1.util;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import com.mycompany.proyecto_final_p1.util.Conexion;
import com.mycompany.proyecto_final_p1.model.Propietario;
/**
 *
 * @author cinto
 */
public class PropietarioDAO {
    
    public boolean insertar(Propietario propietario) {
        // La consulta SQL con los campos de la tabla que revisamos
        String sql = "INSERT INTO propietario (nombre, telefono, correo, created_by) VALUES (?, ?, ?, ?)";
        
        try {
            Connection con = Conexion.getConexion();
            PreparedStatement ps = con.prepareStatement(sql);
            
            // Llenamos los campos usando los GETTERS que creaste
            ps.setString(1, propietario.getNombre());
            ps.setString(2, propietario.getTelefono());
            ps.setString(3, propietario.getCorreo());
            ps.setInt(4, propietario.getCreatedBy());
            
            int filasInsertadas = ps.executeUpdate(); // Ejecuta la acción en la DB
            return filasInsertadas > 0; // Si insertó algo, devuelve true
            
        } catch (SQLException e) {
            System.out.println("Error al insertar propietario: " + e.getMessage());
            return false;
        }
    }
}
