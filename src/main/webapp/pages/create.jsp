<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page import="java.util.List"%>
<%@ page buffer="16kb"%>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Add new Person</title>
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-ka7Sk0Gln4gmtz2MlQnikT1wXgYsOg+OMhuP+IlRH9sENBO0LRn5q+8nbTov4+1p" crossorigin="anonymous"></script>    
</head>
<body>
    <div class="container-fluid" style="background-color:black; min-height: 100%; height: 100vh;">
        <div class="container text-light bg-dark align-middle" style="height: 100vh;">
            <h2 class="text-center text-uppercase" style="color: whitesmoke; padding-top: 20px;">${welcomeMessage}</h2>
            <div class="container form-group" style="max-width: 55%; margin-top: 30px;">
                <form action="${requestName}" method="post">
                    <div class="container-fluid d-flex flex-row justify-content-between">
                        <label>NAME:
                            <input class="form-control-sm" type="text" value="${nameValue}" name="nameParam">
                        </label>
                        <label>AGE:
                            <input class="form-control-sm" type="number" value="${ageValue}" name="ageParam">
                        </label>
                    </div>
                    <div style="margin-top: 30px;">
                        <input class="form-control-lg" type="hidden" value="${personId}" name="personId">
                        <button class="container-fluid btn-lg btn-primary btn-block" type="submit" id="creating">Submit</button>
                    </div>
                </form">
                <form action="/servlets-app/main" method="get">
                    <button class="container-fluid btn-lg btn-warning btn-block"  style="margin-top: 10px;">Cancel</button>
                </form>
            </div>
        </div>
    </div>
</body>
</html>