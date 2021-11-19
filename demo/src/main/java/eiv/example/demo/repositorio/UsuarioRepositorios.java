package eiv.example.demo.repositorio;


import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.stereotype.Repository;


import eiv.example.demo.entidades.Usuarios;

@Repository
public interface UsuarioRepositorios extends JpaRepository<Usuarios, Integer>{


	
}
