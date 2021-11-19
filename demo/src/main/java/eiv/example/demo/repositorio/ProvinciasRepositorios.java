package eiv.example.demo.repositorio;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import eiv.example.demo.entidades.Provincias;

@Repository
public interface ProvinciasRepositorios extends JpaRepository<Provincias, Integer> {

}
