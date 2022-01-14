<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page import="java.util.List"%>
<%@ page buffer="16kb"%>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Add new Person</title>
</head>
<body>
<h2>${welcomeMessage}</h2>
<form action="${requestName}" method="post">
    <label>NAME:
        <input type="text" value="${nameValue}" name="nameParam">
    </label>
    <label>AGE:
        <input type="number" value="${ageValue}" name="ageParam">
    </label>
    <input type="hidden" value="${personId}" name="personId">
    <button type="submit" id="creating">Submit</button>
</form>
<br>
<form action="/servlets-app/main" method="get">
    <button>Cancel</button>
</form>
</body>
</html>