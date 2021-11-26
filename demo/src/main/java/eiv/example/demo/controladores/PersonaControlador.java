package eiv.example.demo.controladores;


import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import eiv.example.demo.entidades.Persona;
import eiv.example.demo.errores.WebException;
import eiv.example.demo.servicios.PersonaServicios;

@Controller
@RequestMapping("/personas")
public class PersonaControlador {
	
	@Autowired
	private PersonaServicios servPersonas;
	
	@GetMapping("/mostrartodo")
	public List<Persona> mostrar()throws WebException {
		return servPersonas.mostrartodos();
	}
	
	
	@PostMapping("/registrar")
	public Persona registrar(@RequestBody Persona persona) throws WebException{
		
		return servPersonas.registrar(persona);
	}
	
	@PutMapping("/modificar")
	public Persona modificar(@RequestBody Persona persona) throws WebException {
		
		servPersonas.buscarPersonaPorID(persona.getNumeroDocumento());
		return servPersonas.modificar(persona);                   
	}
	
	@DeleteMapping("/eliminar")
	public void eliminar(Persona persona) throws Exception {
		servPersonas.eliminar(persona);
	}

	@PutMapping("/dar-baja")
	public Persona darbaja(@RequestBody Persona persona) throws WebException {
		servPersonas.buscarPersonaPorID(persona.getNumeroDocumento());
	   return servPersonas.darBaja(persona);
	}
	
	@PutMapping("/dar-alta")
	public Persona daralta(@RequestBody Persona persona ) throws WebException {
		servPersonas.buscarPersonaPorID(persona.getNumeroDocumento());
		return servPersonas.daralta(persona);
	}
	
}
