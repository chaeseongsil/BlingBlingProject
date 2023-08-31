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
        <link rel="stylesheet" href="../resources/css/reviewList.css">
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
                    <div class="boardListWrap">
                        <div class="boardList">
                            <div class="top">
                                <div class="num">번호</div>
                                <div class="product">상품</div>
                                <div class="title">제목</div>
                                <div class="writer">작성자</div>
                                <div class="date">작성일</div>
                                <div class="count">조회수</div>
                            </div>
                            <c:forEach items="${requestScope.rList }" var="review">
	                            <div>
	                                <div class="num">${review.reviewNo }</div>
	                           		<div class="product">
	                           			<a href="/product/shopDesc.do?productNo=${review.product.productNo }">
		                           			<img alt="${review.product.productName }" src="${review.product.pImagePath }">
	                           			</a>
	                           		</div>
	                                <div class="title"><a href="/review/reviewDetail.do?reviewNo=${review.reviewNo }">${review.reviewTitle }</a></div>
	                                <div class="writer">${review.reviewWriter }</div>
	                                <div class="date">${review.rCreateDate.toString().substring(0,11) }</div>
	                                <div class="count">${review.reviewCount }</div>
	                            </div>
                            </c:forEach>
                        </div>
                        <div id="boardButton" class="pageBtn">
	                        <c:if test="${pInfo.startNavi ne '1' }">
								<c:url var="pageUrl" value="/review/reviewList.do">
									<c:param name="page" value="${pInfo.startNavi-1 }"></c:param>
								</c:url>
									<a href="${pageUrl }"class="prev-btn"><img src="https://cdn-icons-png.flaticon.com/512/271/271220.png" alt=""> </a>
							</c:if>
							<c:forEach begin="${pInfo.startNavi }" end="${pInfo.endNavi }" var="p">
								<c:url var="pageUrl" value="/review/reviewList.do">
									<c:param name="page" value="${p }"></c:param>
								</c:url>
								<div class="page-numbers">
                                	<span class="page-number"><a href="${pageUrl }">${p }</a>&nbsp;</span>
                          	 	</div>
							</c:forEach>
							<c:if test="${pInfo.endNavi ne pInfo.naviTotalCount }">
								<c:url var="pageUrl" value="/review/reviewList.do">
									<c:param name="page" value="${pInfo.endNavi+1 }"></c:param>
								</c:url>
									<a href="${pageUrl }"class="prev-btn"><img src="https://cdn-icons-png.flaticon.com/512/87/87425.png" alt=""> </a>
							</c:if>
                            <%-- <div class="page-numbers">
                                <span class="page-number">${pageNavi }</span>
                            </div> --%>
                            <!-- <button class="next-btn">
                                <img src="https://cdn-icons-png.flaticon.com/512/87/87425.png" alt="">
                            </button> -->
                        </div>
                        <div class="bt_wrap">
                            <a href="" class="on">등록</a>
                            <!--<a href="#">수정</a>-->
                        </div>
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