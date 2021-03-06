<%--
  Created by IntelliJ IDEA.
  User: 28306
  Date: 2021/12/27
  Time: 9:46
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set value="${pageContext.request.contextPath}" var="ctx"/>
<html>
<head>
    <title>Title</title>
    <link rel="stylesheet" type="text/css" href="${ctx}/public/css/boostratp.css"/>
    <link rel="stylesheet" type="text/css" href="${ctx}/public/css/boostrap.min.css"/>
    <link rel="stylesheet"  href="${ctx}/public/font/bootstrap-icons.css"/>
    <link href="${ctx}/public/css/signin.css" rel="stylesheet">
    <!-- <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.7.2/font/bootstrap-icons.css"> -->
    <link rel="apple-touch-icon" href="https://getbootstrap.com/docs/5.1/assets/img/favicons/apple-touch-icon.png" sizes="180x180">
    <link rel="icon" href="https://getbootstrap.com/docs/5.1/assets/img/favicons/favicon-32x32.png" sizes="32x32" type="image/png">
    <link rel="icon" href="https://getbootstrap.com/docs/5.1/assets/img/favicons/favicon-16x16.png" sizes="16x16" type="image/png">
    <script src="${ctx}/public/js/bootstrap.bundle.min.js" type="text/javascript" charset="utf-8"></script>
</head>
<style>
    .bd-placeholder-img {
        font-size: 1.125rem;
        text-anchor: middle;
        -webkit-user-select: none;
        -moz-user-select: none;
        user-select: none;
    }

    @media (min-width: 768px) {
        .bd-placeholder-img-lg {
            font-size: 3.5rem;
        }
    }
</style>
<body  class="text-center">
<main class="form-signin">
    <c:if test="${requestScope.img != null}">
        <c:out value="${requestScope.img}"/>
    </c:if>
    <c:if test="${requestScope.img == null}">
        <form action="${ctx}/updateImg" method="post" enctype="multipart/form-data">
            <input type="file" name="img" id="" value="" />
            <input type="submit" class="btn btn-primary" value="????????????"/>
        </form>
    </c:if>
    <form action="${ctx}/register_user" method="post">
        <img class="mb-4" src="https://getbootstrap.com/docs/5.1/assets/brand/bootstrap-logo.svg" alt="" width="72" height="57">
        <h1 class="h3 mb-3 fw-normal">Please Register in</h1>
        <input type="hidden" name="img_url" value="${requestScope.img}">

        <div class="form-floating">
            <input type="text" class="form-control" name="username"  placeholder="????????????????????????">
            <label for="floatingInput">userName</label>
        </div>

        <div class="form-floating">
            <input type="text" class="form-control" id="floatingInput" name="accement_name" placeholder="?????????????????????">
            <label for="floatingInput">accementName</label>
        </div>
        <div class="form-floating">
            <input type="password" class="form-control" id="floatingPassword" name="password" placeholder="?????????????????????">
            <label for="floatingPassword">Password</label>
        </div>

        <div class="checkbox mb-3">
<%--            <a href="${pageContext.request.contextPath}/register">????????????</a>--%>
        </div>
        <button class="w-100 btn btn-lg btn-primary" type="submit">Register in</button>
        <p class="mt-5 mb-3 text-muted">&copy; 2017???2021</p>
    </form>
</main>
</body>
</html>
