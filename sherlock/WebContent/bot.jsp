<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<c:import url="css/botcss.html" />
<!--
Inspired by https://dribbble.com/supahfunk
-->
<section class="avenue-messenger">
	<div class="menu">
		<div class="button"><i class="fa fa-angle-down" aria-hidden="true"></i></div>
	</div>
	<div class="agent-face">
		<div class="half">
			<img class="agent circle" src="/sherlock/assets/Sher.png" alt="Sher">
		</div>
	</div>
	<div class="chat">
		<div class="chat-title">
			<h1>Sher</h1>
			<h2>professor assistente</h2>
			<!--  <figure class="avatar">
      <img src="http://askavenue.com/img/17.jpg" /></figure>-->
		</div>
		<div class="messages">
			<div class="messages-content"></div>
		</div>
		<div class="message-box">
			<textarea type="text" class="message-input"
				placeholder="Type message..."></textarea>
			<button type="submit" class="message-submit"><i class="fa fa-paper-plane" aria-hidden="true"></i></button>
			<button type="submit" class="record"><i class="fa fa-microphone" aria-hidden="true"></i></button>
		</div>
	</div>
</section>
<script src="https://code.jquery.com/jquery-3.4.1.min.js"
	integrity="sha256-CSXorXvZcTkaix6Yvo6HppcZGetbYMGWSFlBw8HfCJo="
	crossorigin="anonymous"></script>
<script
	src="https://cdn.rawgit.com/mattdiamond/Recorderjs/08e7abd9/dist/recorder.js"></script>
<!-- Para a versão dois utilizar o script main.js -->
<script type="text/javascript" src="scripts/assistant.js"></script>
<script type="text/javascript" src="scripts/tts.js"></script>
<script type="text/javascript" src="scripts/stt.js"></script>
