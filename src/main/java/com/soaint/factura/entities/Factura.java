package com.soaint.factura.entities;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="factura")
public class Factura implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;	
	
	@Column(name="cantidad",nullable=false)
	private int cantidad_producto;
	
	@Column(name="precio",nullable=false)
	private Double precio_producto;
	
	@Column(name="nombre",nullable=false,length = 50)
	private String nombre_producto;
	

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public int getCantidad_producto() {
		return cantidad_producto;
	}

	public void setCantidad_producto(int cantidad_producto) {
		this.cantidad_producto = cantidad_producto;
	}

	public String getNombre_producto() {
		return nombre_producto;
	}

	public void setNombre_producto(String nombre_producto) {
		this.nombre_producto = nombre_producto;
	}

	public Double getPrecio_producto() {
		return precio_producto;
	}

	public void setPrecio_producto(Double precio_producto) {
		this.precio_producto = precio_producto;
	}
	
}
