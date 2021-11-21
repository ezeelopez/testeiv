package eiv.example.demo.controladores;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import eiv.example.demo.entidades.Localidades;
import eiv.example.demo.entidades.Provincias;
import eiv.example.demo.errores.WebException;
import eiv.example.demo.servicios.LocalidadesServicios;

@Controller
@RequestMapping("/localidades")
public class LocalidadesControlador {
     
	@Autowired
	private LocalidadesServicios servLocalidades;
	
	
	@GetMapping("/mostrar")
	public List<Localidades> mostrar()throws WebException {
		return servLocalidades.buscarTodosLasLocalidades();
	}
	
	
	@PostMapping("/registrar")
	public Localidades registrar(@RequestParam String nombre,
    @RequestParam Provincias provincia , @RequestParam String codigo_postal) throws WebException {
		return servLocalidades.registrar(nombre, provincia, codigo_postal);
	}
	
	@PostMapping("/modificar")
	public Localidades modificar(@RequestParam Integer id, @RequestParam String nombre,
		    @RequestParam Provincias provincia , @RequestParam String codigo_postal) throws WebException {
	    return servLocalidades.modificar(id, nombre, provincia, codigo_postal);
	}
	
	
	
}
