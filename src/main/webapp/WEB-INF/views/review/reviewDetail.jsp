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
        <link rel="stylesheet" href="../resources/css/reviewDetail.css">
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
                    <div class="boardViewWrap">
                            <div class="board_view">
                                <div class="title" id="reviewTitle">
                                   <p>${review.reviewTitle }</p>
                                </div>
                                <div class="info">
                                    <dl>
                                        <dt>번호</dt>
                                        <dd id="boardNum">
                                        	<%-- <a href="/product/shopDesc.do?productNo=${review.product.productNo }">
		                           				<img alt="${review.product.productName }" src="${review.product.pImagePath }" style="width:5%;">
	                           				</a> --%>
	                           				${review.reviewNo }
                                        </dd>
                                    </dl>
                                    <dl>
                                        <dt>글쓴이</dt>
                                        <dd>${review.reviewWriter }</dd>
                                    </dl>
                                    <dl>
                                        <dt>작성일</dt>
                                        <dd id="boardDate">${review.rCreateDate.toString().substring(0,11) }</dd>
                                    </dl>
                                    <dl>
                                    	<dt>별점</dt>
                                    	<c:if test="${review.reviewStar eq '1' }">
                                    		<dd class="reviewStar" style="color:rgba(250, 208, 0, 0.99);">★</dd>
                                    	</c:if>
                                    	<c:if test="${review.reviewStar eq '2' }">
                                    		<dd class="reviewStar" style="color:rgba(250, 208, 0, 0.99);">★★</dd>
                                    	</c:if>
                                    	<c:if test="${review.reviewStar eq '3' }">
                                    		<dd class="reviewStar" style="color:rgba(250, 208, 0, 0.99);">★★★</dd>
                                    	</c:if>
                                    	<c:if test="${review.reviewStar eq '4' }">
                                    		<dd class="reviewStar" style="color:rgba(250, 208, 0, 0.99);">★★★★</dd>
                                    	</c:if>
                                    	<c:if test="${review.reviewStar eq '5' }">
                                    		<dd class="reviewStar" style="color:rgba(250, 208, 0, 0.99);">★★★★★</dd>
                                    	</c:if>
                                    </dl>
                                    <dl>
                                        <dt>조회수</dt>
                                        <dd id="boardCount">${review.reviewCount }</dd>
                                    </dl>
                                </div>
                                <div class="reviewImg">
                                	<img alt="${review.product.productName }" src="${review.product.pImagePath}">
                                </div>
                                <div class="cont" id="boardContent">
                                    ${review.reviewContent }
                                </div>
                            </div>
                        <div class="bt_wrap" id="bt_btn">
                            <button onclick="goReviewList();">목록</button>
                            <c:if test="${sessionScope.memberId eq review.reviewWriter }">
	                            <button onclick="goModify();">수정하기</button>
	                            <button onclick="goDelete();">삭제하기</button>
                            </c:if>
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
            /* const urlParams = new URLSearchParams(window.location.search);
            const noticeNum = urlParams.get('num');
            const noticeTitle = urlParams.get('title');
            const noticeDate = urlParams.get('date');
            const noticeCount = urlParams.get('count');
            document.querySelector("#boardTitle").innerText += "[" + noticeTitle + "]";
            document.querySelector("#boardNum").innerText = noticeNum;
            document.querySelector("#boardDate").innerText = noticeDate;
            document.querySelector("#boardCount").innerText = noticeCount;
            for(let i = 0; i < 6; i++){
                document.querySelector("#boardContent").innerHTML += noticeTitle +"<br>";
            } */
            function goModify(){
            	var reviewNo = '${review.reviewNo}';
				location.href = "/review/modify.do?reviewNo="+reviewNo;            	
            }
            function goReviewList(){
                history.back();
            }
            function alertLogin(){
	           	alert("로그인이 필요한 서비스입니다.");
            }
        </script>
    </body>
</html>