package eiv.example.demo.servicios;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import eiv.example.demo.entidades.Tipo_documentos;
import eiv.example.demo.errores.WebException;
import eiv.example.demo.repositorio.Tipo_documentoRepositorios;

@Service
public class Tipo_documentosServicios {

	@Autowired
	private Tipo_documentoRepositorios rpstipodocumento;
	
	@Transactional
	public Tipo_documentos registra(String nombre , String abreviatura, boolean cuit) throws WebException {
		validar(nombre,abreviatura,cuit);
		 Tipo_documentos documento = new Tipo_documentos();
		 
		 documento.setNombre(nombre);
		 documento.setAbreviatura(abreviatura);
		 documento.setValidar_como_cuit(cuit);
		 
	    rpstipodocumento.save(documento);
		 return documento;
		
	}
	
	@Transactional
	public Tipo_documentos modificar(Integer id,  String nombre , String abreviatura, boolean cuit) throws WebException{
		validar(nombre,abreviatura,cuit);
		
		Optional<Tipo_documentos> modificar = buscarDocumentosPorID(id);
		   if(modificar.isPresent()) {
			   Tipo_documentos documento = modificar.get();
				 documento.setNombre(nombre);
				 documento.setAbreviatura(abreviatura);
				 documento.setValidar_como_cuit(cuit);
				 
			    rpstipodocumento.save(documento);
				 return documento;
		   }else {
			   throw new WebException("no se ha encontrado la solicitud");
		   }
		
	}
	

	 @Transactional(readOnly = true)
		public List<Tipo_documentos> buscarTodosLosDocumentos(){
			List<Tipo_documentos> docuementos = rpstipodocumento.findAll();	
			return  docuementos;
		}
	
		 @Transactional(readOnly = true)
			public Optional<Tipo_documentos> buscarDocumentosPorID(Integer id){
				Optional<Tipo_documentos> buscar = rpstipodocumento.findById(id);
				return buscar;
			}
		
	
	
    private void validar(String nombre , String abreviatura , boolean verificarcuit) throws WebException{
    	if(nombre == null || nombre.isEmpty()) {
    		throw new WebException("el nombre no puede ser nulo o vacio");
    	}if(abreviatura == null || abreviatura.isEmpty() && abreviatura.length() <= 5) {
    		throw new WebException("la abreviatura no puede estar nulo o vacio");
    	}
    	if(abreviatura.equalsIgnoreCase("DNI")) {
    		verificarcuit = true;
    	}else {
    		verificarcuit = false;
    	}
    }
	
}
