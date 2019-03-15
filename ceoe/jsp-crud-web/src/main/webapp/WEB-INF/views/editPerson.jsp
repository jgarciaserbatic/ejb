<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" isELIgnored="false" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<title>Editar persona</title>
</head>
<body>
	<div id="content">
		<jsp:include page="../components/personForm.jsp">
			<jsp:param value="${pageContext.request.contextPath}/editPerson" name="action"/>
		</jsp:include>
	</div>
</body>
</html>