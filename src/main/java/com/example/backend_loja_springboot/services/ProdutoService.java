package com.example.backend_loja_springboot.services;

import java.util.List;

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
		return produtoRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Produto com id " + id + " não encontrado!"));
	}
	
	public Produto insertProduto(Produto produto) {
		return produtoRepository.save(produto);
	}
	
	public void deleteProduto(Long id) {
		
		if(!produtoRepository.existsById(id)) {
			throw new ResourceNotFoundException("Produto não encontrado!");
		}
		produtoRepository.deleteById(id);
	}
}
