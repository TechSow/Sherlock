<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:set var="i" value="1"/>
<c:forEach var="conteudo" items="${conteudos}">
	<ul class="lista-content">
		
		<li class="item-content d-flex justify-content-between"><span>${conteudo.titulo}</span>
		<a href="/sherlock/controller?tarefa=ConteudoController&id_conteudo=${conteudo.id_conteudo}" class="btn btn-primary">cap ${i}</a>
		</li>
		<c:set var="i" value="${i = i + 1}"/>
	</ul>
</c:forEach>

<style>
	
</style>