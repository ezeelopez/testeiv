package eiv.example.demo.servicios;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import eiv.example.demo.entidades.Localidad;


import eiv.example.demo.errores.WebException;
import eiv.example.demo.repositorio.LocalidadRepositorio;

@Service
public class LocalidadServicios {
	
	@Autowired
	private LocalidadRepositorio rpsLocalidades;
	
	@Transactional
	public Localidad registrar(Localidad localidad) throws WebException {
		
	validar(localidad);
	return	rpsLocalidades.save(localidad);
	
	}
	
	
	
	@Transactional
	public Localidad modificar(Localidad localidad) throws WebException {
	
		 Optional<Localidad> modificar = buscarLocalidadPorID(localidad.getIdlocalidad());
		 if(modificar.isPresent()) {
			 Localidad localida = modificar.get();
				localida.setNombre(localidad.getNombre());
				localida.setProvincia(localidad.getProvincia());
				localida.setCodigopostal(localidad.getCodigopostal());
				
		   	return	rpsLocalidades.save(localidad);
				
		 }else {
			 throw new WebException("no se ha encontrado la solicitud");
		 }
		
	}
	
	@Transactional
	public void eliminar(Localidad localidad) throws Exception {
		rpsLocalidades.deleteById(localidad.getIdlocalidad());
	}
	
	

	 @Transactional(readOnly = true)
		public List<Localidad> buscarTodosLasLocalidades(){
			List<Localidad> localidad = rpsLocalidades.findAll();	
			return  localidad;
		}
	
	 @Transactional(readOnly = true)
		public Optional<Localidad> buscarLocalidadPorID(Integer id){
			Optional<Localidad> buscar = rpsLocalidades.findById(id);
			return buscar;
		}
	 
	 
	 

	private void validar(Localidad localidad) throws WebException{
		
	if(localidad.getNombre() == null || localidad.getNombre().isEmpty()) {
		throw new WebException("el nombre no puede estar nulo o vacio");
	}
	if(localidad.getProvincia() == null) {
		throw new WebException("la provincia no puede estar nula");
	}
	if(localidad.getCodigopostal() == null || localidad.getCodigopostal().isEmpty()) {
		throw new WebException("el codigo postal no puede estar nulo o vacio");
	}
	} 
	

}
