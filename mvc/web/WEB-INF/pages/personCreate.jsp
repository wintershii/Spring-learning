<%--
  Created by IntelliJ IDEA.
  User: shidongxuan
  Date: 18-12-11
  Time: 下午10:22
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>新增人员</title>
</head>
<body>
    <form action="/user/updatePersonList" method="post"
          enctype="multipart/form-data">
        姓名:<input type="text" name="name">
        <br/>
        年龄:<input type="text" name="age">
        <br/>
        头像:<input type="file" name="photo">
        <br/>
        <input type="submit" value="提交">
        <br/>
    </form>

</body>
</html>
