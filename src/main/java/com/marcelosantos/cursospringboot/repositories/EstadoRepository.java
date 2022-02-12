package com.marcelosantos.cursospringboot.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.marcelosantos.cursospringboot.domain.Estado;

@Repository
public interface EstadoRepository extends JpaRepository <Estado, Integer>{

	
	
}