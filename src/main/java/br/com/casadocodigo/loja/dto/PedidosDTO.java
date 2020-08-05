package br.com.casadocodigo.loja.dto;

import java.math.BigDecimal;
import java.util.Calendar;
import java.util.List;

import br.com.casadocodigo.loja.models.Produto;

public class PedidosDTO {

	Integer id;
	BigDecimal valor;
	Calendar data;
	List<Produto> produtos;
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public BigDecimal getValor() {
		return valor;
	}
	public void setValor(BigDecimal valor) {
		this.valor = valor;
	}
	public Calendar getData() {
		return data;
	}
	public void setData(Calendar data) {
		this.data = data;
	}
	public List<Produto> getProdutos() {
		return produtos;
	}
	public void setProdutos(List<Produto> produtos) {
		this.produtos = produtos;
	}
}
