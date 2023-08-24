/**
 * 
 */
let price = document.querySelectorAll(".priceOne");
let totalPrice = 0;
for(let i = 0; i < price.length; i++){
	totalPrice += parseInt(price[i].innerText);            	
}
document.querySelector(".totalPrice1").innerText = totalPrice;
document.querySelector(".totalPrice2").innerText = totalPrice;

const lastPrice = document.querySelector("#product-price");
lastPrice.innerText = totalPrice + "원";
//var totalPrice = price.replace(/,/g, "");
const resultP = document.querySelector("#resultPrice");
resultP.innerText = totalPrice + "원";

/*document.querySelector("#coin").addEventListener("change", () => {
    const coinVal = document.querySelector("#coin").value;
    const resultP = document.querySelector("#resultPrice");
    if(coinVal > 5000){
        alert("보유한 적립금보다 입력한 금액이 더 큽니다.");
        document.querySelector("#coin").value = 5000;
        document.querySelector("#totalCoin").innerText = 5000 + "원";
        resultP.innerText = totalPrice - 5000 + "원";
    }else{
        document.querySelector("#totalCoin").innerText = coinVal + "원";
        resultP.innerText = totalPrice - coinVal + "원";
    }
})*/

function goBack(){
    history.back();
}
const uName = document.querySelector("#user-name").value;
const uAddr = document.querySelector("#user-post-addr2").value;
const uTel = document.querySelector("#user-tel1").value
document.querySelector("#orderForm").addEventListener("submit", (e) => {
    if(uName !== null && uAddr !== null && uTel !== null){
        alert("주문이 완료되었습니다. 감사합니다.");
        location.href = "/member/myOrderList.jsp";
    }
    else {
        alert("입력 칸을 빠짐없이 작성해주세요.");
        return false;
    }
})
function paySuccess(){
    alert("주문이 완료되었습니다. 감사합니다.");
    location.href = "/member/myOrderList.jsp";
}