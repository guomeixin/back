<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2019/3/23
  Time: 11:24
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Head</title>
</head>
<body>
 <%
   String basePath= request.getScheme()+"://"+ request.getServerName();
   if(request.getLocalPort()!=80){
       basePath+=":"+request.getServerPort();
   }
   basePath+=request.getContextPath();
   pageContext.setAttribute("basePath", basePath);
 %>
</body>
</html>
