<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <title>Modificar Usuario</title>
</head>
<body>
    <h1>Modificar Datos del Usuario</h1>
    
    <form action="ModificarUsuarioServlet" method="post">
      
        <input type="hidden" name="idUsuario" value="${usuario.id}"> 
        Nombre: <input type="text" name="nombre" value="${usuario.nombre}" required><br>
        Usuario: <input type="text" name="username" value="${usuario.username}" readonly><br> 
        Email: <input type="email" name="email" value="${usuario.email}" required><br>
        Contraseña: <input type="password" name="password" required><br>
        
        <input type="submit" value="Actualizar">
    </form>

    <br>
    <a href="perfil.jsp">Volver a perfil</a>
</body>
</html>
