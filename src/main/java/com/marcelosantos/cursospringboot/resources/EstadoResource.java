package com.marcelosantos.cursospringboot.resources;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.marcelosantos.cursospringboot.domain.Cidade;
import com.marcelosantos.cursospringboot.domain.Estado;
import com.marcelosantos.cursospringboot.dto.CidadeDTO;
import com.marcelosantos.cursospringboot.dto.EstadoDTO;
import com.marcelosantos.cursospringboot.services.CidadeService;
import com.marcelosantos.cursospringboot.services.EstadoService;

@RestController
@RequestMapping(value="/estados")
public class EstadoResource {
	
	@Autowired
	private EstadoService service;
	
	@Autowired
	private CidadeService cidadeService;
	
	@RequestMapping( method=RequestMethod.GET)
	public ResponseEntity<List<EstadoDTO>> findAll(){
	 List<Estado> list =  service.findAll();
	 List<EstadoDTO> listDTO = list.stream().map(obj -> new EstadoDTO(obj)).collect(Collectors.toList());
	  
	 return ResponseEntity.ok().body(listDTO);
	}	
	
	
	
	@RequestMapping(value="{estado_id}/cidades", method=RequestMethod.GET)
	public ResponseEntity<List<CidadeDTO>> findCidades(@PathVariable Integer estado_id){
	 Estado estado =  service.find(estado_id);
	 List<Cidade> list =  cidadeService.findCidade(estado.getId());
			 
	 List<CidadeDTO> listDTO = list.stream().map(obj -> new CidadeDTO(obj)).collect(Collectors.toList());
	  
	 return ResponseEntity.ok().body(listDTO);
	}
}
