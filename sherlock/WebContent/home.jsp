<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:import url="partial/head.jsp" />
<c:choose>
	<c:when test="${not empty usuario }">
		<body class="grid-container">
			<div class="main">
				<c:import url="sccafolding/mainHome.jsp" />
			</div>
			<div class="nav">
				<ul class="lista">
					<c:if test="${usuario.adm == 1}">
						<li class="item"><a href="/sherlock/controller?tarefa=GetMateriaController">Área do administrador</a></li>
					</c:if>
					<c:if test="${usuario.professor == 1}">
						<li class="item"><a href="/sherlock/controller?tarefa=GetMateriaController">Área do Professor</a></li>
					</c:if>
						<li class="item"><a href="/sherlock/controller?tarefa=CursoController&cursobool=true">Lista de Cursos</a></li>
					
				</ul>
			</div>
			<div class="logo">
				<c:import url="sccafolding/logo.html" />
			</div>
			<div class="header">
				<div>
					<h2>Listagem de cursos</h2>
					<p>Seja bem-vindo, ${usuario.apelido}!</p>
				</div>
				<div>
					<a href="/sherlock/controller?tarefa=GetPessoaController&usuarioId=${usuario.idUsuario}">
					<i class="fa fa-user" aria-hidden="true"></i> </a>
					 
					<a href="/sherlock/controller?tarefa=LogoutController">
					<i class="fa fa-power-off" aria-hidden="true"></i> </a>
				</div>
			</div>

			<div class="footer">
				<c:import url="sccafolding/footer.html" />
			</div>
	</c:when>
	<c:otherwise>
		<body>
			<c:import url="errors/erro401.html" />
	</c:otherwise>
</c:choose>
<style>
.main{
	flex-wrap:wrap;
	overflow:hidden;
	overflot-y:scroll;
}
</style>
</body>
</html>