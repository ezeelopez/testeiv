package eiv.example.demo.entidades;

import java.util.Objects;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;

@Entity
public class Usuario {
@Id
@GeneratedValue(strategy = GenerationType.IDENTITY)
private Integer id;

   @OneToOne
    private Tipodocumento documento;
	

	@OneToOne
	private Persona numeroDocumento;

	private String nombreUsuario;
	
	private boolean alta;
	
	private String hashedPwd;
	
	
   
	public Usuario() {
		super();
	}
	 
	
	
   
    public Usuario(Integer id, Tipodocumento documento, Persona numeroDocumento, String nombreUsuario, boolean alta,
			String hashedPwd) {
		super();
		this.id = id;
		this.documento = documento;
		this.numeroDocumento = numeroDocumento;
		this.nombreUsuario = nombreUsuario;
		this.alta = alta;
		this.hashedPwd = hashedPwd;
	}


    

	@Override
	public int hashCode() {
		return Objects.hash(alta, documento, hashedPwd, id, nombreUsuario, numeroDocumento);
	}


	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Usuario other = (Usuario) obj;
		return alta == other.alta && Objects.equals(documento, other.documento)
				&& Objects.equals(hashedPwd, other.hashedPwd) && Objects.equals(id, other.id)
				&& Objects.equals(nombreUsuario, other.nombreUsuario)
				&& Objects.equals(numeroDocumento, other.numeroDocumento);
	}



	public Integer getId() {
	return id;
}



public void setId(Integer id) {
	this.id = id;
}



public Tipodocumento getDocumento() {
	return documento;
}



public void setDocumento(Tipodocumento documento) {
	this.documento = documento;
}



public Persona getNumeroDocumento() {
	return numeroDocumento;
}



public void setNumeroDocumento(Persona numeroDocumento) {
	this.numeroDocumento = numeroDocumento;
}



public String getNombreUsuario() {
	return nombreUsuario;
}



public void setNombreUsuario(String nombreUsuario) {
	this.nombreUsuario = nombreUsuario;
}



public boolean isAlta() {
	return alta;
}



public void setAlta(boolean alta) {
	this.alta = alta;
}



public String getHashedPwd() {
	return hashedPwd;
}



public void setHashedPwd(String hashedPwd) {
	this.hashedPwd = hashedPwd;
}



	
	
	
	
}