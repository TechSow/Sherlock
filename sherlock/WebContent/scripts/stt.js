
//webkitURL é legado 
URL = window.URL || window.webkitURL;
// stream é criado a partir getUserMedia()
var gumStream;
// Objeto do Record.js
var rec;
// MediaStreamAudioSourceNode
var input;
// criar novo AudioContext
var AudioContext = window.AudioContext || window.webkitAudioContext; // Classe
var audioContext; // objeto
// selecionar os botoes

$(".record").on("mousedown", function(e){
	e.preventDefault();
	
	constraints = {
			audio : true,
			video : false
	}
	navigator.mediaDevices.getUserMedia(constraints).then(function(stream) {
		audioContext = new AudioContext;
		gumStream = stream;
		input = audioContext.createMediaStreamSource(stream);
		rec = new Recorder(input, {
			numChannels : 1
		});
		rec.record();
	}).catch(function(err){
		console.log(err);
		btnRecord.disabled = false;
		btnPause.disabled = true;
		btnStop.disabled = true;
	});
	
})

$(".record").on("mouseup", function(e){
	e.preventDefault();
	rec.stop();
	gumStream.getAudioTracks()[0].stop();
	rec.exportWAV(generateBlob);
})

function generateBlob(blob) {
	createAudioElement(blob);
	sendBlob(blob);
}

function sendBlob(blob) {
	var xhr = new XMLHttpRequest();
	xhr.open("POST", "responseAudio", true);
	xhr.setRequestHeader("Content-type", "audio/wav");
	xhr.addEventListener("load", function() {
		if(xhr.status == 200) {
			//console.log(JSON.parse(xhr.responseText)[0].alternatives.forEach(t =>{console.log(t.transcript)}))
			// Deu bom
			var blob = new Blob([xhr.response], {type : "audio/wav"});
			console.log(blob);
			createAudioElement(blob);
		} else {
			// Deu ruim
			console.log(xhr.status);
			console.log(xhr.responseText);
		}
	});
	xhr.responseType = 'blob';
	xhr.send(blob);
}

function createAudioElement(blob) {
	var url = URL.createObjectURL(blob);
	var audio = document.createElement("audio");
	var div = document.createElement("div");
	
	audio.controls = true;
	audio.src = url;
	
	div.appendChild(audio);
	var chat = document.querySelector(".messages-content");
	chat.appendChild(div);
	updateScrollbar();
}


