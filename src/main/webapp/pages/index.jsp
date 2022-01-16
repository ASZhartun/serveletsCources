<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page import="java.util.List"%>
<%@ page buffer="16kb"%>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Crowd</title>
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-ka7Sk0Gln4gmtz2MlQnikT1wXgYsOg+OMhuP+IlRH9sENBO0LRn5q+8nbTov4+1p" crossorigin="anonymous"></script>    
</head>
<body>
<div class="container-fluid-sm" style="background-color:black; min-height: 100%; background-size: cover; height: 100vh;">
    <div class="container">
        <h2 class="text-center text-uppercase" style="color: whitesmoke; padding: 3vh 3vh;">Crowd of non-existing people</h2>
        <table class="table table-bordered table-dark table-hover text-center">
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
                            <form action="/servlets-app/update" method="get" role="group">
                                <div class="form-group">
                                    <input type="hidden" name="updateById" value="${itemPerson.getId()}"/>
                                    <button class="btn btn-warning container-fluid" type="submit">UPDATE</button>
                                </div>
                            </form>
                        </td>
                        <td>
                            <form action="/servlets-app/delete" method="post">
                                <input type="hidden" name="deleteById" value="${itemPerson.getId()}"/>
                                <button class="btn btn-danger container-fluid" type="submit">DELETE</button>
                            </form>
                        </td>
                    </tr>
        
                </c:forEach>
            </tbody>
        </table>
        <form class="container-fluid-sm" action="/servlets-app/createPerson" method="get">
            <button class="container-fluid btn-lg btn-primary btn-block">Add new person</button>
        </form>
    </div>
</div>


</body>
</html>

