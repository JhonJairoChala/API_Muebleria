package com.muebleria.ws.dao;

import java.util.Iterator;
import java.util.List;

import org.springframework.stereotype.Service;

import com.muebleria.ws.utilidades.PersonasUtilidades;
import com.muebleria.ws.vo.CarritoComprasVo;
import com.muebleria.ws.vo.PersonaVo;

@Service
public class PersonasDao {
	
	public PersonasDao(){
		PersonasUtilidades.iniciarLista();
	}

	public PersonaVo consultarPersonaIndividual(String documento) {
		PersonaVo personaVo = null;
		for (PersonaVo p: PersonasUtilidades.listaPersonas) {
			if(p.getDocumento().equals(documento)) {
				personaVo = new PersonaVo();
				personaVo.setDocumento(p.getDocumento());
				personaVo.setNombre(p.getNombre());
				personaVo.setTelefono(p.getTelefono());
				personaVo.setEdad(p.getEdad());
				personaVo.setCorreo(p.getCorreo());
				personaVo.setDireccion(p.getDireccion());
			}
		}
		return personaVo;
	}
	
	public PersonaVo consultarPersonaIndividualNombre(String nombre) {
		PersonaVo personaVo = null;
		for (PersonaVo p: PersonasUtilidades.listaPersonas) {
			if(p.getNombre().equalsIgnoreCase(nombre)) {
				personaVo = new PersonaVo();
				personaVo.setDocumento(p.getDocumento());
				personaVo.setNombre(p.getNombre());
				personaVo.setTelefono(p.getTelefono());
				personaVo.setEdad(p.getEdad());
				personaVo.setCorreo(p.getCorreo());
				personaVo.setDireccion(p.getDireccion());
			}
		}
		return personaVo;
	}
		
	public List<PersonaVo> obtenerListaPersonas(){
		return PersonasUtilidades.listaPersonas;
	}
	
	public PersonaVo registrarPersona(PersonaVo personaVo) {
		boolean existe = false;
		
		for (PersonaVo persona: PersonasUtilidades.listaPersonas){
			if(persona.getDocumento().equals(personaVo.getDocumento())) {
				existe = true;
				break;
			}
			
		}
		if(existe == false) {
			personaVo.setPassword(personaVo.getDocumento());
			PersonasUtilidades.listaPersonas.add(personaVo);
			CarritoComprasVo carrito= new CarritoComprasVo();
			personaVo.getCarritoCompras().add(carrito);
			carrito.setDocumentoCliente(personaVo.getDocumento());
			return personaVo;
		}else {
			return null;
		}
	}
	
	public PersonaVo login(String documento , String pass) {
		PersonaVo persona = null;
		
		for(PersonaVo p: PersonasUtilidades.listaPersonas) {
			if(p.getDocumento().equals(documento) && p.getPassword().equals(pass)) {
				persona = p;
				break;
			}
		}
		return persona;
	}
	
	public PersonaVo editarPersona(PersonaVo persona) {
		PersonaVo personaVo = null;
		for(PersonaVo p: PersonasUtilidades.listaPersonas) {
			if(p.getDocumento().equals(persona.getDocumento())) {
				p.setDocumento(persona.getDocumento());
				p.setCorreo(persona.getCorreo());
				p.setDireccion(persona.getDireccion());
				p.setEdad(persona.getEdad());
				p.setNombre(persona.getNombre());
				p.setPassword(persona.getPassword());
				p.setTelefono(persona.getTelefono());
				personaVo = p;
				break;
			}
		}
		return personaVo;
	}
	
	public void eliminarPersona(PersonaVo persona) {
		for(PersonaVo p : PersonasUtilidades.listaPersonas) {
			if(p.getDocumento().equals(persona.getDocumento())) {
				PersonasUtilidades.listaPersonas.remove(p);
				break;
			}
		}
	}
}
