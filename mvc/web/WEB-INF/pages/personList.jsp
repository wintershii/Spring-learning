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

    <script lang="JavaScript">
        function deleteMuch() {
            document.forms[0].action = "${pageContext.request.contextPath}/user/deleteMuch";
            document.forms[0].submit();
        }
    </script>

</head>
<body>
    <form action="${pageContext.request.contextPath}" method="post">

        <a href="/user/createPersonInfo">新增</a>

        <a href="#" onclick="deleteMuch()">批量删除</a>

        <table border="1">
            <tr>
                <td>选择：</td>
                <td>头像：</td>
                <td>编号：</td>
                <td>姓名：</td>
                <td>年龄：</td>
                <td>操作：</td>
            </tr>
            
            <c:forEach items="${personList}" var="p">
                <tr>
                    <td>
                        <input type="checkbox" name="id" value="${p.id}">
                    </td>
                    <td>
                        <img src="${pageContext.request.contextPath}${p.photoPath}">
                    </td>
                    <td>${p.id}</td>
                    <td>${p.name}</td>
                    <td>${p.age}</td>
                    <td>
                        <a href="/user/updatePersonInfo?id=${p.id}">修改</a>
                        <a href="/user/deleteById?id=${p.id}">删除</a>
                    </td>
                </tr>
            </c:forEach>
        </table>
    </form>
</body>
</html>
