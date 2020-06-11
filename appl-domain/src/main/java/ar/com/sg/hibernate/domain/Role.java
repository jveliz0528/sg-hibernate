package ar.com.sg.hibernate.domain;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
@Table(name = "role")
public class Role implements Serializable{

	private static final long serialVersionUID = -846562307909649816L;
	
	//Constructores
	public Role() {
		
	}

	public Role(String role, String nombre) {
		this.role = role;
		this.nombre = nombre;
	}



	public Role(Long idRole, String role, String nombre) {
		this.idRole = idRole;
		this.role = role;
		this.nombre = nombre;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((idRole == null) ? 0 : idRole.hashCode());
		result = prime * result + ((nombre == null) ? 0 : nombre.hashCode());
		result = prime * result + ((role == null) ? 0 : role.hashCode());
		return result;
	}
	
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Role other = (Role) obj;
		if (idRole == null) {
			if (other.idRole != null)
				return false;
		} else if (!idRole.equals(other.idRole))
			return false;
		if (nombre == null) {
			if (other.nombre != null)
				return false;
		} else if (!nombre.equals(other.nombre))
			return false;
		if (role == null) {
			if (other.role != null)
				return false;
		} else if (!role.equals(other.role))
			return false;
		return true;
	}
	
	public Long getIdRole() {
		return idRole;
	}

	public void setIdRole(Long idRole) {
		this.idRole = idRole;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	

	@Override
	public String toString() {
		return "Role [idRole=" + idRole + ", role=" + role + ", nombre=" + nombre + "]";
	}


	//Atributos
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idRole")
    private Long idRole;
   
	@Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 20)
    @Column(name = "role", length = 20, nullable = false)
    private String role;
    
	@Basic(optional = false)
    @Size(min = 1, max = 50)
    @Column(name = "nombre", length = 50)
    private String nombre;
	
	@ManyToMany(fetch = FetchType.LAZY, mappedBy = "pesonas")
	private Set<Persona> personas = new HashSet<Persona>(0);
	
}
