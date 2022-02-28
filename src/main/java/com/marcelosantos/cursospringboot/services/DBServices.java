package com.marcelosantos.cursospringboot.services;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.marcelosantos.cursospringboot.domain.Categoria;
import com.marcelosantos.cursospringboot.domain.Cidade;
import com.marcelosantos.cursospringboot.domain.Cliente;
import com.marcelosantos.cursospringboot.domain.Endereco;
import com.marcelosantos.cursospringboot.domain.Estado;
import com.marcelosantos.cursospringboot.domain.ItemPedido;
import com.marcelosantos.cursospringboot.domain.Pagamento;
import com.marcelosantos.cursospringboot.domain.PagamentoComBoleto;
import com.marcelosantos.cursospringboot.domain.PagamentoComCartao;
import com.marcelosantos.cursospringboot.domain.Pedido;
import com.marcelosantos.cursospringboot.domain.Produto;
import com.marcelosantos.cursospringboot.domain.enuns.EstadoPagamento;
import com.marcelosantos.cursospringboot.domain.enuns.TipoCliente;
import com.marcelosantos.cursospringboot.repositories.CategoriaRepository;
import com.marcelosantos.cursospringboot.repositories.CidadeRepository;
import com.marcelosantos.cursospringboot.repositories.ClienteRepository;
import com.marcelosantos.cursospringboot.repositories.EnderecoRepository;
import com.marcelosantos.cursospringboot.repositories.EstadoRepository;
import com.marcelosantos.cursospringboot.repositories.ItemPedidoRepository;
import com.marcelosantos.cursospringboot.repositories.PagamentoRepository;
import com.marcelosantos.cursospringboot.repositories.PedidoRepository;
import com.marcelosantos.cursospringboot.repositories.ProdutoRepository;

@Service
public class DBServices {
	
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
	
	@Autowired
	private PedidoRepository pedidoRepository;
	
	@Autowired
	private PagamentoRepository pagamentoRepository;
	
	@Autowired
	private ItemPedidoRepository itemPedidoRepository ;
	
	public void instatiateTestDataBase() throws ParseException {
		
		Categoria cat1 = new Categoria(null, "Informática");
		Categoria cat2 = new Categoria(null, "Escritório");
		Categoria cat3 = new Categoria(null, "Cama mesa e banho");
		Categoria cat4 = new Categoria(null, "Perfumaria");
		Categoria cat5 = new Categoria(null, "Jardinagem");
		Categoria cat6 = new Categoria(null, "Decoração");
		Categoria cat7 = new Categoria(null, "Eletrônicos");
		
		
		Produto p1 = new Produto(null, "Computador", 2000.00);
		Produto p2 = new Produto(null, "Impressora", 800.00);
		Produto p3 = new Produto(null, "Mouse", 80.00);
		Produto p4 = new Produto(null, "Mesa de Escritório", 300.00);
		Produto p5 = new Produto(null, "Toalha", 50.00);
		Produto p6 = new Produto(null, "Colha", 200.00);
		Produto p7 = new Produto(null, "TV true Color", 1200.00);
		Produto p8 = new Produto(null, "Roçadeira", 800.00);
		Produto p9 = new Produto(null, "Abajour", 100.00);
		
		cat1.getProdutos().addAll(Arrays.asList(p1,p2,p3));
		cat2.getProdutos().addAll(Arrays.asList(p1,p2,p3));
		
		p1.getCategorias().addAll(Arrays.asList(cat1,cat4));
		p2.getCategorias().addAll(Arrays.asList(cat1,cat2,cat4));
		p3.getCategorias().addAll(Arrays.asList(cat1,cat4));
		p4.getCategorias().addAll(Arrays.asList(cat2));
		p5.getCategorias().addAll(Arrays.asList(cat3));
		p6.getCategorias().addAll(Arrays.asList(cat3));
		p7.getCategorias().addAll(Arrays.asList(cat4));
		p8.getCategorias().addAll(Arrays.asList(cat5));
		p9.getCategorias().addAll(Arrays.asList(cat6));
		
		categoriaRepository.saveAll(Arrays.asList(cat1, cat2,cat3,cat4,cat5,cat6,cat7));
		produtoRepository.saveAll(Arrays.asList(p1,p2,p3,p4,p5,p6,p7,p8,p9));
		
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
		
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy HH:mm"); 

		
		Pedido ped1 = new Pedido(null, sdf.parse("12/02/2022 06:34"),cli1,e1);
		Pedido ped2 = new Pedido(null, sdf.parse("08/02/2022 15:34"),cli1,e2);
		
		Pagamento pagto1 = new PagamentoComCartao(null, EstadoPagamento.QUITADO, ped1, 6);
		ped1.setPagamento(pagto1);
		
		Pagamento pagto2 = new PagamentoComBoleto(null, EstadoPagamento.PENDENTE, ped2, sdf.parse("13/02/2022 00:00"), null);
		ped2.setPagamento(pagto2);
		
		cli1.getPedidos().addAll(Arrays.asList(ped1,ped2));
		
		pedidoRepository.saveAll(Arrays.asList(ped1,ped2));
		pagamentoRepository.saveAll(Arrays.asList(pagto1,pagto2));
		
		
		ItemPedido ip1 = new ItemPedido(ped1,p1,0.00,1,2000.00);
		ItemPedido ip2 = new ItemPedido(ped1,p3,0.00,2,80.00);
		ItemPedido ip3 = new ItemPedido(ped2,p2,100.00,1,800.00);
		
		ped1.getItens().addAll(Arrays.asList(ip1,ip2));
		ped2.getItens().addAll(Arrays.asList(ip3));
		
		
		p1.getItens().addAll(Arrays.asList(ip1));
		p2.getItens().addAll(Arrays.asList(ip3));
		p3.getItens().addAll(Arrays.asList(ip2));
		
		itemPedidoRepository.saveAll(Arrays.asList(ip1,ip2,ip3));
	}

}
