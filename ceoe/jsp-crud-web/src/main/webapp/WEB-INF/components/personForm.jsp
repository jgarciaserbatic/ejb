<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" isELIgnored="false" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<div id="person-form">
	<form method="post" action="${param.action}">
		<div class="row">
			<label for="id">Id.:</label>
			<input type="number" id="id" name="id" min="1" value="${person.id}"/>
		</div>
		<div class="row">
			<label for="firstName">First name:</label>
			<input type="text" id="firstName" name="firstName" value="${person.firstName}"  />
		</div>
		<div class="row">
			<label for="lastName">Last name:</label>
			<input type="text" id="lastName" name="lastName" value="${person.lastName}" />
		</div>
		<div class="row">
			<label for="age">Age :</label>
			<input type="number" id="age" name="age" min="1" value="${person.age}" />
		</div>
		<div class="row">
		
		
		<c:if test="${person.id > 0}">
			<input type="submit" value="Actualizar" />
		</c:if>
		<c:if test="${person.id == null}">
			<input type="submit" value="Añadir" />
		</c:if>
		</div>
	</form>
</div>