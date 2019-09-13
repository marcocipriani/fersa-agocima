<%@ page import="model.EvalApt" %>
<%@ page import="model.Eval" %>
<%@ page import="dao.EvalUsrDAO" %>
<%@ page import="java.util.Vector" %>
<%@ page import="java.util.Arrays" %>
<%@ page import="dao.EvalAptDAO" %>
<%@ page import="model.EvalUsr" %>
<%@ page import="bean.SearchBean" %>
<%@ page import="controller.SearchController" %>




<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<jsp:useBean id="searchBean" scope="session" type="bean.SearchBean"/>





<!-- jsp:useBean id="apt" scope="session" type="model.Apt" -->
<!-- jsp:useBean id="ea" scope="session" class="model.EvalApt" -->


<%-- if searchBean.coiche == searchApt
        find --%>
<%
	
	Eval[] e;
	e = SearchController.searchList(searchBean.isChoice(), searchBean.getSearchkeyword());
	System.out.println(e);
	System.out.println(searchBean.getSearchkeyword());

	




	//Vector evalList;
	//Eval [] e;
	

    /*if (searchBean.isChoice()){
    	Vector evalList= EvalAptDAO.findEvalMadeByYou(searchBean.getSearchkeyword());
    	EvalApt[] e = new EvalApt[evalList.size()];
    	evalList.toArray(e);
    	return e;
    	}
    else {
    	evalList= EvalUsrDAO.findEvalMadeByYou(loginBean.getNome());
    	e = new EvalUsr[evalList.size()];
    	evalList.toArray(e);
    }*/
%>

<html>
<head>
    <title>SearchView</title>
</head>
<body>

    <h1>Ricerca di appartamenti e utenti</h1>
    <p>Hai cercato ' SEARCH_KEYWORD '</p>
    <p>NUMBER risultati</p>
    <hr>

    <%
        for (int i = 0; i < e.length; i++) {
    
    

       System.out.println(e[i].getId());
       System.out.println(e[i].getStars()); 
       System.out.println(e[i].getText());
       System.out.println(e[i].getEvalusr());



        }
    %>
    
</body>
</html>