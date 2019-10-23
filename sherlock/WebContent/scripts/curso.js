var form = document.querySelector("#formCadastroCurso");
var nome = form.nome;
var dificuldade = form.dificuldade;
var urlimg = form.urlimg;
var descricao = form.descricao;
var duracao = form.duracao;
var materias = form.selectedMaterias;

console.log(nome);
console.log(dificuldade);
console.log(urlimg);
console.log(descricao);
console.log(duracao);
console.log(materias);

document.querySelector("#cursoOptionAtt").addEventListener("change", function(e){
	this.options[this.selectedIndex].value;
})

$("#cursoOptionAtt").on("change", function(e) {
	var xhr = new XMLHttpRequest();
	xhr.open("post", "curso", true);
	xhr.setRequestHeader("Content-type", "application/x-www-form-urlencoded");
	xhr.addEventListener("load", function() {
		if (xhr.status == 200) {
			// Codigo de sucesso
			console.log(xhr.response)
		} else {
			// Codigo de deu ruim!
			console.log(xhr.status);
			console.log(xhr.responseText);
		}
	});
	var data = "id=" + this.options[this.selectedIndex].value; 
	xhr.send(data);
})
function configureView(){
	
}