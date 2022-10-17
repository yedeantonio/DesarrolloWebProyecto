package co.poli.edu.proyecto.Model;

import javax.persistence.Entity;

import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;


@Entity
@Table (name="pasantias")
public class Pasantia {
	
	@Id	
	private int id_pasantia;
	
	private String lugar;
	private String Fecha;
	private String Hora;
	private String id_estudiante;
	private String nombre_estudiante;
	private String semestre;
	
	@ManyToOne
	@JoinColumn(name = "programa_id")
	private Programa programa;
	
	public Pasantia() {
		
	}
	
	
	public Pasantia(int id_pasantia, String lugar, String fecha, String hora, String id_estudiante,
			String nombre_estudiante, String semestre) {
		super();
		this.id_pasantia = id_pasantia;
		this.lugar = lugar;
		this.Fecha = fecha;
		this.Hora = hora;
		this.id_estudiante = id_estudiante;
		this.nombre_estudiante = nombre_estudiante;
		this.semestre = semestre;
	}
	

	public int getId_pasantia() {
		return id_pasantia;
	}
	
	public void setId_pasantia(int id_pasantia) {
		this.id_pasantia = id_pasantia;
	}
	
	public String getLugar() {
		return lugar;
	}
	
	public void setLugar(String lugar) {
		this.lugar = lugar;
	}
	
	public String getFecha() {
		return Fecha;
	}
	
	public void setFecha(String fecha) {
		Fecha = fecha;
	}
	
	public String getHora() {
		return Hora;
	}
	
	public void setHora(String hora) {
		Hora = hora;
	}
	
	public String getId_estudiante() {
		return id_estudiante;
	}
	
	public void setId_estudiante(String id_estudiante) {
		this.id_estudiante = id_estudiante;
	}
	
	public String getNombre_estudiante() {
		return nombre_estudiante;
	}
	
	public void setNombre_estudiante(String nombre_estudiante) {
		this.nombre_estudiante = nombre_estudiante;
	}

	public Programa getPrograma() {
		return programa;
	}

	public void setPrograma(Programa programa) {
		this.programa = programa;
	}

	public String getSemestre() {
		return semestre;
	}

	public void setSemestre(String semestre) {
		this.semestre = semestre;
	}
	

}
