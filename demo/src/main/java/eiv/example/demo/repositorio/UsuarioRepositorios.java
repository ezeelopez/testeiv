package eiv.example.demo.repositorio;


import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import eiv.example.demo.entidades.Usuarios;

@Repository
public interface UsuarioRepositorios extends JpaRepository<Usuarios, Integer>{
	
	@Query("SELECT a FROM Usuarios a WHERE a.nombre_usuario =:nombre_usuario")
public List<Usuarios> buscarnombreusuario(@Param("nombre_usuario") String nombre_usuario);


	
}
