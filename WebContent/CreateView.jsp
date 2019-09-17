<%@ page contentType="text/html;charset=UTF-8" language="java" %>


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
    <div class="container">

<%
if(request.getParameter("create")!=null) {
	System.out.println(request.getParameter("id"));
}
%>

    </div>
</body>
</html>
