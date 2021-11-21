package eiv.example.demo.controladores;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import eiv.example.demo.entidades.Localidades;
import eiv.example.demo.entidades.Personas;
import eiv.example.demo.entidades.Tipo_documentos;
import eiv.example.demo.errores.WebException;
import eiv.example.demo.servicios.PersonasServicios;

@Controller
@RequestMapping("/personas")
public class PersonasControlador {
	
	@Autowired
	private PersonasServicios servPersonas;
	
	@GetMapping("/mostrartodo")
	public List<Personas> mostrar()throws WebException {
		return servPersonas.mostrartodos();
	}
	
	
	@PostMapping("/registrar")
	public Personas registrar(@RequestParam Integer numero_docuemnto , @RequestParam Tipo_documentos id_documento ,@RequestParam String nombre,
			@RequestParam String apellido, @RequestParam @DateTimeFormat(pattern = "YYYY-MM-dd") Date fecha_nacimineto,
			@RequestParam char genero ,@RequestParam boolean es_argentino,@RequestParam String correo_electronico,@RequestParam Localidades id_localidades,
			@RequestParam String codigo_postal) throws WebException{
		
		return servPersonas.registrar(numero_docuemnto, id_documento, nombre, apellido,
				fecha_nacimineto, genero, es_argentino, correo_electronico, id_localidades, codigo_postal);
	}
	
	@PostMapping("/modificar")
	public Personas modificar(@RequestParam Integer numero_docuemnto , @RequestParam Tipo_documentos id_documento ,@RequestParam String nombre,
			@RequestParam String apellido, @RequestParam @DateTimeFormat(pattern = "YYYY-MM-dd") Date fecha_nacimineto,
			@RequestParam char genero ,@RequestParam boolean es_argentino,@RequestParam String correo_electronico,@RequestParam Localidades id_localidades,
			@RequestParam String codigo_postal) throws WebException {
		
		return servPersonas.modificar(numero_docuemnto, id_documento, nombre, apellido, fecha_nacimineto, genero, es_argentino, correo_electronico, id_localidades, codigo_postal);                   
	}

	@PostMapping("/dar-baja")
	public Personas darbaja(@RequestParam Integer numero_documento , @RequestParam boolean alta) throws WebException {
	   return servPersonas.darBaja(numero_documento, alta);
	}
	
	@PostMapping("/dar-alta")
	public Personas daralta(@RequestParam Integer numero_documento , @RequestParam boolean alta) throws WebException {
		return servPersonas.daralta(numero_documento, alta);
	}
	
}
