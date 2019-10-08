function scrollDivDown(div){
	for(var i = 0; i< div.offsetHeight; i++){
		div.scrollTop++;
	}
}

function createMessage(message, type){
	let chat = document.querySelector(".bot-body");
	let div = createDiv(message, type);
	chat.appendChild(div);
	scrollDivDown(chat);
}

function createDiv(text, type){
	let div = document.createElement("div");
	div.classList.add("chat");
	div.classList.add("type");
	div.textContet = text;
	return div;
}
let btnSendQuestion = document.querySelector(".fa-paper-plane");
btnSendQuestion.addEventListener("click", function(){
	event.preventDefault();
})
