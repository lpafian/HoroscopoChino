package com.edutecno.servlets;

import java.io.IOException;

import com.edutecno.dao.UsuarioDAO;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;



@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
    
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        
        UsuarioDAO usuarioDAO = new UsuarioDAO();
        boolean esValido = false;
		try {
			esValido = usuarioDAO.validarUsuario(username, password);
		} catch (ClassNotFoundException e) {
			
			e.printStackTrace();
		}
        
        if (esValido) {
            request.getSession().setAttribute("usuario", username);
            response.sendRedirect("consulta.jsp");
        } else {
        	response.sendRedirect("login.jsp");
            response.getWriter().write("Usuario o Contraseña corresponde");
           
        }
    }
}

