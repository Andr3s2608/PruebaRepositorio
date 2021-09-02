package com.soaint.factura.repository;


import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.soaint.factura.entities.Factura;

@Repository
public interface FacturaRepository extends JpaRepository<Factura, Long>{
	

}
