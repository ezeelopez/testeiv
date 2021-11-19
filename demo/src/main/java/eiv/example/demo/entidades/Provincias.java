package eiv.example.demo.entidades;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Provincias {
@Id
@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id_provincia;
	
	private String nombre;
	
	private String region;

	
	public Provincias() {
		super();
	}
	
	
	
	public Provincias(Integer id_provincia, String nombre, String region) {
		super();
		this.id_provincia = id_provincia;
		this.nombre = nombre;
		this.region = region;
	}

	public int getId_provincia() {
		return id_provincia;
	}

	public void setId_provincia(Integer id_provincia) {
		this.id_provincia = id_provincia;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getRegion() {
		return region;
	}

	public void setRegion(String region) {
		this.region = region;
	}
	
	
	
	
	
}
