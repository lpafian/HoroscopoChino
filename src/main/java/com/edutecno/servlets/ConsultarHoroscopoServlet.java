package com.edutecno.servlets;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import com.edutecno.dao.HoroscopoDAO;
import com.edutecno.modelo.Horoscopo;
import com.edutecno.modelo.Usuario;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;



@WebServlet("/ConsultarHoroscopoServlet")
public class ConsultarHoroscopoServlet extends HttpServlet {
    
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String fechaNacimientoStr = request.getParameter("fechaNacimiento");
        try {
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
            Date fechaNacimiento = sdf.parse(fechaNacimientoStr);
            
            // Crear un objeto Usuario con la fecha de nacimiento
            Usuario usuario = new Usuario("", "", "", fechaNacimiento, "");
            
            // Obtener la lista de horóscopos
            HoroscopoDAO horoscopoDAO = new HoroscopoDAO();
            List<Horoscopo> listaHoroscopo = horoscopoDAO.obtenerHoroscopo();
            Horoscopo horoscopo = null;
            
            // Buscar el signo correspondiente
            for (Horoscopo h : listaHoroscopo) {
                if (usuario.getFechaNacimiento().after(h.getFechaInicio()) && usuario.getFechaNacimiento().before(h.getFechaFin())) {
                    horoscopo = h;
                    break;
                }
            }
            
            if (horoscopo != null) {
                request.setAttribute("animal", horoscopo.getAnimal());
                request.getRequestDispatcher("consultaHoroscopo.jsp").forward(request, response);
            } else {
                response.getWriter().write("No se encontró el horóscopo.");
            }
        } catch (Exception e) {
            e.printStackTrace();
            response.getWriter().write("Error al procesar la fecha.");
        }
    }
}

