<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:forEach var="curso" items="${cursos}">
    <div class="col-md-3 col-sm-6 col-xs-12">
            <article class="material-card Blue-Grey">
                <h2>
                    <span>${curso.nome}</span>
                    <strong>
                    <c:forEach var="i" begin="1" end="${curso.dificuldade}">
         			    <i class="fa fa-star"></i>
      				</c:forEach>
                        Dificuldade                        
                    </strong>
                </h2>
                <div class="mc-content">
                    <div class="img-container">
                        <img class="img-responsive" src="${curso.urlImg}">
                    </div>
                    <div class="mc-description">
                        ${curso.descricao}
                    </div>
                </div>
                <a class="mc-btn-action">
                    <i class="fa fa-bars"></i>
                </a>
                <div class="mc-footer">
                    <h4>
                        aprender
                    </h4>
                    <a href="/sherlock/controller?tarefa=CursoController&id_curso=${curso.id_curso}"><i class="fa fa-play" aria-hidden="true"></i></a>
                </div>
            </article>
        </div>
</c:forEach>

<script src="https://code.jquery.com/jquery-3.3.1.slim.min.js"
	integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo"
	crossorigin="anonymous"></script>

<script>
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