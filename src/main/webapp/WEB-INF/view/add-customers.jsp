<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html>
<head>
    <title>Customer</title>
    <style>
        .error {
            color: red;
        }

        label {
            display: block;
            margin-bottom: 5px;
        }

        input[type="text"] {
            width: 200px;
            padding: 5px;
            margin-bottom: 10px;
        }

        form {
            margin-top: 20px;
        }

        form button {
            padding: 10px;
            background-color: #007bff;
            color: #fff;
            border: none;
            cursor: pointer;
        }

        form button:hover {
            background-color: #0056b3;
        }
    </style>
</head>
<body>
<a href="${pageContext.request.contextPath}/customers/customers/">view customers</a>
<form:form method="post" action="${pageContext.request.contextPath}/customers/add" modelAttribute="customer">
    <label>First Name</label><form:input path="firstName" />
    <label>Last Name</label><form:input path="lastName"/><br>
    <label>Email</label><form:input path="email"/><br>
    <form:button type="submit" >Add Customer</form:button>
</form:form>
</body>
</html>
