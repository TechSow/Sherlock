<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:import url="partial/head.jsp" />


<div class="container d-flex">
	<div class="row">

		<form action="controller" method="POST">
			<input type="hidden" name="tarefa" id="tarefa" value="Login" />
			<div class="form-group">
				<label for="email">Endere�o de email</label> <input type="email"
					class="form-control" name="email" id="email"
					placeholder="Seu email" required /> <small id="emailHelp"
					class="form-text text-muted"> Nunca vamos compartilhar seu
					email, com ningu�m.</small>
			</div>
			<div class="form-group">
				<label for="senha">Senha</label> <input type="password"
					class="form-control" name="senha" id="senha" placeholder="Senha"
					required />
			</div>
			<button type="submit" class="btn btn-primary">logar</button>
		</form>
	</div>
</div>
<!-- references code pen https://codepen.io/kipp0/pen/pPNrrj -->
<c:if test="${not empty erro}">

	<div id="toast">
		<i class="fas fa-biohazard text-danger" id="img"></i>
		<div id="desc" class="bg-danger">${erro}</div>
	</div>
</c:if>

</body>
<script>
	$(document).ready(function() {
		function launch_toast() {
			var x = document.getElementById("toast")
			x.className = "show";
			setTimeout(function() {
				x.className = x.className.replace("show", "");
			}, 5000);
		}
		launch_toast();

	})
</script>


</html>