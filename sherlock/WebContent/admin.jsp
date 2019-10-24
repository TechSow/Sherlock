<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:import url="partial/head.jsp" />
<c:choose>
	<c:when test="${not empty usuario }">
		<body class="grid-container">
			<div class="main">
				<div class="container">
					<c:import url="sccafolding/mainAdministrador.jsp" />
					
				</div>
			</div>
			<div class="nav">
				<ul class="lista">
					<c:if test="${usuario.adm == 1}">
						<li class="item"><a href="/sherlock/controller?tarefa=GetMateriaController">Área do
								administrador</a></li>
					</c:if>
					<c:if test="${usuario.professor == 1}">
						<li class="item"><a href="">Área do Professor</a></li>
					</c:if>
					<li class="item"><a href="/sherlock/controller?tarefa=CursoController&cursobool=true">Lista de
							Cursos</a></li>
				</ul>
			</div>
			
			<div class="logo">
				<c:import url="sccafolding/logo.html" />
			</div>
			<div class="header">
				<div>
					<h2>Pagina administrativa</h2>
					<p>Seja bem-vindo, ${usuario.apelido}!</p>
				</div>
				<div>
					<a href="/sherlock/controller?tarefa=GetPessoaController&usuarioId=${usuario.idUsuario}">
					<i class="fa fa-user" aria-hidden="true"></i> </a> <a
						href="/sherlock/controller?tarefa=LogoutController"><i
						class="fa fa-power-off" aria-hidden="true"></i></a>
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

<c:if test="${not empty erro}">

    <div id="toast">
        <i class="fa fa-${erro[2]} text-${erro[1] }" id="img" aria-hidden="true"></i>

        <div id="desc" class="bg-${erro[1] }">${erro[0]}</div>
    </div>
    <script>
        function launch_toast() {
            var toast = document.querySelector("#toast");
            if (!(toast === undefined)) {
                toast.classList.add("show");
                setTimeout(function() {
                    toast.className = toast.classList.remove("show");
                }, 5000);
            }
        }
        window.onload = function() {
            launch_toast();
        }
    </script>

</c:if>
</body>
</html>