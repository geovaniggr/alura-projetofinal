package br.com.casadocodigo.loja.controllers;

import java.util.concurrent.Callable;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.servlet.ModelAndView;

import br.com.casadocodigo.loja.dto.PedidosDTO;

@Controller
@RequestMapping("/pedidos")
public class PedidosServicoController {
	
	
	@Autowired
	RestTemplate restTemplate;
	
	@GetMapping
	public Callable<?> listarPedidos() {
		return () -> {
			ModelAndView view = new ModelAndView("pedidos");
			String uri = "https://book-payment.herokuapp.com/orders";
			PedidosDTO[] response = restTemplate.getForObject(uri, PedidosDTO[].class);
			
			view.addObject("pedidos", response);
			
			return view;
		};
	}

}
