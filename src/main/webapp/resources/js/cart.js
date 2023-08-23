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

