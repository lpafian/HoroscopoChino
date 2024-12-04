
package com.edutecno.servlets;

import java.io.IOException;
import java.sql.SQLException;

import com.edutecno.dao.UsuarioDAO;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;



@WebServlet("/EliminarUsuarioServlet")
public class EliminarUsuarioServlet extends HttpServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Recuperamos el ID del usuario a eliminar
        String idUsuarioStr = request.getParameter("idUsuario");

        // Verificamos que el ID no sea nulo ni vacío
        if (idUsuarioStr != null && !idUsuarioStr.isEmpty()) {
            int idUsuario = Integer.parseInt(idUsuarioStr);

            // Usamos el DAO para eliminar al usuario
            UsuarioDAO usuarioDAO = new UsuarioDAO();
            boolean eliminacionExitosa = false;
			try {
				eliminacionExitosa = usuarioDAO.eliminarUsuario(idUsuario);
			} catch (ClassNotFoundException | SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

            // Verificamos si la eliminación fue exitosa
            if (eliminacionExitosa) {
                // Si la eliminación fue exitosa, redirigimos a la página de inicio o a una página de confirmación
                response.sendRedirect("index.jsp");
            } else {
                // Si hubo un error, mostramos un mensaje de error
                response.getWriter().write("Hubo un problema al eliminar el usuario. Intenta nuevamente.");
            }
        } else {
            // Si no se proporcionó un ID válido, mostramos un mensaje de error
            response.getWriter().write("ID de usuario no válido.");
        }
    }
}
