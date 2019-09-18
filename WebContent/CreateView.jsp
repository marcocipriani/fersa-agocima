<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1" %>

<%@ page import="controller.CreateController" %>
<%@ page import="java.util.Vector" %>

<%
    if(request.getParameter("createForm") != null) {
        //CreateController.postRenterForm();
%>
        <jsp:forward page="ProfileView.jsp"/>
<%
    }
%>

<%
    String me = request.getParameter("username"); //useless
    System.out.println(me);
    boolean role = Boolean.parseBoolean(request.getParameter("role"));
    int contractId = Integer.parseInt(request.getParameter("id"));
    Vector contractDetails = CreateController.getContractDetails(contractId);
    String renter = (contractDetails.elementAt(0)).toString(); // can be nested
    String tenant = (contractDetails.elementAt(1)).toString();
    int aptId = (int) contractDetails.elementAt(2);

    String username = tenant;
    String evalusr = renter;
    // switching for tenant
    if(role){
        username = renter;
        evalusr = tenant;
    }
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

        <h3>Valutazione sull'utente <%= username %></h3>
        <form name="createEvalUsrForm" action="CreateView.jsp"  method="POST" align="center">
            <div class="row">
                <div class="col-8 offset-2 form-group">
                    <label for="textUsr">Testo della valutazione</label><br>
                    <textarea id="textUsr" name="textUsr" rows="10" cols="100"
<%
                    if(!role){
%>
                    placeholder="Com'era il proprietario?"
<%
                    } else {
%>
                    placeholder="Com'era l'inquilino?"
<%
                    }
%>
                    required></textarea>
                </div>
            </div>
            <div class="row">
                <div class="col-8 offset-2 form-group starsRadio">
                    <label>Voto</label><br>
                    1 <input type="radio" name="starsUsr" value="1">
                    2 <input type="radio" name="starsUsr" value="2">
                    3 <input type="radio" name="starsUsr" value="3">
                    4 <input type="radio" name="starsUsr" value="4">
                    5 <input type="radio" name="starsUsr" value="5">
                </div>
            </div>
            <div class="row col-4" id="detailsUsr">
                <p>Id del contratto: </p><input type="text" value="<%= contractId %>" class="form-control" readonly>
                <input type="hidden" name="username" value="<%= username %>">
                <input type="hidden" name="me" value="<%= evalusr %>">
            </div>

            <div class="row" style="margin-top: 20px;">
                <div class="col text-center">
                    <input id="createEvalUsrButton" type="submit" name="createForm" value="Crea valutazione utente" class="btn btn-secondary">
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
        <h3>Valutazione sull'appartamento #<%= aptId %></h3>

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
                    1 <input type="radio" name="starsApt" value="1">
                    2 <input type="radio" name="starsApt" value="2">
                    3 <input type="radio" name="starsApt" value="3">
                    4 <input type="radio" name="starsApt" value="4">
                    5 <input type="radio" name="starsApt" value="5">
                </div>
            </div>
            <div class="row col-4" id="detailsApt">
                <p>Id del contratto: </p><input type="text" value="<%= contractId %>" class="form-control" readonly>
                <br>
                <p>Proprietario dell'appartamento: </p><input type="text" value="<%= tenant %>" class="form-control" readonly><%--user sees but cannot interact--%>
                <input type="hidden" name="aptId" value="<%= aptId %>">
                <input type="hidden" name="username" value="<%= username %>">
                <input type="hidden" name="me" value="<%= evalusr %>">
            </div>
            <div class="row" style="margin-top: 20px;">
                <div class="col text-center">
                    <input id="createEvalAptButton" type="submit" name="createForm" value="Crea valutazione appartamento" class="btn btn-secondary">
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
