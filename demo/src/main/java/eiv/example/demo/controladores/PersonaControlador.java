package eiv.example.demo.controladores;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import eiv.example.demo.entidades.Localidad;
import eiv.example.demo.entidades.Persona;
import eiv.example.demo.entidades.Tipodocumento;
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
	public Persona registrar(@RequestParam Integer numero_docuemnto , @RequestParam Tipodocumento id_documento ,@RequestParam String nombre,
			@RequestParam String apellido, LocalDate fecha_nacimineto,
			@RequestParam char genero ,@RequestParam boolean es_argentino,@RequestParam String correo_electronico,@RequestParam Localidad id_localidades,
			@RequestParam String codigo_postal) throws WebException{
		
		return servPersonas.registrar(numero_docuemnto, id_documento, nombre, apellido,
				fecha_nacimineto, genero, es_argentino, correo_electronico, id_localidades, codigo_postal);
	}
	
	@PostMapping("/modificar")
	public Persona modificar(@RequestParam Integer numero_docuemnto , @RequestParam Tipodocumento id_documento ,@RequestParam String nombre,
			@RequestParam String apellido, LocalDate fecha_nacimineto,
			@RequestParam char genero ,@RequestParam boolean es_argentino,@RequestParam String correo_electronico,@RequestParam Localidad id_localidades,
			@RequestParam String codigo_postal) throws WebException {
		
		return servPersonas.modificar(numero_docuemnto, id_documento, nombre, apellido, fecha_nacimineto, genero, es_argentino, correo_electronico, id_localidades, codigo_postal);                   
	}

	@PostMapping("/dar-baja")
	public Persona darbaja(@RequestParam Integer numero_documento , @RequestParam boolean alta) throws WebException {
	   return servPersonas.darBaja(numero_documento, alta);
	}
	
	@PostMapping("/dar-alta")
	public Persona daralta(@RequestParam Integer numero_documento , @RequestParam boolean alta) throws WebException {
		return servPersonas.daralta(numero_documento, alta);
	}
	
}
