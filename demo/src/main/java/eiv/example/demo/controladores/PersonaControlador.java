package eiv.example.demo.controladores;


import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.HttpClientErrorException.NotFound;

import ch.qos.logback.classic.Logger;
import eiv.example.demo.entidades.Persona;
import eiv.example.demo.servicios.PersonaServicios;

@RestController
@RequestMapping("/personas")
public class PersonaControlador {
	
	@Autowired
	private PersonaServicios servPersona;
	
	
	
	
	
	@PostMapping("/registrar")
	public ResponseEntity<Persona> registrar(@RequestBody Persona persona) throws Exception{
		
		try {
	
			return new ResponseEntity<Persona>(servPersona.registrar(persona), HttpStatus.CREATED);
			
		}catch(Exception e) {
			
			return new ResponseEntity<> (HttpStatus.BAD_REQUEST);
			
		}
		
		
	}
	
	@PutMapping("/modificar")
	public ResponseEntity<Persona> modificar(@RequestBody Persona persona) throws Exception {
		
		try {
			
			servPersona.buscarPersonaPorID(persona.getNumeroDocumento());
			servPersona.modificar(persona);
			return new ResponseEntity<Persona>(servPersona.modificar(persona), HttpStatus.ACCEPTED);
			

			
		}catch(Exception e) {
		
			return new ResponseEntity<> (HttpStatus.NOT_FOUND);
		}
		
		         
	}
	
	@DeleteMapping("/eliminar")
	public ResponseEntity<Persona> eliminar(@RequestBody Persona persona) throws Exception {
		
		try {
			servPersona.eliminar(persona);
			return new ResponseEntity<Persona>(HttpStatus.OK);
			
		}catch(Exception e) {
			
			return new ResponseEntity<> (HttpStatus.NOT_FOUND);
		}
		
		
	}

	@PutMapping("/dar-baja")
	public ResponseEntity<Persona> darbaja(@RequestBody Persona persona) throws Exception {
		try {
			servPersona.buscarPersonaPorID(persona.getNumeroDocumento());
			return new ResponseEntity<Persona>(servPersona.darBaja(persona), HttpStatus.ACCEPTED);
			 
		}catch(Exception e) {
		
			return new ResponseEntity<> (HttpStatus.NOT_FOUND);
		}
		
	}
	
	@PutMapping("/dar-alta")
	public ResponseEntity<Persona> daralta(@RequestBody Persona persona ) throws Exception {
		try {
			servPersona.buscarPersonaPorID(persona.getNumeroDocumento());
	
			return new ResponseEntity<Persona>(servPersona.daralta(persona), HttpStatus.ACCEPTED);
			
		}catch(Exception e) {

			return new ResponseEntity<> (HttpStatus.NOT_FOUND);
		}
		
	} 
	

	
	@GetMapping("/mostrartodo")
	public List<Persona> mostrar()throws Exception {
		
		try {
			return servPersona.mostrartodos();
		}catch(NotFound e) {
			throw new Exception();
		}
	
	}
	
}
