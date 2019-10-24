<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<form class="curso col-lg-6 col-12" id="formCadastroCurso"
	action="controller" method="post" style="display: none">

	<input type="hidden" name="tarefa" id="tarefa" value="ManterCurso" />
	<input type="hidden" name="id_curso" id="id_curso" value />
	<input type="hidden" name="queroexcluir" id="queroexcluir" value />
	<h2>Cadastro de Cursos</h2>
	<div class="row">
		<div class="col">
			<label for="nome">Nome Curso</label> <input type="text" id="nome"
				class="form-control" name="nome" placeholder="Algoritimos">
		</div>
		<div class="col">
			<label for="dificuldade">Dificuldade</label> <select type="text"
				id="dificuldade" class="form-control" name="dificuldade"
				id="exampleFormControlSelect1">
				<option>1</option>
				<option>2</option>
				<option>3</option>
				<option>4</option>
				<option>5</option>
			</select>
		</div>
	</div>
	<div class="row">
		<div class="col">
			<label for="urlimg">Url da imagem do card</label> <input type="text"
				class="form-control" id="urlimg" name="urlimg"
				placeholder="http://exemplo.url.imagem/imagem">
		</div>
	</div>
	<div class="form-group curso">
		<label for="descricao">Descrição</label>
		<textarea class="form-control" id="descricao" name="descricao"
			id="exampleFormControlTextarea1" rows="3"></textarea>
	</div>

	<div class="form-group">
		<label for="duracao">Duração</label> <input class="form-control"
			id="duracao" type="number" name="duracao"
			placeholder="Horas previstas" required>
	</div>

	<div>
		<label for="selectMateria">Escolha as matérias deste curso</label> <select
			class="form-control" name="selectedMaterias" id="selectMateria"
			multiple>
			<c:forEach var="materia" items="${materias}">
				<option value="${materia.id_materia}" />${materia.nome}</option>
			</c:forEach>
		</select>

	</div>


	<br>
	<div class="d-flex">
		<button type="submit" class="btn btn-primary mr-2">salvar</button>
		<button type="submit" class="btn btn-danger">Excluir</button>
	</div>
</form>

<div id="cardcursotunado"
	class=" col-12 col-lg-6 mt-3 justify-content-center align-items-center flex-column">
	<select id="cursoOptionAtt" class="form-control">
		<option>Selecione para alterar</option>
		<c:forEach var="curso" items="${cursos}">
			<option value="${curso.id_curso}">${curso.nome}</option>
		</c:forEach>
	</select> <br />
	<article class="material-card Blue-Grey"
		style="width: 480px; padding-bottom: 0 !important; height: 480px;">
		<h2>
			<span id="nomeCurso">${curso.nome}</span> <strong> <span
				id="dificuldadeCurso"> </span> Dificuldade
			</strong>
		</h2>
		<div class="mc-content">
			<div class="img-container">
				<img class="img-responsive" src="#">
			</div>
			<div class="mc-description"></div>
		</div>
		<a class="mc-btn-action"> <i class="fa fa-bars"></i>
		</a>
		<div class="mc-footer">
			<h4>aprender</h4>
			<a href="#"><i class="fa fa-play" aria-hidden="true"></i></a>
		</div>
	</article>
</div>
<style>
</style>
<script src="scripts/curso.js"></script>
<script>
	document.querySelector(".btn-danger").style.display = "none";
	$('.chosen-select').chosen({
		width : '100%'
	});
</script>