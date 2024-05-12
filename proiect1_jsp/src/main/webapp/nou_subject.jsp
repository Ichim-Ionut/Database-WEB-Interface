<%-- 
    Document   : nou_subject
    Author     : alex ;p
--%>

<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page language="java" import="java.lang.*,java.math.*,db.*,java.sql.*, java.io.*, java.util.*"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Adauga Subject</title>
    </head>
    <jsp:useBean id="jb" scope="session" class="db.JavaBean" />
    <jsp:setProperty name="jb" property="*" />
    <body>
        <%
            String Nume = request.getParameter("nume");
            String numarDeCredite = request.getParameter("numarDeCredite");
            String numarDeOre = request.getParameter("numarDeOre");
            if (Nume != null) {
                jb.connect();
                jb.adaugaSubject(Nume, numarDeCredite, numarDeCredite);
                jb.disconnect();
        %>
        <p>Datele au fost adaugate.</p><%
        } else {
        %>
        <h1> Suntem in tabela subjects.</h1>
        <form action="nou_subject.jsp" method="post">
            <table>
                <tr>
                    <td align="right">Nume Subject:</td>
                    <td> <input type="text" name="nume" size="40" /></td>
                </tr>
                <tr>
                    <td align="right">Numar De Credite:</td>
                    <td> <input type="text" name="numarDeCredite" size="30" /></td>
                </tr>
                <tr>
                    <td align="right">Numar De Ore:</td>
                    <td> <input type="text" name="numarDeOre" size="30" /></td>
                </tr>
            </table>
            <input type="submit" value="Adauga subject" />
        </form>
        <%
            }
        %>
        <br/>
        <a href="index.html"><b>Home</b></a>
        <br/>
    </body>
</html>