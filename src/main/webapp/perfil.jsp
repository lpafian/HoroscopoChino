<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <title>Perfil de Usuario</title>
</head>
<body>
    <h1>Perfil de Usuario</h1>
    
   
    <p>Nombre: ${usuario.nombre}</p>
    <p>Email: ${usuario.email}</p>
    
    <a href="modificar.jsp">Modificar Datos</a>
</body>
</html>
