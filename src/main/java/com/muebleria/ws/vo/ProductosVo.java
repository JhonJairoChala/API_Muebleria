package com.muebleria.ws.vo;

public class ProductosVo {
	
	private int codigo;
	private String nombre;
	private String descripcion;
	private double presio;
	
	public ProductosVo() {
		super();
		// TODO Auto-generated constructor stub
	}

	public ProductosVo(int codigo, String nombre, String descripcion, double presio) {
		super();
		this.codigo = codigo;
		this.nombre = nombre;
		this.descripcion = descripcion;
		this.presio = presio;
	}

	public int getCodigo() {
		return codigo;
	}

	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public double getPresio() {
		return presio;
	}

	public void setPresio(double presio) {
		this.presio = presio;
	}

	@Override
	public String toString() {
		return "ProductosVo [codigo=" + codigo + ", nombre=" + nombre + ", descripcion=" + descripcion + ", presio="
				+ presio + "]";
	}
	
	

}
