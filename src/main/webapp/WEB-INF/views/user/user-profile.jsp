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

<section class="login-page">
    <h2>Edytuj Profil</h2>
    <form:form method="post" modelAttribute="user">
        <div class="form-group">
            <form:input type="email" path="email" name="email" placeholder="Email"/>
        </div>
        <div class="form-group">
            <form:input path="password" type="password" name="password" placeholder="Hasło"/>
        </div>
        <div class="form-group">
            <form:input path="matchingPassword" type="password" name="password2" placeholder="Powtórz hasło"/>
        </div>

        <div class="form-group form-group--buttons">
            <button class="btn" type="submit">Zapisz</button>
        </div>
    </form:form>
</section>

<%@include file="../footer.jsp" %>


<script src="<c:url value="/resources/js/app.js"/>"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
</body>
</html>
