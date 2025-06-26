package com.example.backend_loja_springboot.services;

import java.util.Optional;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.example.backend_loja_springboot.model.Usuario;
import com.example.backend_loja_springboot.security.JwtUtil;

@Service
public class AuthService {

	private  UsuarioService usuarioService;
	private  PasswordEncoder passwordEncoder;
	
	public AuthService(UsuarioService usuarioService) {
		this.usuarioService = usuarioService;
		passwordEncoder = new BCryptPasswordEncoder();
	}
	
	public String auth(String username,String password) {
		Optional<Usuario> usuario = usuarioService.findUsuarioByusername(username);
		if(usuario.isPresent() && passwordEncoder.matches(password, usuario.get().getPassword())) {
			String token = JwtUtil.generateToken(usuario.get().getusername());
			return token;
		}
		return "Credenciais inválidas!";
	}
	
}
