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

import eiv.example.demo.entidades.Persona;
import eiv.example.demo.entidades.Provincia;
import eiv.example.demo.servicios.ProvinciaServicios;


@RestController
@RequestMapping("/provincia")
public class ProvinciaControlador {
   
	@Autowired
	private ProvinciaServicios servProvincia;

	

	
	@PostMapping("/registrar")
	public  ResponseEntity<Provincia> registar( @RequestBody Provincia provincia) throws Exception {
		try {
			
			return new ResponseEntity<Provincia>(servProvincia.registrar(provincia), HttpStatus.CREATED);
			
		
		}catch(Exception e) {
			
			return new ResponseEntity<> (HttpStatus.BAD_REQUEST);
		}
		
		
	}
	
	
	@PutMapping("/modificar")
    public ResponseEntity<Provincia> modificar( @RequestBody Provincia provincia)throws Exception {
		try {
			 servProvincia.buscarProvinciasPorID(provincia.getIdProvincia());
			 
				return new ResponseEntity<Provincia>(servProvincia.modificar(provincia), HttpStatus.ACCEPTED);
		
		}catch(Exception e) {

			return new ResponseEntity<> (HttpStatus.NOT_FOUND);
			
		}
		      
	} 
	
	@DeleteMapping("/eliminar")
	public ResponseEntity<Provincia> eliminar(@RequestBody Provincia provincia)throws Exception {
		try {
			 servProvincia.eliminar(provincia);
			 return new ResponseEntity<Provincia>(HttpStatus.OK);
			 
		}catch(Exception e) {

			return new ResponseEntity<> (HttpStatus.NOT_FOUND);
		}
		   
	}
	
	
	@GetMapping("/mostrar")
	public List<Provincia> mostrarTodasLasProvincias() throws Exception{
		try {
		return servProvincia.buscarTodasLasProvincias();
		}catch(Exception e) {
			e.getMessage();
			throw new Exception();
		}
	
	} 
	
}