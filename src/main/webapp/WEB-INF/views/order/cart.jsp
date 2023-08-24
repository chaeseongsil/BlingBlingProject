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
        <link rel="stylesheet" href="../resources/css/cart.css">
    </head>
    <body>
        <div id="container">
			<jsp:include page="/WEB-INF/views/include/header.jsp"></jsp:include>
            <main>
                <div id="mainWrap">
                    <div id="cartTitle">
                        <p>CART</p>
                    </div>
                    <div id="cartList">
                        <table id="cartTable">
                        	<colgroup>
                        		<col width="10%">
                        		<col width="20%">
                        		<col width="60%">
                        		<col width="10%">
                        	</colgroup>
                        	<tbody>
            				<c:if test="${!empty cList}">
            					<c:forEach items="${cList }" var="cart">
            						<tr>
            							<td style="text-align:center;">
            								<input type="checkbox" class="checkCart" value="${cart.cartNo }">
            							</td>
            							<td style="text-align:center;">
            								<img alt="" src="${cart.pImagePath }">
            							</td>
            							<td>
            								<p style="text-align:center;">
            									<a href="/product/shopDesc.do?productNo=${cart.productNo }">${cart.productName }${cart.productColor }</a>
            									
            								</p>
            							</td>
            							<td>
            								<p class="priceOne" style="text-align:center;">
            									${cart.cartPrice }
            								</p>
            							</td>
            						</tr>
            					</c:forEach>
            				</c:if>
            				<c:if test="${empty cList }">
            					<tr >
            						<td colspan="4" style="height:450px; text-align:center;">장바구니가 비어있습니다.</td>
            					</tr>
            				</c:if>
                        	</tbody>
                        </table>
                    </div>
                    <div id="cartPrice">
                        <p>상품 구매 금액 <span class="totalPrice1">0</span>원 + 배송비 0원 = <span class="totalPrice2">0</span>원  </p>
                    </div>
                    <c:if test="${!empty cList}">
	                    <div id="cartBtns">
	                        <button id="deleteBtn">선택 상품 삭제</button>
	                        <button id="selectOrder">선택 상품 주문</button>
	                        <button id="allOrder">전체 상품 주문</button>
	                    </div>
                    </c:if>
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
            document.querySelector("#deleteBtn").addEventListener("click", () => {
            	const memberId = '${memberId}';
            	let checkedItems = document.querySelectorAll(".checkCart");
            	let deleteUrl = "/cart/delete.do?memberId="+memberId;
            	for(let i = 0; i < checkedItems.length; i++){
            		if(checkedItems[i].checked){
	            		deleteUrl += "&cartNo="+ checkedItems[i].value;
            		}
            	}
            	location.href = deleteUrl;
            });
            document.querySelector("#selectOrder").addEventListener("click", () => {
            	const memberId = '${memberId}';
            	let checkedItems = document.querySelectorAll(".checkCart");
            	let selectOrderItems = document.querySelectorAll(".checkCart");
            	let orderUrl = "/cart/sendOrder.do?memberId="+memberId
				let sum = 0;
            	for(let i = 0; i < checkedItems.length; i++){
            		if(checkedItems[i].checked){
            			sum++;
            		}
            		if(sum == 0){
            			alert("주문하실 상품을 선택해주세요.");
            			break;
            		}
            		if(checkedItems[i].checked){
	            		orderUrl += "&cartNo="+ checkedItems[i].value;
            		}
            	}
            	if(sum != 0){
	            	location.href = orderUrl;
            	}
            });
        </script>
        <script type="text/javascript" src="../resources/js/cart.js"></script>
    </body>
</html>