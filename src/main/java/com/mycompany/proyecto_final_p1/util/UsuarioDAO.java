/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.proyecto_final_p1.util;
import com.mycompany.proyecto_final_p1.model.Sesion;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import com.mycompany.proyecto_final_p1.util.Conexion;

/**
 *
 * @author Admin
 */
public class UsuarioDAO {
    public int verificarLogin(String usuario, String contrasena) {
        try{
            Connection con = Conexion.getConexion();
            PreparedStatement ps = con.prepareStatement(
                    "SELECT * FROM usuario WHERE usuario = ? AND contrasena = ? AND activo = true"
            );
            ps.setString(1, usuario);
            ps.setString(2, contrasena);
            ResultSet rs = ps.executeQuery();
            if (rs.next()){
                String nombreUsuario = rs.getString("usuario");
                Sesion.setNombreUsuario(nombreUsuario);
                return rs.getInt("id_usuario");
            }
        } catch (SQLException e){
            System.out.println("Error: " + e.getMessage());
        }
        return -1;
    }
}
