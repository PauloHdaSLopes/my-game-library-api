package br.com.home.gameLibrary.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.home.gameLibrary.model.Usuario;

public interface UsuarioRepository extends JpaRepository<Usuario, Long>{

	Optional<Usuario> findByEmail(String username);

}
