package eiv.example.demo.servicios;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import eiv.example.demo.entidades.Tipodocumento;
import eiv.example.demo.errores.WebException;
import eiv.example.demo.repositorio.TipodocumentoRepositorios;

@Service
public class TipodocumentoServicios {

	@Autowired
	private TipodocumentoRepositorios rpstipodocumento;
	
	@Transactional
	public Tipodocumento registra(Tipodocumento documento) throws WebException {
	    validar(documento);
	    rpstipodocumento.save(documento);
		 return documento;
	}
	
	@Transactional
	public Tipodocumento modificar(Tipodocumento documento) throws WebException{
           
		validar(documento);
		
		Optional<Tipodocumento> modificar = buscarDocumentosPorID(documento.getIdtipodocumento());
		   if(modificar.isPresent()) {
			   Tipodocumento document = modificar.get();
				 document.setNombre(documento.getNombre());
				 document.setAbreviatura(documento.getAbreviatura());
				 document.setValidarcomocuit(documento.isValidarcomocuit());
				 
			    rpstipodocumento.save(documento);
				 return documento;
		   }else {
			   throw new WebException("no se ha encontrado la solicitud");
		   }
		
	}
	
	public void eliminar(Tipodocumento documento) throws Exception {
		rpstipodocumento.deleteById(documento.getIdtipodocumento());
	}
	

	 @Transactional(readOnly = true)
		public List<Tipodocumento> buscarTodosLosDocumentos(){
			List<Tipodocumento> docuementos = rpstipodocumento.findAll();	
			return  docuementos;
		}
	
		 @Transactional(readOnly = true)
			public Optional<Tipodocumento> buscarDocumentosPorID(Integer id){
				Optional<Tipodocumento> buscar = rpstipodocumento.findById(id);
				return buscar;
			}
		
	
	
    private void validar(Tipodocumento documento) throws WebException{
    	if(documento.getNombre() == null || documento.getNombre().isEmpty()) {
    		throw new WebException("el nombre no puede ser nulo o vacio");
    	}if(documento.getAbreviatura() == null || documento.getAbreviatura().isEmpty() && documento.getAbreviatura().length() <= 5) {
    		throw new WebException("la abreviatura no puede estar nulo o vacio");
    	}
    	if(documento.getAbreviatura().equalsIgnoreCase("DNI")) {
    		documento.setValidarcomocuit(true); 
    	}else {
    		documento.setValidarcomocuit(false); 
    	}
    }
	
}
