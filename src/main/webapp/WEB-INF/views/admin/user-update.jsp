<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<%@ include file="../admin/admin-menu.jsp" %>
<br>
<br>
<br>
<br>
<div>
    <h2>
        Edytuj użytkownika ${user.email}:
    </h2>
</div>
<section class="login-page">
    <h2>Załóż konto</h2>
    <form:form method="post" modelAttribute="user">
        <div class="form-group">
            <form:input type="email" path="email" name="email"/>
        </div>
        <div class="form-group">
            <form:input path="password" type="password" name="password"/>
        </div>
        <div class="form-group">
            <form:input path="matchingPassword" type="password" name="password2"/>
        </div>

        <div class="form-group form-group--buttons">
            <button class="btn" type="submit">Zapisz</button>
            <a href='<c:url value="${pageContext.request.contextPath}/admin"/>'
               class="w3-button w3-border w3-padding-small w3-red">Anuluj</a></th>
        </div>
    </form:form>
</section>


<%@include file="../admin/admin-footer.jsp" %>
