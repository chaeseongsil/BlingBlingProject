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
        <link rel="stylesheet" href="../resources/css/header.css">
        <link rel="stylesheet" href="../resources/css/footer.css">
        <link rel="stylesheet" href="../resources/css/shopPage.css">
    </head>
    <body>
        <div id="container">
            <jsp:include page="/WEB-INF/views/include/header.jsp"></jsp:include>
            <main>
                <!-- <div id="shopTitle">
                    <p>SHOP</p>
                </div> -->
                <div id="shopCtg">
                    <ul>
                        <li>
                            <a href="#" class="category-link" data-category="all">ALL</a>
                        </li>
                        <li>
                            <a href="#" class="category-link" data-category="rings">RINGS</a>
                        </li>
                        <li>
                            <a href="#" class="category-link" data-category="bracelets">BLACELETS</a>
                        </li>
                        <li>
                            <a href="#" class="category-link" data-category="necklaces">NECKLACES</a>
                        </li>
                        <li>
                            <a href="#" class="category-link" data-category="earrings">EARRINGS</a>
                        </li>
                        <li>
                            <a href="#" class="category-link" data-category="etc">ETC</a>
                        </li>
                    </ul>
                </div>
                <div id="shopMain" class="productGrid">
                	<c:forEach items="${pList }" var="product">
                		<div class="product-item" data-category="${product.productCategory }">
	                        <a href="/product/shopDesc.do?productNo=${product.productNo }">
	                            <img src="${product.pImagePath }" alt="${product.pImageName }" class="productImg">
	                            <c:if test="${product.productNo+0 > 26}">
		                            <div class="wrapImg">
		                                <span>NEW</span>
		                            </div>
	                            </c:if>
	                            <p class="title">
	                            	${product.productName }
	                            </p>
	                        </a>
	                        <span>
	                            <img src="https://cdn-icons-png.flaticon.com/512/1077/1077035.png" alt="하트" class="addCart">
	                            <img src="../resources/images/heart.png" alt="장바구니 등록완료" class="heartImg">
	                        </span>
	                        <p>&#8361;${product.productPrice }</p>
                    	</div>
                	</c:forEach>
                </div>
                <div id="shopButton" class="pageBtn">
                    <button class="prev-btn">
                        <img src="https://cdn-icons-png.flaticon.com/512/271/271220.png" alt="">
                    </button>
                    <div class="page-numbers">
                    </div>
                    <button class="next-btn">
                        <img src="https://cdn-icons-png.flaticon.com/512/87/87425.png" alt="">
                    </button>
                </div>
            </main>
            <jsp:include page="/WEB-INF/views/include/footer.jsp"></jsp:include>
        </div>
        <script src="../resources/js/shopCategory.js"></script>
        <script src="../resources/js/pageBtn.js"></script>
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