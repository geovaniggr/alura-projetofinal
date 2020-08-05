package br.com.casadocodigo.loja.controllers;

import java.util.Arrays;
import java.util.List;
import java.util.Set;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import br.com.casadocodigo.loja.dao.RoleDAO;
import br.com.casadocodigo.loja.dao.UsuarioDAO;
import br.com.casadocodigo.loja.dto.UsuarioDTO;
import br.com.casadocodigo.loja.models.Role;
import br.com.casadocodigo.loja.models.Usuario;
import br.com.casadocodigo.loja.request.UpdateUserRoleRequest;
import br.com.casadocodigo.loja.request.UsuarioRequest;
import br.com.casadocodigo.loja.validation.UsuarioValidation;

@Controller
@RequestMapping("/usuarios")
public class UsuariosController {
	
	@Autowired
	private UsuarioDAO usuarioDao;
	
	@Autowired
	private BCryptPasswordEncoder passwordEncoder;
	
	@Autowired
	private RoleDAO roleDao;
	
	@InitBinder("usuarioRequest")
	public void initBinder(WebDataBinder binder) {
		binder.addValidators(new UsuarioValidation(usuarioDao));
	}
	
	@GetMapping
	public ModelAndView listaUsuarios() {
		List<UsuarioDTO> usuarios = UsuarioDTO.entityToDTO(usuarioDao.listar());
		ModelAndView view = new ModelAndView("usuarios/lista");
		view.addObject("usuarios", usuarios);
		
		return view;
	}
	
	@GetMapping("/form")
    public ModelAndView formularioUsuario(UsuarioRequest usuario){
        return new ModelAndView("usuarios/formulario");
    }
	
	@PostMapping("/form")
	public ModelAndView gravarUsuario(@Valid UsuarioRequest usuario, BindingResult formulario, RedirectAttributes redirectAttributes){

		if (formulario.hasErrors()) {
			return formularioUsuario(usuario);
		}
		
		usuario.setSenha(passwordEncoder.encode(usuario.getSenha()));
		
		usuarioDao.gravar(usuario.toEntity());
		
		redirectAttributes.addFlashAttribute("sucesso", String.format("Usuario %s cadastrado com sucesso!", usuario.getNome()));
		
		return new ModelAndView("redirect:/usuarios");
	}
	
	
	@GetMapping("/role")
	public ModelAndView formularioAlterarRole(@RequestParam String username, UpdateUserRoleRequest userRole, RedirectAttributes attributes) {
		List<Role> roles = roleDao.listar();
		Usuario usuario;
		try {
			usuario = usuarioDao.loadUserByUsername(username);
		} catch(UsernameNotFoundException notFound) {
			attributes.addFlashAttribute("UserNotFound", String.format("Usuario: %s não encontrado", username));
			return new ModelAndView("redirect:/usuarios");
		}
		
		ModelAndView view = new ModelAndView("usuarios/formularioPermissao");
		view.addObject("roles", roles);
		view.addObject("userRole", new UpdateUserRoleRequest(usuario));
		
		return view;
	}
	
	@PostMapping("/role")
	public ModelAndView alterarRoleUsuario(@RequestParam String email, UpdateUserRoleRequest userRole, RedirectAttributes attributes) {
		
		Usuario usuario;
		try {
			usuario = usuarioDao.loadUserByUsername(email);
		} catch(UsernameNotFoundException notFound) {
			attributes.addFlashAttribute("UserNotFound", String.format("Usuario: %s não encontrado", email));
			return new ModelAndView("redirect:/usuarios");
		}
		usuario.setRoles(userRole.getRoles());
		usuarioDao.gravar(usuario);
		
		attributes.addFlashAttribute("sucesso", String.format("Permissões de %s alteradas com sucesso", usuario.getNome()));
		
		return new ModelAndView("redirect:/usuarios");
	}

}

