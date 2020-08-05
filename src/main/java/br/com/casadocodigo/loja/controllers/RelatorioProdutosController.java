package br.com.casadocodigo.loja.controllers;


import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.format.annotation.DateTimeFormat.ISO;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import br.com.casadocodigo.loja.dao.ProdutoDAO;
import br.com.casadocodigo.loja.dto.RelatorioDTO;
import br.com.casadocodigo.loja.models.Produto;

@RestController
@RequestMapping("/relatorio-produtos")
public class RelatorioProdutosController {
	
	@Autowired
	private ProdutoDAO produtoDAO;
	
	@GetMapping
	public ResponseEntity<?> listProductsByDate(@RequestParam(required=false, name="data") @DateTimeFormat(iso = ISO.DATE) LocalDate data){
		
		List<Produto> produtos = null;
		Calendar dataGeracao= null;
		
		if(data == null) {
			produtos = produtoDAO.listar();
		} else {
			dataGeracao = GregorianCalendar.from(data.atStartOfDay(ZoneId.systemDefault()));
			produtos = produtoDAO.listarPorData(dataGeracao);
		}
		
		RelatorioDTO relatorio = new RelatorioDTO(dataGeracao, produtos);

		return ResponseEntity.ok(relatorio);
	}

}
