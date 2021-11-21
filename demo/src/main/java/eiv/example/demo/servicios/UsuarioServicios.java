package eiv.example.demo.servicios;

import java.util.Iterator;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import eiv.example.demo.entidades.Personas;
import eiv.example.demo.entidades.Tipo_documentos;
import eiv.example.demo.entidades.Usuarios;
import eiv.example.demo.errores.WebException;
import eiv.example.demo.repositorio.UsuarioRepositorios;


@Service
public class UsuarioServicios {

	@Autowired
	private UsuarioRepositorios rpsUsuario;
	
	@Transactional
	public Usuarios registra(Tipo_documentos id_documentos, Personas numero_documento, 
			String nombre_usuario, String hashed_pwd , String hashed_pwd2) throws WebException{
		
		validar(id_documentos, numero_documento, 
				nombre_usuario,hashed_pwd , hashed_pwd2);
		
		Usuarios usuario = new Usuarios();
		usuario.setId_documento(id_documentos);
		usuario.setNumero_documento(numero_documento);
		usuario.setNombre_usuario(nombre_usuario);
		usuario.setHashed_pwd(hashed_pwd);
		usuario.setAlta(true);
		rpsUsuario.save(usuario);
		return usuario;
		
	}
	
	@Transactional
	public Usuarios modificar( Integer id ,Tipo_documentos id_documentos, Personas numero_documento, 
			String nombre_usuario, String hashed_pwd , String hashed_pwd2)throws WebException {
		
		validar(id_documentos, numero_documento, 
				nombre_usuario,hashed_pwd , hashed_pwd2);
		
		 Optional<Usuarios> modificar = buscarUsuarioPorID(id);
		 if(modificar.isPresent()) {
			 Usuarios usuario = modificar.get();
		;
				usuario.setNombre_usuario(nombre_usuario);
				usuario.setHashed_pwd(hashed_pwd);
				usuario.setAlta(true);
				rpsUsuario.save(usuario);
				return usuario;
			 
		 }else {
			 throw new WebException("no se ha encontrado la solicitud");
		 }
		
	}
	
	 @Transactional
		public Usuarios darBaja(Integer id , boolean alta) throws WebException{
			
			Optional<Usuarios> modificar = buscarUsuarioPorID(id);
			if(modificar.isPresent()) {
			  Usuarios usuario = modificar.get();
				usuario.setAlta(false);
				
			rpsUsuario.save(usuario);
				return usuario;
				
			}else {
				throw new WebException("no se ha encontrado la solicitud");
			}
			
		}

	 @Transactional
		public Usuarios darAlta(Integer id , boolean alta) throws WebException{
			
			Optional<Usuarios> modificar = buscarUsuarioPorID(id);
			if(modificar.isPresent()) {
			  Usuarios usuario = modificar.get();
				usuario.setAlta(true);
				
			rpsUsuario.save(usuario);
				return usuario;
				
			}else {
				throw new WebException("no se ha encontrado la solicitud");
			}
			
		}

	
	
	
	
	 @Transactional(readOnly = true)
		public Optional<Usuarios> buscarUsuarioPorID(Integer id){
			Optional<Usuarios> buscar = rpsUsuario.findById(id);
			return buscar;
		}
	
	 @Transactional
	 public List<Usuarios> buscarTodosLosNombreUsuarios(String nombre_usuario){
		 List<Usuarios> buscar = rpsUsuario.buscarnombreusuario(nombre_usuario);
		 return buscar;
	 }
	 
	 
	 @Transactional(readOnly = true)
		public List<Usuarios> buscarTodasLosUsuarios(){
			List<Usuarios> buscar = rpsUsuario.findAll();	
			return buscar;
		}
	
	
	private void validar(Tipo_documentos id_documentos, Personas numero_documento, 
			String nombre_usuario, String hashed_pwd , String hashed_pwd2) throws WebException {
		if(id_documentos == null) {
			throw new WebException("no puede ser nulo");
		}
		if(numero_documento == null) {
			throw new WebException("no puede ser nulo");	
		}
		
		List<Usuarios> nombreusuario = buscarTodosLosNombreUsuarios(nombre_usuario);
		
		for (Usuarios nombreusuario1 : nombreusuario) {
			if(nombreusuario1.getNombre_usuario() == null || nombreusuario1.getNombre_usuario().equals(nombreusuario)) {
				throw new WebException("este nombre de usuario ya existe");
			}
		}
		
		if(hashed_pwd == null || hashed_pwd.isEmpty()) {
			throw new WebException("no puese ser nulo o vacio");
		}
		if(!hashed_pwd2.equals(hashed_pwd)) {
			throw new WebException("la clave no coincide");
		}
	}
	
}
