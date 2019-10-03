
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:import url="partial/head.jsp" />





  <div class="main">
  	<h1>Seja bem vindo ${usuario.apelido}</h1>
  </div>
  <div class="nav">
  <c:forEach var="curso" items="${cursos}">
  	<ul>
  		<li>${curso.nome}</li>
  	</ul>
  </c:forEach>
  </div>
  <div class="logo">
  
  </div>
  <div class="header">
  
  </div>
  <div class="nav">
  
  </div>
  <div class="footer">
  
  </div>



</body>
</html>