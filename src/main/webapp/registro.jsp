<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="jakarta.tags.core" prefix="c" %>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH" crossorigin="anonymous">
		<style>
		
		</style>
		<title>Login</title>
	</head>
	<body>
		<nav class="navbar bg-body-tertiary">
		  <div class="container-fluid">
		    <span class="navbar-text">
		     	Horóscopo Chino      Tu Horóscopo Chino 
		    </span>
		  </div>
		</nav>
	 <br>
    <h3>Regístrate</h3>
    <form action="LoginServlet" method="post">
    	<div class="row g-3 align-items-center">
		  <div class="col-auto">
		Nombre:  <input type="text" name="nombre" required><br>
        Usuario: <input type="text" name="username" required><br>
        Email:   <input type="email" name="email" required><br>
        Fecha de Nacimiento: <input type="date" name="fechaNacimiento" required><br>
        Contraseña: <input type="password" name="password" required><br>
       
		   
		  </div>
		 </div>
		 <br>
        <button type="submit" value="Registrar" class="btn btn-primary">Registrarse</button>
               
       <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-YvpcrYf0tY3lHB60NNkmXc5s9fDVZLESaAA55NDzOxhy9GkcIdslK1eN7N6jIeHz" crossorigin="anonymous"></script>   
    </form>
  </body>
</html>


