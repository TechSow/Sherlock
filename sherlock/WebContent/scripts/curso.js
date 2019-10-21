$("#cursoOptionAtt").on("click", function(e) {
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
	var data = "id_curso=" + 47; 
	xhr.send(data);
})

$('#cursoOptionAtt').change(function() {
    var val = $("#cursoOptionAtt option:selected").text();
    alert(val);
});