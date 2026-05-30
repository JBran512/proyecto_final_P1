/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.proyecto_final_p1.util;
import com.mycompany.proyecto_final_p1.model.Condominio;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class CondominioDAO {
    //Metodo para traer los condominios
    public List<Condominio> listarTodos() throws SQLException {
        List<Condominio> lista = new ArrayList<>();
        try {
            Connection con = Conexion.getConexion();
            PreparedStatement ps = con.prepareStatement(
                "SELECT * FROM condominio"
            );
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Condominio c = new Condominio(
                    rs.getInt("id_condominio"),
                    rs.getString("nombre")
                );
                lista.add(c);
            }
        } catch (SQLException e) {
            System.out.println("Error: " + e.getMessage());
        }
        return lista;
    }
}
