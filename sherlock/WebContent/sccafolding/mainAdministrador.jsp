<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>


<style>
form {
	position: absolute;
	margin-top: 5em;
}
</style>

<ul class="nav nav-tabs">
	<li class="nav-item">
		<button class="nav-link active" id="botaoProfessor"
			onclick="admProfessor()">Professor</button>
	</li>
	<li class="nav-item">
		<button class="nav-link active" id="curso" onclick="admCurso()">Curso</button>
	</li>
	<li class="nav-item">
		<button class="nav-link active" id="materia" onclick="admMateria()">Matéria</button>
	</li>
	<li class="nav-item">
		<button class="nav-link active" id="aluno" onclick="admAluno()">Aluno</button>
	</li>
</ul>


<form class="professor" action="controller" method="post">
	<input type="hidden" name="tarefa" id="tarefa"
		value="CadastroProfessor" />

	<h2>Cadastro de Professores</h2>
	<div class="form-group">
		<label for="exampleInputEmail1">Endereço de email</label> <input
			type="email" class="form-control" id="exampleInputEmail1"
			name="email" aria-describedby="emailHelp"
			placeholder="Email do professor"> <small id="emailHelp"
			class="form-text text-muted">Nunca vamos compartilhar seu
			email, com ninguém.</small>
	</div>

	<div class="form-group">
		<label for="exampleInputEmail1">Apelido</label> <input
			class="form-control" type="text" name="apelido"
			placeholder="Apelido do professor" required> <small
			id="emailHelp" class="form-text text-muted">O apelido precisa
			ser unico e pode ser utilizado para login.</small>
	</div>

	<div class="form-group">
		<label for="exampleInputPassword1">Senha</label> <input
			type="password" class="form-control" name="senha"
			id="exampleInputPassword1" placeholder="Senha">
	</div>

	<button type="submit" class="btn btn-primary">Cadastrar
		professor!</button>
</form>



<form class="curso" action="controller" method="post"
	style="display: none">
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

	<div class="form-group">
		<label for="exampleFormControlTextarea1">Descrição</label>
		<textarea class="form-control" name="descricao"
			id="exampleFormControlTextarea1" rows="3"></textarea>
	</div>

	<div class="form-group">
		<label for="exampleInputEmail1">Duração</label> <input
			class="form-control" type="number" name="duracao"
			placeholder="Horas previstas" required>
	</div>
	<button type="submit" class="btn btn-primary">Cadastar Curso!</button>
</form>


<form class="materia" action="controller" method="post"
	style="display: none">
	<input type="hidden" name="tarefa" id="tarefa" value="CadastroMateria" />

	<h2>Cadastro de Matérias</h2>
	<div class="row">
		<div class="col">
			<label for="exampleFormControlTextarea1">Nome matéria</label> <input
				type="text" class="form-control" name="nome"
				placeholder="Laço de repetição">
		</div>
	</div>


	<div class="form-group">
		<label for="exampleFormControlTextarea1">Ementa</label>
		<textarea class="form-control" name="ementa"
			id="exampleFormControlTextarea1" rows="3"></textarea>
	</div>

	<div class="form-group">
		<label for="exampleFormControlTextarea1">URL da imagem da
			matéria</label> <input type="text" class="form-control" name="urlImg"
			placeholder="URL IMAGEM">
	</div>

	<button type="submit" class="btn btn-primary">Cadastar Curso!</button>
</form>

<form class="aluno" action="controller" method="post" style="display: none">
	<input type="hidden" name="tarefa" id="tarefa"
		value="CadastroUsuario" />

	<h2>Cadastro de Alunos</h2>
	<div class="form-group">
		<label for="exampleInputEmail1">Endereço de email</label> <input
			type="email" class="form-control" id="exampleInputEmail1"
			name="email" aria-describedby="emailHelp"
			placeholder="Email do professor"> <small id="emailHelp"
			class="form-text text-muted">Nunca compartilhar o email com ninguém.</small>
	</div>

	<div class="form-group">
		<label for="exampleInputEmail1">Apelido</label> <input
			class="form-control" type="text" name="apelido"
			placeholder="Apelido do professor" required> <small
			id="emailHelp" class="form-text text-muted">O apelido precisa
			ser unico e pode ser utilizado para login.</small>
	</div>

	<div class="form-group">
		<label for="exampleInputPassword1">Senha</label> <input
			type="password" class="form-control" name="senha"
			id="exampleInputPassword1" placeholder="Senha">
	</div>

	<button type="submit" class="btn btn-primary">Cadastrar Aluno!</button>
</form>

<script src="https://code.jquery.com/jquery-3.3.1.slim.min.js"
	integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo"
	crossorigin="anonymous"></script>

<script>

var p = document.querySelector(".professor");
var c = document.querySelector(".curso");
var m = document.querySelector(".materia");
var a = document.querySelector(".aluno");

function admProfessor() {
	  
	  if (p.style.display === "none") {
	    p.style.display = "block";
	    c.style.display = "none";
	    m.style.display = "none";
	    a.style.display = "none";
	}
}
	
	
function admCurso() {
	if (c.style.display === "none") {
	    p.style.display = "none";
	    c.style.display = "block";
	    m.style.display = "none";
	    a.style.display = "none";
	}  
}

function admMateria() {
	if (m.style.display === "none") {
	    p.style.display = "none";
	    m.style.display = "block";
	    c.style.display = "none";
	    a.style.display = "none";
	}  
}

function admAluno() {
	if (a.style.display === "none") {
	    p.style.display = "none";
	    m.style.display = "none";
	    c.style.display = "none";
	    a.style.display = "block";
	}  
}


	/* 
var btnProf =$("#botaoProfessor");
btnProf.on("click", function(e){
	e.preventDefault()
	$(".professor").toggleClass("d-none");	
}) */


$(function() {
    $('.material-card > .mc-btn-action').click(function () {
        var card = $(this).parent('.material-card');
        var icon = $(this).children('i');
        icon.addClass('fa-spin-fast');

        if (card.hasClass('mc-active')) {
            card.removeClass('mc-active');

            window.setTimeout(function() {
                icon
                    .removeClass('fa-arrow-left')
                    .removeClass('fa-spin-fast')
                    .addClass('fa-bars');

            }, 800);
        } else {
            card.addClass('mc-active');

            window.setTimeout(function() {
                icon
                    .removeClass('fa-bars')
                    .removeClass('fa-spin-fast')
                    .addClass('fa-arrow-left');

            }, 800);
        }
    });
});
</script>