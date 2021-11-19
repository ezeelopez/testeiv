package eiv.example.demo.entidades;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;

@Entity
public class Usuarios {
@Id
@GeneratedValue(strategy = GenerationType.IDENTITY)
private Integer id;

   @OneToOne
    private Tipo_documentos id_documento;
	
    @OneToOne
	private Personas numero_documento;

	private String nombre_usuario;
	
	private boolean alta;
	
	private String hashed_pwd;
	
	
	
	public Usuarios() {
		super();
	}
	 

	public Integer getId() {
		return id;
	}


	public void setId(Integer id) {
		this.id = id;
	}


	public Usuarios(Integer id ,Tipo_documentos id_documento, Personas numero_documento, String nombre_usuario, boolean alta, String hashed_pwd) {
		super();
		this.id = id;
		this.id_documento = id_documento;
		this.numero_documento = numero_documento;
		this.nombre_usuario = nombre_usuario;
		this.alta = alta;
		this.hashed_pwd = hashed_pwd;
	}

	public Tipo_documentos getId_documento() {
		return id_documento;
	}

	public void setId_documento(Tipo_documentos id_documento) {
		this.id_documento = id_documento;
	}

	public Personas getNumero_documento() {
		return numero_documento;
	}

	public void setNumero_documento(Personas numero_documento) {
		this.numero_documento = numero_documento;
	}

	public String getNombre_usuario() {
		return nombre_usuario;
	}

	public void setNombre_usuario(String nombre_usuario) {
		this.nombre_usuario = nombre_usuario;
	}

	public String getHashed_pwd() {
		return hashed_pwd;
	}

	public void setHashed_pwd(String hashed_pwd) {
		this.hashed_pwd = hashed_pwd;
	}

	public boolean isAlta() {
		return alta;
	}

	public void setAlta(boolean alta) {
		this.alta = alta;
	}


	
}
