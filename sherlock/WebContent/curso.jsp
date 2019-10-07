<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:import url="partial/head.jsp" />


<div class="main">

	<c:forEach var="materia" items="${materias}">
		<ul>
			<li>
			<a href="/sherlock/controller?tarefa=ConteudoController&id_materia=${materia.id_materia}">${materia.nome}</a></li>
		</ul>
	</c:forEach>


</div>
<div class="nav">
	<c:forEach var="curso" items="${cursos}">
		<ul>
			<li><a
				href="/sherlock/controller?tarefa=Curso&id_curso=${curso.id_curso}">${curso.nome}</a></li>
		</ul>
	</c:forEach>
</div>
<div class="logo"></div>
<div class="header">
	<h1>Seja bem vindo ${usuario.apelido}</h1>

</div>
<div class="nav"></div>
<div class="footer"></div>



</body>
</html>