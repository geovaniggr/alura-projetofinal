package br.com.casadocodigo.loja.dto;

import java.util.Calendar;
import java.util.List;

import br.com.casadocodigo.loja.models.Produto;

public class RelatorioDTO {
	
	Calendar dataGeracao;
	Integer quantidade;
	List<Produto> produtos;
	
	public RelatorioDTO(Calendar dataGeracao, List<Produto> produtos) {
		this.dataGeracao = dataGeracao;
		this.produtos = produtos;
		this.quantidade = produtos.size();
	}
	
	public Calendar getDataGeracao() {
		return dataGeracao;
	}
	
	public Integer getQuantidade() {
		return quantidade;
	}
	public List<Produto> getProdutos() {
		return produtos;
	}
	

}
