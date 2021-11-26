package eiv.example.demo.repositorio;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import eiv.example.demo.entidades.Tipodocumento;

@Repository
public interface TipodocumentoRepositorios extends JpaRepository<Tipodocumento, Integer>{

}
