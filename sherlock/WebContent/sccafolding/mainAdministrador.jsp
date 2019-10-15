<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>


<style>

form{

position:absolute;
margin-top: 10em;

}

</style>

<ul class="nav nav-tabs">
	<li class="nav-item">
		<button class="nav-link active" id="botaoProfessor"
			onclick="admProfessor()">Professor</button>
	</li>
	<li class="nav-item">
		<button class="nav-link active" id="curso" href="#">Curso</button>
	</li>
	<li class="nav-item">
		<button class="nav-link active" id="materia" href="#">Matéria</button>
	</li>
	<li class="nav-item">
		<button class="nav-link active" id="aluno" href="#">Aluno</button>
	</li>
</ul>


<form class="professor" action="controller" method="post">
<input type="hidden" name="tarefa" id="tarefa" value="CadastroProfessor"/>

<h2> Cadastro de Professores </h2>
  <div class="form-group">
    <label for="exampleInputEmail1">Endereço de email</label>
    <input type="email" class="form-control" id="exampleInputEmail1" name="email" aria-describedby="emailHelp" placeholder="Email do professor">
    <small id="emailHelp" class="form-text text-muted">Nunca vamos compartilhar seu email, com ninguém.</small>
  </div>
  
  <div class="form-group">
    <label for="exampleInputEmail1">Apelido</label>
	<input class="form-control" type="text"  name="apelido" placeholder="Apelido do professor" required>   
    <small id="emailHelp" class="form-text text-muted">O apelido precisa ser unico e pode ser utilizado para login.</small>
  </div>
  
  <div class="form-group">
    <label for="exampleInputPassword1">Senha</label>
    <input type="password" class="form-control" name="senha" id="exampleInputPassword1" placeholder="Senha">
  </div>

  <button type="submit" class="btn btn-primary">Cadastrar professor!</button>
</form>



<form class="curso" action="controller" method="post">
<input type="hidden" name="tarefa" id="tarefa" value="CadastroCurso"/>

<h2> Cadastro de Cursos</h2>
  <div class="form-group">
    <label for="exampleInputEmail1">Endereço de email</label>
    <input type="email" class="form-control" id="exampleInputEmail1" name="email" aria-describedby="emailHelp" placeholder="Email do professor">
    <small id="emailHelp" class="form-text text-muted">Nunca vamos compartilhar seu email, com ninguém.</small>
  </div>
  
  <div class="form-group">
    <label for="exampleInputEmail1">Apelido</label>
	<input class="form-control" type="text"  name="apelido" placeholder="Apelido do professor" required>   
    <small id="emailHelp" class="form-text text-muted">O apelido precisa ser unico e pode ser utilizado para login.</small>
  </div>
  
  <div class="form-group">
    <label for="exampleInputPassword1">Senha</label>
    <input type="password" class="form-control" name="senha" id="exampleInputPassword1" placeholder="Senha">
  </div>

  <button type="submit" class="btn btn-primary">Cadastrar professor!</button>
</form>




<script src="https://code.jquery.com/jquery-3.3.1.slim.min.js"
	integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo"
	crossorigin="anonymous"></script>

<script>


function admProfessor() {
    
    
};

var btnProf =$("#botaoProfessor");
btnProf.on("click", function(e){
	e.preventDefault()
	$(".professor").toggleClass("d-none");	
})


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