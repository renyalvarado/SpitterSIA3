<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Strict//EN"
    "http://www.w3.org/TR/xhtml1/DTD/xhtml1-strict.dtd">
<html xmlns="http://www.w3.org/1999/xhtml" xml:lang="en" lang="en">
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8"/>
        <title>
            <tiles:insertAttribute name="title" ignore="true" />
        </title>
        <link rel="shortcut icon" href="<c:url value='/static/img/favicon.ico'/>" type="image/x-icon" /> 
        <link rel="stylesheet" type="text/css" media="screen"
              href="<c:url value='/static/css/main.css'/>" />
    </head>
    <body>
        <tiles:insertAttribute name="header"/>
        <tiles:insertAttribute name="menu"/>
        <tiles:insertAttribute name="side"/>
        <tiles:insertAttribute name="body"/>
        <tiles:insertAttribute name="footer"/>
    </body>
</html>
