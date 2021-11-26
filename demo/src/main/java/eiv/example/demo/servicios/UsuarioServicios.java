package eiv.example.demo.servicios;


import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


import eiv.example.demo.entidades.Usuario;
import eiv.example.demo.errores.WebException;
import eiv.example.demo.repositorio.UsuarioRepositorios;


@Service
public class UsuarioServicios {

	@Autowired
	private UsuarioRepositorios rpsUsuario;
	
	@Transactional
	public Usuario registra(Usuario usuario) throws WebException{
		
		validar(usuario);
	
		return rpsUsuario.save(usuario);
		
	}
	
	@Transactional
	public Usuario modificar(Usuario usuario)throws WebException {
		
	
		 Optional<Usuario> modificar = buscarUsuarioPorID(usuario.getId());
		 if(modificar.isPresent()) {
			 Usuario usuar = modificar.get();
		;
				usuar.setNombreUsuario(usuario.getNombreUsuario());
				usuar.setHashedPwd(usuario.getHashedPwd());
				usuar.setAlta(true);
				rpsUsuario.save(usuario);
				return usuario;
			 
		 }else {
			 throw new WebException("no se ha encontrado la solicitud");
		 }
		
	}
	
	 @Transactional
		public Usuario darBaja(Usuario usuario) throws WebException{
			
			Optional<Usuario> modificar = buscarUsuarioPorID(usuario.getId());
			if(modificar.isPresent()) {
			  Usuario usuar = modificar.get();
				usuar.setAlta(false);
				
			rpsUsuario.save(usuario);
				return usuario;
				
			}else {
				throw new WebException("no se ha encontrado la solicitud");
			}
			
		}

	 @Transactional
		public Usuario darAlta(Usuario usuario) throws WebException{
			
			Optional<Usuario> modificar = buscarUsuarioPorID(usuario.getId());
			if(modificar.isPresent()) {
			  Usuario usuar = modificar.get();
				usuar.setAlta(true);
				
			rpsUsuario.save(usuario);
				return usuario;
				
			}else {
				throw new WebException("no se ha encontrado la solicitud");
			}
			
		}

	
	
	
	
	 @Transactional(readOnly = true)
		public Optional<Usuario> buscarUsuarioPorID(Integer id){
			Optional<Usuario> buscar = rpsUsuario.findById(id);
			return buscar;
		}
	
	 
	 @Transactional
	 public List<Usuario> buscarTodosLosNombreUsuarios(String nombreusuario){
		 List<Usuario> buscar = rpsUsuario.buscarnombreusuario(nombreusuario);
		 return buscar;
	 } 
	 
	 
	 @Transactional(readOnly = true)
		public List<Usuario> buscarTodasLosUsuarios(){
			List<Usuario> buscar = rpsUsuario.findAll();	
			return buscar;
		}
	
	
	private void validar(Usuario usuario) throws WebException {
		if(usuario.getDocumento() == null) {
			throw new WebException("no puede ser nulo");
		}
		if(usuario.getNumeroDocumento() == null) {
			throw new WebException("no puede ser nulo");	
		}
		
		List<Usuario> nombre = buscarTodosLosNombreUsuarios(usuario.getNombreUsuario());
		
		for (Usuario nombreusuario1 : nombre) {
			if(nombreusuario1.getNombreUsuario() == null || nombreusuario1.getNombreUsuario().equals(nombre)) {
				throw new WebException("este nombre de usuario ya existe");
			}
		}
		
		if(usuario.getHashedPwd() == null || usuario.getHashedPwd().isEmpty()) {
			throw new WebException("no puese ser nulo o vacio");
		}
		if(!usuario.getHashedPwd().equals(usuario.getHashedPwd())) {
			throw new WebException("la clave no coincide");
		}
	} 
	
}
