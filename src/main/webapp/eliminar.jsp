<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <title>Eliminar Usuario</title>
</head>
<body>
    <h1>Eliminar Usuario</h1>
    
    <form action="EliminarUsuarioServlet" method="post">
      
        <input type="hidden" name="idUsuario" value="${usuario.id}">
        
        <p>Estás seguro de que deseas eliminar tu cuenta, ${usuario.nombre}?</p>
        
        <input type="submit" value="Eliminar Usuario">
    </form>
    
    <br>
    <a href="perfil.jsp">Volver al perfil</a>
</body>
</html>
