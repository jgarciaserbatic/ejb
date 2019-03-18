<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" isELIgnored="false"%>
<%@ page import="com.ceoe.java.model.Person"%>

<jsp:useBean id="person" scope="page" class="com.ceoe.java.model.Person" />
<%
	int id = 1;
	String firstName = "";
	String lastName = "";
	int age = 1;
	if (request.getAttribute("person") != null) {
		person = (Person) request.getAttribute("person");
		id = person.getId();
		firstName = person.getFirstName();
		lastName = person.getLastName();
		age = person.getAge();
	}
%>
<div id="person-form">
	<form method="POST" action="${param.action}">
		<div class="row">
			<label for="id">Id.:</label> <input value="<%=id %>" type="number" id="id" name="id"
				min="1" />
		</div>
		<div class="row">
			<label for="firstName">First name:</label> <input value="<%=firstName %>" type="text"
				id="firstName" name="firstName" />
		</div>
		<div class="row">
			<label for="lastName">Last name:</label> <input  value="<%=lastName %>" type="text"
				id="lastName" name="lastName"/>
		</div>
		<div class="row">
			<label for="age">Age :</label> <input value="<%=age %>" type="number" id="age"
				name="age" min="1"/>
		</div>
		<div class="row">
			<input type="submit" value="Enviar" />
		</div>
	</form>
</div>