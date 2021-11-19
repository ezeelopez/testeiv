package eiv.example.demo.entidades;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import javax.persistence.OneToOne;

@Entity
public class Localidades {
@Id
@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id_localidades;
	
	private String nombre;
	
	@OneToOne
	private Provincias id_provincia;
	
	private String codigo_postal;
	
	
	public Localidades() {
		super();
	}
	
	

	public Localidades(Integer id_localidades, String nombre, Provincias id_provincia, String codigo_postal) {
		super();
		this.id_localidades = id_localidades;
		this.nombre = nombre;
		this.id_provincia = id_provincia;
		this.codigo_postal = codigo_postal;
	}

	public int getId_localidades() {
		return id_localidades;
	}

	public void setId_localidades(Integer id_localidades) {
		this.id_localidades = id_localidades;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public Provincias getId_provincia() {
		return id_provincia;
	}

	public void setId_provincia(Provincias id_provincia) {
		this.id_provincia = id_provincia;
	}

	public String getCodigo_postal() {
		return codigo_postal;
	}

	public void setCodigo_postal(String codigo_postal) {
		this.codigo_postal = codigo_postal;
	}
	
	
	
	
	
	
}
