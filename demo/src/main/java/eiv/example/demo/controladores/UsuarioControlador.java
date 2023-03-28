package eiv.example.demo.controladores;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.client.HttpClientErrorException.NotFound;

import eiv.example.demo.entidades.Localidad;
import eiv.example.demo.entidades.Usuario;
import eiv.example.demo.servicios.UsuarioServicios;

@Controller
@RequestMapping("/usuario")
public class UsuarioControlador {

	@Autowired
	private UsuarioServicios servUsuario;
	


	@PostMapping("/registrar")
	public ResponseEntity<Usuario> registrar(Usuario usuario) throws Exception {
		try {

			return new ResponseEntity<Usuario>(servUsuario.registra(usuario), HttpStatus.CREATED);
			
		}catch(Exception e) {
			
			return new ResponseEntity<> (HttpStatus.BAD_REQUEST);
		}
		
	}
	
	@PutMapping("/modificar")
	public ResponseEntity<Usuario> modificar(Usuario usuario)throws Exception {
		try {
		
			servUsuario.buscarUsuarioPorID(usuario.getId());
			return new ResponseEntity<Usuario>(servUsuario.modificar(usuario), HttpStatus.ACCEPTED);
			
		}catch(Exception e) {
		
			return new ResponseEntity<> (HttpStatus.NOT_FOUND);
		}
		
		
		
	}
	
	@DeleteMapping("/eliminar")
	public ResponseEntity<Usuario> eliminar(Usuario usuario) throws Exception {
		
		try {
			servUsuario.eliminar(usuario);
			 return new ResponseEntity<Usuario>(HttpStatus.OK);
			
		}catch(Exception e) {
			return new ResponseEntity<> (HttpStatus.NOT_FOUND);
		}
		
		
	}
	
	
	@PutMapping("/dar-baja")
	public ResponseEntity<Usuario> darbaja(Usuario usuario) throws Exception {
		
		try {
			servUsuario.buscarUsuarioPorID(usuario.getId());
			return new ResponseEntity<Usuario>(servUsuario.darBaja(usuario), HttpStatus.ACCEPTED);
			
		}catch(Exception e) {
			return new ResponseEntity<> (HttpStatus.NOT_FOUND);
		}
		
		
	}
	
	@PutMapping("/dar-alta")
	public ResponseEntity<Usuario> daralta(Usuario usuario) throws Exception {
		try {
			servUsuario.buscarUsuarioPorID(usuario.getId());
			return new ResponseEntity<Usuario>(servUsuario.darAlta(usuario), HttpStatus.ACCEPTED);
		}catch(Exception e) {
		
			return new ResponseEntity<> (HttpStatus.NOT_FOUND);
			
		}
		
	}
	
	@GetMapping("/mostrar")
	public List<Usuario> mostrartodo()throws Exception {
		
		try {
			return servUsuario.buscarTodasLosUsuarios();
		}catch(Exception e) {
			throw new Exception();
		}
	}
		
}
