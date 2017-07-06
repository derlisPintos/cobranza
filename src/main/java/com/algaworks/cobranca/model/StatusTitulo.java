package com.algaworks.cobranca.model;

public enum StatusTitulo {

	PENDIENTE("Pendiente"),
	RECIBIDO("Recibido");
	
	private String descripcion;
	
	StatusTitulo(String descripcion) {
		this.descripcion = descripcion;
	}
	
	public String getDescripcion() {
		return descripcion;
	}
	
}
