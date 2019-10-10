$(document).ready(function(){
	callBot("");
})
function callBot(msg) {
	var xhr = new XMLHttpRequest();
	xhr.open("POST", "assistant", true);
	xhr.setRequestHeader("Content-type", "application/x-www-form-urlencoded");
	xhr.addEventListener("load", function() {
		if (xhr.status == 200) {
			// Codigo de sucesso
			var respostas = JSON.parse(xhr.responseText);
			setMessage(respostas[0].text, "bot");
			
		} else {
			// Codigo de deu ruim!
			console.log(xhr.status);
			console.log(xhr.responseText);
		}
	});
	xhr.addEventListener("progress",
			function() {
						$('<div class="message loading new"><figure class="avatar"><img src="/sherlock/assets/Sher.png" /></figure><span></span></div>')
								.appendTo($('.messages-content'));
						//updateScrollbar();

					});
	var data = "question=" + msg;
	xhr.send(data);
}

var $messages = $('.messages-content'), d, h, m;

//$(document).ready(function() {
//	callBot("");
//});

function updateScrollbar() {
	var div = document.querySelector(".messages-content");
	for (var i = 0; i < div.offsetHeight; i++) {
		div.scrollTop++;
	}
}

function setDate() {
	d = new Date()
	if (m != d.getMinutes()) {
		m = d.getMinutes();
		$('<div class="timestamp">' + d.getHours() + ':' + m + '</div>')
				.appendTo($('.message:last'));
		$('<div class="checkmark-sent-delivered">&check;</div>').appendTo(
				$('.message:last'));
		$('<div class="checkmark-read">&check;</div>').appendTo(
				$('.message:last'));
	}
}

function insertMessage() {
	msg = $('.message-input').val();
	if ($.trim(msg) == '') {
		return false;
	}
	$('<div class="message message-personal">' + msg + '</div>').appendTo(
			$('.messages-content')).addClass('new');
	setDate();
	$('.message-input').val('');
	updateScrollbar();
	callBot(msg);
}

$('.message-submit').click(function() {
	insertMessage();
});

$(window).on('keydown', function(e) {
	if (e.which == 13) {
		insertMessage();
		return false;
	}
})

function setMessage(response) {
	if ($('.message-input').val() != '') {
		return false;
	}

	updateScrollbar();
	$('.message.loading').remove();
	$(
			'<div class="message new"><figure class="avatar"><img src="/sherlock/assets/Sher.png" /></figure>'
					+ response + '</div>').appendTo($('.messages-content'))
			.addClass('new');
	setDate();
	updateScrollbar();


}

$('.button').click(function() {
	$('.avenue-messenger').toggleClass('demonstrated');
	$('.fa-angle-down').toggleClass('rotate-this')
});


