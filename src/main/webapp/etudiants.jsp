<%@ page language ="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>



<html>


<head>
<title>Title</title>
<link href="css/bootstrap.min.css" rel="stylesheet" type="text/css">
</head>
<body>
<%@include file="header.jsp" %>
<div class="container">
<div class="card">


<div class="card-header">
Rechercher Etudiants
</div>

<!-- Search Bar -->
<div class ="card-body">
<form action="chercher.do" method="get">
<label>Departement</label>
<input type ="text" name="motCle" value =" ${model.rechercheDpt}">
<button type="submit" class="btn btn-primary">Chercher</button>
</form>

<!-- Data Table -->
<table class="table table-striped">

<!-- Table Header -->
<tr>
<th>ID</th> <th>Nom</th> <th>Prenom</th> <th>Departement</th>
</tr>
<!-- Table Iterator -->
<c:forEach  items="${model.ets}" var ="p">
<tr>

<td>${p.id}</td>
<td>${p.nom}</td>
<td>${p.prenom}</td>
<td>${p.departement}</td>
<td><a onclick="return confirm('Etes-vous sûr ?')" href="supprimer.do?id=${p.id }">Supprimer</a></td>
<td><a href="editer.do?id=${p.id }">Edit</a></td>
</tr>






</c:forEach>

</table>




</div>


</div>
</div>


</body>

</html>