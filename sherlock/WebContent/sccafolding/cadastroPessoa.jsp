<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<form class="aluno" action="controller" method="post"
	style="display: block" class="col-sm-6 col-12">
	<input type="hidden" name="tarefa" id="tarefa" value="CadastroUsuario" />
	<input type="hidden" name="from" value="2" />
	<input type="hidden" name="idUsuario" value="${usuarioId} }" />


	<h2>Cadastro do Usuario</h2>
	<div class="form-group">
		<label for="exampleInputEmail1">Email: ${usuario.email}</label> <input
			type="email" class="form-control" id="exampleInputEmail1"
			name="email" aria-describedby="emailHelp"
			placeholder="Digitar novo Email"> <small id="emailHelp"
			class="form-text text-muted">Campo único e obrigatório, pode ser usado como login.</small>
	</div>

	<div class="form-group">
		<label for="exampleInputEmail1">Apelido: ${usuario.apelido}</label> <input
			class="form-control" type="text" name="apelido"
			placeholder="Digitar Novo apelido" > <small
			id="emailHelp" class="form-text text-muted">Campo único e obrigatório, pode ser usado como login.</small>
	</div>
	
	<div class="form-group">
		<label for="exampleInputPassword1">Senha: ${usuario.senha}</label> <input
			type="password" class="form-control" name="senha" minlength=6
			id="exampleInputPassword1" placeholder="Digitar nova senha">
	</div>

	<button type="submit" class="btn btn-primary">Atualizar Aluno!</button>
</form>