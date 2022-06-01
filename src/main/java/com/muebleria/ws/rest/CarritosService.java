package com.muebleria.ws.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.muebleria.ws.dao.CarritoComprasDao;
import com.muebleria.ws.vo.CarritoComprasVo;

@RestController
@RequestMapping("/servicioCarritoCompras")
public class CarritosService {
		
		@Autowired(required = true)
		private CarritoComprasDao carritoComprasDao;
		
		@GetMapping("carritos")
		public ResponseEntity<CarritoComprasVo> getCarrito(@RequestParam(value="id",defaultValue="0")String documento){
			CarritoComprasVo carrito = carritoComprasDao.consultarCarrito(documento);
			
			if(carrito == null) {
				carrito = new CarritoComprasVo();
			}
			return ResponseEntity.ok(carrito);
		}
}
