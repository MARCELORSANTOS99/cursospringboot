package com.marcelosantos.cursospringboot.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.marcelosantos.cursospringboot.domain.Cidade;
import com.marcelosantos.cursospringboot.repositories.CidadeRepository;

@Service
public class CidadeService {
	
	@Autowired
	private CidadeRepository repo;
	
		
	public List<Cidade> findCidade(Integer estadoId) {
		return repo.findCidades(estadoId);
	}
}
