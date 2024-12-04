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
	<br>
    <h3>Iniciar Sesión</h3>
    <p>Es necesario que inicies sesión para revisar tu horóscopo chino. Si todavía no tienes cuenta, Haz click<button type="button" class="btn btn-link" href="registro.jsp">aquí</button>
    <br>
    <form action="LoginServlet" method="post">
    	<div class="row g-3 align-items-center">
		  <div class="col-auto">
		    <label for="inputPassword6" class="col-form-label">Nombre de Usuario</label>
		  </div>
		  <div class="col-auto">
		    <input type="text" name="username" id="inputPassword6" class="form-control" aria-describedby="passwordHelpInline">
		  </div>
		 </div>
		 <br>
		 <div class="row g-3 align-items-center">
		  <div class="col-auto">
		    <label for="inputPassword6" class="col-form-label">Contraseña</label>
		  </div>
		  <div class="col-auto">
		    <input type="password" name="password" id="inputPassword6" class="form-control" aria-describedby="passwordHelpInline">
		  </div>
		 </div>
		 <br>
        <button type="submit" value="Iniciar Sesión" class="btn btn-primary">Ingresar</button>
               
       <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-YvpcrYf0tY3lHB60NNkmXc5s9fDVZLESaAA55NDzOxhy9GkcIdslK1eN7N6jIeHz" crossorigin="anonymous"></script>   
    </form>
  </body>
</html>
