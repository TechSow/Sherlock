<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<form class="curso" action="controller" method="post"
	style="display: none" class="col-sm-6 col-12">
	<input type="hidden" name="tarefa" id="tarefa" value="CadastroCurso" />

	<script
		src="https://cdnjs.cloudflare.com/ajax/libs/chosen/1.4.2/chosen.jquery.min.js"></script>
	<link rel="stylesheet"
		href="https://cdnjs.cloudflare.com/ajax/libs/chosen/1.4.2/chosen.min.css">

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
	
	<select data-placeholder="Escolha as matérias..." class="chosen-select" name="selectedMaterias"multiple style="width:350px;" tabindex="4">
            <option value=""></option>
           <c:forEach var="materia" items="${materias}">
					<option name="selectedMaterias" value="${materia.id_materia}" />${materia.nome}</option>
			</c:forEach>
          </select>    
</div>
		
		<br><br>
		<button type="submit" class="btn btn-primary">Cadastar Curso!</button>
</form>

</div>
</form>

<script>

$('.chosen-select').chosen({ width: '100%' });


$('.chosen-select').chosen({}).change( function(obj, result) {
    console.debug("changed: %o", arguments);
    
    console.log("selected: " + result.selected);
});

</script>