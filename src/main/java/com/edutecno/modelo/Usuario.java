package com.edutecno.modelo;

import java.util.Date;

public class Usuario {
    private String nombre;
    private String username;
    private String email;
    private Date fechaNacimiento;
    private String password;
    private String animal;

    public Usuario(String nombre, String username, String email, Date fechaNacimiento, String password) {
        this.nombre = nombre;
        this.username = username;
        this.email = email;
        this.fechaNacimiento = fechaNacimiento;
        this.password = password;
    }

    public Usuario(int idUsuario, String nombre2, String email2, String password2) {
		// TODO Auto-generated constructor stub
	}

	public void setAnimal(String animal) {
        this.animal = animal;
    }

    public Date getFechaNacimiento() {
        return fechaNacimiento;
    }

	public Object getPassword() {
		return null;
	}

	public String getNombre() {
		
		return null;
	}

	public String getEmail1() {
		
		return null;
	}

	public int getId() {
	
		return 0;
	}

	public String getEmail() {
		
		return null;
	}

	public int getId1() {
		// TODO Auto-generated method stub
		return 0;
	}

	public String getUsername() {
		
		return null;
	}
}
