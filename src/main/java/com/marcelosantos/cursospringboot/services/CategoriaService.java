package com.marcelosantos.cursospringboot.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.marcelosantos.cursospringboot.domain.Categoria;
import com.marcelosantos.cursospringboot.repositories.CategoriaRepository;
import com.marcelosantos.cursospringboot.services.exception.ObjectNotFoundException;

@Service
public class CategoriaService {
	
	@Autowired
	private CategoriaRepository repo;
	
	public Categoria buscar(Integer id) { 
		 Optional<Categoria> obj = repo.findById(id); 
		return obj.orElseThrow(() -> new ObjectNotFoundException( 
		 "Objeto não encontrado! Id: " + id + ", Tipo: " + Categoria.class.getName())); 
		}
	
	public Categoria insert(Categoria obj) {
		obj.setId(null);
		return repo.save(obj);
	}

}
