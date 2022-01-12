<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page import="java.util.List"%>
<%@ page buffer="16kb"%>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Crowd</title>
</head>
<body>
<h2>Crowd non-exiting people</h2>
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
        <c:forEach items="${ListOfPerson}" var="itemPerson">

            <tr>
                <td>${itemPerson.getId()}</td>
                <td>${itemPerson.getName()}</td>
                <td>${itemPerson.getAge()}</td>
                <td>
                    <form action="/servlets-app/update" method="get">
                        <input type="hidden" name="updateById" value="${itemPerson.getId()}"/>
                        <button type="submit">UPDATE</button>
                    </form>
                </td>
                <td>
                    <form action="/servlets-app/delete" method="post">
                        <input type="hidden" name="deleteById" value="${itemPerson.getId()}"/>
                        <button type="submit">DELETE</button>
                    </form>
                </td>
            </tr>

        </c:forEach>
    </tbody>
</table>
<br>
<br>
<form action="/servlets-app/createPerson" method="get">
    <button>Add new person</button>
</form>
</body>
</html>

