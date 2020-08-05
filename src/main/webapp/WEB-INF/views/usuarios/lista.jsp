<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="s"%>
<%@ taglib uri="http://www.springframework.org/security/tags" prefix="security"%>
<%@ taglib tagdir="/WEB-INF/tags" prefix="tags"%>
<tags:pageTemplate titulo="Cadastro de Usuários">
<c:url value="/resources/css" var="cssPath" />
<c:url value="/resources/js" var="jp"/>
<link rel="stylesheet" href="${cssPath}/bootstrap.min.css" />
<link rel="stylesheet" href="${cssPath}/bootstrap-theme.min.css" />
	<div class="container">
		${sucesso}
		${UserNotFound}
		<br>
		<a href="${s:mvcUrl('UC#formularioUsuario').build()}">Novo Usuario</a>
		<table class="table table-bordered table-striped table-hover">
			<tr>
				<th> Nome </th>
				<th> Email </th>
				<th> Role </th>
				<th>  </th>
			</tr>
				<c:forEach items="${usuarios}" var="usuario">
					<tr>
						<td>${usuario.nome}</td>
						<td>${usuario.email}</td>
						<td>${usuario.roles}</td>
						<td>
						<a href="/casadocodigo/usuarios/role/?username=${usuario.email}">
							<img src="${contextPath }resources/imagens/adicionar.png">
						</a>
						</td>
					</tr>
				</c:forEach>
		</table>
	</div>
	<br/>
	
</tags:pageTemplate>