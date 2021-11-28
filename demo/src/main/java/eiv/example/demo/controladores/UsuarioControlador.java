package eiv.example.demo.controladores;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.client.HttpClientErrorException.NotFound;


import eiv.example.demo.entidades.Usuario;
import eiv.example.demo.servicios.UsuarioServicios;

@Controller
@RequestMapping("/usuario")
public class UsuarioControlador {

	@Autowired
	private UsuarioServicios servUsuario;
	
	@GetMapping("/mostrar")
	public List<Usuario> mostrartodo()throws Exception {
		
		try {
			return servUsuario.buscarTodasLosUsuarios();
		}catch(NotFound e) {
			throw new Exception();
		}
		
	
	}
	
	@PostMapping("/registrar")
	public Usuario registrar(Usuario usuario) throws Exception {
		try {
			return servUsuario.registra(usuario);
		}catch(NotFound e) {
			throw new Exception();
		}
		
	}
	
	@PutMapping("/modificar")
	public Usuario modificar(Usuario usuario)throws Exception {
		try {
			return servUsuario.modificar(usuario);
		}catch(NotFound e) {
			throw new Exception();
		}
		
		
		
	}
	
	@DeleteMapping("/eliminar")
	public void eliminar(Usuario usuario) throws Exception {
		
		try {
			servUsuario.eliminar(usuario);
		}catch(NotFound e) {
			throw new Exception();
		}
		
		
	}
	
	
	@PutMapping("/dar-baja")
	public Usuario darbaja(Usuario usuario) throws Exception {
		
		try {
			return servUsuario.darBaja(usuario);
		}catch(NotFound e) {
			throw new Exception();
		}
		
		
	}
	
	@PutMapping("/dar-alta")
	public Usuario daralta(Usuario usuario) throws Exception {
		try {
			return servUsuario.darAlta(usuario);
		}catch(NotFound e) {
			throw new Exception();
		}
		
	}
}
