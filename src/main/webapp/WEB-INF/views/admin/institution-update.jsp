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
        Edytuj fundację:
    </h2>
</div>
<div class="w3-container">
    <table class="w3-table-all">
        <thead>
        <tr>
            <th>Id</th>
            <th>Nazwa</th>
            <th>Opis</th>
        </tr>
        </thead>
        <tbody>
        <tr>
            <td>${institution.id}</td>
            <td>${institution.name}</td>
            <td>${institution.description}</td>
        </tr>
        <form:form method="post" modelAttribute="institution">
            <tr>
                <td></td>
                <td><form:textarea path="name" placeholder="${institution.name}" rows="2"/></td>
                <td><form:textarea path="description" placeholder="${institution.description}" rows="5"/></td>
            </tr>
            <tr>
                <th colspan="3"><input type="submit" class="w3-button w3-border w3-padding-small w3-green"
                                       value="Zapisz"></th>
            </tr>
            <tr>
                <th colspan="3"><a href='<c:url value="${pageContext.request.contextPath}/admin"/>'
                                   class="w3-button w3-border w3-padding-small w3-red">Anuluj</a></th>
            </tr>
        </form:form>
        </tbody>
    </table>
</div>

<%@include file="../admin/admin-footer.jsp" %>
