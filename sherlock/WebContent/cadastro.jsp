<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>Cadastro</title>
	<c:import url="partial/bootstrap.html"/>
	<link rel="stylesheet" href="css/toast.css">
	<link rel="stylesheet" href="css/login.css">
</head>
<!--  https://codepen.io/marcobiedermann/pen/Fybpf -->
<body class="align">

  <div class="grid">

    <form action="controller" method="POST" class="form login">
	<input type="hidden" name="tarefa" id="tarefa" value="CadastroUsuario" />
	<input type="hidden" name="from" value="3" />
    	

      <div class="form__field">
        <label style="margin-bottom:0 !important"for="login__username"><svg class="icon"><use xmlns:xlink="http://www.w3.org/1999/xlink" xlink:href="#user"></use></svg><span class="hidden">Email</span></label>
        <input id="login__username" type="text" name="email" class="form__input" placeholder="Email" required>
      </div>

      <div class="form__field">
        <label style="margin-bottom:0 !important"for="login__username"><svg class="icon"><use xmlns:xlink="http://www.w3.org/1999/xlink" xlink:href="#user"></use></svg><span class="hidden">Email</span></label>
        <input id="login__username" type="text" name="apelido" class="form__input" placeholder="Apelido" required>
      </div>
      
       <div class="form__field">
        <label style="margin-bottom:0 !important"for="login__password"><svg class="icon"><use xmlns:xlink="http://www.w3.org/1999/xlink" xlink:href="#lock"></use></svg><span class="hidden">Password</span></label>
        <input id="login__password" type="password" name="senha" class="form__input" placeholder="Senha" minlength=6 required>
      </div>


      <div class="form__field">
        <label style="margin-bottom:0 !important"for="login__password"><svg class="icon"><use xmlns:xlink="http://www.w3.org/1999/xlink" xlink:href="#lock"></use></svg><span class="hidden">Password</span></label>
        <input id="login__password" type="password" name="confirmarSenha" class="form__input" placeholder="Confirmar senha" required>
      </div>
      

      <div class="form__field">
        <input type="submit" value="Cadastrar">
      </div>

    </form>
    
    <p class="text--center">Ja possui login? <a href="login.jsp"> ir para login</a> <svg class="icon"><use xmlns:xlink="http://www.w3.org/1999/xlink" xlink:href="assets/images/icons.svg#arrow-right"></use></svg></p>
    
  </div>

  <svg xmlns="http://www.w3.org/2000/svg" class="icons"><symbol id="arrow-right" viewBox="0 0 1792 1792"><path d="M1600 960q0 54-37 91l-651 651q-39 37-91 37-51 0-90-37l-75-75q-38-38-38-91t38-91l293-293H245q-52 0-84.5-37.5T128 1024V896q0-53 32.5-90.5T245 768h704L656 474q-38-36-38-90t38-90l75-75q38-38 90-38 53 0 91 38l651 651q37 35 37 90z"/></symbol><symbol id="lock" viewBox="0 0 1792 1792"><path d="M640 768h512V576q0-106-75-181t-181-75-181 75-75 181v192zm832 96v576q0 40-28 68t-68 28H416q-40 0-68-28t-28-68V864q0-40 28-68t68-28h32V576q0-184 132-316t316-132 316 132 132 316v192h32q40 0 68 28t28 68z"/></symbol><symbol id="user" viewBox="0 0 1792 1792"><path d="M1600 1405q0 120-73 189.5t-194 69.5H459q-121 0-194-69.5T192 1405q0-53 3.5-103.5t14-109T236 1084t43-97.5 62-81 85.5-53.5T538 832q9 0 42 21.5t74.5 48 108 48T896 971t133.5-21.5 108-48 74.5-48 42-21.5q61 0 111.5 20t85.5 53.5 62 81 43 97.5 26.5 108.5 14 109 3.5 103.5zm-320-893q0 159-112.5 271.5T896 896 624.5 783.5 512 512t112.5-271.5T896 128t271.5 112.5T1280 512z"/></symbol></svg>

</body>
	
<!-- references code pen https://codepen.io/kipp0/pen/pPNrrj -->
<c:if test="${not empty erro}">

    <div id="toast">
        <i class="fa fa-${erro[3]} text-${erro[1] }" id="img" aria-hidden="true"></i>

        <div id="desc" class="bg-${erro[1] }">${erro[0]}</div>
    </div>
    <script>
        function launch_toast() {
            var toast = document.querySelector("#toast");
            if (!(toast === undefined)) {
                toast.classList.add("show");
                setTimeout(function() {
                    toast.className = toast.classList.remove("show");
                }, 5000);
            }
        }
        window.onload = function() {
            launch_toast();
        }
    </script>

</c:if>


</body>
</html>