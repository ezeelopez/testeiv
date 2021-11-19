package eiv.example.demo.repositorio;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import eiv.example.demo.entidades.Personas;

public interface PersonasRepositorios extends JpaRepository<Personas, Integer>{
	// QUERY PARA BUSCAR TODAS LAS PERSONAS QUE CONTENGA UN DOCUMENTO EN LA BASE DE DATO
	@Query("SELECT a FROM Personas a WHERE a.numero_documento =:numero_documento")
	public List<Personas> buscarTodoLosDocumentos(@Param("numero_documento") Integer numero_documento);

}
