package com.marcelosantos.cursospringboot.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.marcelosantos.cursospringboot.domain.Produto;

@Repository
public interface ProdutoRepository extends JpaRepository <Produto, Integer>{

	
	
}
