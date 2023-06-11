<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>

<head>
<title>Application de gestion d'autorisations</title>
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css"
	integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T"
	crossorigin="anonymous">
</head>

<body>

	<header>
		<nav class="navbar navbar-expand-md navbar-dark"
			style="background-color: black">
			<div>
				<a href="" class="navbar-brand"> Application de gestion
					d'autorisations </a>
			</div>

			<ul class="navbar-nav">
				<li><a href="<%=request.getContextPath()%>/list"
					class="nav-link">Enseignants</a></li>
			</ul>
		</nav>
	</header>
	<br>
	<div class="container col-md-5">
		<div class="card">
			<div class="card-body">
				<c:if test="${user != null}">
					<form action="autoriser" method="post">
				</c:if>
				<c:if test="${user == null}">
					<form action="insert" method="post">
				</c:if>

				<caption>
					<h2>
						<c:if test="${user != null}">
                                    Autoriser Enseignant
                                </c:if>
						<c:if test="${user == null}">
                                    Ajouter un nouveau enseignant
                                </c:if>
					</h2>
				</caption>

				<c:if test="${user != null}">
					<input type="hidden" name="id" value="<c:out value='${user.id}' />" />
				</c:if>

				<fieldset class="form-group">
					<label>Nom d'enseignant</label> <input type="text"
						value="<c:out value='${user.name}' />" class="form-control"
						name="name" required="required">
				</fieldset>

				<fieldset class="form-group">
					<label>E-mail de l'enseignant</label> <input type="text"
						value="<c:out value='${user.email}' />" class="form-control"
						name="email">
				</fieldset>

				<fieldset class="form-group">
					<label>Institution de l'enseignant</label> <input type="text"
						value="<c:out value='${user.institution}' />" class="form-control"
						name="institution">
				</fieldset>

				<fieldset class="form-group">
					<label>Description</label> <input type="text"
						value="L'enseignant <c:out value='${user.name}'/> de l'institution <c:out value='${user.institution}'/> est autorise a faire des activites extra-professionelles."
						class="form-control" name="description">
				</fieldset>

				<button type="submit" class="btn btn-success">Imprimer</button>
				</form>
			</div>
		</div>
	</div>
</body>

</html>