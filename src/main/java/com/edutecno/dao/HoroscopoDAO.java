package com.edutecno.dao;

import com.edutecno.modelo.Horoscopo;
import com.edutecno.procesaconexion.ConexionDB;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class HoroscopoDAO {
    
    public List<Horoscopo> obtenerHoroscopo() throws ClassNotFoundException {
        List<Horoscopo> listaHoroscopo = new ArrayList<>();
        String sql = "SELECT * FROM horoscopo";
        
        try (Connection conn = ConexionDB.getConexion(); 
             PreparedStatement ps = conn.prepareStatement(sql);
             ResultSet rs = ps.executeQuery()) {
            
            while (rs.next()) {
                Horoscopo h = new Horoscopo(rs.getString("animal"), rs.getDate("fecha_inicio"), rs.getDate("fecha_fin"));
                listaHoroscopo.add(h);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return listaHoroscopo;
    }
}
