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
        Dodaj użytkownika:
    </h2>
</div>
<div class="w3-container">
    <form:form method="post" modelAttribute="user">
        <table class="w3-table-all">
            <tbody>
            <tr>
                <td>Email</td>
                <td>
                    <form:input type="email" path="email" name="email" placeholder="Email"/>
                </td>
            </tr>
            <tr>
                <td>Hasło</td>
                <td>
                    <form:input path="password" type="password" name="password" placeholder="Hasło"/>
                </td>
            <tr>
                <td>Powtórz hasło</td>
                <td>
                    <form:input path="matchingPassword" type="password" name="password2" placeholder="Powtórz hasło"/>
                </td>
            </tr>
            <tr>
                <th colspan="2">
                    <button class="btn" type="submit">Utwórz</button>
                </th>
            </tr>
            <tr>
                <th colspan="2"><a href='<c:url value="${pageContext.request.contextPath}/admin/user/all"/>'
                                   class="w3-button w3-border w3-padding-small w3-red">Anuluj</a></th>
            </tr>
            </tbody>
        </table>
    </form:form>
</div>
<%@include file="../admin/admin-footer.jsp" %>
