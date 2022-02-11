package com.marcelosantos.cursospringboot;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.marcelosantos.cursospringboot.domain.Categoria;
import com.marcelosantos.cursospringboot.domain.Cidade;
import com.marcelosantos.cursospringboot.domain.Cliente;
import com.marcelosantos.cursospringboot.domain.Endereco;
import com.marcelosantos.cursospringboot.domain.Estado;
import com.marcelosantos.cursospringboot.domain.Produto;
import com.marcelosantos.cursospringboot.domain.enuns.TipoCliente;
import com.marcelosantos.cursospringboot.repositories.CategoriaRepository;
import com.marcelosantos.cursospringboot.repositories.CidadeRepository;
import com.marcelosantos.cursospringboot.repositories.ClienteRepository;
import com.marcelosantos.cursospringboot.repositories.EnderecoRepository;
import com.marcelosantos.cursospringboot.repositories.EstadoRepository;
import com.marcelosantos.cursospringboot.repositories.ProdutoRepository;

@SpringBootApplication
public class CursospringbootApplication implements CommandLineRunner {
	
	@Autowired
	private CategoriaRepository categoriaRepository;
	
	@Autowired
	private ProdutoRepository produtoRepository;
	
	@Autowired
	private EstadoRepository estadoRepository;
	
	@Autowired
	private CidadeRepository cidadeRepository;
	
	@Autowired
	private ClienteRepository clienteRepository;
	
	@Autowired
	private EnderecoRepository enderecoRepository;

	public static void main(String[] args) {
		SpringApplication.run(CursospringbootApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		
		Categoria cat1 = new Categoria(null, "Informática");
		Categoria cat2 = new Categoria(null, "Escritório");
		
		Produto p1 = new Produto(null, "Computador", 2000.00);
		Produto p2 = new Produto(null, "Impressora", 800.00);
		Produto p3 = new Produto(null, "Mouse", 80.00);
		
		
		cat1.getProdutos().addAll(Arrays.asList(p1,p2,p3));
		
		p1.getCategorias().addAll(Arrays.asList(cat1));
		p2.getCategorias().addAll(Arrays.asList(cat1,cat2));
		p3.getCategorias().add(cat1);
		
		categoriaRepository.saveAll(Arrays.asList(cat1, cat2));
		produtoRepository.saveAll(Arrays.asList(p1,p2,p3));
		
		Estado est1 = new Estado(null, "Minas Gerais");
		Estado est2 = new Estado(null, "São Paulo");
		
		Cidade c1 = new Cidade(null, "Uberlândia", est1);
		Cidade c2 = new Cidade(null, "São Paulo", est2);
		Cidade c3 = new Cidade(null, "Campinas", est2);
		
		est1.getCidades().addAll(Arrays.asList(c1));
		est2.getCidades().addAll(Arrays.asList(c2,c3));
		
		estadoRepository.saveAll(Arrays.asList(est1,est2));
		cidadeRepository.saveAll(Arrays.asList(c1,c2,c3));
		
		Cliente cli1 = new Cliente(null, "Debora Mende", "debora@hotmail.com", "22447234880", TipoCliente.PESSOAFISICA);
		cli1.getTelefones().addAll(Arrays.asList("11-98564841","11-56663985"));
		
		Endereco e1 = new Endereco(null, "Rua Zike Tuma", "118", "bl2", "Jd Ubirajara", "04458-000", cli1, c2);
		Endereco e2 = new Endereco(null, "Rua Sobe e desce", "39", "bl1", "Jd Umbuiá", "04777-000", cli1, c3);
		
		cli1.getEnderecos().addAll(Arrays.asList(e1,e2));
		
		clienteRepository.saveAll(Arrays.asList(cli1));
		enderecoRepository.saveAll(Arrays.asList(e1,e2));

		
		
		
	}

}
