<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <script src="https://code.jquery.com/jquery-3.6.1.js"></script>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.1/dist/css/bootstrap.min.css" rel="stylesheet">
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.1/dist/js/bootstrap.bundle.min.js"></script>
<title>Insert title here</title>
</head>

<!-- nav 영역 -->
    <nav class="navbar navbar-expand-lg bg-body-tertiary">
        <div class="container-fluid">
            <a class="navbar-brand" href="index.jsp">Future Home</a>
            <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarContent"
                aria-controls="navbarContent" aria-expanded="false" aria-label="Toggle naviation">
                <span class="navbar-toggler-icon"></span>
            </button>
            <div class="collapse navbar-collapse" id="navbarContent">
                <ul class="navbar-nav me-auto mb-2 mb-lg-0">
                    <li class="nav-item"><a class="nav-link active" aria-current="page" href="main.jsp">메인</a></li>
                    <li class="nav-item"><a class="nav-link" href="bbs.do">게시판</a>
                    </li>
                </ul>
				<c:if test="${ empty userId}">
                <ul class="nav navbar-nav navbar-right" style="margin-right:50px">
                    <li class="nav-item dropdown"><a class="nav-link dropdown-toggle" href="#" role="button"
                            data-bs-toggle="dropdown" aria-expanded="false"> 접속하기</a>
                        <ul class="dropdown-menu">
                            <li><a class="dropdown-item" href="login.do">로그인</a></li>
                            <li>
                                <hr class="dropdown-divider">
                            </li>
                            <li><a class="dropdown-item" href="join.do">회원가입</a></li>
                        </ul>
                    </li>
                </ul>
				</c:if>
				<c:if test="${not empty userId}">
                 <ul class="nav navbar-nav navbar-right" style="margin-right:50px">
                 <li class="nav-item dropdown"><a class="nav-link dropdown-toggle" href="#" role="button"
                            data-bs-toggle="dropdown" aria-expanded="false">${userId }님</a>
                        <ul class="dropdown-menu">
                            <li><a class="dropdown-item" href="mypage.do">마이페이지</a></li>
                            <li><a class="dropdown-item" href="logout">로그아웃</a></li>
                        </ul>
                    </li>
                </ul>
                </c:if>
            </div>
        </div>
    </nav>
    <!-- nav 영역 끝 -->
</html>