<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="s"%>
<%@ taglib tagdir="/WEB-INF/tags" prefix="tags"%>
<tags:pageTemplate titulo="Cadastro de Usuários">
<c:url value="/resources/css" var="cssPath" />
<c:url value="/resources/js" var="jp"/>
<link rel="stylesheet" href="${cssPath}/bootstrap.min.css" />
<link rel="stylesheet" href="${cssPath}/bootstrap-theme.min.css" />
	<div class="container">
		<h1><fmt:message key="form.usuarios.titulo"/></h1>
		<form:form action="${s:mvcUrl('UC#gravarUsuario').build() }" method="post" commandName="usuarioRequest" enctype="application/x-www-form-urlencoded">
			<div class="form-group">
				<label><fmt:message key="form.usuarios.nome"/></label>
				<form:input path="nome" cssClass="form-control" />
				<form:errors path="nome" />
			</div>
			<div class="form-group">
		        <label><fmt:message key="form.usuarios.email"/></label>
				<form:input path="email" cssClass="form-control" />
		        <form:errors path="email" />		        
			</div>
			<div class="form-group">
				<label><fmt:message key="form.usuarios.senha"/></label>
				<form:password path="senha" cssClass="form-control" />
		        <form:errors path="senha" />
			</div>
			<div class="form-group">
				<label><fmt:message key="form.usuarios.senha_confirmacao"/></label>
				<form:password path="confirmacaoDeSenha" cssClass="form-control" />
		        <form:errors path="confirmacaoDeSenha" />
			</div>
			<button type="submit" class="btn btn-primary"><fmt:message key="form.usuarios.cadastrar"/></button>
		</form:form>
	</div>
	<br/>
	
</tags:pageTemplate>