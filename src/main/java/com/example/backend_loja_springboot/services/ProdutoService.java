package com.example.backend_loja_springboot.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.backend_loja_springboot.model.Produto;
import com.example.backend_loja_springboot.repository.ProdutoRepository;

@Service
public class ProdutoService {
	
	private ProdutoRepository produtoRepository;
	
	public ProdutoService(ProdutoRepository produtoRepository) {
		this.produtoRepository = produtoRepository;
	}
	
	public List<Produto> findAll(){
		return produtoRepository.findAll();
	}
	
	
}
