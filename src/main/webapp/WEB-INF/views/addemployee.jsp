<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib uri="http://www.springframework.org/tags/form"
	prefix="springForm"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Employee Save Page</title>
<style>
.error {
	color: #ff0000;
	font-style: italic;
	font-weight: bold;
}
</style>
</head>
<body>
	<div align="center">
		<h1 style="background-color: lightgreen; color: darkgreen">Add 	New Employee Page</h1>
		<table width="80%" align="center">
			<tr bgcolor="lightblue">
				<td align="left"><a href="listemployee"
					style="background-color: lightblue;"> List Employee </a></td>
				<td align="right"><a
					href="${pageContext.request.contextPath}/logout">Logout</a></td>
			</tr>
		</table>
	</div>

	<springForm:form method="POST" commandName="employee" action="updatemployee">
		<table>
			<tr>
				<td>First Name:</td>
				<td><springForm:input path="firstName" /></td>
				<td><springForm:errors path="firstName" cssClass="error" /></td>
			</tr>
			<tr>
				<td>Last Name:</td>
				<td><springForm:input path="lastName" /></td>
				<td><springForm:errors path="lastName" cssClass="error" /></td>
			</tr>
			<tr>
				<td>Job Title :</td>
				<td><springForm:input path="jobTitle" /></td>
				<td><springForm:errors path="jobTitle" cssClass="error" /></td>
			</tr>
			<tr>
				<td>Department :</td>
				<td><springForm:input path="department" /></td>
				<td><springForm:errors path="department" cssClass="error" /></td>
			</tr>
			<tr>
				<td>Salary :</td>
				<td><springForm:input path="salary" /></td>
				<td><springForm:errors path="salary" cssClass="error" /></td>
			</tr>

			<tr>
				<td colspan="3"><input type="submit" value="Save"></td>
			</tr>
		</table>

	</springForm:form>

</body>
</html>