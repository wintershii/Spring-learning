<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: shidongxuan
  Date: 18-12-11
  Time: 下午9:51
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>人员列表</title>
</head>
<body>
    <form action="${pageContext.request.contextPath}" method="post">

        <a href="/user/createPersonInfo">新增</a>

        <table border="1">
            <tr>
                <td>编号：</td>
                <td>姓名：</td>
                <td>年龄：</td>
            </tr>
            
            <c:forEach items="${personList}" var="p">
                <tr>
                    <td>${p.id}</td>
                    <td>${p.name}</td>
                    <td>${p.age}</td>
                </tr>
            </c:forEach>
        </table>
    </form>
</body>
</html>
