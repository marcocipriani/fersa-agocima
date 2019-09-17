<%@ page import="model.ActualUsr" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<%--<%
    //int id = // getParameter("role")

    ActualUsr au =

    if(request.getParameter("create") != null){
        if (request.getParameter("create")){
            // intent createEvalUsr
%>
            <jsp:forward page="ProfileView.jsp"/>
<%
        } else {
            // intent createEvalUsr
             //intent createEvalApt
%>
            <jsp:forward page="ProfileView.jsp"/>
<%
        }
    }
%>--%>

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
        <p>relativa al contratto #<%= request.getParameter("id") %></p>

        <hr>

        <form name="createEvalUsrForm" action="CreateView.jsp" ></form>

        <form name="createEvalAptForm" action="CreateView.jsp"  method="POST" align="center">
            <div class="row">
                <div class="col-8 offset-2 form-group">
                    <label for="username">Testo della valutazione</label><br>
                    <textarea name="textApt" rows="10" cols="100" placeholder="Com'è stato l'appartamento?" required></textarea>
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
            <div class="row" id="details">
                <input type="hidden" name="id" value="ID">
                <p>Proprietario dell'appartamento: </p><input type="text" value="OWNER" class="form-control" readonly><%--user sees but cannot interact--%>
                <input type="hidden" name="stars" value="EVALUSR=ME">
                <input type="hidden" name="stars" value="CONTRACTID">
            </div>
            <hr>
            <div class="row" style="margin-top: 20px;">
                <div class="col text-center">
                    <input id="createButton" type="submit" name="create" value="Crea valutazione" class="btn btn-secondary">
                    <input type="reset" name="reset" class="btn btn-outline-secondary">
                </div>
            </div>
        </form>

    </div>
</body>
</html>
