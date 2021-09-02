package com.soaint.factura.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.soaint.factura.entities.Factura;
import com.soaint.factura.repository.FacturaRepository;

@Service
public class FacturaServiceImpl implements FacturaService{

	@Autowired
	private  FacturaRepository facturaRepository;
	
	@Override
	@Transactional(readOnly = true)
	public Iterable<Factura> FindAll() {
		
		return facturaRepository.findAll();
	}

	@Override
	@Transactional(readOnly = true)
	public Optional<Factura> FindById(Long id) {
		
		
		return facturaRepository.findById(id);
		
	}



	
	@Override
	@Transactional
	public Factura save(Factura factura) {
		
		return facturaRepository.save(factura);
	}

	@Override
	@Transactional
	public void deleteByid(Long id) {
		facturaRepository.deleteById(id);
		
	}

	

}
