package br.com.casadocodigo.loja.validation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import br.com.casadocodigo.loja.dao.UsuarioDAO;
import br.com.casadocodigo.loja.models.Usuario;
import br.com.casadocodigo.loja.request.UsuarioRequest;

public class UsuarioValidation implements Validator {
	
	UsuarioDAO usuarioDao;
	
	public UsuarioValidation(UsuarioDAO usuarioDao) {
		this.usuarioDao = usuarioDao;
	}

	@Override
	public boolean supports(Class<?> clazz) {
		return UsuarioRequest.class.isAssignableFrom(clazz);
	}

	@Override
	public void validate(Object target, Errors errors) {
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "nome", "field.required.usuario.nome");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "email", "field.required.usuario.email");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "senha", "field.required.usuario.senha");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "confirmacaoDeSenha", "field.required.usuario.confirmacao_senha");

		UsuarioRequest usuario = (UsuarioRequest) target;
		
		if(usuario.getSenha().length() < 5)
			errors.rejectValue("senha", "field.required.usuario.senha_curta");
		
		if(!(usuario.getSenha().equals(usuario.getConfirmacaoDeSenha()))) 
			errors.rejectValue("confirmacaoDeSenha", "field.required.usuario.senha_diferente");
		
		if(usuarioDao.existeUsuarioCadastrado(usuario.getEmail())) {
			System.out.println("Existe usuário");
			errors.rejectValue("email", "usuario.email_existente");
		}else {
			System.out.println("Não existe usuario cadastrado");
		}
	}
}
