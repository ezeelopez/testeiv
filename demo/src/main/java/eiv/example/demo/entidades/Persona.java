package eiv.example.demo.entidades;

import java.time.LocalDate;

import javax.persistence.Column;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;


@Entity
@IdClass(value = PersonaPK.class)
public class Persona {
	
	
	@Id
	@Column(name = "NUMERO_DOCUMENTO")
	private Integer numeroDocumento;
	
	@Id
	@JoinColumn(name = "ID_TIPODOCUMENTO")
   private Tipodocumento documento;

	
	
	@Column(name = "NOMBRE")
	private String nombre;
	
	@Column(name = "APELLIDO")
	private String apellido;
	
	@Column(name = "FECHA_NACIMIENTO")
	private LocalDate fechaNacimineto;
	
	@Column(name = "GENERO")
	private char genero;
	
	@Column(name = "ES_ARGENTINO")
	private boolean esArgentino;
	
	private boolean alta;
	
	@Column(name = "CORREO_ELECTRONICO")
	private String correoElectronico;
	
	@OneToOne
	@JoinColumn(name = "ID_LOCALIDAD")
	private Localidad localidad;
	
	@Column(name = "CODIGO_POSTAL")
	private String codigoPostal;
	
	
	
	public Persona() {
		super();
	}


	public Persona( Integer numeroDocumento, String nombre, String apellido, Tipodocumento documento,
			LocalDate fechaNacimineto, char genero, boolean esArgentino, boolean alta, String correoElectronico,
			Localidad localidad, String codigoPostal) {
		super();
		this.numeroDocumento = numeroDocumento;
	    this.documento = documento;
		this.nombre = nombre;
		this.apellido = apellido;
		this.fechaNacimineto = fechaNacimineto;
		this.genero = genero;
		this.esArgentino = esArgentino;
		this.alta = alta;
		this.correoElectronico = correoElectronico;
		this.localidad = localidad;
		this.codigoPostal = codigoPostal;
	}


	
	



	public Integer getNumeroDocumento() {
		return numeroDocumento;
	}


	public void setNumeroDocumento(Integer numeroDocumento) {
		this.numeroDocumento = numeroDocumento;
	}




	public String getNombre() {
		return nombre;
	}



	public void setNombre(String nombre) {
		this.nombre = nombre;
	}



	public String getApellido() {
		return apellido;
	}



	public void setApellido(String apellido) {
		this.apellido = apellido;
	}



	public LocalDate getFechaNacimineto() {
		return fechaNacimineto;
	}



	public void setFechaNacimineto(LocalDate fechaNacimineto) {
		this.fechaNacimineto = fechaNacimineto;
	}



	public char getGenero() {
		return genero;
	}



	public void setGenero(char genero) {
		this.genero = genero;
	}



	public boolean isEsArgentino() {
		return esArgentino;
	}



	public void setEsArgentino(boolean esArgentino) {
		this.esArgentino = esArgentino;
	}



	public boolean isAlta() {
		return alta;
	}



	public void setAlta(boolean alta) {
		this.alta = alta;
	}



	public String getCorreoElectronico() {
		return correoElectronico;
	}



	public void setCorreoElectronico(String correoElectronico) {
		this.correoElectronico = correoElectronico;
	}



	public Localidad getLocalidad() {
		return localidad;
	}



	public void setLocalidad(Localidad localidad) {
		this.localidad = localidad;
	}



	public String getCodigoPostal() {
		return codigoPostal;
	}



	public void setCodigoPostal(String codigoPostal) {
		this.codigoPostal = codigoPostal;
	}


	public Tipodocumento getDocumento() {
		return documento;
	}


	public void setDocumento(Tipodocumento documento) {
		this.documento = documento;
	}




	
	
	
	


}