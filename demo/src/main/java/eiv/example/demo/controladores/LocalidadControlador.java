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

import eiv.example.demo.entidades.Localidad;
import eiv.example.demo.entidades.Provincia;
import eiv.example.demo.servicios.LocalidadServicios;

@RestController
@RequestMapping("/localidad")
public class LocalidadControlador {
     
	@Autowired
	private LocalidadServicios servLocalidad;
	

	
	
	@PostMapping("/registrar")
	public ResponseEntity<Localidad> registrar(@RequestBody Localidad localidad) throws Exception {
		
		try {
		
			
			return new ResponseEntity<Localidad>(servLocalidad.registrar(localidad), HttpStatus.CREATED);
			
		}catch(Exception e) {
			
			return new ResponseEntity<> (HttpStatus.BAD_REQUEST);
		}
		
	
	}
	
	@PutMapping("/modificar")
	public ResponseEntity<Localidad> modificar(@RequestBody Localidad localidad) throws Exception {
		
		try {
			servLocalidad.buscarLocalidadPorID(localidad.getIdlocalidad());
		    
			return new ResponseEntity<Localidad>(servLocalidad.modificar(localidad), HttpStatus.ACCEPTED);
			
		}catch(Exception e) {
			
			return new ResponseEntity<> (HttpStatus.NOT_FOUND);
		}
		
	}
	
	@DeleteMapping("/eliminar")
	public ResponseEntity<Localidad> eliminar(Localidad localidad) throws Exception {
		try {
			servLocalidad.eliminar(localidad);
			 return new ResponseEntity<Localidad>(HttpStatus.OK);
		}catch(Exception e) {
	
			return new ResponseEntity<> (HttpStatus.NOT_FOUND);
		}
		
		
	}
	
	
	@GetMapping("/mostrar")
	public List<Localidad> mostrar()throws Exception {
		
		try {
			return servLocalidad.buscarTodosLasLocalidades();
		}catch(NotFound e) {
			throw new Exception();
		}
	
	}
	
}
