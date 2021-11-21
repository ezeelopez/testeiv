package eiv.example.demo.controladores;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import eiv.example.demo.entidades.Personas;
import eiv.example.demo.entidades.Tipo_documentos;
import eiv.example.demo.entidades.Usuarios;
import eiv.example.demo.errores.WebException;
import eiv.example.demo.servicios.UsuarioServicios;

@Controller
@RequestMapping("/usuario")
public class UsuarioControlador {

	@Autowired
	private UsuarioServicios servUsuario;
	
	@GetMapping("/mostrar")
	public List<Usuarios> mostrartodo()throws WebException {
		return servUsuario.buscarTodasLosUsuarios();
	}
	
	@PostMapping("/registrar")
	public Usuarios registrar(@RequestParam Tipo_documentos id_docuemento, @RequestParam Personas numerodocuemtno ,
			@RequestParam String nombreusuario , @RequestParam  String hashed_pwd , @RequestParam String hashed_pwd2) throws WebException {
		return servUsuario.registra(id_docuemento, numerodocuemtno, nombreusuario, hashed_pwd, hashed_pwd2);
	}
	
	@PostMapping("/modificar")
	public Usuarios modificar( @RequestParam Integer id ,@RequestParam Tipo_documentos id_documentos, @RequestParam Personas numero_documento, 
			@RequestParam String nombre_usuario,@RequestParam String hashed_pwd ,@RequestParam String hashed_pwd2)throws WebException {
		return servUsuario.modificar(id, id_documentos, numero_documento, nombre_usuario, hashed_pwd, hashed_pwd2);
	}
	
	
	@PostMapping("/dar-baja")
	public Usuarios darbaja(@RequestParam Integer id , @RequestParam boolean alta) throws WebException {
		return servUsuario.darBaja(id, alta);
	}
	
	@PostMapping("/dar-alta")
	public Usuarios daralta(@RequestParam Integer id , @RequestParam boolean alta) throws WebException {
		return servUsuario.darAlta(id, alta);
	}
}
