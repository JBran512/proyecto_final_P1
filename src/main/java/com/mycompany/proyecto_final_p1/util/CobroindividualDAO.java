/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.proyecto_final_p1.util;

import com.mycompany.proyecto_final_p1.model.Cobroindividual;
import com.mycompany.proyecto_final_p1.model.Cobros;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Calendar;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;

/**
 *
 * @author Chriss
 */
public class CobroindividualDAO {
    public ArrayList<Cobroindividual> listarCasas() {

    ArrayList<Cobroindividual> casas = new ArrayList<>();

    try {

        Connection con = Conexion.getConexion();

        String sql = """
                     SELECT id_casa, numero_casa
                     FROM casa
                     ORDER BY numero_casa
                     """;

        PreparedStatement ps = con.prepareStatement(sql);

        ResultSet rs = ps.executeQuery();

        while (rs.next()) {

            casas.add(
                new Cobroindividual(
                    rs.getInt("id_casa"),
                    rs.getInt("numero_casa")
                )
            );

        }

    } catch (SQLException e) {

        System.out.println(e.getMessage());

    }

    return casas;
}
}
