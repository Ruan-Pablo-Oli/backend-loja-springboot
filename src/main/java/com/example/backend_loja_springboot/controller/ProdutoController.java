package com.example.backend_loja_springboot.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.backend_loja_springboot.controller.util.URL;
import com.example.backend_loja_springboot.model.Produto;
import com.example.backend_loja_springboot.services.ProdutoService;

@RestController
@RequestMapping(value="/api/products")
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
	public ResponseEntity<Produto> insertProduto(@RequestBody Produto product){
		Produto obj = produtoService.insertProduct(product);
		return ResponseEntity.ok().body(obj);
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<Void> deleteProduto(@PathVariable Long id){
		produtoService.deleteProduct(id);
		return ResponseEntity.noContent().build();
	}
	
	@GetMapping("/search")
	public ResponseEntity<List<Produto>> findByNome(@RequestParam(value="text",defaultValue="") String text){
		text = URL.decodeParam(text);
		
		List<Produto> list = produtoService.findByNome(text);
		return ResponseEntity.ok().body(list);
	}
	
	
}
