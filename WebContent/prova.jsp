<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<ul>
	<c:forEach var="medico" items="${medici}">
		<li>${medico.nome}</li>
	</c:forEach>
</ul>
