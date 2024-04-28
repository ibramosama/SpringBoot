<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html>
<head>
    <title>Customer</title>
    <style>
        body {
            font-family: Arial, sans-serif;
            background-color: #f4f4f4;
        }

        .container {
            max-width: 500px;
            margin: 0 auto;
            padding: 20px;
            background-color: #fff;
            border-radius: 5px;
            box-shadow: 0 2px 4px rgba(0, 0, 0, 0.1);
        }

        .form-group {
            margin-bottom: 20px;
        }

        label {
            display: block;
            margin-bottom: 5px;
            font-weight: bold;
        }

        input[type="text"] {
            width: 100%;
            padding: 10px;
            border: 1px solid #ccc;
            border-radius: 5px;
        }

        .btn {
            display: inline-block;
            padding: 10px 20px;
            background-color: #007bff;
            color: #fff;
            text-decoration: none;
            border-radius: 5px;
            cursor: pointer;
        }

        .btn:hover {
            background-color: #0056b3;
        }

        .error {
            color: red;
        }
    </style>
</head>
<body>
<div class="container">
    <a href="${pageContext.request.contextPath}/customers/customers/" class="btn">View Customers</a>
    <h1>Edit Customer</h1>
    <form:form method="post" action="${pageContext.request.contextPath}/customers/edit/${customer.id}" modelAttribute="customer">
        <div class="form-group">
            <label for="firstName">First Name</label>
            <form:input path="firstName" id="firstName" class="form-control" value="${customer.firstName}"/>
        </div>
        <div class="form-group">
            <label for="lastName">Last Name</label>
            <form:input path="lastName" id="lastName" class="form-control" value="${customer.lastName}"/>
        </div>
        <div class="form-group">
            <label for="email">Email</label>
            <form:input path="email" id="email" class="form-control" value="${customer.email}"/>
        </div>
        <button type="submit" class="btn">Save</button>
    </form:form>
</div>
</body>
</html>
