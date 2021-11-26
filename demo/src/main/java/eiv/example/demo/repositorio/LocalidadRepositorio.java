package eiv.example.demo.repositorio;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import eiv.example.demo.entidades.Localidad;


@Repository
public interface LocalidadRepositorio extends JpaRepository<Localidad, Integer> {


	
	
}
