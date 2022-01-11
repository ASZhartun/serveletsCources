<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page import="java.util.List"%>
<%@ page import="cot.anatoliy.entity.Person"%>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Crowd</title>
</head>
<body>
<h2>Crowd non-exiting people</h2>



<br>


<br>
<table border="2px">
    <thead>
    <th>ID</th>
    <th>NAME</th>
    <th>AGE</th>
    <th>ACTION1</th>
    <th>ACTION2</th>
    </thead>
    <tbody>
    <tr>
        <td>1</td>
        <td>Korpatov Oleg Denisovich</td>
        <td>45</td>
        <td>
            <form action="/servlets-app/main" method="get">
                <button type="submit">UPDATE</button>
            </form>
        </td>
        <td>
            <form action="/servlets-app/main" method="get">
                <button type="submit">DELETE</button>
            </form>
        </td>
    </tr>
    <tr>
        <td>2</td>
        <td>Ivanov Zigmund Albertovich</td>
        <td>32</td>
        <td>
            <form action="/servlets-app/main" method="get">
                <button type="submit">UPDATE</button>
            </form>
        </td>
        <td>
            <form action="/servlets-app/main" method="get">
                <input type="hidden" name="deleteIdParam"  value="${person.getId()}"   />
                <button type="submit">DELETE</button>
            </form>
        </td>
    </tr>
    </tbody>
</table>
<br><br><br>

<table border="2">

    <c:forEach items="${personList}" var="person">
        <tr>
            <td>${person.getId()}</td>
            <td>${person.getName()}</td>
            <td>${person.getAge()}</td>
        </tr>
    </c:forEach>
</table>

<br><br><br>
<form action="/servlets-app/createPerson" method="get">
    <button>Add new person</button>
</form>
</body>
</html>

