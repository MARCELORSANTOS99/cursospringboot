package com.marcelosantos.cursospringboot.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.marcelosantos.cursospringboot.domain.Endereco;

@Repository
public interface EnderecoRepository extends JpaRepository <Endereco, Integer>{

	
	
}
