package eiv.example.demo.repositorio;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import eiv.example.demo.entidades.Provincia;

@Repository
public interface ProvinciaRepositorios extends JpaRepository<Provincia, Integer> {

}
