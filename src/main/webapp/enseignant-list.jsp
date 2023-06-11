<%@ page language="java" contentType="text/html; charset=UTF-8"
 pageEncoding="UTF-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
        <html>

        <head>
            <title>Application d'autorisation d'enseignants</title>
            <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
        </head>

        <body>

            <header>
                <nav class="navbar navbar-expand-md navbar-dark" style="background-color: black">
                    <div>
                        <a href="" class="navbar-brand"> Application de gestion d'autorisations</a>
                    </div>

                    <ul class="navbar-nav">
                        <li><a href="<%=request.getContextPath()%>/list" class="nav-link">Enseignants</a></li>
                    </ul>
                </nav>
            </header>
            <br>

            <div class="row">
                <!-- <div class="alert alert-success" *ngIf='message'>{{message}}</div> -->

                <div class="container">
                    <h3 class="text-center">Liste d'enseignants</h3>
                    <hr>
                    <div class="container text-left">

                        <a href="<%=request.getContextPath()%>/new" class="btn btn-success">Ajouter un nouvel enseignant</a>
                    </div>
                    <br>
                    <table class="table table-bordered">
                        <thead>
                            <tr>
                                <th>ID</th>
                                <th>Nom</th>
                                <th>E-mail</th>
                                <th>Institution</th>
                                <th>Actions</th>
                            </tr>
                        </thead>
                        <tbody>
                            <!--   for (Todo todo: todos) {  -->
                            <c:forEach var="enseignant" items="${listEnseignant}">

                                <tr>
                                    <td>
                                        <c:out value="${enseignant.id}" />
                                    </td>
                                    <td>
                                        <c:out value="${enseignant.name}" />
                                    </td>
                                    <td>
                                        <c:out value="${enseignant.email}" />
                                    </td>
                                    <td>
                                        <c:out value="${enseignant.institution}" />
                                    </td>
                                    <td><a href="autorisation?id=<c:out value='${enseignant.id}' />">Autoriser</a> <a href="edit?id=<c:out value='${enseignant.id}' />">Modifier</a> &nbsp;&nbsp;&nbsp;&nbsp; <a href="delete?id=<c:out value='${enseignant.id}' />">Supprimer</a></td>
                                </tr>
                            </c:forEach>
                            <!-- } -->
                        </tbody>

                    </table>
                </div>
            </div>
        </body>

        </html>