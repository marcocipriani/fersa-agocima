<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1" %>

<%@ page import="controller.CreateController" %>
<%@ page import="java.util.Vector" %>

<%
    if(request.getParameter("createRenterForm") != null) {
        CreateController.postRenterForm(
                request.getParameter("textUsr"),
                Integer.parseInt(request.getParameter("starsUsr")),
                request.getParameter("textApt"),
                Integer.parseInt(request.getParameter("starsApt")),
                Integer.parseInt(request.getParameter("aptId")),
                request.getParameter("tenant"),
                request.getParameter("me"),
                Integer.parseInt(request.getParameter("contractId"))
        );
        System.out.println("RenterForm inviato. Reindirizzamento a ViewProfile");
%>
        <jsp:forward page="ProfileView.jsp"/>
<%
    }
    if(request.getParameter("createTenantForm") != null) {
        CreateController.postTenantForm(
                request.getParameter("textUsr"),
                Integer.parseInt(request.getParameter("starsUsr")),
                request.getParameter("renter"),
                request.getParameter("me"),
                Integer.parseInt(request.getParameter("contractId"))
        );
        System.out.println("TenantForm inviato. Reindirizzamento a ViewProfile");
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
    <div id="form-container" class="container">

<%
    // if tenant show this form
    if(role){
%>
        <form name="createTenantForm" action="CreateView.jsp"  method="POST" align="center">
            <div id="createEvalUsrForm" <%--class="container"--%>>
                <h3>Valutazione sull'utente <%= username %></h3>
                <div class="row">
                    <div class="col-8 offset-2 form-group">
                        <label for="textUsr">Testo della valutazione</label><br>
                        <textarea id="textUsr" name="textUsr" rows="10" cols="100" placeholder="Com'era l'inquilino?" required></textarea>
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
                <div id="detailsUsr" class="row col-4">
                    <p>ID del contratto: </p><input type="text" name="contractId" value="<%= contractId %>" class="form-control" readonly>
                    <input type="hidden" name="renter" value="<%= username %>">
                    <input type="hidden" name="me" value="<%= evalusr %>">
                </div>

                <div class="row" style="margin-top: 20px;">
                    <div class="col text-center">
                        <input id="createEvalUsrButton" type="submit" name="createTenantForm" value="Crea valutazione utente" class="btn btn-secondary">
                        <input type="reset" name="reset" class="btn btn-outline-secondary">
                    </div>
                </div>
            </div>
        </form>
<%
    // if renter show this form
    } else {
%>
        <form name="createRenterForm" action="CreateView.jsp"  method="POST" align="center">
            <div id="createEvalUsrForm" <%--class="container"--%>>
                <h3>Valutazione sull'utente <%= username %></h3>
                <div class="row">
                    <div class="col-8 offset-2 form-group">
                        <label for="textUsr">Testo della valutazione</label><br>
                        <textarea id="textUsr" name="textUsr" rows="10" cols="100" placeholder="Com'era l'inquilino?" required></textarea>
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
                <div id="detailsUsr" class="row col-4">
                    <p>ID del contratto: </p><input type="text" name="contractId" value="<%= contractId %>" class="form-control" readonly>
                    <input type="hidden" name="tenant" value="<%= username %>">
                    <input type="hidden" name="me" value="<%= renter %>">
                </div>
            </div>

            <hr>

            <div id="createEvalAptForm" <%--class="container"--%>>
                <h3>Valutazione sull'appartamento #<%= aptId %></h3>
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
                </div>
            </div>

            <div class="row" style="margin-top: 20px;">
                <div class="col text-center">
                    <input id="createEvalAptUsrButton" type="submit" name="createRenterForm" value="Crea valutazione appartamento e valutazione utente" class="btn btn-secondary">
                    <input type="reset" name="reset" class="btn btn-outline-secondary">
                </div>
            </div>
        </form>
<%
    }
%>
    </div>
</body>
</html>
