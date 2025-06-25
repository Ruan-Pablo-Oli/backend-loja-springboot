package com.example.backend_loja_springboot.services;

import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.example.backend_loja_springboot.model.Usuario;
import com.example.backend_loja_springboot.repository.UsuarioRepository;


@Service
public class UsuarioDetailsService implements UserDetailsService{

	private UsuarioRepository usuarioRepository;
	
	public UsuarioDetailsService(UsuarioRepository usuarioRepository) {
		this.usuarioRepository = usuarioRepository;
	}
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		Usuario usuario = usuarioRepository.findByUsername(username).orElseThrow(() -> new UsernameNotFoundException("Usuário não encontrado"));
		
		return User.builder().username(usuario.getusername()).password(usuario.getPassword()).roles("USER").build();
	}

}
