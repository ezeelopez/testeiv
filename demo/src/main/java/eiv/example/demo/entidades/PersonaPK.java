package eiv.example.demo.entidades;


import java.io.Serializable;
import java.util.Objects;


import javax.persistence.JoinColumn;

import javax.persistence.OneToOne;


public class PersonaPK implements Serializable  {

	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	/**
	 * 
	 */

	
    @OneToOne
	@JoinColumn(name = "ID_TIPODOCUMENTO")
	private Tipodocumento documento;

    
   
    

	public PersonaPK() {
		super();
	}






	public Tipodocumento getDocumento() {
		return documento;
	}






	public void setDocumento(Tipodocumento documento) {
		this.documento = documento;
	}






	public static long getSerialversionuid() {
		return serialVersionUID;
	}






	@Override
	public int hashCode() {
		return Objects.hash(documento);
	}






	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		PersonaPK other = (PersonaPK) obj;
		return Objects.equals(documento, other.documento);
	}


	
	
	
}
