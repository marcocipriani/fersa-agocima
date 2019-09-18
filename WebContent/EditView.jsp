<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<%@ page import="model.EvalApt" %>
<%@ page import="controller.EditController" %>
<%@ page import="model.EvalUsr" %>
<%@ page import="model.Eval" %>

<%
	if (request.getParameter("edit") != null) {
		int evalId = Integer.parseInt(request.getParameter("id"));
		boolean isForUsr = Boolean.parseBoolean(request.getParameter("isforusr"));
		String evalText = request.getParameter(request.getParameter("text"));
		int evalStars = Integer.parseInt(request.getParameter("stars"));
		
		EditController.setEval(evalId, evalText, evalStars, isForUsr);
%>
		<jsp:forward page="ProfileView.jsp"/>
<% 
	}

int evalId = Integer.parseInt(request.getParameter("idfromprofile"));
boolean isForUsr = Boolean.parseBoolean(request.getParameter("isforusrprofile"));
System.out.println(isForUsr);
isForUsr = Boolean.valueOf(request.getParameter("isforusrprofile"));
System.out.println(isForUsr);
int evalStars = Integer.parseInt(request.getParameter("starsfromprofile"));
String evalText = request.getParameter("textfromprofile").toString();
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

        <h2>Modifica la tua valutazione</h2>
        
        <hr>

        <form name="editForm" action="EditView.jsp"  method="POST">
            <div class="row">
                <div class="col-8 offset-2 form-group">
                    <label>Testo della valutazione</label><br>
                    <input name="id" type="hidden" value="<%= eval.getId() %>">
                    <input name="isforusr" type="hidden" value="<%= isForUsr %>">             
                    <textarea name="text" rows="10" cols="100">
                    <%= eval.getText() %>
                    </textarea>
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
                    <input id="editButton" type="submit" name="edit" value="Modifica valutazione" class="btn btn-secondary">
                    <input type="reset" name="reset" class="btn btn-outline-secondary">
                </div>
            </div>
        </form>

    </div>
</body>
</html>
