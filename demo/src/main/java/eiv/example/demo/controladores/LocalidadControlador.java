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

import eiv.example.demo.entidades.Localidad;
import eiv.example.demo.servicios.LocalidadServicios;

@RestController
@RequestMapping("/localidad")
public class LocalidadControlador {
     
	@Autowired
	private LocalidadServicios servLocalidades;
	
	
	@GetMapping("/mostrar")
	public List<Localidad> mostrar()throws Exception {
		
		try {
			return servLocalidades.buscarTodosLasLocalidades();
		}catch(NotFound e) {
			throw new Exception();
		}
	
	}
	
	
	@PostMapping("/registrar")
	public Localidad registrar(@RequestBody Localidad localidad) throws Exception {
		
		try {
			return servLocalidades.registrar(localidad);
		}catch(NotFound e) {
			throw new Exception();
		}
		
	
	}
	
	@PutMapping("/modificar")
	public Localidad modificar(@RequestBody Localidad localidad) throws Exception {
		
		try {
			servLocalidades.buscarLocalidadPorID(localidad.getIdlocalidad());
		    return servLocalidades.modificar(localidad);
		}catch(NotFound e) {
			throw new Exception();
		}
		
	}
	
	@DeleteMapping("/eliminar")
	public void eliminar(Localidad localidad) throws Exception {
		try {
			servLocalidades.eliminar(localidad);
		}catch(NotFound e) {
			throw new Exception();
		}
		
		
	}
	
	
}
