<%@ page language="java" pageEncoding="UTF-8" contentType="text/html; charset=UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@ taglib prefix="e" uri="/WEB-INF/tld/enum.tld" %>
<c:set var="ctxPath" value="${pageContext.request.contextPath}" scope="session"/>


<%--看看jstl版本是多少，如果是1.0的话--%>
<%--<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>--%>

<%--换成：--%>
<%--<%@ taglib uri="http://java.sun.com/jstl/core" prefix="c" %>--%>