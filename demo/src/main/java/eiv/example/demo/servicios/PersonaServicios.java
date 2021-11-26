package eiv.example.demo.servicios;

import java.time.LocalDate;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import eiv.example.demo.entidades.Localidad;
import eiv.example.demo.entidades.Persona;
import eiv.example.demo.entidades.Tipodocumento;
import eiv.example.demo.errores.WebException;
import eiv.example.demo.repositorio.PersonaRepositorios;
import eiv.example.demo.repositorio.TipodocumentoRepositorios;

@Service
public class PersonaServicios {

	@Autowired
	private PersonaRepositorios rpsPersonas;
	
	@Autowired
	private TipodocumentoRepositorios rpsTipodocumento;
	
	// METODO PARA REGISTRAR UNA PERSONA
	@Transactional
	public Persona registrar(Integer numerodocumento , Tipodocumento idtipodocumento,
		    String nombre , String apellido , LocalDate fechanacimiento , char genero,
		    boolean esargentino, String correoelectronico ,
			Localidad localidad , String codigopostal) throws WebException{
	
		
		verificarargentino(esargentino);
		
		Persona persona = new Persona();
	
		persona.setNumeroDocumento(numerodocumento);
		persona.setTipodocumento(idtipodocumento);
		persona.setNombre(nombre);
		persona.setApellido(apellido);
		persona.setFechaNacimineto(fechanacimiento);
		persona.setGenero(genero);
		persona.setEsArgentino(esargentino);
		persona.setAlta(true);
		persona.setCorreoElectronico(correoelectronico);
		persona.setLocalidad(localidad);
		persona.setCodigoPostal(codigopostal);
		
		rpsPersonas.save(persona);
		return persona;
	}
	
	//METODO PARA MODIFICAR UNA PERSONA
	 @Transactional
	public Persona modificar(Integer numerodocumento , Tipodocumento tipodocumento,
		    String nombre , String apellido , LocalDate fechanacimiento , char genero,
		    boolean esargentino, String correoelectronico ,
			Localidad localidad , String codigopostal) throws WebException{
		
	
		
		verificarargentino(esargentino);
		// UN METODO QUE ME AYUDA A ENCONTRAR EL ID DE LA PERSONA , SI LLEGA A EXISTIR ME LO MODIFICA
		 Optional<Persona> modificar = buscarPersonaPorID(numerodocumento);	
		 if(modificar.isPresent()) {
			 Persona persona = modificar.get();
				
				persona.setNumeroDocumento(numerodocumento);
				persona.setTipodocumento(tipodocumento);
				persona.setNombre(nombre);
				persona.setApellido(apellido);
				persona.setFechaNacimineto(fechanacimiento);
				persona.setGenero(genero);
				persona.setEsArgentino(esargentino);
				persona.setAlta(true);
				persona.setCorreoElectronico(correoelectronico);
				persona.setLocalidad(localidad);
				persona.setCodigoPostal(codigopostal);
				
				rpsPersonas.save(persona);
				return persona;
		 }else {
			 throw new WebException("no se ha encontrado la solicitud");
		 }
		
	}
		
	
	// METODO PARA DAR DE BAJA UNA PERSONA
	 @Transactional
	public Persona darBaja(Integer numero_documento , boolean alta) throws WebException{
		
		Optional<Persona> modificar = buscarPersonaPorID(numero_documento);
		if(modificar.isPresent()) {
			Persona persona = modificar.get();
			persona.setAlta(false);
			return rpsPersonas.save(persona);
			
		}else {
			throw new WebException("no se ha encontrado la solicitud");
		}
		
	}

	// METODO PARA DAR DE ALTA UNA PERSONA
	 @Transactional
public Persona daralta(Integer numero_documento , boolean alta) throws WebException{
		
		Optional<Persona> modificar = buscarPersonaPorID(numero_documento);
		if(modificar.isPresent()) {
			Persona persona = modificar.get();
			persona.setAlta(true);
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
	/*
	 @Transactional(readOnly = true)
	public List<Persona> buscarTodoLosDocumentos(Integer numero_docuemnto){
		List<Persona> buscarpordocuemento = rpsPersonas.buscarTodoLosDocumentos(numero_docuemnto);
		return buscarpordocuemento;
	} */
	
	// METODO PARA VALIDAR SI EL TIPO DE DOCUMENTO ES ARGENTINO O  EXTRANJERO
	 @Transactional
	public void verificarargentino(boolean esargentino) {
		Tipodocumento documento = (Tipodocumento) rpsTipodocumento.findAll();
		if(documento.getAbreviatura().equalsIgnoreCase("DNI")) {
			esargentino = true;
		}else {
			esargentino = false;
		}
	}
	
	
	// METODO DE VALIDACION
	 /*
	private void validar(Integer numerodocumento , Tipodocumento tipodocumento,
		    String nombre , String apellido ,LocalDate fechanacimiento , char genero,
		     String correoelectronico ,Localidad localidad , String codigopostal) throws WebException{
		
		List<Persona> numero_documento1 = buscarTodoLosDocumentos(numerodocumento);
		for(Persona numero_documento : numero_documento1) {
			if(numero_documento.getNumeroDocumento() == null || numero_documento.getNumeroDocumento().equals(numero_documento1)) {
				throw new WebException("el numero de documento ya existe");
			}
		}
		if(tipodocumento == null) {
			throw new WebException("el tipo de documento no puede estar nulo o vacio");
			
		}
		
		if(nombre == null || nombre.isEmpty()) {
			throw new WebException("el nombre no puede ser nulo o vacio");
			
		}
		if(apellido == null || apellido.isEmpty()) {
			throw new WebException("el apellido no puede ser nulo o vacio");
			
		}
		if(fechanacimiento == null) {
			throw new WebException("la fecha nacimiento no puede ser nulo");
			
		}
		
		if(genero == 'm' && genero == 'f') {
			
		}else {
			throw new WebException("el genero no puede ser nula o ingrese correctamente");
		}
		
		if(correoelectronico == null || correoelectronico.isEmpty()) {
			throw new WebException("el correo electronico no puede ser nulo o vacio");
			
		}
		if(localidad == null) {
			throw new WebException("la localidad no puede nulo o vacio");
		}
		if(codigopostal == null || codigopostal.isEmpty()) {
			throw new WebException("el codigo postal no puede ser nulo o vacio");
		}
	} */
	

}
