document.querySelector("#cursoOptionAtt").addEventListener("change", function(e){
	this.options[this.selectedIndex].value;
})

$("#cursoOptionAtt").on("change", function(e) {
	var xhr = new XMLHttpRequest();
	xhr.open("GET", "cursos", true);
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
	var data = "id_curso=" + this.options[this.selectedIndex].value; 
	xhr.send(data);
})

