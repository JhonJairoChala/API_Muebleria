package com.muebleria.ws.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.muebleria.ws.dao.ProductosDao;
import com.muebleria.ws.vo.ProductosVo;

@RestController
@RequestMapping("/servicioProductos")
public class ProductosService {
	
	@Autowired(required=true)
	private ProductosDao productosDao;
	
	//http://localhost:8080/servicioProductos/productos?id=<codigo del producto>
	@GetMapping("productos")
	public ResponseEntity<ProductosVo>getProducto(
			@RequestParam(value="id",defaultValue="0")int id){
		
		ProductosVo producto=productosDao.consultarProductoIndividual(id);
		
		return ResponseEntity.ok(producto);
	}
	
	//consulta usando @PathVariable
	
	//http://localhost:8080/servicioProductos/productos/<codigo del producto>
	@GetMapping("productos/{id}")
	public ResponseEntity<ProductosVo>getProductoId(@PathVariable("id")int codigo){
		ProductosVo producto=productosDao.consultarProductoIndividual(codigo);
		
		if(producto!=null) {
			
			return ResponseEntity.ok(producto);
		}
		
		return ResponseEntity.notFound().build();//si el producto no existe sera Error 404 not Found
	}
	
	// http://localhost:8080/servicioProductos/productos-list
	@GetMapping("/productos-list")
	public ResponseEntity<List<ProductosVo>> getPrdouctos(){
		
		List<ProductosVo> productos=productosDao.consultarLista();
		
		return ResponseEntity.ok(productos);
	}
	
	//Registrar Producto
	
	@PostMapping("guardar")
	public ResponseEntity<ProductosVo>registrarProductos(@RequestBody ProductosVo productos){
		ProductosVo miProducto=productosDao.registrarProductos(productos);
		if(miProducto!=null) {
			return ResponseEntity.ok(miProducto);
			
		}else {
			return ResponseEntity.notFound().build();
		}
	}
	
	
	// http://localhost:8080/servicioProductos/actualizarProducto
	@PutMapping("actualizarProducto")
	public ResponseEntity<ProductosVo>actualizarProducto(@RequestBody ProductosVo producto){
		
		ProductosVo productoVo=null;
		if(productosDao.consultarProductoIndividual(producto.getCodigo())!=null) {
			productoVo=productosDao.actualizarProducto(producto);
			if(productoVo!=null) {
				return ResponseEntity.ok(productoVo);
			}else {
				return ResponseEntity.notFound().build();
			}
		}else {
			return ResponseEntity.notFound().build();
		}
	}
	
	@DeleteMapping("eliminar/{id}")
	public ResponseEntity<Void>eliminarProducto(@PathVariable int codigo){
	
		ProductosVo producto=productosDao.consultarProductoIndividual(codigo);
		if(producto!=null) {
			productosDao.eliminarProducto(producto);
			return ResponseEntity.ok(null);
		}
		return ResponseEntity.notFound().build();
	}
}
