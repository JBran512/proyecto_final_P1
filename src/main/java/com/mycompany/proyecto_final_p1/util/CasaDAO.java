/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.proyecto_final_p1.util;
import com.mycompany.proyecto_final_p1.util.Conexion;
import com.mycompany.proyecto_final_p1.model.Casa;
import java.util.List;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author Admin
 */
//centraliza operaciones CRUD directas en la base de datos mediante consultas de SQL
public class CasaDAO {
    //Metodos necesarios para extraer, insertar, crear, actualizar y listar datos de la base de datos
    public List<Casa> listarCasas() throws SQLException{
        List<Casa> lista = new ArrayList<>();
        try {
            Connection con = Conexion.getConexion();
            PreparedStatement ps = con.prepareStatement(
                "SELECT * FROM casa"
            );
            ResultSet rs = ps.executeQuery();
            while (rs.next()){
                Casa c = new Casa();
                c.setIdCasa(rs.getInt("id_casa"));
                c.setNumeroCasa(rs.getInt("numero_casa"));
                c.setIdPropietario(rs.getInt("id_propietario"));
                c.setIdCondominio(rs.getInt("id_condominio"));
                lista.add(c);
            }
        } catch (SQLException e){
            System.out.println("Error: " + e.getMessage());
        }
        return lista;
    }
    //corrobora si existe una casa registrada con un numero especifico en el sistema
    public boolean existeNumero(int numeroCasa) throws SQLException{
        try{
            Connection con = Conexion.getConexion();
            PreparedStatement ps = con.prepareStatement(
                "SELECT * FROM casa WHERE numero_casa = ?"
            );
            ps.setInt(1, numeroCasa);
            ResultSet rs = ps.executeQuery();
            return rs.next();
        } catch(SQLException e){
            System.out.println("Error: " + e.getMessage());
        }
        return false;
    }
    
    public boolean insertar(Casa casa)throws SQLException{
        try{
            Connection con = Conexion.getConexion();
            
            PreparedStatement psConteo = con.prepareStatement(
                "SELECT COUNT(*) FROM casa WHERE id_condominio = ?"
            );
            psConteo.setInt(1, casa.getIdCondominio());
            ResultSet rs = psConteo.executeQuery();
            rs.next();
            if (rs.getInt(1) >= 30) {
                System.out.println("Límite de 33 casas alcanzado");
                return false;
            }
            
            PreparedStatement ps = con.prepareStatement(
                "INSERT INTO casa (numero_casa, id_propietario, id_condominio, created_by) VALUES (?, ?, ?, ?)"
            );
            ps.setInt(1, casa.getNumeroCasa());
            ps.setInt(2, casa.getIdPropietario());
            ps.setInt(3, casa.getIdCondominio());
            ps.setInt(4, casa.getCreatedBy());
            return ps.executeUpdate() > 0;
        } catch (SQLException e){
            System.out.println("Error: " + e.getMessage());
        }
        return false;
    }
    
    public Casa buscarPorNumero (int numeroCasa)throws SQLException{
        try{
            Connection con = Conexion.getConexion();
            PreparedStatement ps = con.prepareStatement(
                "SELECT * FROM casa WHERE numero_casa = ?"
            );
            ps.setInt(1, numeroCasa);
            ResultSet rs = ps.executeQuery();
            if (rs.next()){
                Casa c = new Casa();
                c.setIdCasa(rs.getInt("id_casa"));
                c.setNumeroCasa(rs.getInt("numero_casa"));
                c.setIdPropietario(rs.getInt("id_propietario"));
                c.setIdCondominio(rs.getInt("id_condominio"));
                return c;
            }
        } catch (SQLException e){
            System.out.println("Error: " + e.getMessage());
        }
        return null;
    }
    
    public Casa buscarPorId (int idCasa)throws SQLException{
        try{
            Connection con = Conexion.getConexion();
            PreparedStatement ps = con.prepareStatement(
                "SELECT * FROM casa WHERE id_casa = ?"
            );
            ps.setInt(1, idCasa);
            ResultSet rs = ps.executeQuery();
            if (rs.next()){
                Casa c = new Casa();
                c.setIdCasa(rs.getInt("id_casa"));
                c.setNumeroCasa(rs.getInt("numero_casa"));
                c.setIdPropietario(rs.getInt("id_propietario"));
                c.setIdCondominio(rs.getInt("id_condominio"));
                return c;
            }
        } catch (SQLException e){
            System.out.println("Error: " + e.getMessage());
        }
        return null;
    }
    
    public boolean actualizar(Casa casa) throws SQLException {
        try {
            Connection con = Conexion.getConexion();
            PreparedStatement ps = con.prepareStatement(
                "UPDATE casa SET numero_casa = ?, id_propietario = ?, id_condominio = ?, updated_by = ? WHERE id_casa = ?"
            );
            ps.setInt(1, casa.getNumeroCasa());
            ps.setInt(2, casa.getIdPropietario());
            ps.setInt(3, casa.getIdCondominio());
            ps.setInt(4, casa.getUpdatedBy());
            ps.setInt(5, casa.getIdCasa());
            return ps.executeUpdate() > 0;
        } catch (SQLException e) {
            System.out.println("Error: " + e.getMessage());
        }
        return false;
    }
    
}
