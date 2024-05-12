<%-- 
    Document   : tabela_tests
    Author     : alex ;p
--%>

<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page language="java" import="java.lang.*,java.math.*,db.*,java.sql.*, java.io.*, java.util.*"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Tabela Tests</title>
    </head>
    <jsp:useBean id="jb" scope="session" class="db.JavaBean" />
    <jsp:setProperty name="jb" property="*" />
    <body>
        <h1 align="center"> Tabela Tests:</h1>
        <br/>
        <p align="center"><a href="nou_test.jsp"><b>Adauga un nou test.</b></a> <a href="index.html"><b>Home</b></a></p>
        <form action="sterge_test.jsp" method="post">
            <table border="1" align="center">
                <tr>
                    <td><b>Mark:</b></td>
                    <td><b>IdTest:</b></td>
                    <td><b>IdStudent:</b></td>
                    <td><b>NumeStudent:</b></td>
                    <td><b>PrenumeStudent:</b></td>
                    <td><b>Adresa:</b></td>
                    <td><b>Varsta:</b></td>
                    <td><b>IdSubject:</b></td>
                    <td><b>NumeSubject:</b></td>
                    <td><b>NumarDeCredite:</b></td>
                    <td><b>NumarDeOre:</b></td>
                    <td><b>DataTest:</b></td>
                    <td><b>NotaTest:</b></td>
                </tr>
                <%
                    jb.connect();
                    ResultSet rs = jb.vedeTests();
                    long x;
                    while (rs.next()) {
                        x = rs.getInt("idtest");
                %>
                <tr>
                    <td><input type="checkbox" name="primarykey" value="<%= x%>" /></td><td><%= x%></td>
                    <td><%= rs.getInt("idstudent_test")%></td>
                    <td><%= rs.getString("NumeStudent")%></td>
                    <td><%= rs.getString("PrenumeStudent")%></td>
                    <td><%= rs.getString("adresa")%></td>
                    <td><%= rs.getInt("varsta")%></td>
                    <td><%= rs.getInt("idsubject_test")%></td>
                    <td><%= rs.getString("NumeSubject")%></td>
                    <td><%= rs.getInt("NumarDeCredite")%></td>
                    <td><%= rs.getInt("NumarDeOre")%></td>
                    <td><%= rs.getDate("data")%></td>
                    <td><%= rs.getInt("nota")%></td>
                    <%
                        }
                    %>
                </tr>
            </table><br/>
            <p align="center">
                <input type="submit" value="Sterge liniile marcate">
            </p>
        </form>
        <%
            rs.close();
            jb.disconnect();
        %>
        <br/>
        <p align="center">
            <a href="index.html"><b>Home</b></a>
            <br/>
        </p>
    </body>
</html>