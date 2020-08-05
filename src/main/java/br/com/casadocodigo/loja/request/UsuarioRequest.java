package br.com.casadocodigo.loja.request;

import java.util.Arrays;

import br.com.casadocodigo.loja.models.Role;
import br.com.casadocodigo.loja.models.Usuario;

public class UsuarioRequest {

	private String nome;

	private String email;
	
	private String senha;
	
	private String confirmacaoDeSenha;

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	public String getConfirmacaoDeSenha() {
		return confirmacaoDeSenha;
	}

	public void setConfirmacaoDeSenha(String confirmacaoDeSenha) {
		this.confirmacaoDeSenha = confirmacaoDeSenha;
	}
	
	public Usuario toEntity() {
		return new Usuario(nome, email, senha, Arrays.asList(new Role("ROLE_USER")));
	}
}
