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
        <link rel="stylesheet" href="../resources/css/join.css">
    </head>
    <body>
        <div id="container">
            <jsp:include page="/WEB-INF/views/include/header.jsp"></jsp:include>
            <main>
                <div id="mainWrap">
                    <div id="mainTitle">
                        <p>JOIN</p>
                    </div>
                    <div id="mainForm">
                    	<span id="message" style="color:blue;"></span>
                        <form id="join-form" action="/member/register.do" method="post">
                        	
                            <div class="join-form-div">
                                <p>ID *</p> 
                                <input type="text" name="userId" id="user-id" class="join-form-field" placeholder="영문 소문자/숫자 6~12자"required> 
                            </div>
                            <div class="join-form-div">
                                <p>PASSWORD *</p>
                                <input type="password" name="userPw" id="user-pw" class="join-form-field" placeholder="영문 대소문자/숫자/특수문자 중 2가지 이상 조합, 8자~16자" required>
                            </div>
                            <div class="join-form-div">
                                <p>PASSWORD CHECK *</p>
                                <input type="password" name="userPwCheck" id="user-pw-check" class="join-form-field" required>
                                <p id="name-span"></p>
                            </div>
                            <div class="join-form-div">
                                <p>NAME</p>
                                <input type="text" name="userName" id="user-name" class="join-form-field" required>
                            </div>
                            <div class="join-form-div">
                                <p>ADDRESS</p>
                                <div id="postBox">
                                    <input type="text" name="userPost" id="user-post" class="join-form-field" readonly/>
                                    <!-- <input type="button" value="우편번호" id="join-form-btn1" > -->
                                    <button id="join-form-btn1" onclick="execDaumPostcode()">우편번호</button>
                                </div>
                                <input type="text" name="userPostAddr1" id="user-post-addr1" placeholder="기본주소" class="join-form-field" readonly>
                                <input type="text" name="userPostAddr2" id="user-post-addr2" placeholder="상세주소" class="join-form-field" required>
                            </div>
                            <div class="join-form-div">
                                <p>MOBILE *</p>
                                <div id="phoneBox">
                                    <select name="tel1" id="user-tel1" class="join-form-field" required>
                                        <option value="010">010</option>
                                        <option value="011">011</option>
                                        <option value="016">016</option>
                                        <option value="017">017</option>
                                        <option value="018">018</option>
                                        <option value="019">019</option>
                                    </select>
                                    &nbsp;-&nbsp; 
                                    <input type="tel" name="tel2" id="user-tel2" class="join-form-field" required>
                                </div>
                            </div>
                            <div class="join-form-div">
                                <p>EMAIL *</p>
                                <input type="email" name="userEmail" id="user-email" class="join-form-field" required>
                            </div>
                            <div class="join-form-agree">
                                <div class="agree">
                                    <input type="checkbox" name="serviceAgree" id="serviceAgree1" required>  
                                    <label for="serviceAgree1"> <b>[필수] 개인정보 수집 및 이용 동의</b></label>
                                    <a href="#">자세히 보기</a>
                                </div>
                                <div class="agree">
                                    <input type="checkbox" name="serviceAgree" id="serviceAgree2"> 
                                    <label for="serviceAgree2"> [선택] 마케팅 활용 및 광고성 정보 수신 동의</label>
                                    <a href="#">자세히 보기</a>
                                </div>
                            </div>
                            <div class="join-form-submit">
                                <input type="submit" value="CREATE ACCOUNT" id="join-form-signin" class="join-form-btn">
                            </div>
                        </form>
                    </div>
                </div>
            </main>
            <jsp:include page="/WEB-INF/views/include/footer.jsp"></jsp:include>
        </div>
        <script src="http://dmaps.daum.net/map_js_init/postcode.v2.js?autoload=false"></script>
        <script>
            
         /*    const signinDone = document.querySelector("#join-form-signin");
            signinDone.addEventListener("click", function(event) {
                event.preventDefault();
	           	const result = '${msg}';
	           	const url = '${url}';
	           	alert(result);
	           	location.href = url;
            }); */
            function execDaumPostcode() {
                daum.postcode.load(function(){
                    new daum.Postcode({
                        oncomplete: function(data) {
                        // 팝업에서 검색결과 항목을 클릭했을때 실행할 코드를 작성하는 부분입니다.
                            document.querySelector("#user-post").value = data.zonecode;
                            document.querySelector("#user-post-addr1").value = data.roadAddress;
                            document.querySelector("#user-post-addr2").focus();
                        }
                    }).open();
                });
            }
            function alertLogin(){
	           	alert("로그인이 필요한 서비스입니다.");
            }
            document.querySelector("#join-form").addEventListener("submit",(e)=>{
                msg = document.querySelector("#message");
                msg.style.color = "red";
                msg.style.fontWeight = "bolder";
                // 입력값 가져오기
                const userId = document.querySelector("#user-id").value;
                const userPw = document.querySelector("#user-pw").value;
                const userPwRe = document.querySelector("#user-pw-check").value;
                const userName = document.querySelector("#user-name").value;
                const userAddr = document.querySelector("#user-post").value;
                const userPost1 = document.querySelector("#user-post-addr1").value;
                const userPost2 = document.querySelector("#user-post-addr2").value;
                const userEmail = document.querySelector("#user-email").value;
                // 정규표현식
                const idRegExp = /^[a-z][a-z0-9]{4,12}$/g;
                const pwRegExp = /^[a-zA-Z0-9]{8,16}$/g;
                const nameRegExp = /^[가-힣]+$/g;
                const addrRegExp = /[a-zA-z]+/g;
                const postRegExp = /^[0-9]+$/;
                const emailRegExp = /^[a-zA-Z0-9]{4,12}@[a-z]+\.[a-z]{3,4}/g; //.을 문자로 체크하려면 \붙여줘야함
                const tel1RegExp = /^010$/g;
                const tel2RegExp = /^\d{3,4}$/g;
                const tel3RegExp = /^\d{4}$/g
                //id
                if(!idRegExp.test(userId)){
                    e.preventDefault();
                    msg.innerText = "ID는 영어소문자, 숫자만 가능합니다.(4~12자리)";
                    
                }else if(!pwRegExp.test(userPw)){
                    //pw
                    e.preventDefault();
                    msg.innerText = "PW는 영어소문자,대문자,숫자만 입력 가능합니다.(최소 8~16자리)";
                }else if(userPw != userPwRe){
                    //pw == pw-re
                    e.preventDefault();
                    msg.innerText = "비밀번호가 일치하지 않습니다.";
                    
                }else if(!nameRegExp.test(userName)){
                    //name
                    e.preventDefault();
                    msg.innerText = "이름은 한글만 가능합니다.(최소 1글자 이상)";
                    
                }else if(addrRegExp.test(userAddr)){
                    //주소
                    e.preventDefault();
                    msg.innerText = "주소는 영어 사용이 불가합니다.(공백 불가)";
                    
                }else if(!emailRegExp.test(userEmail)){
                    //e-mail
                    e.preventDefault();
                    msg.innerText = "이메일은 @가 포함되어야 합니다.(아이디 : 영문자,숫자로 4~12글자)";
                    
                }
            })
        </script>
    </body>
</html>