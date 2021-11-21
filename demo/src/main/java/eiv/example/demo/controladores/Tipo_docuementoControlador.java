package eiv.example.demo.controladores;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import eiv.example.demo.entidades.Tipo_documentos;
import eiv.example.demo.errores.WebException;
import eiv.example.demo.servicios.Tipo_documentosServicios;

@Controller
@RequestMapping("/tipo-documentos")
public class Tipo_docuementoControlador {

	@Autowired
	private Tipo_documentosServicios servTipoDocumento;
	
	
	@GetMapping("/mostrar")
	public List<Tipo_documentos> mostrarTodoTipoDocumentos() throws WebException{
		return servTipoDocumento.buscarTodosLosDocumentos();
	}
	
	@PostMapping("/registrar")
	public Tipo_documentos registrar(@RequestParam String nombre ,
	@RequestParam String abreviatura , @RequestParam boolean cuit) throws WebException {
		return servTipoDocumento.registra(nombre, abreviatura, cuit);
	}
	
	@PostMapping("/modificar")
	public Tipo_documentos modificar(@RequestParam Integer id,@RequestParam String nombre ,
			@RequestParam String abreviatura , @RequestParam boolean cuit)throws WebException {
		return servTipoDocumento.modificar(id, nombre, abreviatura, cuit);
	}
	
	
}
