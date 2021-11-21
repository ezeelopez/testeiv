package eiv.example.demo.controladores;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import eiv.example.demo.entidades.Provincias;
import eiv.example.demo.errores.WebException;
import eiv.example.demo.servicios.ProvinciasServicios;

@Controller
@RequestMapping("/provincias")
public class ProvinciasControlador {
   
	@Autowired
	private ProvinciasServicios servProvincias;
	
	@GetMapping("/mostrar")
	public List<Provincias> mostrarTodasLasProvincias() throws WebException{
		return servProvincias.buscarTodasLasProvincias();
	}
	
	@PostMapping("/registrar")
	public Provincias registar(@RequestParam String nombre , String region)throws WebException {
		return servProvincias.registrar(nombre, region);
	}
	
	
	@PostMapping("/modificar")
    public Provincias modificar(@RequestParam Integer id, @RequestParam String nombre ,@RequestParam String region)throws WebException {
	    return servProvincias.modificar(id, nombre, region);
	}
	
	
	
	
	
}