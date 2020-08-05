package br.com.casadocodigo.loja.dto;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import br.com.casadocodigo.loja.models.Role;
import br.com.casadocodigo.loja.models.Usuario;

public class UsuarioDTO {

	private String nome;
	private String email;
	private List<Role> roles;
	
	public UsuarioDTO(Usuario usuario) {
		this.nome = usuario.getNome();
		this.email = usuario.getEmail();
		this.roles = usuario.getRoles();
	}
	
	public static List<UsuarioDTO> entityToDTO(List<Usuario> usuarios){
		return usuarios
				.stream()
				.map(UsuarioDTO::new)
				.collect(Collectors.toList());
	}
	
	public String getNome() {
		return nome;
	}
	
	public String getEmail() {
		return email;
	}
	public List<String> getRoles() {
		return roles.stream().map( role -> role.getNome()).collect(Collectors.toList());
	}
	
}
