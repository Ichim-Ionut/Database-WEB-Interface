<%-- 
    Document   : nou_student
    Author     : alex ;p
--%>

<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page language="java" import="java.lang.*,java.math.*,db.*,java.sql.*, java.io.*, java.util.*"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Adauga student</title>
    </head>
    <jsp:useBean id="jb" scope="session" class="db.JavaBean" />
    <jsp:setProperty name="jb" property="*" />
    <body>
        <%
            String Nume = request.getParameter("Nume");
            String Prenume = request.getParameter("Prenume");
            String Adresa = request.getParameter("Adresa");
            String Varsta = request.getParameter("Varsta");
            if (Nume != null) {
                jb.connect();
                jb.adaugaStudent(Nume, Prenume, Adresa, Varsta);
                jb.disconnect();
        %>
        <p>Datele au fost adaugate.</p><%
        } else {
        %>
        <h1> Suntem in tabela Student.</h1>
        <form action="nou_student.jsp" method="post">
            <table>
                <tr>
                    <td align="right">Nume Student:</td>
                    <td> <input type="text" name="Nume" size="30" /></td>
                </tr>
                <tr>
                    <td align="right">Prenume Student:</td>
                    <td> <input type="text" name="Prenume" size="30" /></td>
                </tr>
                <tr>
                    <td align="right">Adresa:</td>
                    <td> <input type="text" name="Adresa" size="30" /></td>
                </tr>
                <tr>
                    <td align="right">Varsta:</td>
                    <td> <input type="text" name="Varsta" size="30" /></td>
                </tr>
            </table>
            <input type="submit" value="Adauga studentul" />
        </form>
        <%
            }
        %>
        <br/>
        <a href="index.html"><b>Home</b></a>
        <br/>
    </body>
</html>