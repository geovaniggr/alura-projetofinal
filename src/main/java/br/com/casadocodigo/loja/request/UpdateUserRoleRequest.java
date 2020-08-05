package br.com.casadocodigo.loja.request;

import java.util.List;

import br.com.casadocodigo.loja.models.Role;
import br.com.casadocodigo.loja.models.Usuario;

public class UpdateUserRoleRequest {

	private String nome;
	private String email;
	private List<Role> roles;
	
	public UpdateUserRoleRequest() {}
	
	public UpdateUserRoleRequest(Usuario usuario) {
		this.nome = usuario.getNome();
		this.email = usuario.getEmail();
		this.roles = usuario.getRoles();
	}

	public String getNome() {
		return nome;
	}
	
	public String getEmail() {
		return email;
	}
	
	public List<Role> getRoles() {
		return roles;
	}
	
	public void setRoles(List<Role> roles) {
		this.roles = roles;
	}
	
	
	public void setEmail(String email) {
		this.email = email;
	}
	
	public void setNome(String nome) {
		this.nome = nome;
	}
}
