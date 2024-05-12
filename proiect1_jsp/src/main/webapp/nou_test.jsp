<%-- 
    Document   : nou_Consultatie
    Created on : Nov 14, 2016, 1:08:21 PM
    Author     : vali
--%>

<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page language="java" import="java.lang.*,java.math.*,db.*,java.sql.*, java.io.*, java.util.*"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Adauga test</title>
    </head>
    <jsp:useBean id="jb" scope="session" class="db.JavaBean" />
    <jsp:setProperty name="jb" property="*" />
    <body>
        <%
            int idstudent, idsubject;
            String id1, id2, NumeStudent, PrenumeStudent, Adresa, Varsta, NumeSubject, NumarDeCredite, NumarDeOre, Nota, Data;
            id1 = request.getParameter("idstudent");
            id2 = request.getParameter("idsubject");
            Data = request.getParameter("data");
            Nota = request.getParameter("nota");
            if (id1 != null) {
                jb.connect();
                jb.adaugaTest(java.lang.Integer.parseInt(id1), java.lang.Integer.parseInt(id2), Data, java.lang.Integer.parseInt(Nota));
                jb.disconnect();
        %>
        <p>Datele au fost adaugate.</p><%
        } else {
        jb.connect();
        ResultSet rs1 = jb.vedeTabela("students");
        ResultSet rs2 = jb.vedeTabela("subjects");
        %>
        <h1> Suntem in tabela tests.</h1>
        <form action="nou_test.jsp" method="post">
            <table>
                <tr>
                    <td align="right">IdStudent:</td>
                    <td> 
                        Selectati studentul:
			<SELECT NAME="idstudent">
                                <%
                                    while(rs1.next()){
                                        idstudent = rs1.getInt("idstudent");
                                        NumeStudent = rs1.getString("nume");
                                        PrenumeStudent = rs1.getString("prenume");
                                        Adresa = rs1.getString("adresa");
                                        Varsta = rs1.getString("varsta");
                                %>
                                    <OPTION VALUE="<%= idstudent%>"><%= idstudent%>,<%= NumeStudent%>,<%= PrenumeStudent%>,<%= Adresa%>,<%= Varsta%></OPTION>
                                <%
                                    }
                                %>
			</SELECT>
                    
                    </td>
                </tr>
                <tr>
                    <td align="right">IdSubject:</td>
                    <td> 
                        Selectati subject:
			<SELECT NAME="idsubject">
				<!-- OPTION selected="yes" VALUE="iris1">Iris 1</OPTION -->
                                <%
                                    while(rs2.next()){
                                        idsubject = rs2.getInt("idsubject");
                                        NumeSubject = rs2.getString("nume");
                                        NumarDeCredite = rs2.getString("numar de credite");
                                        NumarDeOre = rs2.getString("numar de ore");
                                %>
                                    <OPTION VALUE="<%= idsubject%>"><%= idsubject%>,<%= NumeSubject%>,<%= NumarDeCredite%>,<%= NumarDeOre%></OPTION>
                                <%
                                    }
                                %>
			</SELECT>
                     </td>
                </tr>
                <tr>
                    <td align="right">Data:</td>
                    <td> <input type="text" name="data" size="30" /></td>
                </tr>
                <tr>
                    <td align="right">Nota:</td>
                    <td> <input type="text" name="nota" size="30" /></td>
                </tr>
            </table>
            <input type="submit" value="Adauga test" />
        </form>
        <%
            }
        %>
        <br/>
        <a href="index.html"><b>Home</b></a>
        <br/>
    </body>
</html>