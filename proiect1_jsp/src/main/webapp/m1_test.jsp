<%-- 
    Document   : m1_test
    Author     : alex ;p
--%>

<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page language="java" import="java.lang.*,java.math.*,db.*,java.sql.*, java.io.*, java.util.*"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Tabela Tests</title>
        <link href="table.css" rel="stylesheet" type="text/css" media="screen" />
    </head>
    <jsp:useBean id="jb" scope="session" class="db.JavaBean" />
    <jsp:setProperty name="jb" property="*" />
    <body>
        <h1 align="center">Tabela Tests:</h1>
        <br/>
        <p align="center"><a href="nou_test.jsp"><b>Adauga un nou test.</b></a> <a href="index.html"><b>Home</b></a></p>
        <%
            jb.connect();
            String NumeStudent, PrenumeStudent, Adresa, Varsta, NumeSubject, NumarDeCredite, NumarDeOre, Nota, Data;
            int aux = java.lang.Integer.parseInt(request.getParameter("primarykey"));
            ResultSet rs = jb.intoarceTestId(aux);
            rs.first();
            int id1 = rs.getInt("idstudent_test");
            int id2 = rs.getInt("idsubject_test");

            NumeStudent = rs.getString("NumeStudent");
            PrenumeStudent = rs.getString("PrenumeStudent");
            Adresa = rs.getString("adresa");
            Varsta = rs.getString("varsta");
            NumeSubject = rs.getString("NumeSubject");
            NumarDeCredite = rs.getString("NumarDeCredite");
            NumarDeOre=rs.getString("NumarDeOre");
            Data = rs.getString("data");
            Nota = rs.getString("nota");

            ResultSet rs1 = jb.vedeTabela("students");
            ResultSet rs2 = jb.vedeTabela("subjects");
            int idstudent, idsubject;


        %>
        <form action="m2_test.jsp" method="post">
            <table align="center">
                <tr>
                    <td align="right">IdTest:</td>
                    <td> <input type="text" name="idtest" size="30" value="<%= aux%>" readonly/></td>
                </tr>
                <tr>
                    <td align="right">IdStudent:</td>
                    <td> 
                        <SELECT NAME="idstudent">
                            <%
                            while(rs1.next()){
                                idstudent = rs1.getInt("idstudent");
                                NumeStudent = rs1.getString("nume");
                                PrenumeStudent = rs1.getString("prenume");
                                Adresa = rs1.getString("adresa");
                                Varsta = rs1.getString("varsta");
                                    if (idstudent != id1) {
                            %>
                            <OPTION VALUE="<%= idstudent%>"><%= idstudent%>, <%= NumeStudent%>,<%= PrenumeStudent%>,<%= Adresa%>,<%= Varsta%></OPTION>
                                <%
                                        } else {
                                %>                
                            <OPTION selected="yes" VALUE="<%= idstudent%>"><%= idstudent%>, <%= NumeStudent%>,<%= PrenumeStudent%>,<%= Adresa%>,<%= Varsta%></OPTION>
                                <%
                                        }
                                    }
                                %>
                        </SELECT>

                    </td>
                </tr>
                <tr>
                    <td align="right">idsubject:</td>
                    <td> 
                        <SELECT NAME="idsubject">
                            <%
                            while(rs2.next()){
                                idsubject = rs2.getInt("idsubject");
                                NumeSubject = rs2.getString("nume");
                                NumarDeCredite = rs2.getString("numar de credite");
                                NumarDeOre = rs2.getString("numar de ore");
                            if (idsubject != id2) {
                            %>
                            <OPTION VALUE="<%= idsubject%>"><%= idsubject%>,<%= NumeSubject%>,<%= NumarDeCredite%>,<%= NumarDeOre%></OPTION>
                                <%
                                        } else {
                                %>                
                            <OPTION selected="yes" VALUE="<%= idsubject%>"><%= idsubject%>,<%= NumeSubject%>,<%= NumarDeCredite%>,<%= NumarDeOre%></OPTION>
                                <%
                                        }
                                    }
                                %>
                        </SELECT>

                    </td>
                </tr>
                <tr>
                    <td align="right">Data:</td>
                    <td> <input type="text" name="data" size="30" value="<%= Data%>"/></td>
                </tr>
                <tr>
                    <td align="right">Nota:</td>
                    <td> <input type="text" name="nota" size="30" value="<%= Nota%>"/></td>
                </tr>
            </table><p align="center">
                <input type="submit" value="Modifica linia">
            </p>
        </form>
        <p align="center">
            <a href="index.html"><b>Home</b></a>
            <br/>
    </body>
    <%
        rs.close();
        rs1.close();
        rs2.close();
        jb.disconnect();
    %>
</html>