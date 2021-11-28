package eiv.example.demo.entidades;

import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Provincia {
@Id
@GeneratedValue(strategy = GenerationType.IDENTITY)
   @Column(name = "ID_PROVINCIA")
	private Integer idProvincia;
	
    @Column(name = "NOMBRE")
	private String nombre;
    
    @Column(name = "REGION")
	private String region;

	
	public Provincia() {
		super();
	}

	

	public Provincia(Integer idProvincia, String nombre, String region) {
		super();
		this.idProvincia = idProvincia;
		this.nombre = nombre;
		this.region = region;
	}





	@Override
	public int hashCode() {
		return Objects.hash(idProvincia, nombre, region);
	}



	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Provincia other = (Provincia) obj;
		return Objects.equals(idProvincia, other.idProvincia) && Objects.equals(nombre, other.nombre)
				&& Objects.equals(region, other.region);
	}



	public Integer getIdProvincia() {
		return idProvincia;
	}


	public void setIdProvincia(Integer idProvincia) {
		this.idProvincia = idProvincia;
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