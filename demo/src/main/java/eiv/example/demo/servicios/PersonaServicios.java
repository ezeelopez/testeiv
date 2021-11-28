package eiv.example.demo.servicios;

import java.time.LocalDate;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


import eiv.example.demo.entidades.Persona;

import eiv.example.demo.errores.WebException;
import eiv.example.demo.repositorio.PersonaRepositorios;


@Service
public class PersonaServicios {

	@Autowired
	private PersonaRepositorios rpsPersonas;
	

	
	// METODO PARA REGISTRAR UNA PERSONA
	@Transactional
	public Persona registrar(Persona persona) throws WebException{
		
		validar(persona);
        verificarargentino(persona);
	return	rpsPersonas.save(persona);
	
	}
	 
	
	//METODO PARA MODIFICAR UNA PERSONA
	 @Transactional
	public Persona modificar(Persona persona) throws WebException{
		
		 Optional<Persona> modificar = buscarPersonaPorID(persona.getNumeroDocumento());	
		 if(modificar.isPresent()) {
			 Persona personas = modificar.get();
				
				personas.setNombre(persona.getNombre());
				personas.setApellido(persona.getApellido());
				personas.setFechaNacimineto(persona.getFechaNacimineto());
				personas.setGenero(persona.getGenero());
				personas.setEsArgentino(persona.isEsArgentino());
				personas.setAlta(true);
				personas.setCorreoElectronico(persona.getCorreoElectronico());
				personas.setLocalidad(persona.getLocalidad());
				personas.setCodigoPostal(persona.getCodigoPostal());
				
				rpsPersonas.save(persona);
				return persona;
		 }else {
			 throw new WebException("no se ha encontrado la solicitud");
		 }
		
	}
		
	 //METODO PARA ELIMINAR
	 public void eliminar(Persona persona) throws Exception{
		 rpsPersonas.deleteById(persona.getNumeroDocumento());
	 }
	 
	 
	 
	
	// METODO PARA DAR DE BAJA UNA PERSONA
	 @Transactional
	public Persona darBaja(Persona persona) throws WebException{
		
		Optional<Persona> modificar = buscarPersonaPorID(persona.getNumeroDocumento());
		if(modificar.isPresent()) {
			Persona personas = modificar.get();
			personas.setAlta(false);
			return rpsPersonas.save(persona);
			
		}else {
			throw new WebException("no se ha encontrado la solicitud");
		}
		
	}

	// METODO PARA DAR DE ALTA UNA PERSONA
	 @Transactional
public Persona daralta(Persona persona) throws WebException{
		
		Optional<Persona> modificar = buscarPersonaPorID(persona.getNumeroDocumento());
		if(modificar.isPresent()) {
			Persona personas = modificar.get();
			personas.setAlta(true);
			return rpsPersonas.save(persona);
			
		}else {
			throw new WebException("no se ha encontrado la solicitud");
		}
		
	}
	
	
	//METODO PARA BUSCAR TODAS LAS PERSONA POR ID
	
	 @Transactional(readOnly = true)
		public Optional<Persona> buscarPersonaPorID(Integer id){
			Optional<Persona> buscar = rpsPersonas.findById(id);
			return buscar;
		}
	
	public List<Persona> mostrartodos(){
		List<Persona> mostrar = rpsPersonas.findAll();
		return mostrar;
	}
	
	
	
	
	// METODO PARA BUSCAR TODOS LOS DOCUMENTO DE LA PERSONA
	
	 @Transactional(readOnly = true)
	public List<Persona> buscarTodoLosDocumentos(Integer numerodocuemnto){
		List<Persona> buscarpordocuemento = rpsPersonas.buscarTodoLosDocumentos(numerodocuemnto);
		return buscarpordocuemento;
	} 
	
	// METODO PARA VALIDAR SI EL TIPO DE DOCUMENTO ES ARGENTINO O  EXTRANJERO
	 @Transactional
	public void verificarargentino(Persona persona) {
		   
		if(persona.getDocumento().getAbreviatura().equalsIgnoreCase("DNI")) {
			persona.setEsArgentino(true); 
		}else {
			persona.setEsArgentino(false);
		}
	}
	
	
	// METODO DE VALIDACION
	 
	private void validar(Persona persona) throws WebException{
		
		List<Persona> numero_documento1 = buscarTodoLosDocumentos(persona.getNumeroDocumento());
		for(Persona numero_documento : numero_documento1) {
			if(numero_documento.getNumeroDocumento() == null || numero_documento.getNumeroDocumento().equals(numero_documento1)) {
				throw new WebException("el numero de documento ya existe");
			}
		}
		if(persona.getDocumento() == null) {
			throw new WebException("el tipo de documento no puede estar nulo o vacio");
			
		}
		
		if(persona.getNombre() == null || persona.getNombre().isEmpty()) {
			throw new WebException("el nombre no puede ser nulo o vacio");
			
		}
		if(persona.getApellido() == null || persona.getApellido().isEmpty()) {
			throw new WebException("el apellido no puede ser nulo o vacio");
			
		}
		if(persona.getFechaNacimineto() == null) {
			throw new WebException("la fecha nacimiento no puede ser nulo");
			
		}
		
		if(persona.getGenero() == 'm' && persona.getGenero() == 'f') {
			
		}else {
			throw new WebException("el genero no puede ser nula o ingrese correctamente");
		}
		
		if(persona.getCorreoElectronico() == null || persona.getCorreoElectronico().isEmpty()) {
			throw new WebException("el correo electronico no puede ser nulo o vacio");
			
		}
		if(persona.getLocalidad() == null) {
			throw new WebException("la localidad no puede nulo o vacio");
		}
		if(persona.getCodigoPostal() == null || persona.getCodigoPostal().isEmpty()) {
			throw new WebException("el codigo postal no puede ser nulo o vacio");
		}
	} 
	

}
