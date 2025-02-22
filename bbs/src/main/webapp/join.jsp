<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원가입</title>
</head>
<body>
	<jsp:include page="WEB-INF/inc/top.jsp"></jsp:include>
	<div class="container-fluid">
      <div class="row align-items-center" style="height:700px">
        <div class="col-lg-4"></div>
        <div class="col-lg-4">
          <form action="JoinAction.jsp" method="post" class="needs-validation" novalidate>
            <h3	style="text-align: center; padding-bottom: 5%; padding-top: 15%;">회원가입 화면</h3>
            <div class="form-group">
              <input type="text" class="form-control" placeholder="아이디" name="userId" maxlength="20" required>
              <div class="invalid-feedback">
              	아이디는 필수 입니다.
              </div>
            </div>
            <div class="form-group">
              <input type="password" class="form-control" placeholder="비밀번호" name="userPw" maxlength="20" required>
              <div class="invalid-feedback">
              	패스워드는 필수 입니다.
              </div>
            </div>
            <input type="submit" class="btn btn-dark form-control" value="회원가입">
          </form>
        </div>
        <div class="col-lg-4">
        </div>
      </div>
    </div>
    <script>
    	$(document).ready(function() {
    		const forms = document.querySelectorAll('.needs-validation')
    		console.log(forms);
    		 Array.from(forms).forEach(form => {
    			    form.addEventListener('submit', event => {
    			      if (!form.checkValidity()) {
    			        event.preventDefault()
    			        event.stopPropagation()
    			      }

    			      form.classList.add('was-validated')
    			    }, false)
    			
    		});
			
		});
    </script>
	<jsp:include page="WEB-INF/inc/footer.jsp"></jsp:include>
</body>
</html>