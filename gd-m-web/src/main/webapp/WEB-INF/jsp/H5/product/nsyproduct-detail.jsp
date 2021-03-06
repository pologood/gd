<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/jsp/pub/constants.inc" %>
<%@ include file="/WEB-INF/jsp/pub/tags.inc" %>

<!DOCTYPE html>
<html>
	<head>
		<%@ include file="/WEB-INF/jsp/pub/head.inc" %>
		<meta charset="utf-8">
		<title>商品详情</title>
		<meta name="viewport" content="width=device-width, initial-scale=1,maximum-scale=1,user-scalable=no">
		<meta name="apple-mobile-web-app-capable" content="yes">
		<meta name="apple-mobile-web-app-status-bar-style" content="black">
		
		<link rel="stylesheet" type="text/css" href="${CONTEXT }css/nsy/style.css"/>
		<link rel="stylesheet" type="text/css" href="${CONTEXT }css/nsy/layer.css"/>
		<link rel="stylesheet" type="text/css" href="${CONTEXT }css/swiper.min.css"/>
		
		<script src="${CONTEXT }js/layer.js" type="text/javascript" charset="utf-8"></script>
		
		<script type="text/javascript">
	    	function aonClick(urlType,params){
				switch(urlType){
				case 0:JsBridge.call(params);break;
				}
			}
   		 </script>
   		 
	</head>
	<body style="-moz-user-select:none;-webkit-user-select:none">
		<div class="productDetailsWrap">
		<!-- 返回按钮 -->
		<%-- <div class="back"><img src="${CONTEXT }images/nsyimg/back.png"></div> --%>
		
		
			<!--轮播图片开始-->
			<div class="swiper">
				<div class="swiper-container">
			        <div class="swiper-wrapper">
			        <c:forEach items="${productDto.pictures}" end="9" var="picture" varStatus="s">
			         <div class="swiper-slide"><img src="${imgHostUrl }${picture.urlOrg }"/></div>
					</c:forEach>
			           
			        </div>
			        <div class="swiper-pagination"></div>
			    </div>
			</div>
			<!--轮播图片结束-->
			<p class="tital">${productDto.productName}</p>
			<!--单价-->
			<div class="price">
			<c:if test="${platform ==  1 }">
				<p class="distribution_icon">
					<img src="${CONTEXT }v1.0/images/marketing/icon_tag.png" style="width:6.4rem; height:1.4rem;" />
				</p>
			</c:if>
			<div class="left">
					<div class="content"><span id="each" class="money">${productDto.formattedPrice}</span><c:if test="${productDto.formattedPrice ne '面议' }"><span class="moneyFont">元/${productDto.unitName}</span></c:if></div>
					<div class="time"><fmt:formatDate value="${productDto.updateTime}" pattern="MM-dd"/></div>
				</div>
				<!--关注商品-->
				<div class="careAll">
					<span class="js-uncollectProduct" style="display:none">
						<img class="care" src="${CONTEXT }images/nsyimg/care.png"/>
						<span class="reg-mark">取消关注</span>
					</span>
					<span class="js-collectProduct" style="display:none">
						<img class="care" src="${CONTEXT }images/nsyimg/no_care.png"/>
						<span class="reg-mark">关注商品</span>
					</span>
					
				</div>
			</div>
			<!--商品介绍-->
			<div class="introduce">
			    <!--
				<p class="tital">商品介绍:</p>
				-->
				<p class="content">${productDto.description}</p>
			</div>
			<div class="line"></div>
			<!--商店介绍-->
			<div class="storeIntroduction">
				<div class="left2">
					<img class="left" src="${CONTEXT }images/nsyimg/shop_tital.png"/>
					<div class="con">
						<p class="tital" >${productDto.shopsName}</p>
						<p class="count">共${productCount}件商品</p>
						<p class="content">${productDto.marketName}</p>
					</div>
				</div>
				
					<img class="right" id = "confirmBtn111" src="${CONTEXT }images/nsyimg/productDetails_phone.png"/>
					
			</div>
			<div class="line sp-line" style="margin-bottom:6rem;"></div>
			<!--选购数量-->
			<c:if test="${productDto.state == '3' && stockCount > 0}">
			<style>
				.productDetailsWrap>.pay>.buttom{width: 28%;}
				.productDetailsWrap>.pay{font-size: 1rem;}
			</style>
			<div class="count">
				<div class="left">库存:<span id="stock">${dealStockCount}</span></div>
				<div class="right">采购量: <div class="inputs" id="quantity" onclick="productSell()">0</div></div>
			</div>
			
			<!--下单-->
			<div class="pay">
				<div class="moneyFont">合计:<span id="ttmoney">0.00</span>元</div>
				
				<div class="buttom" onclick="dealOrder()">立即购买</div>
				<div class="buttom" style="background-color: rgb(254, 153, 0)" onclick="add2Shopcart()">加入购物车</div>
			</div>
			</c:if>
			<c:if test="${productDto.state == '3' && stockCount == 0}">
			<style>
				.sp-line{margin-bottom: 3rem !important;}
			</style>
			<div class="pay" style="line-height:3rem;text-align: center;font-size: 1rem;background-color: #bfbfbf;">
				商品已经卖完了
			</div>
			</c:if>
			<c:if test="${productDto.state ne '3'}">
			<style>
				.sp-line{margin-bottom: 3rem !important;}
			</style>
			<div class="pay" style="line-height:3rem;text-align: center;font-size: 1rem;background-color: #bfbfbf;">
				商品已下架
			</div>
			</c:if>
			<!--采购弹窗-->

			<div id="popupAll" style="display: none;">
				<div class="mark"></div>
				<div class="popup">
					<p>输入采购量</p>
					<div class="count"><div id="reduce" style="margin-right:-4px;">-</div><input type="text" value="1" onkeyup='this.value=this.value.replace(/[^\d.]/g,"")' onpaste="return false" /><div id="pluss" style="margin-left:-4px;">+</div></div>
					<div class="w-inspectbox-ft w-inspectbox-ft-2">
						<button class="pro-btn" type="button"><span>取消</span></button>
					</div>
					<div class="w-inspectbox-ft w-inspectbox-ft-1">
						<button class="pro-btn" type="button"><span>确定</span></button>
					</div>
				</div>
			</div>
			  <input type="hidden" id="userId" value="${productDto.memberId }">
		</div>
		<script src="${CONTEXT }js/swiper.min.js" type="text/javascript" charset="utf-8"></script>
		<script type="text/javascript" src="${CONTEXT }v1.0/module/mui/dist/js/mui.min.js"></script>
		
		
		<script type="text/javascript">
		
			//跳转到商铺列表页面
			function goToShopList(shopData){
				JsBridge.goToShopList(shopData);
			}
			//返回按钮跳转
			function goToBack(){
				JsBridge.goToBack();
			}
			//弹框text是显示内容字符串格式
			function myLayer(text){
				layer.msg(text);
			};
			
			function setSwiperHeight(){
				var h=$(window).width();
				$(".productDetailsWrap .swiper .swiper-container").height(h);
			}
			
			setSwiperHeight();
			
			//图片轮播
		    var swiper = new Swiper('.swiper-container', {
		        pagination: '.swiper-pagination',
		        paginationClickable: true,
		        autoplay : 3000,
		        autoplayDisableOnInteraction : false
		    });
		    
		  //点击采购量
		    function productSell(){
		    	var popupAll=document.getElementById("popupAll"),
		    		no=document.getElementsByClassName("w-inspectbox-ft-2")[0],
		    		yes=document.getElementsByClassName("w-inspectbox-ft-1")[0],
		    		plus=document.getElementById("pluss"),
		    		reduce=document.getElementById("reduce"),
		    		inputs=document.getElementsByClassName("inputs")[0],
		    		pInput=popupAll.getElementsByTagName("input")[0],
		    		//stock=document.getElementById("stock"),
		    		maxNum=parseInt("${productDto.stockCount}"),
		    		each=document.getElementById("each").innerHTML,
		    		ttmoney=document.getElementById("ttmoney"),
		    		buttom=document.getElementsByClassName("buttom")[0],
		    		minNum=1;
		    		each=each.replace(",","");
		    		each=parseFloat(each);
		    		
		    	popupAll.style.display="block";
		    	no.onclick=function(){
		    		popupAll.style.display="none";
		    	};
		    	yes.onclick=function(){
		    		var num=pInput.value;
		    		inputs.innerHTML=num;
		    		var numAll=num*each;
		    		numAll=numAll.toFixed(2);
		    		if("${productDto.formattedPrice}"=='面议'){
		    			numAll="0.00";
		    		}
		    		ttmoney.innerHTML=numAll;
		    		buttom.style.backgroundColor="#ff4000";
		    		popupAll.style.display="none";
		    	};
		    	plus.onclick=function(){
		    		var num=pInput.value;
		    		if(num<maxNum){
		    			num++;
		    			pInput.value=num;
		    		}
		    	};
		    	reduce.onclick=function(){
		    		var num=pInput.value;
		    		if(num>minNum){
		    			num--;
		    			pInput.value=num;
		    		}
		    	};
		    	pInput.onblur=function(){
		    		var num=pInput.value;
		    		if(num>maxNum){
		    			pInput.value=maxNum;
		    		}
		    		if(num<1){
		    			pInput.value=1;
		    		}
		    	};
		    }
			
		    $(document).ready(function(){
		    	 $(".js-collectProduct").click(function(){
					focusFuncProduct($("#userId").val());
				});
				
				$(".js-uncollectProduct").click(function(){
					blurFuncProduct($("#userId").val());
				}); 
				
				if($(".swiper-wrapper img").length==1){
					$(".swiper-pagination").hide();
				}
				
		    	//判断是否已关注
		    	if('${productDto.hasFocused}'=='1'){
		    		$(".js-uncollectProduct").show();
		    		$(".care").attr("src","${CONTEXT }images/nsyimg/care.png");
		    	}else{
		    		$(".js-collectProduct").show();
		    		$(".care").attr("src","${CONTEXT }images/nsyimg/no_care.png");
		    	}
		    	
				//点击商户信息跳转
				$(".productDetailsWrap>.storeIntroduction>.left2").click(function(){
					var shopData={
							"businessId":'${productDto.businessId }',
							"productId":'${productDto.productId}',
							"shopsName":'${productDto.shopsName }',
							"mainProduct":'${productDto.mainProduct }',
							"mobile":'${productDto.mobile }'
						};
			    	goToShopList(JSON.stringify(shopData));
			    	
				});
				
		    	//点击本页面的商品已下架后的头返回按钮
		    	$("#goBackClick").click(function(){
					goToBack();
				});
		    	
				//点击返回按钮
				$(".back").click(function(){
					goToBack();
				});
				
		    	//拨打电话功能
				$("#confirmBtn111").on("tap",function(){
					aonClick(0, 'mobile=${productDto.mobile }' );
					if("${productDto.memberId }"){
						//调用接口拨打电话
						$.ajax({
							url:"${CONTEXT }product/addCall",
							type:"post",
							data:{
								'sysCode':'${fromCode}',
								's_Mobile':'${productDto.mobile }',
								's_Name':'${productDto.realName}',
								//'e_Mobile':'${mem.contactMobile}',
								//'e_Name':'${mem.contactName}',
								'source':"SPXQ",
								'shopName':'${productDto.shopsName }',
								'fromCode':3,
								'b_memberId':'${productDto.businessUserId }',
								'memberId':'${productDto.memberId }'
							},
							dataType:"text",
							success:function(data){
								
							},
							error:function(){
							}
						});
					}
					
			});
	
		});

		//跳转登录
		function goToLogin(){
			JsBridge.goToLogin();
		}
		//登录成功后回调
		function goLoginBack(userId){
			$("#userId").val(userId);
			funcProduct(userId);
		}
		function focusFuncProduct(userId) {
			//如果关注前没有登录，跳转到登录页面让其登录
			if(!userId){
				goToLogin();
			}else{
				funcProduct(userId);
			}
		}
		
		
		//调用关注商品接口
		function funcProduct(userId){
			$.ajax({
				type: 'POST',
				url: '${CONTEXT }product/focus/'+ '${productDto.productId }'+"?userId="+userId,
			    cache: 'false' ,
			    dataType: 'json' ,
			    success: function(data) {
			    	if(data.resultcode=='0000') {
			    		//关注成功
			    		/* myLayer('关注成功！'); */
			    		$(".care").attr("src","${CONTEXT }images/nsyimg/care.png");
			    		$(".js-collectProduct").hide();
			    		$(".js-uncollectProduct").show();
			    	} else {
			    		//关注失败
			    		myLayer('关注失败！');
			    	}
			    } ,
			    error: function(err) {
			    	//系统维护中。。。
			    	myLayer('系统维护中。。。');
			    }
			});
		}
		function blurFuncProduct(userId) {
			
			$.ajax({
				type: 'POST',
				url: '${CONTEXT }product/blur/'+ '${productDto.productId }' +"?userId="+userId ,
			    cache: 'false' ,
			    dataType: 'json' ,
			    success: function(data) {
			    	if(data.resultcode=='0000') {
			    		//取消关注成功
			    		myLayer('取消关注成功！');
			    		$(".productDetailsWrap>.price .care").attr("src","${CONTEXT }images/nsyimg/no_care.png");
			    		$(".js-collectProduct").show();
			    		$(".js-uncollectProduct").hide();
			    	} else {
			    		//取消关注失败
			    		myLayer('取消关注失败！');
			    	}
			    } ,
			    error: function(err) {
			    	//系统维护中
			    	myLayer('系统维护中。。。');
			    }
			});
		}
		//跳转到下订单逻辑
		function goToOrder(params){
			JsBridge.goToOrder(params);
		}
		
		//跳转到添加购物车逻辑
		function addIntoShopcart(params){
			JsBridge.addIntoShopcart(params);
		}
		
		var newBol=0;
		var timer=null;
		
		function add2Shopcart(){
			var memberId = $("#userId").val();
			var productId = "${productDto.productId}";
			var quantity = $("#quantity").html();
			if(quantity == 0){
				myLayer('请输入采购量！');
				return;
			}
			
			//console.log("memberId: " + memberId + ", productId: " + productId);
			var productDetails={
		        "productId": productId,            // 产品id
		        "quantity": quantity                //购买数量
			};
			
			var jProductDetails = new Array();
			jProductDetails.push(productDetails);
			
			var data={
				'memberId':memberId,
				'productDetails':jProductDetails
			};
			
			//console.log(JSON.stringify(data));
			var params = JSON.stringify(data);
			addIntoShopcart(params);
		}
		
		function dealOrder(){
			if(newBol==0){
				newBol++;
				var memberId = $("#userId").val();
				var totalMoney = $("#ttmoney").html();
				var imgUrl = $(".swiper-slide").find('img:first').attr("src");
				var each=$("#each").html();
				if(each=="面议"){
					myLayer('请联系卖家！');
					return;
				}else if(totalMoney=="0.00"){
					//订单金额不能为空或0!
					myLayer('请输入采购量！');
					return;
				}
				var ProdDetails={
			    "needToPayAmount": totalMoney,              //产品总金额
		        "price": "${productDto.price}",           //产品单价
		        "productId": "${productDto.productId}",            // 产品id
		        "productName": "${productDto.productName}",        //产品名字
		        "purQuantity": $("#quantity").html(),                //购买数量
		        "unitName":"${productDto.unitName}",      //单位
		        "imgUrl":imgUrl        //图片地址

				};
				
				var jProductDetails = new Array();
				jProductDetails.push(ProdDetails);
			
				var data={
					'memberId':memberId,
					'businessId':'${productDto.businessId }',
					'shopName':'${productDto.shopsName }',
					'marketId':'${productDto.marketId}',
					'orderAmount':totalMoney,
					'payAmount':totalMoney,
					'orderSource':'2',
					//客户端自己传值 
					//'channel':'2',
					'jProductDetails':jProductDetails,
				};
					
				goToOrder(JSON.stringify(data));
			}	
			
			clearTimeout(timer);
			timer=setTimeout(function(){
				newBol=0;
			},1000)
			
		}
	    </script>
	<%@ include file="/WEB-INF/jsp/pub/baidu.inc" %>
</body>
</html>
