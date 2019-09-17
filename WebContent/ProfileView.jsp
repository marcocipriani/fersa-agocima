<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1" %>

<%@ page import="dao.UsrDAO" %>
<%@ page import="java.util.Vector" %>
<%@ page import="controller.LoginController" %>
<%@ page import="controller.ProfileController" %>
<%@ page import="model.*" %>

<jsp:useBean id="loginBean" scope="request" type="bean.LoginBean"/>

<%
    ActualUsr au = ProfileController.getUser(loginBean.getUsername(), loginBean.getPassword(), loginBean.getLoginRole());
    System.out.println("@ProfileView.jsp - Username: " +loginBean.getUsername() + " pwd: " + loginBean.getPassword() + " ruolo di login: " + loginBean.getLoginRole());

    Vector<Contract> contractsList = ProfileController.getContracts(au.getUsername(), au.isActualRole());
    Vector<Eval> evalAboutYouList = ProfileController.getEvalAboutYou(au.getUsername());
    Vector<Eval> evalMadeByYouList = ProfileController.getEvalMadeByYou(au.getUsername());
    // evalAboutYourApts is in html body
%>

<%
    Vector<Contract> contractsReadyList = new Vector<Contract>();
	for (Contract c : contractsList){
		if (!ProfileController.selectId(c,evalMadeByYouList)){
			contractsReadyList.add(c);
		}
	}
	
	


	/*contractsList.forEach((n) -> 
    contractsReadyList.add(ProfileController.compare(n,evalMadeByYouList)));


	for (int i = 0; i < contractsList.size(); i++){
        for (int j = 0; j < evalMadeByYouList.size(); j++){
            if (evalMadeByYouList.elementAt(j).getContractid() != contractsList.elementAt(i).getId()) {
                contractsReadyList.add(contractsList.elementAt(i));
                System.out.println(evalMadeByYouList.elementAt(j).getContractid());
                System.out.println(contractsList.elementAt(i).getId());
                break;
            }
        }
    }
    System.out.println(contractsList);*/

%>

<!DOCTYPE html>
<html>
<head>
    <title>ProfileView.jsp</title>

    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">

    <link rel="stylesheet" type="text/css" href="css/bootstrap.css">
    <link rel="stylesheet" type="text/css" href="css/bootstrap-grid.css">
    <link rel="stylesheet" type="text/css" href="css/style.css">
</head>
<body>
    <div class="container text-center">

        <h2>Bentornato <%= au.getName() %></h2>
        <p>Hai eseguito l'accesso come
<%
        if(au.isActualRole()) {
%>
            proprietario
<%
        } else if (!au.isActualRole()) {
%>
            renter
<%
        } else {
%>
		errore
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
                for (int i = 0; i < contractsReadyList.size(); i++) {
            %>
            <!--  a row for each result -->
            <tr>
                <td><%= contractsReadyList.elementAt(i).getId() %></td>
                <td><%= contractsReadyList.elementAt(i).getApt() %></td>
                <td><%= contractsReadyList.elementAt(i).isExpired() %></td>
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