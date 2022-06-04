package com.muebleria.ws.utilidades;

import java.util.ArrayList;
import java.util.List;

import com.muebleria.ws.vo.ProductosVo;

public class ProductosUtilidades {
	
	//public final static int TIPO_ADMIN=1;
	//public final static int TIPO_EMPLEADO=2;
	static int bandera=0;
	
	public static List<ProductosVo>listaProductos=new ArrayList<ProductosVo>();
	
	public static void  iniciarListaPersona() {
		if(bandera==0) {
			listaProductos.add(new ProductosVo(1,"comedor","color: amarillo",5.000));
			listaProductos.add(new ProductosVo(2,"armario","color: red",10.000));
			bandera=1;
		}
	}

}
