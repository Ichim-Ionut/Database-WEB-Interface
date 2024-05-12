<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page language="java"
	import="java.lang.*,java.math.*,db.*,java.sql.*, java.io.*, java.util.*"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Tabela Studenti</title>
</head>
<jsp:useBean id="jb" scope="session" class="db.JavaBean" />
<jsp:setProperty name="jb" property="*" />
<body>
	<h1 align="center">Tabela Studenti:</h1>
	<br />
	<p align="center">
		<a href="nou_student.jsp"><b>Adauga un nou student.</b></a> <a
			href="index.html"><b>Home</b></a>
	</p>
	<form action="sterge_student.jsp" method="post"> <%//important%> <%//vezi alte metode%>
		<table border="1" align="center">
			<tr>
				<td><b>Mark:</b></td>
				<td><b>IdStudent:</b></td>
				<td><b>Nume:</b></td>
				<td><b>Prenume:</b></td>
				<td><b>Adresa:</b></td>
				<td><b>Varsta:</b></td>

			</tr>
			<%
                    jb.connect();
                    ResultSet rs = jb.vedeTabela("students");
                    long x;
                    while (rs.next()) {
                        x = rs.getInt("idstudent");
                %>
			<tr>
				<td><input type="checkbox" name="primarykey" value="<%= x%>" /></td> <%//important%>
				<td><%= x%></td>
				<td><%= rs.getString("nume")%></td>
				<td><%= rs.getString("prenume")%></td>
				<td><%= rs.getString("adresa")%></td>
				<td><%= rs.getInt("varsta")%></td>
				<%
                        }
                    %>
			</tr>
		</table>
		<br />
		<p align="center">
			<input type="submit" value="Sterge liniile marcate">
		</p>
	</form>
	<%
            rs.close();
            jb.disconnect();
        %>
	<br />
	<p align="center">
		<a href="index.html"><b>Home</b></a> <br />
	</p>
</body>
</html>