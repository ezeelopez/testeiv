package eiv.example.demo.entidades;

import java.util.Objects;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import javax.persistence.OneToOne;

@Entity
public class Localidad {
@Id
@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer idlocalidad;
	
	private String nombre;
	
	@OneToOne
	private Provincia provincia;
	
	private String codigopostal;
	
	
	public Localidad() {
		super();
	}
	
	

	public Localidad(Integer idlocalidad, String nombre, Provincia provincia, String codigopostal) {
		super();
		this.idlocalidad = idlocalidad;
		this.nombre = nombre;
		this.provincia = provincia;
		this.codigopostal = codigopostal;
	}

	
	
	
	
	
	@Override
	public int hashCode() {
		return Objects.hash(codigopostal, idlocalidad, nombre, provincia);
	}



	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Localidad other = (Localidad) obj;
		return Objects.equals(codigopostal, other.codigopostal) && Objects.equals(idlocalidad, other.idlocalidad)
				&& Objects.equals(nombre, other.nombre) && Objects.equals(provincia, other.provincia);
	}



	public int getIdlocalidad() {
		return idlocalidad;
	}

	public void setIdlocalidades(Integer idlocalidades) {
		this.idlocalidad = idlocalidades;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public Provincia getProvincia() {
		return provincia;
	}

	public void setProvincia(Provincia provincia) {
		this.provincia = provincia;
	}

	public String getCodigopostal() {
		return codigopostal;
	}

	public void setCodigopostal(String codigopostal) {
		this.codigopostal = codigopostal;
	}
	
	
	
	
	
	
}
