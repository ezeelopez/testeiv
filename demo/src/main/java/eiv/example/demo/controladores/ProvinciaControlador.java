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

import eiv.example.demo.entidades.Provincia;
import eiv.example.demo.servicios.ProvinciaServicios;


@RestController
@RequestMapping("/provincia")
public class ProvinciaControlador {
   
	@Autowired
	private ProvinciaServicios servProvincias;

	
	@GetMapping("/mostrar")
	public List<Provincia> mostrarTodasLasProvincias() throws Exception{
		try {
		return servProvincias.buscarTodasLasProvincias();
		}catch(NotFound e) {
			e.getMessage();
			throw new Exception();
		}
	
	} 
	
	@PostMapping("/registrar")
	public  Provincia registar( @RequestBody Provincia provincia) throws Exception {
		try {
			return servProvincias.registrar(provincia);
		}catch(NotFound e) {
			throw new Exception();
		}
		
		
	}
	
	
	@PutMapping("/modificar")
    public Provincia modificar( @RequestBody Provincia provincia)throws Exception {
		try {
			 servProvincias.buscarProvinciasPorID(provincia.getIdProvincia());
			    return servProvincias.modificar(provincia);
		}catch(NotFound e) {
			throw new Exception();
		}
		      
	} 
	
	@DeleteMapping("/eliminar")
	public void eliminar(@RequestBody Provincia provincia)throws Exception {
		try {
			 servProvincias.eliminar(provincia);
		}catch(NotFound e) {
			throw new Exception();
		}
		   
	}
	
	
	
	
}