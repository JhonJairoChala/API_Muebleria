package com.muebleria.ws.vo;

public class CarritoComprasVo {
	private int codigoCarrito;
	private String nombreProducto;
	private String descripcionProducto;
	private float precio;
	private String documentoCliente;
	
	public CarritoComprasVo(int codigoCarrito, String nombreProducto, String descripcionProducto, float precio , String documentoCliente) {
		super();
		this.codigoCarrito = codigoCarrito;
		this.nombreProducto = nombreProducto;
		this.descripcionProducto = descripcionProducto;
		this.precio = precio;
		this.documentoCliente = documentoCliente;
	}

	public CarritoComprasVo() {
	
	}

	public String getDocumentoCliente() {
		return documentoCliente;
	}

	public void setDocumentoCliente(String documentoCliente) {
		this.documentoCliente = documentoCliente;
	}

	public int getCodigoCarrito() {
		return codigoCarrito;
	}

	public void setCodigoCarrito(int codigoCarrito) {
		this.codigoCarrito = codigoCarrito;
	}

	public String getNombreProducto() {
		return nombreProducto;
	}

	public void setNombreProducto(String nombreProducto) {
		this.nombreProducto = nombreProducto;
	}

	public String getDescripcionProducto() {
		return descripcionProducto;
	}

	public void setDescripcionProducto(String descripcionProducto) {
		this.descripcionProducto = descripcionProducto;
	}

	public float getPrecio() {
		return precio;
	}

	public void setPrecio(float precio) {
		this.precio = precio;
	}

	@Override
	public String toString() {
		return "CarritoComprasVo [codigoCarrito=" + codigoCarrito + ", nombreProducto=" + nombreProducto
				+ ", descripcionProducto=" + descripcionProducto + ", precio=" + precio + "]";
	}
	
}
