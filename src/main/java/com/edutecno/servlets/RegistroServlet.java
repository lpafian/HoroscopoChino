package com.edutecno.servlets;

import java.io.IOException;
import java.sql.Date;
import java.sql.SQLException;
import java.text.SimpleDateFormat;

import com.edutecno.dao.UsuarioDAO;
import com.edutecno.modelo.Usuario;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;



@WebServlet("/RegistroServlet")
public class RegistroServlet extends HttpServlet {

    // Este método maneja las solicitudes POST cuando el usuario envía el formulario de registro
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Recuperamos los parámetros del formulario
        String nombre = request.getParameter("nombre");
        String username = request.getParameter("username");
        String email = request.getParameter("email");
        String fechaNacimientoStr = request.getParameter("fecha_nacimiento");
        String password = request.getParameter("password");

        // Validamos y convertimos la fecha de nacimiento a un objeto Date
        Date fechaNacimiento = null;
        try {
            SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
            fechaNacimiento = (Date) sdf.parse(fechaNacimientoStr);
        } catch (Exception e) {
            e.printStackTrace();
        }

        // Creamos el objeto Usuario con los datos proporcionados
        Usuario usuario = new Usuario(nombre, username, email, fechaNacimiento, password);

        // Usamos el DAO para registrar al usuario en la base de datos
        UsuarioDAO usuarioDAO = new UsuarioDAO();
        boolean registroExitoso = false;
		try {
			registroExitoso = usuarioDAO.registrarUsuario(usuario);
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

        // Verificamos si el registro fue exitoso
        if (registroExitoso) {
            // Si el registro fue exitoso, redirigimos al usuario a la página de login
            response.sendRedirect("login.jsp");
        } else {
            // Si el registro falla, mostramos un mensaje de error
            response.getWriter().write("Hubo un problema al registrar el usuario. Intenta nuevamente.");
        }
    }
}
