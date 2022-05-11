package com.generation.lojadegame.security;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;


import com.generation.lojadegame.model.Usuario;
import com.generation.lojadegame.repository.UsuarioRepository;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {

	@Autowired
	private UsuarioRepository userRepository;
	@Override
	public UserDetails loadUserByUsername(String userName) throws UsernameNotFoundException {
		Optional<Usuario>usuario = userRepository.findByUsuario(userName);
		usuario.orElseThrow(()-> new UsernameNotFoundException(userName + "Usuario não encontrado"));
		return usuario.map(UserDetailsImpl::new).get();
	}
}
