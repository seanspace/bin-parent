<%--
  Created by IntelliJ IDEA.
  User: xiaobin
  Date: 2016/12/13
  Time: 23:59
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/comm/taglibs.jsp"%>
<html>
<head>
    <title>Demo</title>
</head>
<body>
性别：
<e:write type="com.bin.api.enums.SexEnum" enumValue="${sex}" />
</br>
是否：
<b:write value="${bool}" />
</body>
</html>
