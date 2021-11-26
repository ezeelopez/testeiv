package eiv.example.demo.entidades;

import java.util.Objects;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
@Entity
public class Tipodocumento {
@Id
@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer idtipodocumento;
	
	private String nombre;
	
	private String abreviatura;
	
	private boolean validarcomocuit;
	
	public Tipodocumento(){
		super();
	}
	
	
	
	public Tipodocumento(Integer idtipodocumento, String nombre, String abreviatura, boolean validarcomocuit) {
		super();
		this.idtipodocumento = idtipodocumento;
		this.nombre = nombre;
		this.abreviatura = abreviatura;
		this.validarcomocuit = validarcomocuit;
	}

	
	
	
	
	@Override
	public int hashCode() {
		return Objects.hash(abreviatura, idtipodocumento, nombre, validarcomocuit);
	}



	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Tipodocumento other = (Tipodocumento) obj;
		return Objects.equals(abreviatura, other.abreviatura) && Objects.equals(idtipodocumento, other.idtipodocumento)
				&& Objects.equals(nombre, other.nombre) && validarcomocuit == other.validarcomocuit;
	}



	public Integer getIdtipodocumento() {
		return idtipodocumento;
	}

	public void setIdtipodocumento(Integer idtipodocumento) {
		this.idtipodocumento = idtipodocumento;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getAbreviatura() {
		return abreviatura;
	}

	public void setAbreviatura(String abreviatura) {
		this.abreviatura = abreviatura;
	}

	public boolean isValidarcomocuit() {
		return validarcomocuit;
	}

	public void setValidarcomocuit(boolean validarcomocuit) {
		this.validarcomocuit = validarcomocuit;
	}


	
	
	
	
}
