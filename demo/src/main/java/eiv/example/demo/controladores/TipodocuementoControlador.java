package eiv.example.demo.controladores;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.HttpClientErrorException.NotFound;

import eiv.example.demo.entidades.Tipodocumento;

import eiv.example.demo.servicios.TipodocumentoServicios;

@RestController
@RequestMapping("/tipodocumentos")
public class TipodocuementoControlador {

	@Autowired
	private TipodocumentoServicios servTipoDocumento;
	
	
	@GetMapping("/mostrar")
	public List<Tipodocumento> mostrarTodoTipoDocumentos() throws Exception{
		try {
			
		}catch(NotFound e) {
			throw new Exception();
		}
		return servTipoDocumento.buscarTodosLosDocumentos();
	}
	
	@PostMapping("/registrar")
	public Tipodocumento registrar(Tipodocumento documento) throws Exception {
        try {
	        return servTipoDocumento.registra(documento);
		}catch(NotFound e) {
			throw new Exception();
		}
		
	}
	
	@PutMapping("/modificar")
	public Tipodocumento modificar(Tipodocumento documento)throws Exception {
try {
	  servTipoDocumento.buscarDocumentosPorID(documento.getIdtipodocumento()); 
		return servTipoDocumento.modificar(documento);
		}catch(NotFound e) {
			throw new Exception();
		}
	   
	}
	
	@DeleteMapping("/eliminar")
	public void eliminar(Tipodocumento documento) throws Exception {
try {
	     servTipoDocumento.eliminar(documento);
		}catch(NotFound e) {
			throw new Exception();
		}
		
	}
}
