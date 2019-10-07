<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html lang="pt">
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<meta http-equiv="X-UA-Compatible" content="ie=edge">
<title>${title}</title>
<c:import url="imports/imports.html" />
</head>
<body
	style="margin: 0px !important; padding: 0px !important; overflow: hidden;">
	<iframe
		style="width: 98%; height: 100vh; margin: 0 !important; padding: 0 !important; overflow-x: hidden;"
		src="${conteudo.url_pdf}" frameborder="0"></iframe>
</body>
<style>
.dh-viewport .no-focus-ring .ember-view {
	overflow-x: hidden !important; 
}
</style>
</html>
