package com.example.backend_loja_springboot.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.backend_loja_springboot.model.Produto;
import com.example.backend_loja_springboot.services.ProdutoService;

@RestController
@RequestMapping(value="/api/produtos")
public class ProdutoController {

	private final ProdutoService produtoService;
	
	public ProdutoController(ProdutoService produtoService) {
		this.produtoService = produtoService;
	}
	
	@GetMapping
	public ResponseEntity<List<Produto>> findAll(){
		List<Produto> list = produtoService.findAll();
		return ResponseEntity.ok().body(list);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<?> findById(@PathVariable Long id){
			Produto produto = produtoService.findById(id);
			return ResponseEntity.ok().body(produto);
	}
	
	@PostMapping
	public ResponseEntity<Produto> insertProduto(@RequestBody Produto produto){
		Produto obj = produtoService.insertProduto(produto);
		return ResponseEntity.ok().body(obj);
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<Void> deleteProduto(@PathVariable Long id){
		produtoService.deleteProduto(id);
		return ResponseEntity.noContent().build();
	}
	
	
	
	
}
