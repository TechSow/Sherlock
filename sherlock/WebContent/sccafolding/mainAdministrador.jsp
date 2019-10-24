<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<script
	src="https://cdnjs.cloudflare.com/ajax/libs/chosen/1.4.2/chosen.jquery.min.js"></script>
<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/chosen/1.4.2/chosen.min.css">


<style>
.container {
	max-width: 100% !important;
}

.multiselect {
	width: 200px;
}

.selectBox {
	position: relative;
}

.selectBox select {
	width: 100%;
	font-weight: bold;
}

.overSelect {
	position: absolute;
	left: 0;
	right: 0;
	top: 0;
	bottom: 0;
}
</style>
<div class="row">
	<ul class="nav nav-tabs col-12 col-sm-12">
		<c:if test="${usuario.adm == 1 }">

			<li class="nav-item">
				<button class="nav-link active" id="botaoProfessor"
					onclick="admProfessor()">Professor</button>
			</li>

			<li class="nav-item">
				<button class="nav-link active" id="aluno" onclick="admAluno()">Aluno</button>
			</li>
		</c:if>

		<li class="nav-item">
			<button class="nav-link active" id="curso" onclick="admCurso()">Curso</button>
		</li>
		<li class="nav-item">
			<button class="nav-link active" id="materia" onclick="admMateria()">Matéria</button>
		</li>
	</ul>
</div>
<div class="row d-flex justify-content-center align-items-center">
	<c:import url="sccafolding/cadastroCurso.jsp" />
	<c:import url="sccafolding/cadastroMateria.jsp" />
	<c:import url="sccafolding/cadastroProfessor.html" />
	<c:import url="sccafolding/cadastroAluno.html" />
</div>

<script src="https://code.jquery.com/jquery-3.3.1.slim.min.js"
	integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo"
	crossorigin="anonymous"></script>

<script>
	var p = document.querySelector(".professor");
	var c = document.querySelector(".curso");
	var cc = document.querySelector("#cardcursotunado")
	var m = document.querySelector(".materia");
	var a = document.querySelector(".aluno");
	var uc = document.querySelector(".updateCurso");
	var um = document.querySelector(".updateMateria");
	cc.style.display = "none";
	function admProfessor() {

		if (p.style.display === "none") {
			p.style.display = "block";
			c.style.display = "none";
			m.style.display = "none";
			a.style.display = "none";
			cc.style.display = "none";
			um.style.display = "none";
		}
	}

	function admCurso() {
		if (c.style.display === "none") {
			p.style.display = "none";
			c.style.display = "block";
			m.style.display = "none";
			a.style.display = "none";
			cc.style.display = "flex";
			um.style.display = "none";

		}
	}

	function admMateria() {
		if (m.style.display === "none") {
			p.style.display = "none";
			m.style.display = "block";
			c.style.display = "none";
			a.style.display = "none";
			cc.style.display = "none";
			um.style.display = "block";

		}

	}

	function admAluno() {
		if (a.style.display === "none") {
			p.style.display = "none";
			m.style.display = "none";
			c.style.display = "none";
			a.style.display = "block";
			cc.style.display = "none";
			um.style.display = "none";

		}
	}

	var expanded = false;

	function showCheckboxes() {
		var checkboxes = document.getElementById("checkboxes");
		if (!expanded) {
			checkboxes.style.display = "block";
			expanded = true;
		} else {
			checkboxes.style.display = "none";
			expanded = false;
		}
	}

	$(function() {
		$('.material-card > .mc-btn-action').click(
				function() {
					var card = $(this).parent('.material-card');
					var icon = $(this).children('i');
					icon.addClass('fa-spin-fast');

					if (card.hasClass('mc-active')) {
						card.removeClass('mc-active');

						window.setTimeout(function() {
							icon.removeClass('fa-arrow-left').removeClass(
									'fa-spin-fast').addClass('fa-bars');

						}, 800);
					} else {
						card.addClass('mc-active');

						window.setTimeout(function() {
							icon.removeClass('fa-bars').removeClass(
									'fa-spin-fast').addClass('fa-arrow-left');

						}, 800);
					}
				});
	});
</script>