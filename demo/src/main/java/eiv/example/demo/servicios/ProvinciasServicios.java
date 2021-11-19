package eiv.example.demo.servicios;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


import eiv.example.demo.entidades.Provincias;
import eiv.example.demo.errores.WebException;
import eiv.example.demo.repositorio.ProvinciasRepositorios;

@Service
public class ProvinciasServicios {
	
	@Autowired
	private ProvinciasRepositorios rpsProvincias;
	
	
	// METODO PARA REGISTRAR UNA PROVINCIA
	
	@Transactional
	public Provincias registrar(String nombre , String region) throws WebException {
		
		validar(nombre,region);
		Provincias provincia = new Provincias();
		provincia.setNombre(nombre);
		provincia.setRegion(region);
		  
		rpsProvincias.save(provincia);
		
		return provincia;
	}
	
	//METODO PARA MODIFICAR UNA PROVINCIA
	@Transactional
	public Provincias modificar(Integer id ,String nombre , String region) throws WebException {
		validar(nombre,region);
		Optional<Provincias> modificar = buscarProvinciasPorID(id);
		if(modificar.isPresent()) {
			Provincias provincia = modificar.get();
			provincia.setNombre(nombre);
			provincia.setRegion(region);
			  
			rpsProvincias.save(provincia);
			
			return provincia;
		}else {
			throw new WebException("no se ha encontrado la solicitud");
		}
	}
	
	
	// METODO PARA BUSCAR TODAS LAS PROVINCIA
	
	 @Transactional(readOnly = true)
		public List<Provincias> buscarTodasLasProvincias(){
			List<Provincias> provincias = rpsProvincias.findAll();	
			return provincias;
		}
	 
	 // METODO PARA BUSCAR TODAS LA PROVINCIAS POR ID
	 @Transactional(readOnly = true)
		public Optional<Provincias> buscarProvinciasPorID(Integer id){
			Optional<Provincias> buscar = rpsProvincias.findById(id);
			return buscar;
		}
	 
	 
	 // METODO PARA VALIDAR 
	 
	private void validar(String nombre , String region) throws WebException {
		
		if(nombre == null || nombre.isEmpty()) {
			throw new WebException("el nombre no puede estar nulo o vacio");
		}
		if(!region.equalsIgnoreCase("NOA") && !region.equalsIgnoreCase("NEA") && 
		   !region.equalsIgnoreCase("CUY") && !region.equalsIgnoreCase("PAM") && 
		   !region.equalsIgnoreCase("GBA") && !region.equalsIgnoreCase("PAT")) {
			throw new WebException("ingrese la region correctamente");
		}
	}
	
	
	
	

}
