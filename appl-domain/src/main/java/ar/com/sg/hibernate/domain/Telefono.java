package ar.com.sg.hibernate.domain;

import java.io.Serializable;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.Size;

@Entity
@Table(name = "telefonos")
public class Telefono implements Serializable{
	
	private static final long serialVersionUID = 2348857148456111727L;
	
	//Constructores	
	public Telefono() {
		
	}

	//Constructor
	public Telefono(Long idTelefono, String telefono) {
		this.idTelefono = idTelefono;
		this.telefono = telefono;
	}
	
	public Telefono(String telefono) {
		this.telefono = telefono;
	}

	public Long getIdTelefono() {
		return idTelefono;
	}

	public void setIdTelefono(Long idTelefono) {
		this.idTelefono = idTelefono;
	}

	public String getTelefono() {
		return telefono;
	}

	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}


	@Override
	public String toString() {
		return "Telefono [idTelefono=" + idTelefono + ", telefono=" + telefono + ", telefono2=" + "]";
	}


	//Atributos
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idTelefono")
    private Long idTelefono;

    @Size(min = 14, max = 14)
    @Column(name = "telefono")
    private String telefono;
    

}
