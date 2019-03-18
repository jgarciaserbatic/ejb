<%@ taglib uri="http://java.sun.com/jsp/jstl/core"  prefix="c"  %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt"  prefix="fmt"  %>
<%@ page isELIgnored="false" %>
<%@ page import="java.util.List" %>
<%@ page import="com.ceoe.java.model.*" %>

<div id="persons-list">
	<%
	List<Person> persons = (List<Person>) request.getAttribute("persons");
	if(persons.size() > 0) { 
	%>
		<table>
			<thead>
				<tr>
					<td>Id.</td>
					<td>Nombre</td>
					<td>Apellidos</td>
					<td>Edad</td>
					<td>Acciones</td>
				</tr>
			</thead>
			<tbody>
			<% for(Person person: persons) {%>
				<tr>
					<td><%= person.getId() %></td>
					<td><%= person.getFirstName() %></td>
					<td><%= person.getLastName() %></td>
					<td><%= person.getAge() %></td>
					<td>
						<form method="get" action="${pageContext.request.contextPath}/editPerson">
							<input type="hidden" id="id" name="id" value="<%=person.getId()%>" />
							<input type="Submit" value="Editar" />
						</form>
						<form method="post" action="${pageContext.request.contextPath}/deletePerson">
							<input type="hidden" id="id" name="id" value="<%=person.getId()%>" />
							<input type="Submit" value="Borrar" />
						</form>
					</td>
				</tr>
			<% } %>
			</tbody>
		</table>
	<%} else { %>
		<span> No hay personas en BBDD </span>
	<%} %>
</div>