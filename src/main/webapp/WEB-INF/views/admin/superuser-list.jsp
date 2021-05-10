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
<div class="w3-container">
    <table class="w3-table-all">
        <thead>
        <tr>
            <th colspan="5"><a href='<c:url value="${pageContext.request.contextPath}/admin/user/add"/>'
                               class="w3-button w3-border w3-padding-small w3-green">Dodaj</a></th>
        </tr>
        <tr>
            <th>Id</th>
            <th>Email</th>
            <th>Aktywny</th>
            <th colspan="3"></th>
        </tr>
        </thead>
        <tbody>
        <c:forEach items="${users}" var="user">
            <tr>
                <td>${user.id}</td>
                <td>${user.email}</td>
                <td>${user.enabled}</td>
                <td>
                    <a href='<c:url value="${pageContext.request.contextPath}/admin/user/update/${user.id}"/>'
                       class="w3-button w3-border w3-padding-small w3-orange">Edytuj</a></td>
                <td>
                    <a href='<c:url value="${pageContext.request.contextPath}/admin/user/delete/${user.id}"/>'
                       class="w3-button w3-border w3-padding-small w3-red">Usuń</a></td>
            </tr>
        </c:forEach>
        </tbody>
    </table>
</div>

<%@include file="../admin/admin-footer.jsp" %>

