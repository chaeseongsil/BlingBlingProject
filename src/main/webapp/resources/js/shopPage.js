/**
 * 
 */// shop페이지에서 이미지, title, 가격 값을 받아오는 코드 
            const productName = document.querySelector('.product-name').innerText;
            const productPrice = document.querySelector('.product-price').value;
            const imageElement = document.querySelector('.product-image');
            const imageDesc = document.querySelector('.product-image-desc');
            const imageDesc2 = document.querySelector('.product-image-desc2');

            //상품 색상 선택시 div가 최대 3개까지 추가되는 코드 
            const colorSelect = document.getElementById('productColor');
            const infoSelectDiv = document.getElementById('infoSelect');
            const infoTitleContainer = document.querySelector("#infoTitle");
            const orderSum = document.querySelector("#orderResult");
            const orderPrice = document.querySelector("#priceResult");

            let priceTotal = 0;
            
            const maxCloneCount = 3;
            let cloneCount = 0;

            colorSelect.addEventListener('change', function() {
                const selectedColor = this.value;
                addInfoSelect(selectedColor);
            });
            function addInfoSelect(color){
                if(cloneCount >= maxCloneCount){
                    return;
                }
                const infoSelectClone = infoSelectDiv.cloneNode(true);
                infoSelectClone.setAttribute('id', '');
                infoSelectClone.querySelector("#pName").textContent = productName;
                infoSelectClone.querySelector("#pColor").textContent = "(" + color + ")";
                infoSelectClone.style.display = 'block';
                infoSelectClone.style.height = "50px";
                const removeBtn = infoSelectClone.querySelector(".removeBtn");
                removeBtn.addEventListener("click", function(){
                    infoTitleContainer.removeChild(infoSelectClone);
                    cloneCount--;
                    totalNumber();
                });
                infoTitleContainer.appendChild(infoSelectClone);
                cloneCount++;
                totalNumber();

            }
            function totalNumber(){
                const orderCount = document.querySelectorAll(".orderCount");
                let total = 0;
                orderCount.forEach(function(element){
                    let value = parseInt(element.value);

                    if(!isNaN(value)){
                        total += value;
                    }
                });
                total = total-1;
                orderSum.textContent = total + "개";
                var totalPrice = productPrice.replace(/,/g, "");
                totalPrice = parseInt(totalPrice);
                priceResult.innerText = totalPrice*total + "원";
                priceTotal = totalPrice*total;
            }
            

            document.querySelector("#cartBtn").addEventListener("click", () =>{
            	var pNames = document.querySelectorAll("#pName.product-name");
            	var spanColors = document.querySelectorAll(".spanColor");
            	var orderCounts = document.querySelectorAll(".orderCount");
            	
            	var productNo = document.querySelector("#productNo").value;
            	var price = document.querySelector(".product-price").value;
            	var pImagePath = document.querySelector("#productImg").value;
            	var memberId = document.querySelector("#memberId").value;
            	
            	var cartUrl = "/cart/insert.do?memberId="+memberId+"&productNo="+productNo+"&productPrice="+price+"&pImagePath="+pImagePath;
            	for(var i = 0; i < pNames.length; i++){
            		cartUrl += "&productName="+pNames[i].innerText;
            		cartUrl += "&productColor="+spanColors[i].innerText;
            		cartUrl += "&amount="+orderCounts[i].value;
                }
            	location.href=cartUrl;
            });

            document.querySelector("#toOrderBtn").addEventListener("click", () => {
                location.href="/shop/order.jsp?image="+urlParams.get('image')+"&title=" + urlParams.get('title') + "&price=" + priceTotal;
            });