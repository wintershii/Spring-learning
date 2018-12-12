<%--
  Created by IntelliJ IDEA.
  User: shidongxuan
  Date: 18-12-12
  Time: 下午5:42
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>修改信息</title>
</head>
<body>
    <form method="post" action="/user/updatePersonList" enctype="multipart/form-data">
        <input type="hidden" name="id" value="${p.id}">
        姓名:<input type="text" name="name" value="${p.name}">
        <br/>
        年龄:<input type="text" name="age" value="${p.age}">
        <br/>
        头像:<input type="file" name="photo">
        <br/>

        <input type="submit" value="修改">
    </form>

</body>
</html>
