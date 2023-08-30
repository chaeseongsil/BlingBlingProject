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
        <link rel="stylesheet" href="../resources/css/myOrderListDesc.css">
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
            <main style="height:1200px;">
                <div id="mainWrap">
                    <div class="board-title">
                        <p>주문 내역</p>
                    </div>
                    <div class="orderListWrap">
                        <div class="orderList">
                            <div class="top">
                                <div class="date">주문일자</div>
                                <div class="number">주문번호</div>
                                <div class="productName" style="padding-left:200px;">상품명</div>
                                <div class="pay">결제수단</div>
                                <div class="state">처리현황</div>
                            </div>
                            <div class="second">
                                <div class="date" id="dateOn">${order.orderDate.toString().substring(0,11) }</div>
                                <div class="number"><a href="" id="numberOn">${order.orderNo }</a></div>
                                <div class="productName">
                                    <span id="pNameOn">${order.orderName }<a href="#" id="showDetail">상세 보기</a></span>
                                </div>
                                <div class="pay" id="payOn">${order.payment }</div>
                                <div class="state" id="stateOn">${order.orderStatus }</div>
                            </div>
                            <div id="detailDiv">
                            	<c:forEach items="${cList }" var="cart" varStatus="i">
                            		<div class="cart-item">
		                            	<div class="date">${i.count}</div>
		                            	<div class="number">
		                            		<img alt="" src="${cart.pImagePath }" style="width:25%;">
		                            	</div>
	                            		<div class="productName">
		                            		<a href="/product/shopDesc.do?productNo=${cart.productNo }">
		                            			${cart.productName }${cart.productColor }
		                            		</a>
		                            		<a href="/review/insert.do?productNo=${cart.productNo }" id="goReview">
		                            			리뷰 작성하기
		                            		</a>
	                            		</div>
	                            		<div class="pay">${cart.amount }</div>
	                            		<div class="state">${cart.cartPrice }</div>
                            		</div>
                            	</c:forEach>
                            	
                            </div>
                        </div>
                        <div class="orderSpecific">
                            <div class="orderSpec">
                                <div class="orderSpecTitle">결제 정보</div>
                                <div>
                                    <span>주문 금액</span>
                                    <span id="priceOn">${order.orderPrice }</span>
                                </div>
                                <div>
                                    <span>결제 수단</span>
                                    <span id="payOn1">${order.payment }<a href='#'> 명세서 보기 </a></span>
                                </div>
                            </div>
                            <div class="orderSpec">
                                <div class="orderSpecTitle">배송지 정보</div>
                                <div>
                                    <span>받으시는 분</span>
                                    <span>${order.memberName }</span>
                                </div>
                                <div>
                                    <span>우편번호</span>
                                    <span>${order.memberPostCode }</span>
                                </div>
                                <div>
                                    <span>배송지 주소</span>
                                    <span>${order.memberAddr1} ${order.memberAddr2 }</span>
                                </div>
                            </div>
                        </div>
                        <div id="boardButton" class="pageBtn">
                            <button onclick="changeItem();">교환/반품 신청</button>
                            <button onclick="goBack();">뒤로가기</button>
                        </div>
                        
                    </div>
                </div>
            </main>
            <jsp:include page="/WEB-INF/views/include/footer.jsp"></jsp:include>
        </div>
        <script>
        	document.querySelector("#showDetail").addEventListener("click", () => {
        		const detailDiv = document.getElementById("detailDiv");
        	    const cListItems = document.querySelectorAll(".cart-item");
        	    
        	    // cList 항목 수에 따라 원하는 높이 계산
        	    const desiredHeight = cListItems.length * 50;
        	    const main = document.querySelector("main");
        	    // detailDiv에 'active' 클래스 토글
        	    
        	    // detailDiv의 max-height 설정
        	    if (detailDiv.classList.contains("active")) {
	        	    detailDiv.classList.remove("active");
        	        main.style.height = `1200px`;
        	    } else {
        	    	detailDiv.classList.add("active");
        	        detailDiv.style.maxHeight = `${desiredHeight}px`;
        	        main.style.height = ``;
        	    }
        	    
        	    // 페이지 높이 조정
        	    adjustPageHeight();
        	});
        	function adjustPageHeight() {
        	    // 전체 페이지의 새로운 높이 계산
        	    const mainWrap = document.getElementById("mainWrap");
        	    const detailDiv = document.getElementById("detailDiv");
        	    const newPageHeight = mainWrap.clientHeight + detailDiv.clientHeight;
        	    const mainHeight = newPageHeight - 100;
        	    
        	    // 컨테이너 또는 body 요소의 새로운 높이 설정
        	    const container = document.getElementById("container");
        	    const main = document.querySelector("main");
        	    container.style.height = `${newPageHeight}px`;
        	    main.style.height = `${mainHeight}px`;
        	}
            var logout = document.querySelector("#logoutBtn");
            logout.addEventListener("click", () => {
                var isLogout = confirm("정말 로그아웃 하시겠습니까?");
                if(isLogout == true){
                    alert("정상적으로 로그아웃되었습니다.");
                    location.href="/member/logout.do";
                }
            });
            function goBack(){
                history.back();
            }

            function changeItem(){
                location.href="/member/myOrderChange.jsp";
            }
            function alertLogin(){
	           	alert("로그인이 필요한 서비스입니다.");
            }
        </script>
    </body>
</html>