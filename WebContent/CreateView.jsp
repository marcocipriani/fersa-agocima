<%@ page import="model.ActualUsr" %>
<%@ page import="controller.CreateController" %>
<%@ page import="java.util.Vector" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<%
    if(request.getParameter("create") != null) {
        //CreateController.postRenterForm();
%>
        <jsp:forward page="ProfileView.jsp"/>
<%
    }
%>

<%
    String username = request.getParameter("username");
    boolean role = Boolean.parseBoolean(request.getParameter("role"));
    int contractId = Integer.parseInt(request.getParameter("id"));
    Vector contractDetails = CreateController.getContractDetails(contractId);
    String renter = (contractDetails.elementAt(0)).toString();
    String tenant = (contractDetails.elementAt(1)).toString();
    int aptid = (int) contractDetails.elementAt(2);

%>

<html>
<head>
    <title>CreateView.jsp</title>

    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">

    <link rel="stylesheet" type="text/css" href="css/bootstrap.css">
    <link rel="stylesheet" type="text/css" href="css/bootstrap-grid.css">
    <link rel="stylesheet" type="text/css" href="css/style.css">
</head>
<body>
    <div class="container text-center">

        <h2>Creazione valutazione</h2>
        <p>relativa al contratto #<%= contractId %></p>

        <hr>

    </div>

    <div id="createEvalUsrForm" class="container">

        <h3>Valutazione sull'utente<%= username %></h3>
        <form name="createEvalUsrForm" action="CreateView.jsp"  method="POST" align="center">
            <div class="row">
                <div class="col-8 offset-2 form-group">
                    <label for="username">Testo della valutazione</label><br>
                    <textarea name="textApt" rows="10" cols="100" placeholder="Com'era il proprietario/inquilino?" required></textarea>
                </div>
            </div>
            <div class="row">
                <div class="col-8 offset-2 form-group starsRadio">
                    <label>Voto</label><br>
                    1 <input type="radio" name="stars" value="1">
                    2 <input type="radio" name="stars" value="2">
                    3 <input type="radio" name="stars" value="3">
                    4 <input type="radio" name="stars" value="4">
                    5 <input type="radio" name="stars" value="5">
                </div>
            </div>
            <div class="row" id="detailsUsr">
                <input type="hidden" name="id" value="ID">
                <p>Id del contratto: </p><input type="text" value="<%= contractId %>" class="form-control" readonly>
                <input type="hidden" name="username" value="<%= username %>">
            </div>

            <div class="row" style="margin-top: 20px;">
                <div class="col text-center">
                    <input id="createEvalUsrButton" type="submit" name="create" value="Crea valutazione utente" class="btn btn-secondary">
                    <input type="reset" name="reset" class="btn btn-outline-secondary">
                </div>
            </div>
        </form>

    <hr>
    </div>

<%
    // if renter show this form
    if (!role) {
%>
    <div id="createEvalAptForm" class="container">
        <p>Valutazione sull'appartamento
        </p>

        <form name="createEvalAptForm" action="CreateView.jsp"  method="POST" align="center">
            <div class="row">
                <div class="col-8 offset-2 form-group">
                    <label for="textApt">Testo della valutazione</label><br>
                    <textarea id="textApt" name="textApt" rows="10" cols="100" placeholder="Com'era l'appartamento?" required></textarea>
                </div>
            </div>
            <div class="row">
                <div class="col-8 offset-2 form-group starsRadio">
                    <label>Voto</label><br>
                    1 <input type="radio" name="stars" value="1">
                    2 <input type="radio" name="stars" value="2">
                    3 <input type="radio" name="stars" value="3">
                    4 <input type="radio" name="stars" value="4">
                    5 <input type="radio" name="stars" value="5">
                </div>
            </div>
            <hr>
            <div class="row" id="detailsApt">
                <input type="hidden" name="id" value="ID">
                <p>Proprietario dell'appartamento: </p><input type="text" value="OWNER" class="form-control" readonly><%--user sees but cannot interact--%>
                <input type="hidden" name="stars" value="EVALUSR=ME">
                <input type="hidden" name="stars" value="CONTRACTID">
            </div>
            <hr>
            <div class="row" style="margin-top: 20px;">
                <div class="col text-center">
                    <input id="createEvalAptButton" type="submit" name="create" value="Crea valutazione appartamento" class="btn btn-secondary">
                    <input type="reset" name="reset" class="btn btn-outline-secondary">
                </div>
            </div>
        </form>

    </div>

<%
    }
%>

</body>
</html>
