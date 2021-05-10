<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<%@ include file="../header.jsp" %>
<header>
    <%@ include file="../user/navbar-logged.jsp" %>


</header>
<div class="form--steps-container">
    <div>
        <h2>Moje Dary:</h2>
    </div>
    <table class="w3-table-all">
        <thead>
        <tr>
            <th>Data utworzenia</th>
            <th>Fundacja</th>
            <th>Planowana data odbioru</th>
            <th>Odebrane</th>
            <th>Data odebrania</th>
            <th></th>
        </tr>
        </thead>
        <tbody>
        <c:forEach items="${donations}" var="d">
            <tr>
                <td>${d.entryDate}</td>
                <td>${d.institution.name}</td>
                <td>${d.pickupDate}</td>
                <td>${d.pickupStatus}</td>
                <td>${d.pickupStatusDate}</td>
                <td><a href='<c:url value="${pageContext.request.contextPath}/user/donation/${d.id}"/>'
                       class="w3-button w3-border w3-padding-small w3-orange">Szczegóły</a></td>
            </tr>

        </c:forEach>
        </tbody>
    </table>
</div>

<%@include file="../footer.jsp" %>


<script src="<c:url value="/resources/js/app.js"/>"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
</body>
</html>
