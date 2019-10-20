<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>


<form class="materia" action="controller" method="post"
	style="display: none" class="col-sm-6 col-12">
	<input type="hidden" name="tarefa" id="tarefa" value="CadastroMateria" />

	<h2>Cadastro de Matérias</h2>
	<div class="row">
		<div class="col">
			<label for="exampleFormControlTextarea1">Nome matéria</label> <input
				type="text" class="form-control" name="nome"
				placeholder="Laço de repetição">
		</div>
	</div>

	<div class="row">
		<div class="col">

			<div class="form-group">
				<label for="exampleFormControlTextarea1">Ementa</label>
				<textarea class="form-control" name="ementa"
					id="exampleFormControlTextarea1" rows="3"></textarea>
			</div>
		</div>
	</div>

	<div class="row">
		<div class="col">

			<div class="form-group">
				<label for="exampleFormControlTextarea1">URL da imagem da
					matéria</label> <input type="text" class="form-control" name="urlImg"
					placeholder="URL IMAGEM">
			</div>
		</div>
	</div>

	<button type="submit" class="btn btn-primary">Cadastar
		Matéria!</button>

</form>


<form class="updateMateria" action="controller" method="post"
	style="display: none" class="col-sm-6 col-12">
	<input type="hidden" name="tarefa" id="tarefa" value="UpdateMateria" />


	<h2>Atualizar de Matérias</h2>

	<div class="row">
		<div class="col">
			<label for="selectMateria">Selecione matéria</label> <select
				data-placeholder="Escolha a matéria..." class="chosen-select"
				name="selectedMateria" id="selectMateria" single>
				<option value=""></option>
				<c:forEach var="materia" items="${materias}">
					<option value="${materia.id_materia}" />${materia.nome}</option>
				</c:forEach>
			</select>
		</div>
	</div>


	<div class="row">
		<div class="col">
			<label for="exampleFormControlTextarea1">Nome matéria</label> <input
				type="text" class="form-control" name="nome"
				placeholder="Laço de repetição">
		</div>
	</div>

	<div class="row">
		<div class="col">
			<div class="form-group">
				<label for="exampleFormControlTextarea1">Ementa</label>
				<textarea class="form-control" name="ementa"
					id="exampleFormControlTextarea1" rows="3"></textarea>
			</div>
		</div>
	</div>
	<div class="row">
		<div class="col">
			<div class="form-group">
				<label for="exampleFormControlTextarea1">URL da imagem da
					matéria</label> <input type="text" class="form-control" name="urlImg"
					placeholder="URL IMAGEM">
			</div>
		</div>
	</div>
	<button type="submit" class="btn btn-primary">Atualizar
		Matéria!</button>


</form>