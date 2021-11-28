package eiv.example.demo.controladores;


import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.HttpClientErrorException.NotFound;

import eiv.example.demo.entidades.Persona;
import eiv.example.demo.servicios.PersonaServicios;

@RestController
@RequestMapping("/personas")
public class PersonaControlador {
	
	@Autowired
	private PersonaServicios servPersonas;
	
	
	
	
	@GetMapping("/mostrartodo")
	public List<Persona> mostrar()throws Exception {
		
		try {
			return servPersonas.mostrartodos();
		}catch(NotFound e) {
			throw new Exception();
		}
	
	}
	
	
	@PostMapping("/registrar")
	public Persona registrar(@RequestBody Persona persona) throws Exception{
		
		try {
			return servPersonas.registrar(persona);
		}catch(NotFound e) {
			throw new Exception();
		}
		
		
	}
	
	@PutMapping("/modificar")
	public Persona modificar(@RequestBody Persona persona) throws Exception {
		
		try {
			servPersonas.buscarPersonaPorID(persona.getNumeroDocumento());
			return servPersonas.modificar(persona);          
		}catch(NotFound e) {
			throw new Exception();
		}
		
		         
	}
	
	@DeleteMapping("/eliminar")
	public void eliminar(@RequestBody Persona persona) throws Exception {
		
		try {
			servPersonas.eliminar(persona);
		}catch(NotFound e) {
			throw new Exception();
		}
		
		
	}

	@PutMapping("/dar-baja")
	public Persona darbaja(@RequestBody Persona persona) throws Exception {
		try {
			servPersonas.buscarPersonaPorID(persona.getNumeroDocumento());
			   return servPersonas.darBaja(persona);
		}catch(NotFound e) {
			throw new Exception();
		}
		
	}
	
	@PutMapping("/dar-alta")
	public Persona daralta(@RequestBody Persona persona ) throws Exception {
		try {
			servPersonas.buscarPersonaPorID(persona.getNumeroDocumento());
			return servPersonas.daralta(persona);
		}catch(NotFound e) {
			throw new Exception();
		}
		
	} 
	
}
