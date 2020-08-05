<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="s"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib tagdir="/WEB-INF/tags" prefix="tags"%>
<c:url value="/" var="contextPath" />
<tags:pageTemplate titulo="Seu carrinho de compra">
<jsp:body>
	<section class ="container middle">
		<h1>Lista de Pedidos Atuais</h1>
		<table class="table table-bordered table-striped table-hover">
			<tr>
				<th> ID </th>
				<th> Valor </th>
				<th> Data Pedido </th>
				<th> Titulos </th>
			</tr>
				<c:forEach items="${pedidos}" var="pedido">
					<tr>
						<td>${pedido.id }</td>
						<td>${pedido.valor }</td>
						<td><fmt:formatDate value="${pedido.data.time}" pattern="dd/MM/yyyy"/></td>
						<td>
							<c:forEach items="${pedido.produtos}" var="produto" varStatus="status">
								${produto.titulo}
								${not status.last ? "," : ""} 
							</c:forEach>
						</td>
					</tr>
				</c:forEach>
		</table>
	</section>
</jsp:body>
</tags:pageTemplate>