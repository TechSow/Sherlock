<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html lang="pt">
<head>
<link href="https://stackpath.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css" rel="stylesheet" integrity="sha384-wvfXpqpZZVQGK6TAh5PVlGOfQNHSoD2xbE+QkPxCAFlNEevoEH3Sl0sibVcOQVnN" crossorigin="anonymous">
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<meta http-equiv="X-UA-Compatible" content="ie=edge">
<title>${title}</title>
<c:import url="imports/imports.html" />
<c:if test="${usuario.hasbot == 1}">
		<c:import url="bot.jsp" />
	</c:if>
</head>
<body
	style="margin: 0px !important; padding: 0px !important; overflow: hidden;">
	<iframe
		style="width: 100%; height: 100vh; margin: 0 !important; padding: 0 !important; overflow-x: hidden !important;"
		src="${conteudo.url_pdf}" frameborder="0"></iframe>
	<!--  erro de cache brabríssimo  -->
	<c:if test="${conteudo.hasbot == 1}">
		<c:import url="bot.jsp" />
	</c:if>
</body>
<style>
.dh-viewport .no-focus-ring .ember-view {
	overflow-x: hidden !important; 
}
</style>
</html>
