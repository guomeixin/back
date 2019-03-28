<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2019/3/22
  Time: 21:11
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ include file="/WEB-INF/pages/common/head.jsp" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!--<html>
<head>
    <title>list</title>
    <style>
        #tb{
            border-collapse: collapse;
        }
        #tb th,#tb td{
            border:1px solid #999999;
            padding :5px 10px;
        }
    </style>
</head>
<body>
<table id="tb">
    <thead>
    <tr>
        <th>编号</th>
        <th>登录编号</th>
        <th>姓名</th>
        <th>电话</th>
        <th>密码</th>
        <th>性别</th>
        <th>生日</th>
        <th>邮箱</th>
        <th>地址</th>
        <th>是否失效</th>

    </tr>
    </thead>
    <tbody>
    <c:forEach var="user" items="${list}">
        <tr>
            <td>${user.id}</td>
            <td>${user.login_id}</td>
            <td>${user.name}</td>
            <td>${user.phone}</td>
            <td>${user.password}</td>
            <td>${user.sex}</td>
            <td>${user.birthday}</td>
            <td>${user.email}</td>
            <td>${user.address}</td>
            <td>
                <a href="update?id=${user.id}">修改</a>
                <c:if test="${user.is_del==1}"><a href="javascript:void(0)" onclick="del(${user.id},1)">删除</a></c:if>
                <c:if test="${user.is_del==0}"><a href="javascript:void(0)" onclick="del(${user.id},1)">恢复</a></c:if>
                <a href="user/add?id=${user.id}">添加</a>
            </td>
        </tr>
    </c:forEach>
    </tbody>
</table>
<a href="add" >添加</a>
<script>
    function del(id,flag){
        var message=flag==1?"确定要删除吗":"确定要恢复吗";
        if(confirm(message)){
            window.location.href="delete?id="+id;
        }
    }
</script>
</body>

</html>-->
<!DOCTYPE html>
<html lang="zh-cn">
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=no" />
    <meta name="renderer" content="webkit">
    <title></title>
    <link rel="stylesheet" href="${basePath}/css/pintuer.css">
    <link rel="stylesheet" href="${basePath}/css/admin.css">
    <script src="${basePath}/js/jquery.js"></script>
    <script src="${basePath}/js/pintuer.js"></script>
    <script src="https://cdn.jsdelivr.net/npm/vue/dist/vue.js"></script>
</head>
<body>
<form method="post" action="" id="listform">
    <div class="panel admin-panel">

        <table class="table table-hover text-center">
            <thead>
                <tr>
                    <th>登录名</th>
                    <th>用户名</th>
                    <th>电话</th>
                    <th>性别</th>
                    <th>email</th>
                    <th>地址</th>
                    <th>操作</th>
                </tr>
            </thead>
            <tbody>

            </tbody>
        </table>
    </div>
</form>
<script>
     new Vue
</script>
</body>
</html>
