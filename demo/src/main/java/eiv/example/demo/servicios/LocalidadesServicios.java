package eiv.example.demo.servicios;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import eiv.example.demo.entidades.Localidades;
import eiv.example.demo.entidades.Provincias;

import eiv.example.demo.errores.WebException;
import eiv.example.demo.repositorio.LocalidadesRepositorio;

@Service
public class LocalidadesServicios {
	
	@Autowired
	private LocalidadesRepositorio rpsLocalidades;
	
	@Transactional
	public Localidades registrar(String nombre, Provincias provincia , String codigo_postal) throws WebException {
		
		validar(nombre,provincia,codigo_postal);
		Localidades localidades = new Localidades();
		localidades.setNombre(nombre);
		localidades.setId_provincia(provincia);
		localidades.setCodigo_postal(codigo_postal);
		
		rpsLocalidades.save(localidades);
		return localidades;
	}
	
	@Transactional
	public Localidades modificar(Integer id ,String nombre, Provincias provincia , String codigo_postal) throws WebException {
		validar(nombre,provincia,codigo_postal);
		 Optional<Localidades> modificar = buscarLocalidadesPorID(id);
		 if(modificar.isPresent()) {
			 Localidades localidades = modificar.get();
				localidades.setNombre(nombre);
				localidades.setId_provincia(provincia);
				localidades.setCodigo_postal(codigo_postal);
				
				rpsLocalidades.save(localidades);
				return localidades;
		 }else {
			 throw new WebException("no se ha encontrado la solicitud");
		 }
		
	}
	
	

	 @Transactional(readOnly = true)
		public List<Localidades> buscarTodosLasLocalidades(){
			List<Localidades> localidades = rpsLocalidades.findAll();	
			return  localidades;
		}
	
	 @Transactional(readOnly = true)
		public Optional<Localidades> buscarLocalidadesPorID(Integer id){
			Optional<Localidades> buscar = rpsLocalidades.findById(id);
			return buscar;
		}
	 
	 
	 
	
	private void validar(String nombre , Provincias provincia , String codigo_postal) throws WebException{
		
	if(nombre == null || nombre.isEmpty()) {
		throw new WebException("el nombre no puede estar nulo o vacio");
	}
	if(provincia == null) {
		throw new WebException("la provincia no puede estar nula");
	}
	if(codigo_postal == null || codigo_postal.isEmpty()) {
		throw new WebException("el codigo postal no puede estar nulo o vacio");
	}
	}
	

}
