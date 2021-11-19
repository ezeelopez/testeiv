package eiv.example.demo.servicios;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import eiv.example.demo.entidades.Localidades;
import eiv.example.demo.entidades.Personas;
import eiv.example.demo.entidades.Tipo_documentos;
import eiv.example.demo.errores.WebException;
import eiv.example.demo.repositorio.PersonasRepositorios;
import eiv.example.demo.repositorio.Tipo_documentoRepositorios;

@Service
public class PersonasServicios {

	@Autowired
	private PersonasRepositorios rpsPersonas;
	
	@Autowired
	private Tipo_documentoRepositorios rpsTipodocumento;
	
	// METODO PARA REGISTRAR UNA PERSONA
	@Transactional
	public Personas registrar(Integer numero_documento , Tipo_documentos id_tipodocumento,
		    String nombre , String apellido , Date fecha_nacimiento , char genero,
		    boolean es_argentino, String correo_electronico ,
			Localidades id_localidad , String codigo_postal) throws WebException{
		
		validar(numero_documento ,id_tipodocumento , nombre , apellido , fecha_nacimiento , genero,
			    correo_electronico , id_localidad , codigo_postal);
		
		verificarargentino(es_argentino);
		
		Personas persona = new Personas();
	
		persona.setNumero_documento(numero_documento);
		persona.setId_tipodocumento(id_tipodocumento);
		persona.setNombre(nombre);
		persona.setApellido(apellido);
		persona.setFecha_nacimineto(fecha_nacimiento);
		persona.setGenero(genero);
		persona.setEs_argentino(es_argentino);
		persona.setAlta(true);
		persona.setCorreo_electronico(correo_electronico);
		persona.setId_localidad(id_localidad);
		persona.setCodigo_postal(codigo_postal);
		
		rpsPersonas.save(persona);
		return persona;
	}
	
	//METODO PARA MODIFICAR UNA PERSONA
	 @Transactional
	public Personas modificar(Integer numero_documento , Tipo_documentos id_tipodocumento,
		    String nombre , String apellido , Date fecha_nacimiento , char genero,
		    boolean es_argentino, String correo_electronico ,
			Localidades id_localidad , String codigo_postal) throws WebException{
		
		validar(numero_documento ,id_tipodocumento , nombre , apellido , fecha_nacimiento , genero,
			    correo_electronico , id_localidad , codigo_postal);
		
		verificarargentino(es_argentino);
		// UN METODO QUE ME AYUDA A ENCONTRAR EL ID DE LA PERSONA , SI LLEGA A EXISTIR ME LO MODIFICA
		 Optional<Personas> modificar = buscarPersonaPorID(numero_documento);	
		 if(modificar.isPresent()) {
			 Personas persona = modificar.get();
				
				persona.setNumero_documento(numero_documento);
				persona.setId_tipodocumento(id_tipodocumento);
				persona.setNombre(nombre);
				persona.setApellido(apellido);
				persona.setFecha_nacimineto(fecha_nacimiento);
				persona.setGenero(genero);
				persona.setEs_argentino(es_argentino);
				persona.setAlta(true);
				persona.setCorreo_electronico(correo_electronico);
				persona.setId_localidad(id_localidad);
				persona.setCodigo_postal(codigo_postal);
				
				rpsPersonas.save(persona);
				return persona;
		 }else {
			 throw new WebException("no se ha encontrado la solicitud");
		 }
		
	}
		
	
	// METODO PARA DAR DE BAJA UNA PERSONA
	 @Transactional
	public Personas darBaja(Integer numero_documento , boolean alta) throws WebException{
		
		Optional<Personas> modificar = buscarPersonaPorID(numero_documento);
		if(modificar.isPresent()) {
			Personas persona = modificar.get();
			persona.setAlta(false);
			return rpsPersonas.save(persona);
			
		}else {
			throw new WebException("no se ha encontrado la solicitud");
		}
		
	}

	// METODO PARA DAR DE ALTA UNA PERSONA
	 @Transactional
public Personas daralta(Integer numero_documento , boolean alta) throws WebException{
		
		Optional<Personas> modificar = buscarPersonaPorID(numero_documento);
		if(modificar.isPresent()) {
			Personas persona = modificar.get();
			persona.setAlta(true);
			return rpsPersonas.save(persona);
			
		}else {
			throw new WebException("no se ha encontrado la solicitud");
		}
		
	}
	
	
	//METODO PARA BUSCAR TODAS LAS PERSONA POR ID
	
	 @Transactional(readOnly = true)
		public Optional<Personas> buscarPersonaPorID(Integer id){
			Optional<Personas> buscar = rpsPersonas.findById(id);
			return buscar;
		}
	
	
	
	
	
	
	// METODO PARA BUSCAR TODOS LOS DOCUMENTO DE LA PERSONA
	 @Transactional(readOnly = true)
	public List<Personas> buscarTodoLosDocumentos(Integer numero_docuemnto){
		List<Personas> buscarpordocuemento = rpsPersonas.buscarTodoLosDocumentos(numero_docuemnto);
		return buscarpordocuemento;
	}
	
	// METODO PARA VALIDAR SI EL TIPO DE DOCUMENTO ES ARGENTINO O  EXTRANJERO
	 @Transactional
	public void verificarargentino(boolean esargentino) {
		Tipo_documentos documento = (Tipo_documentos) rpsTipodocumento.findAll();
		if(documento.getAbreviatura().equalsIgnoreCase("DNI")) {
			esargentino = true;
		}else {
			esargentino = false;
		}
	}
	
	
	// METODO DE VALIDACION
	private void validar(Integer numero_documento , Tipo_documentos id_tipodocumento,
		    String nombre , String apellido , Date fecha_nacimiento , char genero,
		     String correo_electronico ,Localidades id_localidad , String codigo_postal) throws WebException{
		
		List<Personas> numero_documento1 = buscarTodoLosDocumentos(numero_documento);
		for(Personas numerodocumento : numero_documento1) {
			if(numerodocumento.getNumero_documento() == null || numerodocumento.getNumero_documento().equals(numero_documento1)) {
				throw new WebException("el numero de documento ya existe");
			}
		}
		if(id_tipodocumento == null) {
			throw new WebException("el tipo de documento no puede estar nulo o vacio");
			
		}
		
		if(nombre == null || nombre.isEmpty()) {
			throw new WebException("el nombre no puede ser nulo o vacio");
			
		}
		if(apellido == null || apellido.isEmpty()) {
			throw new WebException("el apellido no puede ser nulo o vacio");
			
		}
		if(fecha_nacimiento == null) {
			throw new WebException("la fecha nacimiento no puede ser nulo");
			
		}
		
		if(genero == 'm' && genero == 'f') {
			
		}else {
			throw new WebException("el genero no puede ser nula o ingrese correctamente");
		}
		
		if(correo_electronico == null || correo_electronico.isEmpty()) {
			throw new WebException("el correo electronico no puede ser nulo o vacio");
			
		}
		if(id_localidad == null) {
			throw new WebException("la localidad no puede nulo o vacio");
		}
		if(codigo_postal == null || codigo_postal.isEmpty()) {
			throw new WebException("el codigo postal no puede ser nulo o vacio");
		}
	}
	

}
