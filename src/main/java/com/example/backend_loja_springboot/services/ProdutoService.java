package com.example.backend_loja_springboot.services;

import java.util.List;
import java.util.Optional;

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
	
	public Optional<Produto> findById(Long id){
		Optional<Produto> obj = produtoRepository.findById(id);
		
		if(obj.isEmpty()) {
			System.out.println("Produto não existente!");
		}
		return obj;
	}
	
	public Produto insertProduto(Produto produto) {
		return produtoRepository.save(produto);
	}
	
	public void deleteProduto(Long id) {
		produtoRepository.deleteById(id);
	}
}
