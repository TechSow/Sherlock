var form = document.querySelector("#formCadastroCurso");
var curso;
var nome = form.nome;
var dificuldade = form.dificuldade;
var urlimg = form.urlimg;
var descricao = form.descricao;
var duracao = form.duracao;
var materias = form.selectedMaterias;
var id_curso = form.id_curso;

$("#cursoOptionAtt").on("change", function(e) {
	var idCurso = this.options[this.selectedIndex].value;
	if(idCurso == ""){
		resetForm();
		return
	}
	var xhr = new XMLHttpRequest();
	xhr.open("post", "curso", true);
	xhr.setRequestHeader("Content-type", "application/x-www-form-urlencoded");
	xhr.addEventListener("load", function() {
		if (xhr.status == 200) {
			// Codigo de sucesso
			curso = JSON.parse(xhr.response);
			setForm(curso);
			configureCard(curso);
		} else {
			// Codigo de deu ruim!
			console.log(xhr.status);
			console.log(xhr.responseText);
		}
	});
	var data = "id=" + idCurso;
	xhr.send(data);
})

function setForm(curso) {
	nome.value = curso.nome;
	dificuldade.value = curso.dificuldade;
	urlimg.value = curso.urlImg;
	descricao.value = curso.descricao;
	duracao.value = curso.duracao;
	id_curso.value = curso.id_curso;
	setSelectedMaterias(curso);
}
function resetForm() {
	id_curso.value= null;
	nome.value="";
	dificuldade.value = null;
	urlimg.value="";
	descricao.value="";
	duracao.value=null;
	resetSelectedMaterias();
}

function setSelectedMaterias(curso){
	var values = curso.materias.map(function(i) {
		return i.id_materia
	});
	for (var j = 0; j < values.length; j++) {
		for (var i = 0; i < materias.options.length; i++) {
			if(values[j] == materias.options[i].value){
				materias.options[i].selected = true;
				break;
			}
		}
	}
}

function resetSelectedMaterias(){
	for (var i = 0; i < materias.options.length; i++) {
			materias.options[i].selected = false;
	}
}


function setCard(curso) {
	var card = document.querySelector(".material-card");
	card.querySelector("#nomeCurso").textContent = curso.nome;
	limparElemento(card.querySelector("#dificuldadeCurso"));
	for(var i = 0; i < curso.dificuldade; i++){
		card.querySelector("#dificuldadeCurso").appendChild(criarEstrela());
	}
	card.querySelector(".img-responsive").src = curso.urlImg;
	card.querySelector(".mc-description").textContent = curso.descricao;
}

function criarEstrela(){
	var i = document.createElement('i');
	i.classList.add('fa');
	i.classList.add('fa-star');
	return i
}

function limparElemento(element){
	for(var i = 0; i < element.childElementCount; i++){
		element.removeChild(element.childNodes[i]);
	}
}