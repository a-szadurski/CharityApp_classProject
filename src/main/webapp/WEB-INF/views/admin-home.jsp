<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<%@ include file="header.jsp" %>
<header class="header--form-page">
    <%@ include file="navbar.jsp" %>

    <div>
        <h2>
            Zarządzaj fundacjami:
        </h2>
    </div>
    <div class="w3-container">
        <table class="w3-table-all">
            <thead>
            <tr>
                <th>Id</th>
                <th>Nazwa</th>
                <th>Opis</th>
                <th colspan="2"></th>
            </tr>
            </thead>
            <tbody>
            <c:forEach items="${institutions}" var="institution">
                <tr>
                    <td>${institution.id}</td>
                    <td>${institution.name}</td>
                    <td>${institution.description}</td>
                    <td>
                        <a href='<c:url value="${pageContext.request.contextPath}/admin/institution/update/${institution.id}"/>'
                           class="w3-button w3-border w3-padding-small">Edytuj</a></td>
                    <td>
                        <a href='<c:url value="${pageContext.request.contextPath}/admin/institution/delete/${institution.id}"/>'
                           class="w3-button w3-border w3-padding-small">Usuń</a></td>
                </tr>
            </c:forEach>
            <tr>
                <th colspan="5"><a href='<c:url value="${pageContext.request.contextPath}/admin/institution/create"/>'
                                   class="w3-button w3-border w3-padding-small">Dodaj</a></th>
            </tr>
            </tbody>
        </table>
    </div>
</header>

<%@include file="footer.jsp" %>


<script src="<c:url value="/resources/js/app.js"/>"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
</body>
</html>
