<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1" %>

<!-- Creating LoginBean and SearchBean -->
<jsp:useBean id="loginBean" scope="session" class="bean.LoginBean"/>
<jsp:useBean id="searchBean" scope="session" class="bean.SearchBean" />

<!-- Mapping JSP properties -->
<jsp:setProperty name="loginBean" property="username"/>
<jsp:setProperty name="loginBean" property="password"/>
<jsp:setProperty name="loginBean" property="loginRole"/>
<jsp:setProperty name="searchBean" property="searchKeyword"/>
<jsp:setProperty name="searchBean" property="choice"/>

<!-- Check on loginForm -->
<%
    if (request.getParameter("login") != null) {
    	if (loginBean.validate()) {
%>
            <jsp:forward page="ProfileView.jsp"/>
<%
        } else {
%>
            <p style="text-color:red; text-align: center;">Dati errati</p>
<%
        }
    } else {
%>
        <p class="text-info" style="text-align: center;">Accesso non effettuato</p>
<%
    }
%>

<!-- Check on searchForm -->
<%
	if (request.getParameter("search") != null) {
		System.out.println(searchBean.getSearchKeyword());
        System.out.println(searchBean.isChoice());
%>
            <jsp:forward page="SearchView.jsp"/>
<%
	}
%>

<!DOCTYPE html>
<html>
<head>
    <title>Homepage.jsp</title>
    <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">

    <link rel="stylesheet" type="text/css" href="css/bootstrap.css">
    <link rel="stylesheet" type="text/css" href="css/bootstrap-grid.css">
    <link rel="stylesheet" type="text/css" href="css/style.css">
</head>
<body class="homepage">
    <div class="container text-center login">

        <h2>Accesso all'area riservata</h2>

        <form action="HomePage.jsp" name="loginForm" method="POST" align="center">
            <div class="row">
                <div class="col-8 offset-2 form-group">
                    <label for="username">Username</label>
                    <input id="username" name="username" type="text" placeholder="username" class="form-control">
                </div>
            </div>
            <div class="row">
                <div class="col-8 offset-2 form-group">
                    <label for="password">Password</label>
                    <input id="password" name="password" type="password" placeholder="password" class="form-control">
                </div>
            </div>
            <div class="row">
                <div class="col-8 offset-2 form-group">
                    <label for="tenantCheck">Entrare come proprietario?</label>
                    <input id="tenantCheck" name="loginRole" type="checkbox" class="form-check-input"  value="true">
                </div>
            </div>
            <div class="row">
                <div class="col text-center">
                    <input id="login" type="submit" name="login" value="Accedi" class="btn btn-info">
                    <input type="reset" name="reset" class="btn btn-outline-info">
                </div>
            </div>
        </form>

    </div>

    <div class="container text-center search">

        <h2>Ricerca di appartamenti o utenti</h2>

        <form action="HomePage.jsp" name="searchForm" method="POST">
            <div class="row">
                <div class="col-8 offset-2 text-center form-group">
                    <input id="searchKeyword" name="searchKeyword" type="text"  value="" placeholder="Digitare indirizzo o username" class="form-control">
                </div>
            </div>
            <div class="row">
                <%-- if false apt, true usr --%>
                <div class="col-4 offset-2 form-group">
                    <label for="aptRadio">Ricerca appartamento</label><input id="aptRadio" type="radio" name="choice" value="false" checked>
                </div>
                <div class="col-4 form-group">
                    <label for="userRadio">Ricerca utente</label><input id="userRadio" type="radio" name="choice" value="true">
                </div>
            </div>
            <div class="row">
                <div class="col text-center">
                    <input id="searchButton" type="submit" name="search" value="Cerca" class="btn btn-success">
                    <input type="reset" name="reset" class="btn btn-outline-success">
                </div>
            </div>

        </form>

    </div>
</body>
</html>