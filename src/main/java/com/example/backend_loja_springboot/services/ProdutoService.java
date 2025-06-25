package com.example.backend_loja_springboot.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.example.backend_loja_springboot.exceptions.ResourceNotFoundException;
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
	
	public Produto findById(Long id){
		return produtoRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Product with id " + id + " not found!"));
	}
	
	public Produto insertProduct(Produto produto) {
		return produtoRepository.save(produto);
	}
	
	public void deleteProduct(Long id) {
		
		if(!produtoRepository.existsById(id)) {
			throw new ResourceNotFoundException("Product not found!");
		}
		produtoRepository.deleteById(id);
	}
	
	public List<Produto> findByNome(String nome){
		return produtoRepository.findByNomeContainingIgnoreCase(nome);
	}
}
