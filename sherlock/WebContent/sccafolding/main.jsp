<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>



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

<form class="professor" >
  <div class="form-group">
    <label for="exampleInputEmail1">Endereço de email</label>
    <input type="email" class="form-control" id="exampleInputEmail1" aria-describedby="emailHelp" placeholder="Seu email">
    <small id="emailHelp" class="form-text text-muted">Nunca vamos compartilhar seu email, com ninguém.</small>
  </div>
  <div class="form-group">
    <label for="exampleInputPassword1">Senha</label>
    <input type="password" class="form-control" id="exampleInputPassword1" placeholder="Senha">
  </div>

  <button type="submit" class="btn btn-primary">Enviar</button>
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