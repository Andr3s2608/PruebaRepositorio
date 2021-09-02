package com.soaint.factura.controller;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.soaint.factura.entities.Factura;
import com.soaint.factura.service.FacturaService;

import ch.qos.logback.core.joran.util.beans.BeanUtil;

@RestController
@RequestMapping("/factura")
public class FacturaController {

	@Autowired
	private FacturaService facturaService;
	
	//Create
	@PostMapping
	public ResponseEntity<?> crear(@RequestBody Factura factura){
		return ResponseEntity.status(HttpStatus.CREATED).body(facturaService.save(factura));
	}
	
	//Read
	@GetMapping("/{id}")
	public ResponseEntity<?> buscarPorId (@PathVariable(value= "id") Long facturaId){
		Optional <Factura> facturaBuscada = facturaService.FindById(facturaId);
		if(facturaBuscada.isEmpty())
		{
			return ResponseEntity.notFound().build();
		}
		else
		{
			return ResponseEntity.ok(facturaBuscada);
		}
	}

	
	//Read all users
	
	@GetMapping
	public List<Factura> buscarTodos()
	{
		List<Factura> facturas= StreamSupport
				.stream(facturaService.FindAll().spliterator(), false)
				
				.filter(fact1 -> fact1.getCantidad_producto()==2)
				.collect(Collectors.toList());
		
		
		return facturas;
	}
	
	//update
	
	@PutMapping("/{id}")
	public ResponseEntity<?> modificar (@RequestBody Factura facturaDetails,@PathVariable (value ="id")Long facturaId ){
		Optional <Factura> facturaBuscada = facturaService.FindById(facturaId);
		
		
		if(facturaBuscada.isEmpty())
		{
			return ResponseEntity.notFound().build();
		}
		else
		{
			//para copiar todo el objeto de factura ingresado
			//BeanUtils.copyProperties(facturaDetails,facturaBuscada);
			facturaBuscada.get().setCantidad_producto(facturaDetails.getCantidad_producto());
			facturaBuscada.get().setPrecio_producto(facturaDetails.getPrecio_producto());
			
			
			 return ResponseEntity.status(HttpStatus.CREATED).body(facturaService.save(facturaBuscada.get()));
		}
		
	}
	
	
	@DeleteMapping("/{id}")
	public ResponseEntity<?> borrar( @PathVariable (value="id") Long facturaId){
		if(facturaService.FindById(facturaId).isEmpty())
		{
		
			return ResponseEntity.notFound().build();
		}
		else
		{
			facturaService.deleteByid(facturaId);
			return ResponseEntity.ok().build();
		}
		
	}
	

	
	
	
}
