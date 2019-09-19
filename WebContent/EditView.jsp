<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1" %>
<%@ page errorPage = "ErrorView.jsp" %>

<jsp:useBean id="profileBean" scope="session" type="bean.ProfileBean"/>

<%@ page import="controller.EditController" %>
<%@ page import="model.Eval" %>

<%
	if (request.getParameter("edit") != null) {
		int evalId = Integer.parseInt(request.getParameter("id"));
		boolean isForUsr = Boolean.parseBoolean(request.getParameter("isforusr"));
        String evalText = request.getParameter("text");
		int evalStars = Integer.parseInt(request.getParameter("stars"));

		EditController.setEval(evalId, evalText, evalStars, isForUsr);
%>
		<jsp:forward page="ProfileView.jsp"/>
<% 
	}

	if (request.getParameter("delete") != null) {
	    if(profileBean.getLoginRole()) {
            int evalId = Integer.parseInt(request.getParameter("id"));
            boolean isForUsr = Boolean.parseBoolean(request.getParameter("isforusr"));
            EditController.deleteEvalAsTenant(evalId, isForUsr);
        } else {
	        String evalusr = request.getParameter("evalusr");
            int contractid = Integer.parseInt(request.getParameter("contractid"));
            EditController.deleteEvalAsRenter(evalusr, contractid);
%>
        <jsp:forward page="ProfileView.jsp"/>
<%
    }
%>

<%
    int evalId = Integer.parseInt(request.getParameter("id"));
    boolean isForUsr = Boolean.parseBoolean(request.getParameter("isforusr"));

    Eval eval = EditController.getEval(evalId, isForUsr);
%>

<html>
<head>
    <title>EditView.jsp</title>

    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">

    <link rel="stylesheet" type="text/css" href="css/bootstrap.css">
    <link rel="stylesheet" type="text/css" href="css/bootstrap-grid.css">
    <link rel="stylesheet" type="text/css" href="css/style.css">
</head>
<body>
	<div class="container text-center">

        <h2>Modifica la tua valutazione <%if(isForUsr){%>utente<%} else {%>appartamento<%}%></h2>
        <p>ID valutazione: <%= evalId %></p>
        
        <hr>

        <form name="editForm" action="EditView.jsp"  method="POST">
            <div class="row">
                <div class="col-8 offset-2 form-group">
                    <label>Testo della valutazione</label><br>
                    <input name="id" type="hidden" value="<%= eval.getId() %>">
                    <input name="isforusr" type="hidden" value="<%= isForUsr %>">
                    <input name="contractid" type="hidden" value="<%= eval.getContractid() %>">
                    <input name="evalusr" type="hidden" value="<%= eval.getEvalusr() %>">
                    <textarea name="text" rows="10"></textarea>
                    <!--<input name="text" type="text" value="">-->
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
            <div class="row" style="margin-top: 20px;">
                <div class="col text-center">
                    <input id="edit-button" type="submit" name="edit" value="Modifica valutazione" class="btn btn-secondary">
                    <input type="reset" name="reset" class="btn btn-outline-secondary">
                </div>
            </div>
            <div class="row" style="margin-top: 20px;">
                <div class="col text-center">
                    <input id="delete-button" type="submit" name="delete" value="Cancella valutazione" class="btn btn-danger">
                </div>
            </div>
        </form>

    </div>
</body>
</html>
