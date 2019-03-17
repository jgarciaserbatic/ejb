<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" isELIgnored="false"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<title>Listado de personas</title>
</head>
<body>
	<div id="content">
		<form action="<%=request.getContextPath()%>/addPerson" method="GET">
			<input type="submit" value="Añadir persona" />
		</form>
		<br>
		<form action="<%=request.getContextPath()%>/findPerson" method="GET">
			<input type="text" id="firstName" name="firstName" />
			<input type="submit" value="Encontrar persona por nombre" />
		</form>
		<jsp:include page="../components/persons.jsp" />
	</div>
</body>
</html>