<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1" %>

<%@ page import="java.util.Vector" %>
<%@ page import="model.*" %>
<%@ page import="controller.ProfileController" %>

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

        <h3>I tuoi contratti</h3>
<%
        if(contractsList.size() != 0){
%>
        <table id ="contractsTable" class="table">
            <thead class="thead-light">
            <tr>
                <th scope="col">ID</th>
                <th scope="col"># Appartamento</th>
                <th scope="col">Terminato?</th>
<<<<<<< HEAD
                <th scope="col">Azione</th>
=======
                <th></th>
>>>>>>> branch 'cid' of https://github.com/marcocipriani/fersa-agocima
            </tr>
            </thead>
            <tbody>
            <%
                for (int i = 0; i < contractsReadyList.size(); i++) {
            %>
            <tr>
                <td><%= contractsReadyList.elementAt(i).getId() %></td>
                <td><%= contractsReadyList.elementAt(i).getApt() %></td>
                <td><%= contractsReadyList.elementAt(i).isExpired() %></td>
                <td>
<%
<<<<<<< HEAD
                    if(contractsReadyList.elementAt(i).isExpired()){
%>
                    <form action="CreateView.jsp" name="viewForm">
                        <input name="create" type="submit" value="Create" class="form-control">
                        <input name="id" type="hidden" value="<%= contractsReadyList.elementAt(i).getId() %>">
                    </form>
<%
                    } else {
%>
                    Contratto in corso
<%
                    }
%>
                </td>	
=======
                if(contractsReadyList.elementAt(i).isExpired()){
%>
                    <form action="CreateView.jsp" name="viewForm">
                        <input name="view" type="submit" placeholder="" value="Crea valutazione" class="form-control">
                        <input name="id" type="hidden" value="<%= contractsReadyList.elementAt(i).getId() %>">
                        <input name="role" type="hidden" value="<%= au.isActualRole() %>">
                    </form>
<%
                } else {
%>
                    Contratto ancora in corso
<%
                }
%>
                </td>

>>>>>>> branch 'cid' of https://github.com/marcocipriani/fersa-agocima
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
                    <th scope="col">Azioni</th>
                </tr>
            </thead>
            <tbody>
            <%
                for (int i = 0; i < evalAboutYouList.size(); i++) {
            %>
                <tr>
                    <td><%= evalAboutYouList.elementAt(i).getId() %></td>
                    <td><%= evalAboutYouList.elementAt(i).getStars() %></td>
                    <td><%= evalAboutYouList.elementAt(i).getText() %></td>
                    <td><%= evalAboutYouList.elementAt(i).getEvalusr() %></td>
                    <td>                         
		                <form action="EvalUsrView.jsp" name="viewForm">
		                    <input name="view" type="submit" value="View" class="form-control">
		                    <input name="id" type="hidden" value="<%= evalAboutYouList.elementAt(i).getId() %>">
		                </form>             	                
                	</td>
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
                <th scope="col">Azioni</th>
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
    			<td> 
<%
    			if(evalMadeByYouList.elementAt(i).getClass().toString().equals("class model.EvalUsr")){
%>                                    
	                <form action="EvalUsrView.jsp" name="viewForm">
	                    <input name="view" type="submit" value="View" class="form-control">
	                    <input name="id" type="hidden" value="<%= evalMadeByYouList.elementAt(i).getId() %>">
	                </form>
<%
        		} else {
%>
        			<form action="EvalAptView.jsp" name="viewForm">
	                    <input name="view" type="submit" value="View" class="form-control">
	                    <input name="id" type="hidden" value="<%= evalMadeByYouList.elementAt(i).getId() %>">	                    
	                </form>
<%
        		}
%>	                
	                
                </td>
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
                <th scope="col">Azioni</th>
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
                <td>                         
		                <form action="EvalAptView.jsp" name="viewForm">
		                    <input name="view" type="submit" value="View" class="form-control">
		                    <input name="id" type="hidden" value="<%= evalAboutYourAptsList.elementAt(i).getId() %>">
		                </form>             	                
                	</td>
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