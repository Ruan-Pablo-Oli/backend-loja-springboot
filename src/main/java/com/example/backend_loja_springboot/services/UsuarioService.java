package com.example.backend_loja_springboot.services;

import java.util.Optional;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.example.backend_loja_springboot.model.Usuario;
import com.example.backend_loja_springboot.repository.UsuarioRepository;

@Service
public class UsuarioService {
	private final UsuarioRepository usuarioRepository;
	private final PasswordEncoder passwordEncoder;
	
	public UsuarioService(UsuarioRepository usuarioRepository) {
		this.usuarioRepository = usuarioRepository;
		this.passwordEncoder = new BCryptPasswordEncoder();
	}
	
	public Usuario insertUsuario(String username, String password) {
		String senhaCriptografada = passwordEncoder.encode(password);
		Usuario usuario = new Usuario(username,senhaCriptografada); 
		return usuarioRepository.save(usuario);
	}
	
	public Optional<Usuario> findUsuarioByusername(String username){
		return usuarioRepository.findByUsername(username);
	}
	
	

	
}
