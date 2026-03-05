package com.tt1.test;

public class ToDo {
	private String nombre;
	private String descripcion;
	private java.time.LocalDate fechaLimite;
	private Boolean completado;
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getDescripcion() {
		return descripcion;
	}
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	public java.time.LocalDate getFechaLimite() {
		return fechaLimite;
	}
	public void setFechaLimite(java.time.LocalDate fechaLimite) {
		this.fechaLimite = fechaLimite;
	}
	public Boolean getCompletado() {
		return completado;
	}
	public void setCompletado(Boolean completado) {
		this.completado = completado;
	}
	
	
}
