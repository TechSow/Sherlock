<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:import url="partial/head.jsp" />

  <div class="main">
  	 
  </div>
  <div class="nav">
  <c:forEach var="curso" items="${cursos}">
  	<ul>
  		<li><a href="/sherlock/controller?tarefa=MateriaController&id_curso=${curso.id_curso}">${curso.nome}</a></li>
  	</ul>
  </c:forEach>
  </div>
  <div class="logo">
  	<h1>Seja bem vindo ${usuario.apelido}</h1>
  </div>
  <div class="header">
  
  </div>
  <div class="nav">
  
  </div>
  <div class="footer">
  
  </div>



</body>
</html>