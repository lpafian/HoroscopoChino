package com.edutecno.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.edutecno.modelo.Usuario;
import com.edutecno.procesaconexion.ConexionDB;

public class UsuarioDAO {
	
	 public boolean validarUsuario(String username, String password) throws ClassNotFoundException {
	        String sql = "SELECT * FROM usuarios WHERE username = ? AND password = ?";
	        try (Connection conn = ConexionDB.getConexion();
	             PreparedStatement ps = conn.prepareStatement(sql)) {
	            
	            ps.setString(1, username);
	            ps.setString(2, password);
	            
	            try (ResultSet rs = ps.executeQuery()) {
	                return rs.next(); // Si hay resultados, el usuario existe
	            }
	        } catch (SQLException e) {
	            e.printStackTrace();
	        }
	        return false;
	    }
		
    // Método para actualizar los datos del usuario en la base de datos
    public boolean actualizarUsuario(Usuario usuario) throws ClassNotFoundException, SQLException {
        boolean actualizacionExitosa = false;
        String consultaSql = "UPDATE usuarios SET nombre = ?, email = ?, password = ? WHERE id = ?";
        Connection conn = ConexionDB.getConexion();

        try {
            PreparedStatement pstm = conn.prepareStatement(consultaSql);
            pstm.setString(1, usuario.getNombre());
            pstm.setString(2, usuario.getEmail1());
            pstm.setString(3, (String) usuario.getPassword());
            pstm.setInt(4, usuario.getId1());  // Usamos el ID para identificar al usuario a actualizar

            int filasAfectadas = pstm.executeUpdate();

            if (filasAfectadas > 0) {
                actualizacionExitosa = true;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return actualizacionExitosa;
    }

	public Usuario obtenerUsuarioPorUsername(String username) {
		
		return null;
	}


	
	 // Método para eliminar un usuario de la base de datos
    public boolean eliminarUsuario(int idUsuario) throws ClassNotFoundException, SQLException {
        boolean eliminacionExitosa = false;
        String consultaSql = "DELETE FROM usuarios WHERE id = ?";
        Connection conn = ConexionDB.getConexion();

        try {
            PreparedStatement pstm = conn.prepareStatement(consultaSql);
            pstm.setInt(1, idUsuario);  // Establecemos el ID del usuario a eliminar

            int filasAfectadas = pstm.executeUpdate();

            if (filasAfectadas > 0) {
                eliminacionExitosa = true;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return eliminacionExitosa;
    }
    
   

       // Método para registrar un nuevo usuario en la base de datos
       public boolean registrarUsuario(Usuario usuario) throws ClassNotFoundException, SQLException {
            boolean registroExitoso = false;
            String consultaSql = "INSERT INTO usuarios (nombre, username, email, fecha_nacimiento, password) VALUES (?, ?, ?, ?, ?)";
            Connection conn = ConexionDB.getConexion();

            try {
                PreparedStatement pstm = conn.prepareStatement(consultaSql);
                pstm.setString(1, usuario.getNombre());
                pstm.setString(2, usuario.getUsername());
                pstm.setString(3, usuario.getEmail());
                pstm.setDouble(4, usuario.getFechaNacimiento().getTime());
                pstm.setString(5, (String) usuario.getPassword());

                int filasAfectadas = pstm.executeUpdate();

                if (filasAfectadas > 0) {
                    registroExitoso = true;
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
            return registroExitoso;
        }
       
       public Usuario obtenerUsuarioPorUsername1(String username) throws ClassNotFoundException, SQLException {
           Usuario usuario = null;
           String consultaSql = "SELECT * FROM usuarios WHERE username = ?";
           Connection conn = ConexionDB.getConexion();

           try {
               PreparedStatement pstm = conn.prepareStatement(consultaSql);
               pstm.setString(1, username);
               ResultSet rs = pstm.executeQuery();

               if (rs.next()) {
                   usuario = new Usuario(
                       rs.getString("nombre"),
                       rs.getString("username"),
                       rs.getString("email"),
                       rs.getDate("fecha_nacimiento"),
                       rs.getString("password")
                   );
               }
           } catch (SQLException e) {
               e.printStackTrace();
           }
           return usuario;
       }   
       
    }  


