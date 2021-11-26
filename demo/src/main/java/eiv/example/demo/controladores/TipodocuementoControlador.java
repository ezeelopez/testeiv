package eiv.example.demo.controladores;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import eiv.example.demo.entidades.Tipodocumento;
import eiv.example.demo.errores.WebException;
import eiv.example.demo.servicios.TipodocumentoServicios;

@RestController
@RequestMapping("/tipodocumentos")
public class TipodocuementoControlador {

	@Autowired
	private TipodocumentoServicios servTipoDocumento;
	
	
	@GetMapping("/mostrar")
	public List<Tipodocumento> mostrarTodoTipoDocumentos() throws WebException{
		return servTipoDocumento.buscarTodosLosDocumentos();
	}
	
	@PostMapping("/registrar")
	public Tipodocumento registrar(Tipodocumento documento) throws WebException {
		return servTipoDocumento.registra(documento);
	}
	
	@PutMapping("/modificar")
	public Tipodocumento modificar(Tipodocumento documento)throws WebException {
	    servTipoDocumento.buscarDocumentosPorID(documento.getIdtipodocumento()); 
		return servTipoDocumento.modificar(documento);
	}
	
	
}
