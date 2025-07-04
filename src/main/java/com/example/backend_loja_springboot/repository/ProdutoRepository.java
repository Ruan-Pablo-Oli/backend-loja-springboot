package com.example.backend_loja_springboot.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.backend_loja_springboot.model.Produto;

public interface ProdutoRepository extends JpaRepository<Produto, Long> {
	List<Produto> findByNomeContainingIgnoreCase(String nome);
}
