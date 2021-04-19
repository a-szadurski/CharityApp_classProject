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
        <tbody>
        <tr>
            <td>Ilość worków</td>
            <td>
                <ul>
                    <li>${d.quantity}</li>
                </ul>
            </td>
        </tr>
        <tr>
            <td>Kategorie</td>
            <td>
                <ul>
                    <c:forEach items="${d.categories}" var="c">
                        <li>${c.name}</li>
                    </c:forEach>
                </ul>
            </td>
        </tr>
        <tr>
            <td>Adres nadania</td>
            <td>
                ul. ${d.street}<br>
                Kod pocztowy: ${d.zipCode}<br>
                Miasto: ${d.city}<br>
                tel. ${d.phoneNumber}
            </td>
        </tr>
        <tr>
            <td>Data utworzenia</td>
            <td>${d.entryDate}</td>
        </tr>
        <tr>
            <td>Fundacja</td>
            <td>${d.institution.name}</td>
        </tr>
        <tr>
            <td>Planowany odbiór</td>
            <td>${d.pickupDate}</td>
        </tr>
        <tr>
            <td>Status odbioru</td>
            <td>${d.pickupStatus}</td>
        </tr>
        <tr>
            <form:form modelAttribute="d">
            <td>Data odebrania</td>
            <td><form:input type="date" path="pickupStatusDate"/></td>
        </tr>
        <tr>
            <td></td>
            <td>
                <button class="w3-button w3-border w3-padding-small w3-green" type="submit">Zapisz</button>
            </td>
        </tr>
        </form:form>
        </tbody>
    </table>
</div>

<%@include file="../footer.jsp" %>


<script src="<c:url value="/resources/js/app.js"/>"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
</body>
</html>
