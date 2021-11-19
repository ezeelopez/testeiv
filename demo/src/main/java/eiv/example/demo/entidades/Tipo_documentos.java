package eiv.example.demo.entidades;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
@Entity
public class Tipo_documentos {
@Id
@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id_tipodocumento;
	
	private String nombre;
	
	private String abreviatura;
	
	
	public Tipo_documentos(){
		super();
	}
	
	
	
	public Tipo_documentos(Integer id_tipodocumento, String nombre, String abreviatura, boolean validar_como_cuit) {
		super();
		this.id_tipodocumento = id_tipodocumento;
		this.nombre = nombre;
		this.abreviatura = abreviatura;
		this.validar_como_cuit = validar_como_cuit;
	}

	public Integer getId_tipodocumento() {
		return id_tipodocumento;
	}

	public void setId_tipodocumento(Integer id_tipodocumento) {
		this.id_tipodocumento = id_tipodocumento;
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

	public boolean isValidar_como_cuit() {
		return validar_como_cuit;
	}

	public void setValidar_como_cuit(boolean validar_como_cuit) {
		this.validar_como_cuit = validar_como_cuit;
	}

	private boolean validar_como_cuit;
	
	
	
	
}
