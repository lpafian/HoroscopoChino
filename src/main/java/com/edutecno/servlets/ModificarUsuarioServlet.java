package com.edutecno.servlets;

import java.io.IOException;
import java.sql.SQLException;

import com.edutecno.dao.UsuarioDAO;
import com.edutecno.modelo.Usuario;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;


@WebServlet("/ModificarUsuarioServlet")
public class ModificarUsuarioServlet extends HttpServlet {

    // Este método maneja las solicitudes POST cuando el usuario envía el formulario de modificación
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Recuperamos los parámetros enviados desde el formulario
        String idUsuarioStr = request.getParameter("idUsuario");
        String nombre = request.getParameter("nombre");
        String email = request.getParameter("email");
        String password = request.getParameter("password");

        // Validamos que el ID del usuario sea válido
        if (idUsuarioStr != null && !idUsuarioStr.isEmpty()) {
            int idUsuario = Integer.parseInt(idUsuarioStr);

            // Creamos el objeto Usuario con los nuevos datos
            Usuario usuario = new Usuario(idUsuario, nombre, email, password);

            // Usamos el DAO para actualizar los datos del usuario en la base de datos
            UsuarioDAO usuarioDAO = new UsuarioDAO();
            boolean actualizacionExitosa = false;
			try {
				actualizacionExitosa = usuarioDAO.actualizarUsuario(usuario);
			} catch (ClassNotFoundException | SQLException e) {
				
				e.printStackTrace();
			}

            // Verificamos si la actualización fue exitosa
            if (actualizacionExitosa) {
                // Si fue exitosa, redirigimos al perfil del usuario o a alguna página de éxito
                response.sendRedirect("perfil.jsp");
            } else {
                // Si hubo un error, mostramos un mensaje de error
                response.getWriter().write("Hubo un problema al modificar los datos. Intenta nuevamente.");
            }
        } else {
            // Si el ID no es válido, mostramos un mensaje de error
            response.getWriter().write("ID de usuario no válido.");
        }
    }
}

