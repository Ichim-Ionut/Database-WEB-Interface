<%-- 
    Document   : m1_student
    Author     : alex ;p
--%>

<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page language="java" import="java.lang.*,java.math.*,db.*,java.sql.*, java.io.*, java.util.*"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Tabela Studenti</title>
        <link href="table.css" rel="stylesheet" type="text/css" media="screen" />
    </head>
    <jsp:useBean id="jb" scope="session" class="db.JavaBean" /> <%//important%> <%//tema:vezi ce inseamna alte chestii pt scope%>
    <jsp:setProperty name="jb" property="*" /> <%//important%> 
    <body>
        <h1 align="center">Tabela Studenti:</h1>
        <br/>
        <p align="center"><a href="nou_student.jsp"><b>Adauga un nou student.</b></a> <a href="index.html"><b>Home</b></a></p>
        <%
            jb.connect();
            int aux = java.lang.Integer.parseInt(request.getParameter("primarykey"));
            ResultSet rs = jb.intoarceLinieDupaId("students", "idstudent", aux);
            rs.first();
            String nume = rs.getString("nume");
            String prenume = rs.getString("prenume");
            String adresa = rs.getString("adresa");
            Integer varsta = Integer.valueOf(rs.getString("varsta"));
            rs.close();
            jb.disconnect();
        %>
        <form action="m2_student.jsp" method="post">
            <table align="center">
                <tr>
                    <td align="right">IdStudent:</td>
                    <td> <input type="text" name="idstudent" size="30" value="<%= aux%>" readonly/></td>
                </tr>
                <tr>
                    <td align="right">Nume:</td>
                    <td> <input type="text" name="nume" size="30" value="<%= nume%>"/></td>
                </tr>
                <tr>
                    <td align="right">Prenume:</td>
                    <td> <input type="text" name="prenume" size="30" value="<%= prenume%>"/></td>
                </tr>
                <tr>
                    <td align="right">Adresa:</td>
                    <td> <input type="text" name="adresa" size="30" value="<%= adresa%>"/></td>
                </tr>
                 <tr>
                    <td align="right">Varsta:</td>
                    <td> <input type="text" name="varsta" size="30" value="<%= varsta%>"/></td>
                </tr>
            </table><p align="center">
                <input type="submit" value="Modifica linia">
            </p>
        </form>
        <p align="center">
            <a href="index.html"><b>Home</b></a>
            <br/>
    </body>
</html>