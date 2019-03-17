<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page isELIgnored="false"%>

<div id="persons-list">
	<c:if test="${not empty persons}">
		<table>
			<thead>
				<tr>
					<td>Id.</td>
					<td>Documento</td>
					<td>Nombre</td>
					<td>Apellidos</td>
					<td>Edad</td>
					<td>Acciones</td>
				</tr>
			</thead>
			<tbody>
				<c:forEach items="${persons}" var="person">
					<tr>
						<td>${person.id}</td>
						<td>${person.identityDoc}</td>
						<td>${person.firstName}</td>
						<td>${person.lastName}</td>
						<td>${person.age}</td>
						<td>
							<form method="GET"
								action="${pageContext.request.contextPath}/editPerson">
								<input type="hidden" id="id" name="id" value="${person.id}" />
								<c:catch var="exception">${person.idEmployee}</c:catch>
								<c:if test="${empty exception}">
									<input type="hidden" id="EMP" name="EMP" />
								</c:if>
								<input type="Submit" value="Editar" />
							</form>
						</td>
						<td>
							<form method="POST"
								action="${pageContext.request.contextPath}/deletePerson">
								<input type="hidden" id="id" name="id" value="${person.id}" />
								<input type="Submit" value="Eliminar" />
							</form>
						</td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
	</c:if>
	<c:if test="${empty persons}">
		<span> No hay personas en BBDD </span>
	</c:if>
</div>