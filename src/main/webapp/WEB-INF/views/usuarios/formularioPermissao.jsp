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
		<form:form action="/casadocodigo/usuarios/role/?email=${userRole.email}" commandName="userRole" method="post" enctype="application/x-www-form-urlencoded">
				<h1><s:message code="form.role.nome" arguments="${userRole.nome}"></s:message></h1>
				<c:forEach items="${roles}" var="role">
				<label>
					${role.nome}
					<form:checkbox path="roles" value="${role.nome}" ></form:checkbox>
				</label>
					<br/>
				</c:forEach>
			<button type="submit" class="btn btn-primary"><fmt:message  key="form.role.atualizar"/></button>
		</form:form>
	</div>
	<br/>
	
</tags:pageTemplate>