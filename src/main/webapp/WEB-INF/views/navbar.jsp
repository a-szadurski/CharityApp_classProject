<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<nav class="container container--70">
    <ul class="nav--actions">
        <li><a href='<c:url value="${pageContext.request.contextPath}/login"/>'
               class="btn btn--small btn--without-border">Zaloguj</a></li>
        <li><a href='<c:url value="${pageContext.request.contextPath}/register"/>'
               class="btn btn--small btn--highlighted">Załóż konto</a></li>
    </ul>

    <ul>
        <li><a href='<c:url value="${pageContext.request.contextPath}/"/>'
               class="btn btn--without-border active">Start</a></li>
        <li><a href='<c:url value="${pageContext.request.contextPath}/mission"/>' class="btn btn--without-border">O co
            chodzi?</a></li>
        <li><a href='<c:url value="${pageContext.request.contextPath}/about"/>' class="btn btn--without-border">O
            nas</a></li>
        <li><a href='<c:url value="${pageContext.request.contextPath}/institutions"/>' class="btn btn--without-border">Fundacje
            i organizacje</a></li>
        <li><a href='<c:url value="${pageContext.request.contextPath}/contact"/>' class="btn btn--without-border">Kontakt</a>
        </li>
    </ul>
</nav>