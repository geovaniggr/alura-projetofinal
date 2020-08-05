package br.com.casadocodigo.loja.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Repository;

import br.com.casadocodigo.loja.models.Produto;
import br.com.casadocodigo.loja.models.Usuario;

@Repository
@Transactional
public class UsuarioDAO implements UserDetailsService{

	@PersistenceContext
	private EntityManager manager;

	public Usuario loadUserByUsername(String email) {
		List<Usuario> usuarios = manager.createQuery("select u from Usuario u where email = :email", Usuario.class)
				.setParameter("email", email)
				.getResultList();
		if(usuarios.isEmpty()) {
			throw new UsernameNotFoundException("Usuario " + email + " não foi encontrado");
		}
		
		return usuarios.get(0);
	}

	public void gravar(Usuario usuario) {
		manager.persist(usuario);
	}
	
	public boolean existeUsuarioCadastrado(String email) {
		try {
			manager.createQuery("select u from Usuario u where email = :email", Usuario.class)
			.setParameter("email", email)
			.getSingleResult();
		} catch(NoResultException notFound) {
			return false;
		}
		return true;
	}
	
	public List<Usuario> listar(){
		return manager
				.createQuery("select distinct(u) from Usuario u", Usuario.class)
				.getResultList();
	}
	
	
	
}