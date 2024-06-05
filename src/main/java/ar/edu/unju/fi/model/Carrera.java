package ar.edu.unju.fi.model;

public class Carrera {
	private String codigo;
	private String nombre;
	private Integer duracion;
	private Boolean estado;
	
	public Carrera() {
		// TODO Auto-generated constructor stub
	}

	public Carrera(String codigo, String nombre, Integer duracion, Boolean estado) {
		this.codigo = codigo;
		this.nombre = nombre;
		this.duracion = duracion;
		this.estado = estado;
	}

	public String getCodigo() {
		return codigo;
	}

	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public Integer getDuracion() {
		return duracion;
	}

	public void setDuracion(Integer duracion) {
		this.duracion = duracion;
	}

	public Boolean getEstado() {
		return estado;
	}

	public void setEstado(Boolean estado) {
		this.estado = estado;
	}
	
	

}
