<%--
  Created by IntelliJ IDEA.
  User: unbelievable9
  Date: 2018/7/26
  Time: 下午5:32
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Shiro Web</title>
</head>
<body>
<label>
    Login Success, Welcome: ${subject.principal}
    <br/>
    <a href="${pageContext.request.contextPath}/logout">Logout</a>
    <a href="${pageContext.request.contextPath}/role">Check Role</a>
</label>
</body>
</html>
