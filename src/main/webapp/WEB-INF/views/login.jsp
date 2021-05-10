<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<%@ include file="header.jsp" %>

<header>
    <%@ include file="navbar.jsp" %>
</header>

<section class="login-page">
    <h2>Zaloguj się</h2>
    <form name='login' action="${pageContext.request.contextPath}/login" method='POST'>
        <div class="form-group">
            <input type="email" name="username" placeholder="Email"/>
        </div>
        <div class="form-group">
            <input type="password" name="password" placeholder="Hasło"/>
            <a href="#" class="btn btn--small btn--without-border reset-password">Przypomnij hasło</a>
        </div>

        <div class="form-group form-group--buttons">
            <a href='<c:url value="${pageContext.request.contextPath}/register"/>' class="btn btn--without-border">Załóż
                konto</a>
            <button class="btn" type="submit">Zaloguj się</button>
            <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
        </div>
    </form>
</section>

<%@include file="footer.jsp" %>

<script type="text/javascript">
    function validate() {
        if (document.login.username.value === "" && document.login.password.value === "") {
            alert("Username and password are required");
            document.login.username.focus();
            return false;
        }
        if (document.login.username.value === "") {
            alert("Username is required");
            document.login.username.focus();
            return false;
        }
        if (document.login.password.value === "") {
            alert("Password is required");
            document.login.password.focus();
            return false;
        }
    }
</script>

<script src="<c:url value="/resources/js/app.js"/>"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
</body>
</html>

