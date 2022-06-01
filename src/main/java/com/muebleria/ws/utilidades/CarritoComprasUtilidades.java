package com.muebleria.ws.utilidades;

import java.util.ArrayList;
import java.util.List;

import com.muebleria.ws.vo.CarritoComprasVo;

public class CarritoComprasUtilidades {
	public final static int TIPO_ADMIN=1;
	public final static int TIPO_EMPLEADO=2;
	static int bandera=0;
	
	public static List<CarritoComprasVo> listaCarritos = new ArrayList<CarritoComprasVo>();

	public static void iniciarLista() {
		if(bandera==0) {
			listaCarritos.add(new CarritoComprasVo(1,"Mesa","Azul,Redonda",500000 , "123456789"));
			listaCarritos.add(new CarritoComprasVo(2,"Silla","Roja,Madera fina",250000 , "987654321"));
			bandera = 1;
		}
	}

}
