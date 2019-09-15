<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1" %>

<%@ page import="dao.UsrDAO" %>
<%@ page import="java.util.Vector" %>

<%@ page import="controller.ProfileController" %>
<%@ page import="model.*" %>

<jsp:useBean id="loginBean" scope="session" type="bean.LoginBean"/>

<%
    ActualUsr au = UsrDAO.findByUsername(loginBean.getUsername(), loginBean.getPassword(), loginBean.getLoginRole());
    System.out.println("@ProfileView.jsp - Username: " +loginBean.getUsername() + " pwd: " + loginBean.getPassword() + " role: " + loginBean.getLoginRole());

    Vector<Contract> contractsList = ProfileController.getContracts(au.getUsername(), au.isActualRole());
    Vector<Eval> evalAboutYouList = ProfileController.getEvalAboutYou(au.getUsername());
    Vector<Eval> evalMadeByYouList = ProfileController.getEvalMadeByYou(au.getUsername());
    // evalAboutYourApts is in html body
%>

<!DOCTYPE html>
<html>
<head>
    <title>ProfileView.jsp</title>


    <link rel="stylesheet" type="text/css" href="css/bootstrap.css">
    <link rel="stylesheet" type="text/css" href="css/bootstrap-grid.css">
    <link rel="stylesheet" type="text/css" href="css/style.css">
</head>
<body>
    <div class="container text-center">

        <h2>Bentornato <%= au.getName() %></h2>
        <p>Hai eseguito l'accesso come
<%
        if(!au.isActualRole()) {
%>
            inquilino (renter)
<%
        } else {
%>
            proprietario (tenant)
<%
        }
%>
        </p>

        <hr>

        <h3>Tuoi contratti</h3>
<%
        if(contractsList.size() != 0){
%>
        <table id ="contractsTable" class="table">
            <thead class="thead-light">
            <tr>
                <th scope="col">ID</th>
                <th scope="col"># Appartamento</th>
                <th scope="col">Terminato?</th>
            </tr>
            </thead>
            <tbody>
            <%
                for (int i = 0; i < contractsList.size(); i++) {
            %>
            <!--  a row for each result -->
            <tr>
                <td><%= contractsList.elementAt(i).getId() %></td>
                <td><%= contractsList.elementAt(i).getApt() %></td>
                <td><%= contractsList.elementAt(i).isExpired() %></td>
            </tr>
            <%
                }
            %>
            </tbody>
        </table>
<%
        } else {
%>
        <p>Nessun contratto in essere</p>
<%
        }
%>
        <hr>

        <h3>Valutazioni su di te</h3>
        <table id ="evalAboutYouTable" class="table">
            <thead class="thead-light">
                <tr>
                    <th scope="col">ID</th>
                    <th scope="col">Stelle</th>
                    <th scope="col">Testo</th>
                    <th scope="col">Autore della valutazione</th>
                </tr>
            </thead>
            <tbody>
            <%
                for (int i = 0; i < evalAboutYouList.size(); i++) {
            %>
            <!--  a row for each result -->
                <tr>
                    <td><%= evalAboutYouList.elementAt(i).getId() %></td>
                    <td><%= evalAboutYouList.elementAt(i).getStars() %></td>
                    <td><%= evalAboutYouList.elementAt(i).getText() %></td>
                    <td><%= evalAboutYouList.elementAt(i).getEvalusr() %></td>
                </tr>
            <%
                }
            %>
            </tbody>
        </table>
        <hr>

        <h3>Valutazioni fatte da te</h3>
        <table id="evalMadeByYouTable" class="table">
            <thead class="thead-light">
            <tr>
                <th scope="col">ID</th>
                <th scope="col">Stelle</th>
                <th scope="col">Testo</th>
            </tr>
            </thead>
            <tbody>
            <%
                for (int i = 0; i < evalMadeByYouList.size(); i++) {
            %>
            <!--  a row for each result -->
            <tr>
                <td><%= evalMadeByYouList.elementAt(i).getId() %></td>
                <td><%= evalMadeByYouList.elementAt(i).getStars() %></td>
                <td><%= evalMadeByYouList.elementAt(i).getText() %></td>
            </tr>
            <%
                }
            %>
            </tbody>
        </table>
        <hr>

<%
        if(au.isActualRole()){
            Vector<Eval> evalAboutYourAptsList = ProfileController.getEvalAboutYourApts(au.getUsername());
%>
        <h3>Valutazioni fatte sui tuoi appartamenti</h3>
        <table id="evalAboutYourAptsTable" class="table">
            <thead class="thead-light">
            <tr>
                <th scope="col">ID</th>
                <th scope="col">Stelle</th>
                <th scope="col">Testo</th>
                <th scope="col">Autore della valutazione</th>
            </tr>
            </thead>
            <tbody>
            <%
                for (int i = 0; i < evalAboutYourAptsList.size(); i++) {
            %>
            <!--  a row for each result -->
            <tr>
                <td><%= evalAboutYourAptsList.elementAt(i).getId() %></td>
                <td><%= evalAboutYourAptsList.elementAt(i).getStars() %></td>
                <td><%= evalAboutYourAptsList.elementAt(i).getText() %></td>
                <td><%= evalAboutYourAptsList.elementAt(i).getEvalusr() %></td>
            </tr>
            <%
                }
            %>
            </tbody>
        </table>
        <hr>
<%
        }
%>

    </div>

</body>
</html>