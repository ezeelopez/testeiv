package eiv.example.demo.servicios;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.client.HttpClientErrorException.NotFound;

import eiv.example.demo.entidades.Provincia;
import eiv.example.demo.errores.WebException;
import eiv.example.demo.repositorio.ProvinciaRepositorios;
import javassist.NotFoundException;

@Service
public class ProvinciaServicios {
	
	@Autowired
	private ProvinciaRepositorios rpsProvincias;
		
	// METODO PARA REGISTRAR UNA PROVINCIA
	
	@Transactional
	public Provincia registrar(Provincia provincia) throws Exception {
		
		try {
			validar(provincia);
			
			return rpsProvincias.save(provincia);
			
		}catch(NotFound e) {
			throw new Exception();
		}
		
		
	}
	
	//METODO PARA MODIFICAR UNA PROVINCIA
	@Transactional
	public Provincia modificar(Provincia provincia) throws Exception {
         
		 Optional<Provincia> modificar = buscarProvinciasPorID(provincia.getIdProvincia());
		     if(modificar.isPresent()){
		    	 Provincia provi = modificar.get(); 
		    	 provi.setNombre(provincia.getNombre());
		    	 provi.setRegion(provincia.getRegion());
		    	 return rpsProvincias.save(provincia);
		     }else {
		    	 throw new Exception("la solicitud no se ha encontrado");
		     }


	}
	
    @Transactional
	public void eliminar(Provincia provincia) throws Exception {
		 rpsProvincias.deleteById(provincia.getIdProvincia());
		 
	}
	
	// METODO PARA BUSCAR TODAS LAS PROVINCIA
	
	 @Transactional(readOnly = true)
		public List<Provincia> buscarTodasLasProvincias(){
			List<Provincia> provincias = rpsProvincias.findAll();	
			return provincias;
		}
	 
	 // METODO PARA BUSCAR TODAS LA PROVINCIAS POR ID
	 @Transactional(readOnly = true)
		public Optional<Provincia> buscarProvinciasPorID(Integer id){
			Optional<Provincia> buscar = rpsProvincias.findById(id);
			return buscar;
		}
	 
	 
	 // METODO PARA VALIDAR 
	 
	private void validar(Provincia provincia) throws Exception {
		
		if(provincia.getNombre() == null || provincia.getNombre().isEmpty()) {
			throw new WebException("el nombre no puede estar nulo o vacio");
		}
		if(!provincia.getRegion().equalsIgnoreCase("NOA") && !provincia.getRegion().equalsIgnoreCase("NEA") && 
		   !provincia.getRegion().equalsIgnoreCase("CUY") && !provincia.getRegion().equalsIgnoreCase("PAM") && 
		   !provincia.getRegion().equalsIgnoreCase("GBA") && !provincia.getRegion().equalsIgnoreCase("PAT")) {
			throw new NotFoundException("region incorrecta");
	}
	
	}
}
	
	


