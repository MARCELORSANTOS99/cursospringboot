package com.marcelosantos.cursospringboot.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.marcelosantos.cursospringboot.domain.Pedido;

@Repository
public interface PedidoRepository extends JpaRepository <Pedido, Integer>{

	
	
}
