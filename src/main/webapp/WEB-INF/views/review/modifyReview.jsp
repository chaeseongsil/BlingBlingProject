<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html lang="ko">
    <head>
        <meta charset="UTF-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <title>BlingBling : handcraft jewelry shop</title>
        <link rel="stylesheet" href="../resources/css/all.css">
        <link rel="stylesheet" href="../resources/css/footer.css">
        <link rel="stylesheet" href="../resources/css/header.css">
        <link rel="stylesheet" href="../resources/css/myReviewWrite.css">
        <style>
            .login-form-btn {
                font-size : 15px;
                margin-top : 20px;
            }
        </style>
    </head>
    <body>
        <div id="container">
            <jsp:include page="/WEB-INF/views/include/header.jsp"></jsp:include>
            <main>
                <div id="mainWrap">
                    <div class="board-title">
                        <p>REVIEW</p>
                    </div>
                    <div class="boardWriteWrap">
                       	<form action="/review/insert.do" method="post" enctype="multipart/form-data">
	                       <div class="boardWrite">
	                           <div class="title reviewDiv">
	                               <dl>
	                                   <dt>상품</dt>
	                                   <dd id="reviewProduct" style="display: flex;align-items: center;">
	                                   		<img alt="" src="${review.product.pImagePath }">
	                                        ${review.product.productName }
	                                   </dd>
	                               </dl>
	                               <dl id="star">
	                                   <dt>나의 별점</dt>
	                                   <dd id="stardd">
	                                       <input type="radio" name="reviewStar" value="5" id="rate1" <c:if test="${review.reviewStar eq '5' }">checked</c:if>>
	                                       <label for="rate1">★</label>
	                                       <input type="radio" name="reviewStar" value="4" id="rate2" <c:if test="${review.reviewStar eq '4' }">checked</c:if>>
	                                       <label for="rate2">★</label>
	                                       <input type="radio" name="reviewStar" value="3" id="rate3" <c:if test="${review.reviewStar eq '3' }">checked</c:if>>
	                                       <label for="rate3">★</label>
	                                       <input type="radio" name="reviewStar" value="2" id="rate4" <c:if test="${review.reviewStar eq '2' }">checked</c:if>>
	                                       <label for="rate4">★</label>
	                                       <input type="radio" name="reviewStar" value="1" id="rate5" <c:if test="${review.reviewStar eq '1' }">checked</c:if>>
	                                       <label for="rate5">★</label>
	                                   </dd>
	                               </dl>
	                           </div>
	                           <div class="info">
	                               <dl>
	                                   <dt>제목</dt>
	                                   <dd><input type="text" name="reviewTitle" value="${review.reviewTitle }"></dd>
	                               </dl>
	                               <dl>
	                                   <dt>파일첨부</dt>
	                                   <dd>
	                                   	   <a href="../resources/ruploadFiles/${review.reviewFileRename}" download>${review.reviewFilename }</a>
	                                       <input type="file" name="uploadFile" id="orderChangeFile" multiple>
	                                   </dd>
	                               </dl>
	                           </div>
	                           <div class="cont">
	                               <textarea name="reviewContent">${review.reviewContent }</textarea>
	                           </div>
	                       </div>
	                       <div class="bt_wrap" id="bt_btn">
	                           <button type="submit">등록</button>
	                           <!--<a href="#">수정</a>-->
	                       </div>
                       	</form>
                    </div>
                </div>
            </main>
            <jsp:include page="/WEB-INF/views/include/footer.jsp"></jsp:include>
        </div>
        <script>
            var logout = document.querySelector("#logoutBtn");
            logout.addEventListener("click", () => {
                var isLogout = confirm("정말 로그아웃 하시겠습니까?");
                if(isLogout == true){
                    alert("정상적으로 로그아웃되었습니다.");
                    location.href="/member/logout.do";
                }
            });
            
            function alertLogin(){
	           	alert("로그인이 필요한 서비스입니다.");
            }
        </script>
    </body>
</html>