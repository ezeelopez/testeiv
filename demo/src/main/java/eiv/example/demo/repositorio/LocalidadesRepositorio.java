package eiv.example.demo.repositorio;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import eiv.example.demo.entidades.Localidades;


@Repository
public interface LocalidadesRepositorio extends JpaRepository<Localidades, Integer> {


	
	
}
