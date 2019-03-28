<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2019/3/26
  Time: 8:24
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
<head>
    <title>update</title>
</head>
<body>
    <form action="update" method="post">
        <input type="hidden" value="user.id"/><br/>
        编号：<input name="id" value="${user.id}"/><br/>
        登录编号：<input name="login_id" value="${user.login_id}"/><br/>
        姓名：<input name="name" value="${user.name}"/><br/>
        电话：<input name="phone" value="${user.phone}"/><br/>
        密码：<input name="password" value="${user.password}"/><br/>
        性别：<input name="sex" value="${user.sex}"/><br/>
        生日：<input name="birthday" value="${user.birthday}"/><br/>
        邮箱：<input name="email" value="${user.email}"/><br/>
        地址：<input name="address" value="${user.address}"/><br/>
        <button type="submit">提交</button>
    </form>
</body>
</html>
