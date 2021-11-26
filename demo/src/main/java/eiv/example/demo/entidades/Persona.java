package eiv.example.demo.entidades;

import java.time.LocalDate;
import java.util.Objects;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToOne;


@Entity
public class Persona {

	@Id
	private Integer numeroDocumento;
	
	@OneToOne
	private Tipodocumento tipodocumento;
	
	private String nombre;
	
	private String apellido;
	
	
	private LocalDate fechaNacimineto;
	
	private char genero;
	
	private boolean esArgentino;
	
	private boolean alta;
	
	private String correoElectronico;
	
	@OneToOne
	private Localidad localidad;
	
	private String codigoPostal;
	
	
	
	public Persona() {
		super();
	}


	
	public Persona(Integer numeroDocumento, Tipodocumento tipodocumento, String nombre, String apellido,
			LocalDate fechaNacimineto, char genero, boolean esArgentino, boolean alta, String correoElectronico,
			Localidad localidad, String codigoPostal) {
		super();
		this.numeroDocumento = numeroDocumento;
		this.tipodocumento = tipodocumento;
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




	@Override
	public int hashCode() {
		return Objects.hash(alta, apellido, codigoPostal, correoElectronico, esArgentino, fechaNacimineto, genero,
				localidad, nombre, numeroDocumento, tipodocumento);
	}



	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Persona other = (Persona) obj;
		return alta == other.alta && Objects.equals(apellido, other.apellido)
				&& Objects.equals(codigoPostal, other.codigoPostal)
				&& Objects.equals(correoElectronico, other.correoElectronico) && esArgentino == other.esArgentino
				&& Objects.equals(fechaNacimineto, other.fechaNacimineto) && genero == other.genero
				&& Objects.equals(localidad, other.localidad) && Objects.equals(nombre, other.nombre)
				&& Objects.equals(numeroDocumento, other.numeroDocumento)
				&& Objects.equals(tipodocumento, other.tipodocumento);
	}





	public Integer getNumeroDocumento() {
		return numeroDocumento;
	}



	public void setNumeroDocumento(Integer numeroDocumento) {
		this.numeroDocumento = numeroDocumento;
	}



	public Tipodocumento getTipodocumento() {
		return tipodocumento;
	}



	public void setTipodocumento(Tipodocumento tipodocumento) {
		this.tipodocumento = tipodocumento;
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
	
	
	
	


}