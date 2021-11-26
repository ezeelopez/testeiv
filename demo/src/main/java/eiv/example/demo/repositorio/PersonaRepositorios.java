package eiv.example.demo.repositorio;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import eiv.example.demo.entidades.Persona;

public interface PersonaRepositorios extends JpaRepository<Persona, Integer>{
	// QUERY PARA BUSCAR TODAS LAS PERSONAS QUE CONTENGA UN DOCUMENTO EN LA BASE DE DATO
	
	/*
	@Query("SELECT a FROM Personas a WHERE a.numerodocumento =:numerodocumento")
	public List<Persona> buscarTodoLosDocumentos(@Param("numerodocumento") Integer numero_documento);
     */
}
