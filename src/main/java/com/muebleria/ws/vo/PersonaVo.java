package com.muebleria.ws.vo;

import java.util.List;

public class PersonaVo {
	private String documento;
	private String nombre;
	private String telefono;
	private int edad;
	private String direccion;
	private String correo;
	private String password; 
	private List<CarritoComprasVo> carritoCompras;
	
	public PersonaVo(String documento, String nombre, String telefono, int edad, String direccion, String correo) {
		super();
		this.documento = documento;
		this.nombre = nombre;
		this.telefono = telefono;
		this.edad = edad;
		this.direccion = direccion;
		this.correo = correo;
	}

	
	
	public PersonaVo() {
	
	}

	
	public List<CarritoComprasVo> getCarritoCompras() {
		return carritoCompras;
	}

	public void setCarritoCompras(List<CarritoComprasVo> carritoCompras) {
		this.carritoCompras = carritoCompras;
	}

	public String getDocumento() {
		return documento;
	}

	public void setDocumento(String documento) {
		this.documento = documento;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getTelefono() {
		return telefono;
	}

	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}

	public int getEdad() {
		return edad;
	}

	public void setEdad(int edad) {
		this.edad = edad;
	}

	public String getDireccion() {
		return direccion;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

	public String getCorreo() {
		return correo;
	}

	public void setCorreo(String correo) {
		this.correo = correo;
	}
	
	
	
	public String getPassword() {
		return password;
	}



	public void setPassword(String password) {
		this.password = password;
	}



	@Override
	public String toString() {
		return "PersonaVo [documento=" + documento + ", nombre=" + nombre + ", telefono=" + telefono + ", edad=" + edad
				+ ", direccion=" + direccion + ", correo=" + correo + "]";
	}
	
	
}
