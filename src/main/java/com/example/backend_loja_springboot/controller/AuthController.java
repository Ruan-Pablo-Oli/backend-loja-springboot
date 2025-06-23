package com.example.backend_loja_springboot.controller;

import java.util.Map;
import java.util.Optional;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.backend_loja_springboot.controller.dto.AuthAccRequest;
import com.example.backend_loja_springboot.model.Usuario;
import com.example.backend_loja_springboot.security.JwtUtil;
import com.example.backend_loja_springboot.services.UsuarioService;

@RestController
@RequestMapping(value="/auth")
public class AuthController {

	private final UsuarioService usuarioService;
	
	public AuthController(UsuarioService usuarioService) {
		this.usuarioService = usuarioService;
	}
	
	@PostMapping(value="/register")
	public ResponseEntity<?> register(@RequestBody AuthAccRequest request){
		Usuario usuario = usuarioService.insertUsuario(request.username(), request.password());
		return ResponseEntity.ok().body(usuario);
	}
	
	@PostMapping(value="/login")
	public ResponseEntity<?> login(@RequestBody AuthAccRequest request){
		Optional<Usuario> usuario = usuarioService.findUsuarioByusername(request.username());
		
		if(usuario.isPresent() && usuario.get().getPassword().equals(request.password())) {
			String token = JwtUtil.generateToken(usuario.get().getusername());
			return ResponseEntity.ok(Map.of("token",token));
		}
		return ResponseEntity.status(401).body("Credencias Inválidas");
	}
	
	
}
