<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>마이페이지</title>
</head>

<body>
<jsp:include page="/WEB-INF/inc/top.jsp"></jsp:include>
	<div class="container-fluid">
      <div class="row align-items-center" style="height:600px">
        <div class="col-lg-4"></div>
        <div class="col-lg-4">
          <form action="mypage.do" method="post" class="needs-validation" novalidate>
            <h3	style="text-align: center; padding-bottom: 5%; padding-top: 15%">마이페이지</h3>
            <div class="form-group">
              <input type="text" class="form-control" placeholder="아이디" maxlength="20" value="${vo.userId }" disabled>
              <input type="hidden" name="userId" value="${vo.userId }">
            </div>
            <div class="form-group">
              <input type="password" class="form-control" placeholder="비밀번호" name="userPw" maxlength="20" value="${vo.userPw }" disabled>
            </div>
            <div class="form-group">
              <input type="text" class="form-control" placeholder="이름" name="userNm" maxlength="20" required value="${vo.userNm }">
            </div>
            <input type="submit" class="btn btn-primary form-control" value="수정하기">
          </form>
        </div>
        <div class="col-lg-4">
        </div>
      </div>
    </div>
    <jsp:include page="/WEB-INF/inc/footer.jsp"></jsp:include>
</body>
</html>