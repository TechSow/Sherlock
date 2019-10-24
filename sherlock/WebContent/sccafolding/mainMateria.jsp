<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:forEach var="materia" items="${materias}">

	<div class="card">
     <div class="card__image-container">
       <img class="card__image" src="${materia.urlImg} " alt="">
    </div>
      
      <svg class="card__svg" viewBox="0 0 800 500">

        <path d="M 0 100 Q 50 200 100 250 Q 250 400 350 300 C 400 250 550 150 650 300 Q 750 450 800 400 L 800 500 L 0 500" stroke="transparent" fill="#333"/>
        <path class="card__line" d="M 0 100 Q 50 200 100 250 Q 250 400 350 300 C 400 250 550 150 650 300 Q 750 450 800 400" stroke="pink" stroke-width="3" fill="transparent"/>
      </svg>
    
     <div class="card__content">
       <h1 class="card__title">${materia.nome}</h1>
     <p>${materia.ementa}</p>
     <a href="/sherlock/controller?tarefa=MateriaController&id_materia=${materia.id_materia}" class="btn btn-primary">Iniciar</a>
    </div>
  </div>

</c:forEach>

<script src="https://code.jquery.com/jquery-3.3.1.slim.min.js"
	integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo"
	crossorigin="anonymous"></script>

<style>

.card {
	font-family: 'Open Sans', sans-serif;
  position: relative;
  background: #333;
  width: 400px;
  height: 600px;
  border-radius: 6px;
  padding: 2rem;
  color: #aaa;
  box-shadow: 0 0.25rem 0.25rem rgba(0, 0, 0, 0.2), 0 0 1rem rgba(0, 0, 0, 0.2);
  overflow: hidden;
  margin:20px;
}
.card__image-container {
  margin: -2rem -2rem 1rem -2rem;
}
.card__line {
  opacity: 0;
  animation: LineFadeIn .8s .8s forwards ease-in;
}
.card__image {
  opacity: 0;
  animation: ImageFadeIn .8s 1.4s forwards;
  height:320px;
}
.card__title {
  color: white;
  margin-top: 0;
  font-weight: 800;
  letter-spacing: 0.01em;
}
.card__content {
  margin-top: -1rem;
  opacity: 0;
  animation: ContentFadeIn .8s 1.6s forwards;
}
.card__svg {
  position: absolute;
  left: 0;
  top: 115px;
}

@keyframes LineFadeIn {
  0% {
    opacity: 0;
    d: path("M 0 300 Q 0 300 0 300 Q 0 300 0 300 C 0 300 0 300 0 300 Q 0 300 0 300 ");
    stroke: #fff;
  }
  50% {
    opacity: 1;
    d: path("M 0 300 Q 50 300 100 300 Q 250 300 350 300 C 350 300 500 300 650 300 Q 750 300 800 300");
    stroke: #888BFF;
  }
  100% {
    opacity: 1;
    d: path("M -2 100 Q 50 200 100 250 Q 250 400 350 300 C 400 250 550 150 650 300 Q 750 450 802 400");
    stroke: #545581;
  }
}
@keyframes ContentFadeIn {
  0% {
    transform: translateY(-1rem);
    opacity: 0;
  }
  100% {
    transform: translateY(0);
    opacity: 1;
  }
}
@keyframes ImageFadeIn {
  0% {
    transform: translate(-0.5rem, -0.5rem) scale(1.05);
    opacity: 0;
    filter: blur(2px);
  }
  50% {
    opacity: 1;
    filter: blur(2px);
  }
  100% {
    transform: translateY(0) scale(1);
    opacity: 1;
    filter: blur(0);
  }
}
	
</style>