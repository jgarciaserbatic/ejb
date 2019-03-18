<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" isELIgnored="false" %>
<%@ page import="com.ceoe.java.model.Person" %>
 
<jsp:useBean id="person" scope="page" class="com.ceoe.java.model.Person" />

<div id="person-form">
	<form method="post" action="${param.action}">
		<div class="row">
			<label for="id">Id.:</label>
			<input type="number" id="id" name="id" min="1" value ="${param.id}" />
		</div>
		<div class="row">
			<label for="firstName">First name:</label>
			<input type="text" id="firstName" name="firstName" value ="${persona.firstName}" />
		</div>
		<div class="row">
			<label for="lastName">Last name:</label>
			<input type="text" id="lastName" name="lastName" value ="${persona.lastName}" />
		</div>
		<div class="row">
			<label for="age">Age :</label>
			<input type="number" id="age" name="age" min="1" value ="${persona.age}" />
		</div>
		<div class="row">
			<input type="submit" value="Enviar" />
		</div>
	</form>
</div>