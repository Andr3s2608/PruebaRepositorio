package com.soaint.factura.service;

import java.util.List;
import java.util.Optional;

import com.soaint.factura.entities.Factura;

public interface FacturaService {

	public Iterable<Factura> FindAll();
	public Optional<Factura> FindById(Long id);
	public Factura save(Factura factura);
	public void deleteByid(Long id);

}
