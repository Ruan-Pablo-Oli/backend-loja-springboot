package com.example.backend_loja_springboot.controller;

import java.util.Map;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.backend_loja_springboot.controller.dto.AuthAccRequest;
import com.example.backend_loja_springboot.model.Usuario;
import com.example.backend_loja_springboot.services.AuthService;
import com.example.backend_loja_springboot.services.UsuarioService;

@RestController
@RequestMapping(value="/auth")
public class AuthController {

	private final UsuarioService usuarioService;
	private final AuthService authService;
	public AuthController(UsuarioService usuarioService,AuthService authService) {
		this.usuarioService = usuarioService;
		this.authService = authService;
	}
	
	@PostMapping(value="/register")
	public ResponseEntity<?> register(@RequestBody AuthAccRequest request){
		Usuario usuario = usuarioService.insertUsuario(request.username(), request.password());
		return ResponseEntity.ok().body(usuario);
	}
	
	@PostMapping(value="/login")
	public ResponseEntity<?> login(@RequestBody AuthAccRequest request){
		String text = authService.auth(request.username(), request.password());
		return ResponseEntity.ok().body(Map.of("token",text));
	}
	
	
}
