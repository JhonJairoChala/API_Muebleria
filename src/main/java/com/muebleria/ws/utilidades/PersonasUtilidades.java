package com.muebleria.ws.utilidades;

import java.util.ArrayList;
import java.util.List;

import com.muebleria.ws.vo.PersonaVo;

public class PersonasUtilidades {
	public final static int TIPO_ADMIN=1;
	public final static int TIPO_EMPLEADO=2;
	static int bandera=0;
	
	public static List<PersonaVo> listaPersonas = new ArrayList<PersonaVo>();

	public static void iniciarLista() {
		if(bandera==0) {
			listaPersonas.add(new PersonaVo("123456789","Jhon","1234",18,"Armenia","jj@gmail.com"));
			listaPersonas.add(new PersonaVo("987654321","Prueba","4321",0,"Armenia","prueba@gmail.com"));
			bandera = 1;
		}
	}
}
