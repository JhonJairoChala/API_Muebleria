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

import com.muebleria.ws.dao.PersonasDao;
import com.muebleria.ws.vo.PersonaVo;

@RestController
@RequestMapping("/servicio")
public class PersonasService {
	
	@Autowired(required = true)
	private PersonasDao personaDao;
	
	@GetMapping
	public String saludo() {
		return "Saludo de la muebleria";
	}
	
	//http://localhost:8080/servicio/personas?id=123456789
	@GetMapping("personas")
	public ResponseEntity<PersonaVo> getPersona(@RequestParam(value="id",defaultValue="0")String documento){
		PersonaVo persona = personaDao.consultarPersonaIndividual(documento);
		
		if(persona == null) {
			persona = new PersonaVo();
		}
		return ResponseEntity.ok(persona);
	}
	
	//http://localhost:8080/servicio/personasNombre?nombre=jhon
	@GetMapping("personasNombre")
	public ResponseEntity<PersonaVo> getPersonaNombre(@RequestParam(value="nombre",defaultValue="")String nombre){
		PersonaVo persona = personaDao.consultarPersonaIndividualNombre(nombre);
		
		if(persona == null) {
			persona = new PersonaVo();
		}
		return ResponseEntity.ok(persona);
	}
	
	//http://localhost:8080/servicio/listaPersonas
	@GetMapping("listaPersonas")
	public ResponseEntity<List<PersonaVo>> getPersonas(){
		List<PersonaVo> personas = personaDao.obtenerListaPersonas();
		
		return ResponseEntity.ok(personas);
	}
	
	//http://localhost:8080/servicio/registrar
	@PostMapping("registrar")
	public ResponseEntity<PersonaVo> registrarPersona(@RequestBody PersonaVo persona){
		PersonaVo miPersona = personaDao.registrarPersona(persona);
		if(miPersona == null) {
			return ResponseEntity.ok(miPersona);
		}else {
			return ResponseEntity.notFound().build();
		}
	}
	
	//http://localhost:8080/servicio/login
	@PostMapping("login")
	public ResponseEntity<PersonaVo> validarUsuario(@RequestBody PersonaVo persona){
		PersonaVo miPersona = personaDao.login(persona.getDocumento(), persona.getPassword());
		if(miPersona != null) {
			return ResponseEntity.ok(miPersona);
		}else {
			return ResponseEntity.notFound().build();
		}
	}
	
	//http://localhost:8080/servicio/editar
	@PutMapping("editar")
	public ResponseEntity<PersonaVo> editarUsuario(@RequestBody PersonaVo persona){
		PersonaVo miPersona = null;
		if(personaDao.consultarPersonaIndividual(persona.getDocumento()) != null) {
			miPersona = personaDao.editarPersona(persona);
			if(miPersona != null) {
				return ResponseEntity.ok(miPersona);
			}else {
				return ResponseEntity.notFound().build();
			}	
		}else {
			return ResponseEntity.notFound().build();
		}
	}
	
	//http://localhost:8080/servicio/eliminar/123456789
	@DeleteMapping("eliminar/{id}")
	public ResponseEntity<Void> eliminarUsuario(@PathVariable String id){
		PersonaVo miPersona = personaDao.consultarPersonaIndividual(id);
		if(miPersona != null) {
			personaDao.eliminarPersona(miPersona);
			return ResponseEntity.ok(null);
		}
		
		return ResponseEntity.notFound().build();
	}
	
}
