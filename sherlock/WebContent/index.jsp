<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:import url="partial/head.jsp" />

<c:if test="${not empty error}">
	<div class="toast" role="alert" aria-live="assertive"
		data-authide="true" data-animation="true" aria-atomic="true">
		<div class="toast-header">
			<strong class="mr-auto">Sherlock</strong>
			<button type="button" class="ml-2 mb-1 close" data-dismiss="toast"
				aria-label="Close">
				<span aria-hidden="true">&times;</span>
			</button>
		</div>
		<div class="toast-body">${error}</div>
	</div>
</c:if>
<div class="container d-flex">
	<div class="row">

		<form action="controller" method="POST">
			<input type="hidden" name="tarefa" id="tarefa" value="Login" />
			<div class="form-group">
				<label for="email">Endereço de email</label> <input type="email"
					class="form-control" name="email" id="email"
					placeholder="Seu email" required /> <small id="emailHelp"
					class="form-text text-muted"> Nunca vamos compartilhar seu
					email, com ninguém.</small>
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

</body>
</html>