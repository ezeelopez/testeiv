package eiv.example.demo.controladores;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import eiv.example.demo.entidades.Persona;
import eiv.example.demo.entidades.Tipodocumento;
import eiv.example.demo.entidades.Usuario;
import eiv.example.demo.errores.WebException;
import eiv.example.demo.servicios.UsuarioServicios;

@Controller
@RequestMapping("/usuario")
public class UsuarioControlador {

	@Autowired
	private UsuarioServicios servUsuario;
	
	@GetMapping("/mostrar")
	public List<Usuario> mostrartodo()throws WebException {
		return servUsuario.buscarTodasLosUsuarios();
	}
	
	@PostMapping("/registrar")
	public Usuario registrar(Usuario usuario) throws WebException {
		return servUsuario.registra(usuario);
	}
	
	@PutMapping("/modificar")
	public Usuario modificar(Usuario usuario)throws WebException {
		return servUsuario.modificar(usuario);
	}
	
	@DeleteMapping("/eliminar")
	public void eliminar(Usuario usuario) throws Exception {
		servUsuario.eliminar(usuario);
	}
	
	
	
	@PutMapping("/dar-baja")
	public Usuario darbaja(Usuario usuario) throws WebException {
		return servUsuario.darBaja(usuario);
	}
	
	@PutMapping("/dar-alta")
	public Usuario daralta(Usuario usuario) throws WebException {
		return servUsuario.darAlta(usuario);
	}
}
