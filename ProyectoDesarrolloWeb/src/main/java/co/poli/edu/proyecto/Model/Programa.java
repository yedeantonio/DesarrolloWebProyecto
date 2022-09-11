package co.poli.edu.proyecto.Model;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table (name="programas")
public class Programa {
	
	@Id	
	private String num_programa;
	
	private String nombre;
	private String facultad;
	private String escuela;
	
	@OneToMany(mappedBy="programa",cascade=CascadeType.ALL)
	@JsonIgnore
	private Set<Pasantia> pasantias;

	

	public Programa(String num_programa, String nombre, String facultad, String escuela, Set<Pasantia> pasantias) {
		super();
		this.num_programa = num_programa;
		this.nombre = nombre;
		this.facultad = facultad;
		this.escuela = escuela;
		this.pasantias = pasantias;
	}

	public Programa() {
		
	}
	
	public Set<Pasantia> getPasantias() {
		return pasantias;
	}

	public void setPasantias(Set<Pasantia> pasantias) {
		this.pasantias = pasantias;
	}

	public String getNum_programa() {
		return num_programa;
	}
	
	public void setNum_programa(String num_programa) {
		this.num_programa = num_programa;
	}
	
	public String getNombre() {
		return nombre;
	}
	
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	
	public String getFacultad() {
		return facultad;
	}
	
	public void setFacultad(String facultad) {
		this.facultad = facultad;
	}
	
	public String getEscuela() {
		return escuela;
	}
	
	public void setEscuela(String escuela) {
		this.escuela = escuela;
	}
	
	
}
