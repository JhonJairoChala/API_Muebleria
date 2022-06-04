package com.muebleria.ws.dao;

import java.util.List;

import org.springframework.stereotype.Service;

import com.muebleria.ws.utilidades.ProductosUtilidades;
import com.muebleria.ws.vo.ProductosVo;

@Service
public class ProductosDao {

	public ProductosDao() {
		ProductosUtilidades.iniciarListaPersona();
	}

	public ProductosVo consultarProductoIndividual(int id) {
		ProductosVo producto=null;
		for(ProductosVo p:ProductosUtilidades.listaProductos) {
			if(p.getCodigo()==id) {
				producto=new ProductosVo();
				producto.setCodigo(p.getCodigo());
				producto.setNombre(p.getNombre());
				producto.setDescripcion(p.getDescripcion());
				producto.setPresio(p.getPresio());
			}
		}
		
		return producto;
	}
	
	public List<ProductosVo> consultarLista() {
		return ProductosUtilidades.listaProductos;
	}
	
	//Registrar Producto
	
	public ProductosVo registrarProductos(ProductosVo producto) {
		
		boolean existe=false;
		
		for(ProductosVo obj:ProductosUtilidades.listaProductos) {
			if(obj.getCodigo()==producto.getCodigo()) {
				existe=true;
				break;
			}
		}
		if(existe==false) {
			producto.setCodigo(producto.getCodigo());
			ProductosUtilidades.listaProductos.add(producto);
			return producto;
		}else {
			return null;
		}
	}
	
	//actualizarProducto
	public ProductosVo actualizarProducto(ProductosVo producto) {
		ProductosVo productoVo=null;
		for(ProductosVo obj:ProductosUtilidades.listaProductos) {
			if(obj.getCodigo()==producto.getCodigo()) {
				obj.setCodigo(producto.getCodigo());
				obj.setNombre(producto.getNombre());
				obj.setDescripcion(producto.getDescripcion());
				obj.setPresio(producto.getPresio());
				producto=obj;
				break;
			}
		}
		
		return productoVo;
	}
	
	//eliminarProducto
	
	public void eliminarProducto(ProductosVo productoVo) {
		for(ProductosVo producto:ProductosUtilidades.listaProductos) {
		if(producto.getCodigo()==productoVo.getCodigo()) {
			ProductosUtilidades.listaProductos.remove(producto);
			break;
		}
		}
	}

}
