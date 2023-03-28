package eiv.example.demo.controladores;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.HttpClientErrorException.NotFound;

import eiv.example.demo.entidades.Localidad;
import eiv.example.demo.entidades.Tipodocumento;

import eiv.example.demo.servicios.TipodocumentoServicios;

@RestController
@RequestMapping("/tipodocumentos")
public class TipodocuementoControlador {

	@Autowired
	private TipodocumentoServicios servTipoDocumento;
	
	
	@PostMapping("/registrar")
	public ResponseEntity<Tipodocumento> registrar(Tipodocumento documento) throws Exception {
        try {

			return new ResponseEntity<Tipodocumento>(servTipoDocumento.registra(documento), HttpStatus.CREATED);
		}catch(Exception e) {
			
			return new ResponseEntity<> (HttpStatus.BAD_REQUEST);
		}
		
	}
	
	@PutMapping("/modificar")
	public ResponseEntity<Tipodocumento> modificar(Tipodocumento documento)throws Exception {
try {
	  servTipoDocumento.buscarDocumentosPorID(documento.getIdtipodocumento()); 
		
		return new ResponseEntity<Tipodocumento>(servTipoDocumento.modificar(documento), HttpStatus.ACCEPTED);
		
		}catch(Exception e) {
			return new ResponseEntity<> (HttpStatus.NOT_FOUND);
		}
	   
	}
	
	@DeleteMapping("/eliminar")
	public ResponseEntity<Tipodocumento> eliminar(Tipodocumento documento) throws Exception {
try {
	     servTipoDocumento.eliminar(documento);
	     return new ResponseEntity<Tipodocumento>(HttpStatus.OK);
	     
		}catch(Exception e) {
			return new ResponseEntity<> (HttpStatus.NOT_FOUND);
		}
		
	}

	@GetMapping("/mostrar")
	public List<Tipodocumento> mostrarTodoTipoDocumentos() throws Exception{
		try {
			
		}catch(Exception e) {
			throw new Exception();
		}
		return servTipoDocumento.buscarTodosLosDocumentos();
	}
	
	
}
