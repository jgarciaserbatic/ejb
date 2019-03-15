<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
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
			</tbody>
		</table>
	<%} else { %>
		<span> No hay personas en BBDD </span>
	<%} %>
</div>