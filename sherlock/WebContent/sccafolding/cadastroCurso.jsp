<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<form class="curso col-lg-6 col-12" id="formCadastroCurso" action="controller" method="post"
	style="display: none" >
	
	<input type="hidden" name="tarefa" id="tarefa" value="CadastroCurso" />
	<h2>Cadastro de Cursos</h2>
	<div class="row">
		<div class="col">
			<label for="exampleFormControlTextarea1">Nome Curso</label> <input
				type="text" class="form-control" name="nome"
				placeholder="Algoritimos">
		</div>
		<div class="col">
			<label for="exampleFormControlTextarea1">Dificuldade</label> <select
				type="text" class="form-control" name="dificuldade"
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
			<label for="exampleFormControlTextarea1">Url da imagem do
				card</label> <input type="text" class="form-control" name="urlimg"
				placeholder="http://exemplo.url.imagem/imagem">
		</div>
	</div>
	<div class="form-group curso">
		<label for="exampleFormControlTextarea1">Descrição</label>
		<textarea class="form-control" name="descricao"
			id="exampleFormControlTextarea1" rows="3"></textarea>
	</div>

	<div class="form-group">
		<label for="exampleInputEmail1">Duração</label> <input
			class="form-control" type="number" name="duracao"
			placeholder="Horas previstas" required>
	</div>

	<div>
		<label for="selectMateria">Escolha as matérias deste curso</label> <select
			data-placeholder="Escolha as matérias..." class="chosen-select"
			name="selectedMaterias" id="selectMateria" multiple>
			<option value=""></option>
			<c:forEach var="materia" items="${materias}">
				<option value="${materia.id_materia}" />${materia.nome}</option>
			</c:forEach>
		</select>

	</div>


	 <br>
	<button type="submit" class="btn btn-primary">Cadastar Curso!</button>


</form>

<div class=" col-12 col-lg-6 d-flex mt-3 justify-content-center align-items-center flex-column">
			<select id="cursoOptionAtt" class="form-control">
				<option>Selecione para alterar</option>
				<c:forEach var="curso" items="${cursos}">
					<option  value="${curso.id_curso}">
						${curso.nome}
					</option>
				</c:forEach>
			</select>
			<br/>
            <article class="material-card Blue-Grey" style="width: 100%;">
                <h2>
                    <span id="nomeCurso">${curso.nome}</span>
                    <strong>
						<span id="dificuldadeCurso">
         			    <i class="fa fa-star"></i>
         			    </span>
                        Dificuldade                        
                    </strong>
                </h2>
                <div class="mc-content">
                    <div class="img-container">
                        <img class="img-responsive" src="#">
                    </div>
                    <div class="mc-description">
                    </div>
                </div>
                <a class="mc-btn-action">
                    <i class="fa fa-bars"></i>
                </a>
                <div class="mc-footer">
                    <h4>
                        aprender
                    </h4>
                    <a href="#"><i class="fa fa-play" aria-hidden="true"></i></a>
                </div>
            </article>
</div>
<style>
	
</style>
<script src="scripts/curso.js"></script>
<script>
	$('.chosen-select').chosen({
		width : '100%'
	});
</script>