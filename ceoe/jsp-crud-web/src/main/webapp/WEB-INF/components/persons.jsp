<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ page isELIgnored="false" %>
<%@ page import="java.util.List" %>
<%@ page import="com.ceoe.java.model.*" %>

<div id="persons-list">
	<%
	List<Person> persons = (List<Person>) request.getAttribute("persons");
	if(persons.size() > 0) { 
	%>
		<table border=1>
			<thead>
				<tr>
					<td>ID</td>					
					<td>Nombre</td>
					<td>Apellidos</td>
					<td>Edad</td>
					<td colspan="2">Acciones</td>
				</tr>
			</thead>
			<tbody>
			<c:forEach var="person" items="${persons}">			
				<tr>	
					<td>${ person.getId() }</td>				
					<td>${ person.getFirstName() }</td>
					<td>${ person.getLastName() }</td>
					<td>${ person.getAge() }</td>
					<td><a href="${pageContext.request.contextPath}/editPerson?id=${person.getId()}" >Editar</a> </td>
					<td><a href="${pageContext.request.contextPath}/deletePerson?id=${person.getId()}" >Eliminar</a> </td>
				</tr>
			</c:forEach>	
			
			</tbody>
		</table>
	<%} else { %>
		<span> No hay personas en BBDD </span>
	<%} %>
</div>