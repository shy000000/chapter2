<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: root
  Date: 8/20/17
  Time: 10:14 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>login</title>
</head>
<body>
<c:if test="${!empty error}">
    <font color="red"><c:out value="${error}"/></font>
</c:if>
<form action="<c:url value="/loginCheck.html"/> " method="post">
    用户名：<input type="text" name="userName"/><br>
    密码：<input type="text" type="password" name="password"/><br>
    <input type="submit" value="login"/>
    <input type="reset" value="reset"/>
</form>
</body>
</html>
