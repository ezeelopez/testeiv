package eiv.example.demo.entidades;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
public class Personas {

	@Id
	private Integer numero_documento;
	
	@OneToOne
	private Tipo_documentos id_tipodocumento;
	
	private String nombre;
	
	private String apellido;
	
	@Temporal(TemporalType.DATE)
	private Date fecha_nacimineto;
	
	private char genero;
	
	private boolean es_argentino;
	
	private boolean alta;
	
	private String correo_electronico;
	
	@OneToOne
	private Localidades id_localidad;
	
	private String codigo_postal;
	
	
	
	public Personas() {
		super();
	}
	
	




	public Personas(Integer numero_documento, Tipo_documentos id_tipodocumento, String nombre,String apellido,
			Date fecha_nacimineto, char genero, boolean es_argentino, boolean alta, String correo_electronico,
			Localidades id_localidad, String codigo_postal) {
		super();
		this.numero_documento = numero_documento;
		this.id_tipodocumento = id_tipodocumento;
		this.nombre = nombre;
		this.apellido = apellido;
		this.fecha_nacimineto = fecha_nacimineto;
		this.genero = genero;
		this.es_argentino = es_argentino;
		this.alta = alta;
		this.correo_electronico = correo_electronico;
		this.id_localidad = id_localidad;
		this.codigo_postal = codigo_postal;
	}

	public Integer getNumero_documento() {
		return numero_documento;
	}

	public void setNumero_documento(Integer numero_documento) {
		this.numero_documento = numero_documento;
	}

	public Tipo_documentos getId_tipodocumento() {
		return id_tipodocumento;
	}

	public void setId_tipodocumento(Tipo_documentos id_tipodocumento) {
		this.id_tipodocumento = id_tipodocumento;
	}

	public String getNombre() {
		return nombre;
	}

	public String getApellido() {
		return apellido;
	}

	public void setApellido(String apellido) {
		this.apellido = apellido;
	}

	public void setNombre(String nombre_apellido) {
		this.nombre = nombre_apellido;
	}

	public Date getFecha_nacimineto() {
		return fecha_nacimineto;
	}

	public void setFecha_nacimineto(Date fecha_nacimineto) {
		this.fecha_nacimineto = fecha_nacimineto;
	}

	public char getGenero() {
		return genero;
	}

	public void setGenero(char genero) {
		this.genero = genero;
	}

	public boolean isEs_argentino() {
		return es_argentino;
	}

	public void setEs_argentino(boolean es_argentino) {
		this.es_argentino = es_argentino;
	}

	public String getCorreo_electronico() {
		return correo_electronico;
	}

	public void setCorreo_electronico(String correo_electronico) {
		this.correo_electronico = correo_electronico;
	}

	public Localidades getId_localidad() {
		return id_localidad;
	}

	public void setId_localidad(Localidades id_localidad) {
		this.id_localidad = id_localidad;
	}

	public String getCodigo_postal() {
		return codigo_postal;
	}

	public void setCodigo_postal(String codigo_postal) {
		this.codigo_postal = codigo_postal;
	}
	

	public boolean isAlta() {
		return alta;
	}

	public void setAlta(boolean alta) {
		this.alta = alta;
	}
	
	
	
	
}
