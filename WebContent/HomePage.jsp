<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1" %>
<%@ page errorPage = "ErrorView.jsp" %>

<!-- Creating LoginBean and SearchBean -->
<jsp:useBean id="loginBean" scope="request" class="bean.LoginBean"/>
<jsp:useBean id="searchBean" scope="request" class="bean.SearchBean" />
<jsp:useBean id="profileBean" scope="session" class="bean.ProfileBean"/>

<!-- Mapping JSP properties -->
<jsp:setProperty name="loginBean" property="username"/>
<jsp:setProperty name="loginBean" property="password"/>
<jsp:setProperty name="loginBean" property="loginRole"/>
<jsp:setProperty name="searchBean" property="searchKeyword"/>
<jsp:setProperty name="searchBean" property="choice"/>

<!-- Reset after logoutForm -->

<% 
 if (request.getParameter("logout") != null) {
	 profileBean.setLoginRole(false);
     profileBean.setPassword("");
     profileBean.setUsername("");
     profileBean.setFirsTime(true);
     request.getSession().invalidate();
 	}
 %>

<!-- Check on loginForm -->
<%
    if (request.getParameter("login") != null) {
    	if (loginBean.validate()) {
			if (loginBean.checkRole()) {
			    profileBean.setFirsTime(true); // every login is the first time
%>
            	<jsp:forward page="ProfileView.jsp"/>
<%
			} else {
%>
				<p style="text-color:red; text-align: center;">Non hai i privilegi necessari</p>
<%
			}
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
		System.out.println("@Homepage - Chiave di ricerca: " + searchBean.getSearchKeyword());
        System.out.println("@Homepage - Selezione apt[false]/usr[true]: " + searchBean.isChoice());
        if (!searchBean.isChoice()){
%>
            <jsp:forward page="SearchAptView.jsp"/>
<%
        } else {
%>
            <jsp:forward page="SearchUsrView.jsp"/>
<%
        }
	}
%>

<!DOCTYPE html>
<html>
<head>
    <title>Homepage.jsp</title>
    <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">

    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">

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

        <form action="HomePage.jsp" name="searchForm" method="GET">
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