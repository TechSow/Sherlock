var form = document.querySelector("#formCadastroCurso");
var curso;
var id_curso = form.id_curso;
var nome = form.nome;
var dificuldade = form.dificuldade;
var urlimg = form.urlimg;
var descricao = form.descricao;
var duracao = form.duracao;
var materias = form.selectedMaterias;
var btnExcluir = document.querySelector(".btn-danger");

$("#cursoOptionAtt").on("change", function(e) {
	var idCurso = this.options[this.selectedIndex].value || 0;
	var xhr = new XMLHttpRequest();
	xhr.open("post", "curso", true);
	xhr.setRequestHeader("Content-type", "application/x-www-form-urlencoded");
	xhr.addEventListener("load", function() {
		if (xhr.status == 200) {
			// Codigo de sucesso
			curso = JSON.parse(xhr.response);
			configureView(curso);
		} else {
			// Codigo de deu ruim!
			console.log(xhr.status);
			console.log(xhr.responseText);
		}
	});
	btnExcluir.style.display = "block"
	var data = "id=" + idCurso;
	xhr.send(data);
})

function configureView(curso) {
	configureForm(curso);
	configureCard(curso);
}
function configureForm(curso){
	id_curso.value = curso.id_curso;
	nome.value = curso.nome;
	dificuldade.value = curso.dificuldade;
	urlimg.value = curso.urlImg;
	descricao.value = curso.descricao;
	duracao.value = curso.duracao;
	setSelectedMaterias(curso);
}

function setSelectedMaterias(curso){
	var values = curso.materias.map(function(i) {
		return i.id_materia
	});
	for (var i = 0; i < materias.options.length; i++) {
		materias.options[i].selected = false;
	}
	for (var j = 0; j < values.length; j++) {
		for (var i = 0; i < materias.options.length; i++) {
			if(values[j] == materias.options[i].value){
				materias.options[i].selected = true;
				break;
			}
		}
	}
}

function configureCard(curso) {
	var card = document.querySelector(".material-card");
	card.querySelector("#nomeCurso").value = curso.nome;
	cleanElement(card.querySelector("#dificuldadeCurso"));
	for(var x = 0; x< curso.dificuldade ; x++){
		card.querySelector("#dificuldadeCurso").appendChild(generateStar());
	}
	
	card.querySelector(".img-responsive").src = curso.urlImg;
	card.querySelector(".mc-description").textContent = curso.descricao;
	
}

function cleanElement(element){
	if(element.hasChildNodes)
			for(var y = element.childElementCount; y!=-1; y--){
				if(element.children[y])
					element.removeChild(element.children[y]);
			}
		
}

function generateStar(){
	var i = document.createElement("i");
	i.classList.add("fa");
	i.classList.add("fa-star");
	return i;
}

btnExcluir.addEventListener("click", function(e){
	e.preventDefault();
	document.querySelector("#queroexcluir").value = "true";
	form.submit();
})


