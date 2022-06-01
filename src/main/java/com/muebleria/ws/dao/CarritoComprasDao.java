package com.muebleria.ws.dao;

import org.springframework.stereotype.Service;

import com.muebleria.ws.utilidades.CarritoComprasUtilidades;
import com.muebleria.ws.utilidades.PersonasUtilidades;
import com.muebleria.ws.vo.CarritoComprasVo;
import com.muebleria.ws.vo.PersonaVo;

@Service
public class CarritoComprasDao {
	
	public CarritoComprasDao() {
		CarritoComprasUtilidades.iniciarLista();
	}
	
	public CarritoComprasVo consultarCarrito(String documento) {
		CarritoComprasVo carritoCompras = null;
		for (PersonaVo p : PersonasUtilidades.listaPersonas) {
			if(p.getDocumento().equalsIgnoreCase(documento)) {
				for (CarritoComprasVo c: CarritoComprasUtilidades.listaCarritos) {
					if(c.getDocumentoCliente().equalsIgnoreCase(documento)) {
						carritoCompras = new CarritoComprasVo();
						carritoCompras.setCodigoCarrito(c.getCodigoCarrito());
						carritoCompras.setDescripcionProducto(c.getDescripcionProducto());
						carritoCompras.setNombreProducto(c.getNombreProducto());
						carritoCompras.setPrecio(c.getPrecio());
						carritoCompras.setDocumentoCliente(c.getDocumentoCliente());
				}
			}
			}
		}
		return carritoCompras;
	}
	
	
}
