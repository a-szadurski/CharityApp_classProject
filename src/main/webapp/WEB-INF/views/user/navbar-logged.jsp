<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<nav class="container container--70">
    <ul class="nav--actions">
        <li><a href='<c:url value="${pageContext.request.contextPath}/logout"/>'
               class="btn btn--small btn--without-border">Wyloguj</a></li>
        <li><a href='<c:url value="${pageContext.request.contextPath}/user/profile"/>'
               class="btn btn--small btn--highlighted">Profil</a></li>
    </ul>

    <ul>
        <li><a href='<c:url value="${pageContext.request.contextPath}/user/donate"/>'
               class="btn btn--without-border active">Przekaż dar</a></li>
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