<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"
	isELIgnored="false"%>
<div id=employee-form">
	<form method="post" action="${param.action}">
		<div class="row">
			<label for="id">Id. Empleado:</label> <input type="number"
				id="idEmployee" name="id" min="1" value="${person.idEmployee}" />
		</div>
		<div class="row">
			<label for="identityDoc">Cargo:</label> <input type="text"
				id="position" name="position" value="${person.position}" />
		</div>
		<div class="row">
			<label for="id">Id.:</label> <input type="number" id="id" name="id"
				min="1" value="${person.id}" />
		</div>
		<div class="row">
			<label for="identityDoc">Identity Document:</label> <input type="text"
				id="identityDoc" name="identityDoc" value="${person.identityDoc}" />
		</div>
		<div class="row">
			<label for="firstName">First name:</label> <input type="text"
				id="firstName" name="firstName" value="${person.firstName}" />
		</div>
		<div class="row">
			<label for="lastName">Last name:</label> <input type="text"
				id="lastName" name="lastName" value="${person.lastName}" />
		</div>
		<div class="row">
			<label for="age">Age :</label> <input type="number" id="age"
				name="age" min="1" value="${person.age}" />
		</div>
		<div class="row">
			<input type="submit" value="Enviar" />
		</div>
	</form>
</div>