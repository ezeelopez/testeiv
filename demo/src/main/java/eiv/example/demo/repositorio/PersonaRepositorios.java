package eiv.example.demo.repositorio;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import eiv.example.demo.entidades.Persona;

@Repository
public interface PersonaRepositorios extends JpaRepository<Persona, Integer>{
	// QUERY PARA BUSCAR TODAS LAS PERSONAS QUE CONTENGA UN DOCUMENTO EN LA BASE DE DATO
	
	
	@Query("SELECT a FROM Persona a WHERE a.numeroDocumento =:numeroDocumento")
	public List<Persona> buscarTodoLosDocumentos(@Param("numeroDocumento") Integer numerodocumento);
     
}
