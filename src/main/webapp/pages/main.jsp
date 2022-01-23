<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page import="java.util.List"%>
<%@ page buffer="16kb"%>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Menu</title>
</head>
<body>
    <h1>Hello, Stranger!</h1>
    <div>
        <div>
            <form action="/department" method="get">
                <button type="submit">Departments</button>
            </form>
        </div>
        <div>
            <form action="/developers" method="get">
                <button type="submit">Developers</button>
            </form>
        </div>
        <div>
            <form action="/main" method="get">
                <button type="submit">People behind bars</button>
            </form>
        </div>
    </div>
    
</body>
</html>