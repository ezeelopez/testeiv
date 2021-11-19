package eiv.example.demo.repositorio;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import eiv.example.demo.entidades.Tipo_documentos;

@Repository
public interface Tipo_documentoRepositorios extends JpaRepository<Tipo_documentos, Integer>{

}
