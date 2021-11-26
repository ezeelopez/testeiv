package eiv.example.demo.repositorio;


import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import eiv.example.demo.entidades.Usuario;

@Repository
public interface UsuarioRepositorios extends JpaRepository<Usuario, Integer>{
	
	
	@Query("SELECT a FROM Usuario a WHERE a.nombreUsuario =:nombreUsuario")
public List<Usuario> buscarnombreusuario(@Param("nombreUsuario") String nombreusuario);


	
}
