<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<form class="aluno" action="controller" method="post"
	style="display: block" class="col-sm-6 col-12">
	<input type="hidden" name="tarefa" id="tarefa" value="CadastroUsuario" />
	<input type="hidden" name="from" id="tarefa" value="CadastroUsuarioAdm" />


	<h2>Cadastro do Usuario</h2>
	<div class="form-group">
		<label for="exampleInputEmail1">Email: ${usuario.email}</label> <input
			type="email" class="form-control" id="exampleInputEmail1"
			name="email" aria-describedby="emailHelp"
			placeholder="Digitar novo Email"> <small id="emailHelp"
			class="form-text text-muted">Nunca compartilhar o email com
			ninguém.</small>
	</div>

	<div class="form-group">
		<label for="exampleInputEmail1">Apelido: ${usuario.apelido}</label> <input
			class="form-control" type="text" name="apelido"
			placeholder="Digitar Novo apelido" required> <small
			id="emailHelp" class="form-text text-muted">O apelido precisa
			ser unico e pode ser utilizado para login.</small>
	</div>
	
	<div class="form-group">
		<label for="exampleInputEmail1">Nome: ${pessoa.nome}</label> <input
			class="form-control" type="text" name="nome"
			placeholder="Digitar novo nome" required> 
			<small id="emailHelp" class="form-text text-muted">Nome apenas para identificação do Usuario</small>
	</div>
	
	<div class="form-group">
		<label for="exampleInputEmail1">Sobrenome: ${pessoa.sobrenome}</label> <input
			class="form-control" type="text" name="nome"
			placeholder="Digitar Novo sobrenome" required> 
			<small id="emailHelp" class="form-text text-muted">Apenas para identificação do Usuario</small>
	</div>


	<div class="form-group">
		<label for="exampleInputPassword1">Senha: ${usuario.senha}</label> <input
			type="password" class="form-control" name="senha"
			id="exampleInputPassword1" placeholder="Digitar nova senha">
	</div>

	<button type="submit" class="btn btn-primary">Atualizar Aluno!</button>
</form>