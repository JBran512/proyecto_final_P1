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
    private static final java.util.logging.Logger logger = java.util.logging.Logger.getLogger(PropietarioDAO.class.getName());
    
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
    public boolean actualizar(com.mycompany.proyecto_final_p1.model.Propietario propietario) {

        // 1. Colocamos la impresión de prueba al puro inicio del método
        System.out.println("Modificando en BD a: " + propietario.getNombre() + " con ID: " + propietario.getIdPropietario());

        // 2. Definir la consulta SQL (usa 'id_propietario' o 'id' según tu base de datos)
        String sql = "UPDATE propietarios SET nombre = ?, telefono = ?, correo = ? WHERE id_propietario = ?;";

        // NOTA DE PROGRAMACIÓN 1: 
        // Dejamos este return true provisional para simular que todo salió bien.
        // Cuando vayas a conectarlo a la base de datos real, descomenta el bloque try-catch de abajo
        // y elimina este "return true;".
        return true;

        /* try (java.sql.Connection conn = tuClaseConexion.getConexion();
             java.sql.PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setString(1, propietario.getNombre());
            ps.setString(2, propietario.getTelefono());
            ps.setString(3, propietario.getCorreo());
            ps.setInt(4, propietario.getIdPropietario()); 

            int filasAfectadas = ps.executeUpdate();
            return filasAfectadas > 0; 

        } catch (java.sql.SQLException ex) {
            System.out.println("Error al actualizar propietario: " + ex.getMessage());
            return false;
        }
        */
    }
    
    public com.mycompany.proyecto_final_p1.model.Propietario buscarPorId(int idBuscado) {
    com.mycompany.proyecto_final_p1.model.Propietario propietario = null;
    
    // Consulta SQL para buscar por la llave primaria
    String sql = "SELECT nombre, telefono, correo FROM propietarios WHERE id_propietario = ?;";
    
    // NOTA PARA PROGRAMACIÓN 1: 
    // Dejamos esta lógica de prueba para que compile de inmediato.
    // Cuando quieras conectarlo real a la BD, descomenta el bloque try-catch de abajo.
    if (idBuscado != -1) {
        // Simula que encontró al propietario temporalmente para llenar los campos
        propietario = new com.mycompany.proyecto_final_p1.model.Propietario("Cargando...", "", "", 1);
    }
    return propietario;

    /* try (java.sql.Connection conn = tuClaseConexion.getConexion();
         java.sql.PreparedStatement ps = conn.prepareStatement(sql)) {
        
        ps.setInt(1, idBuscado);
        try (java.sql.ResultSet rs = ps.executeQuery()) {
            if (rs.next()) {
                String nom = rs.getString("nombre");
                String tel = rs.getString("telefono");
                String corr = rs.getString("correo");
                
                // Construimos el objeto con los datos de la BD
                propietario = new com.mycompany.proyecto_final_p1.model.Propietario(nom, tel, corr, 1);
                propietario.setIdPropietario(idBuscado);
            }
        }
    } catch (java.sql.SQLException ex) {
        System.out.println("Error al buscar propietario por ID: " + ex.getMessage());
    }
    return propietario;
    */
    }
}
