<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ include file="../pub/constants.inc" %>
<%@ include file="../pub/tags.inc" %>
<%@ include file="/WEB-INF/jsp/pub/baidu.inc" %>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="utf-8" />
		<title></title>
		<link rel="stylesheet" type="text/css" href="${CONTEXT}css/global.m.css"/>
		<link rel="stylesheet" type="text/css" href="${CONTEXT}css/nsy-hd.css"/>
		<script src="${CONTEXT}js/jquery-1.8.3.min.js" type="text/javascript" charset="utf-8"></script>
<%@ include file="../pub/head.inc" %>
<link rel="stylesheet" href="${CONTEXT}v1.0/css/home.css">			
	</head>
	<body>
	<jsp:include page="/WEB-INF/jsp/pub/head.jsp"></jsp:include>
	
		<div class="markAll">
			<div class="mark" onclick="guizeClose()"></div>
			<div class="markKuang">
				<img class="guizeClose" onclick="guizeClose()" src="${CONTEXT}images/tuiguang0811/guizeClose.png"/>
				<ul>
					<li>
						<p class="title"><img src="${CONTEXT}images/tuiguang0811/ashDoc.png"/>活动流程:</p>
						<ul>
							<li>1&nbsp;通过农商友APP在任意合作商铺内首次下单，并通过POS机刷卡或其他方式支付成功。</li>
							<li>2&nbsp;已注册用户可直接参与活动，未注册用户需下载并注册成为农商友会员再参与活动。</li>
							<li>3&nbsp;活动参与成功后，凭借首单成功依据即可在有效期内在礼品管理处领取礼品。</li>
						</ul>
					</li>
					
					<li>
						<p class="title"><img src="${CONTEXT}images/tuiguang0811/ashDoc.png"/>活动参与对象：</p>
						<p>所有农商友注册用户（老用户可直接参与、新用户需先下载并注册成为农商友会员）。</p>
					</li>
					
					<li>
						<p class="title"><img src="${CONTEXT}images/tuiguang0811/ashDoc.png"/>活动参与方式：</p>
						<p>通过农商友APP在合作商铺内，首次下单并付款成功，凭借交易凭证即可领取一份首单奖励礼品。</p>
					</li>
					
					<li>
						<p class="title"><img src="${CONTEXT}images/tuiguang0811/ashDoc.png"/>活动参与有效日期：</p>
						<p>8月20日——12月18日（待定）</p>
						<p class="title">活动礼品领取有效日期：</p>
						<p>8月21日——12月30日（待定）</p>
					</li>
					
					<li>
						<p class="title"><img src="${CONTEXT}images/tuiguang0811/ashDoc.png"/>礼品领取方式：</p>
						<p>POS 刷卡 ：凭借APP交易单号+POS机支付小票，到礼品管理处领取礼品。</p>
						<p>非POS刷卡：凭借APP交易单号+商户开给客户的收据的客户联，到礼品管理处领取礼品</p>
					</li>
				</ul>
			</div>
		</div>
		<div class="nsy-hd-warp">
		    <div class='bg-01'>
					<div class="daojishi">
						<img src="${CONTEXT}images/tuiguang0811/img-tm.png" width='100%'/>
						<div class='time'>
							<span class="day red-font"></span>天<span class="hour red-font"></span>时<span class="fen red-font"></span>分<span class="second red-font"></span>秒
						</div>
					</div>
					<!--<img class="guize" onclick="clickGuize()" src="${CONTEXT}images/tuiguang0811/guize.png"/>-->
		    </div>
			<div class="bg-02">
				<div class='box'>
					<a href="http://www.gdeng.cn/nsy/qdb/nsy_shoudanhuodong.html"><img class="bottom" src="${CONTEXT}images/tuiguang0811/share_bottom.png"/></a>
				</div>
			</div>
			<!--<img class="explain" src="${CONTEXT}images/tuiguang0811/hd_Explain.jpg"/>-->
			<div class="con">
				<div class="content">
					<div class="title">
						<img src="${CONTEXT}images/tuiguang0811/title.png"/>
						<p class="title-font">推荐优质商铺</p>
					</div>
					<ul>
						<li>
							<a href="http://www.gdeng.cn/yulin/business/shop/4007.html">
							<div class="onesImg" style="position:relative;">
								<img src="${CONTEXT}images/tuiguang0811/yulin_new_6.jpg"/>
								<div class="grey">
										<span class="zyfl">主营分类：</span>
										<span>副食</span>
								</div>
							</div>
							<div class="onesFont"><img src="${CONTEXT}images/tuiguang0811/hd_ones_font.png"/><p>陈琼冷冻食品经营部</p></div></a>
						</li>
						<li>
							<a href="http://www.gdeng.cn/yulin/business/shop/10484.html">
							<div class="onesImg" style="position:relative;">
								<img src="${CONTEXT}images/tuiguang0811/yulin_new_5.jpg"/>
								<div class="grey">
										<span class="zyfl">主营分类：</span>
										<span>副食</span>
								</div>
							</div>
							<div class="onesFont"><img src="${CONTEXT}images/tuiguang0811/hd_ones_font.png"/><p>梁弟鲜蛋批发部</p></div></a>
						</li>
						<li>
							<a href="http://www.gdeng.cn/yulin/business/shop/4657.html">
							<div class="onesImg" style="position:relative;">
								<img src="${CONTEXT}images/tuiguang0811/yulin_new_4.jpg"/>
								<div class="grey">
										<span class="zyfl">主营分类：</span>
										<span>果蔬</span>
								</div>
							</div>
							<div class="onesFont"><img src="${CONTEXT}images/tuiguang0811/hd_ones_font.png"/><p>国庆果业</p></div></a>
						</li>
						<li>
							<a href="http://www.gdeng.cn/yulin/business/shop/33973.html">
							<div class="onesImg" style="position:relative;">
								<img src="${CONTEXT}images/tuiguang0811/yulin_new_3.jpg"/>
								<div class="grey">
										<span class="zyfl">主营分类：</span>
										<span>副食</span>
								</div>
							</div>
							<div class="onesFont"><img src="${CONTEXT}images/tuiguang0811/hd_ones_font.png"/><p>饱芝零副食</p></div></a>
						</li>
						
						<li>
							<a href="http://www.gdeng.cn/yulin/business/shop/4208.html">
							<div class="onesImg" style="position:relative;">
								<img src="${CONTEXT}images/tuiguang0811/yulin_new_2.jpg"/>
								<div class="grey">
										<span class="zyfl">主营分类：</span>
										<span>粮油</span>
								</div>
							</div>
							<div class="onesFont"><img src="${CONTEXT}images/tuiguang0811/hd_ones_font.png"/><p>健宏食用油商行</p></div></a>
						</li>
						<li>
							<a href="http://www.gdeng.cn/yulin/business/shop/16108.html">
							<div class="onesImg" style="position:relative;">
								<img src="${CONTEXT}images/tuiguang0811/yulin_new_1.jpg"/>
								<div class="grey">
										<span class="zyfl">主营分类：</span>
										<span>果蔬</span>
								</div>
							</div>
							<div class="onesFont"><img src="${CONTEXT}images/tuiguang0811/hd_ones_font.png"/><p>十二娘果业</p></div></a>
						</li>
						
						<li>
							<a href="http://www.gdeng.cn/yulin/business/shop/4371.html">
							<div class="onesImg" style="position:relative;">
								<img src="${CONTEXT}images/tuiguang0811/yulin_1.jpg"/>
								<div class="grey">
										<span class="zyfl">主营分类：</span>
										<span>酒水</span>
								</div>
							</div>
							<div class="onesFont"><img src="${CONTEXT}images/tuiguang0811/hd_ones_font.png"/><p>炎城商贸</p></div></a>
						</li>
						<li>
							<a href="http://www.gdeng.cn/yulin/business/shop/28120.html">
							<div class="onesImg" style="position:relative;">
							<img src="${CONTEXT}images/tuiguang0811/yulin_2.jpg"/>
							<div class="grey">
										<span class="zyfl">主营分类：</span>
										<span>粮油</span>
							</div>
							</div>
							<div class="onesFont"><img src="${CONTEXT}images/tuiguang0811/hd_ones_font.png"/><p>湖北大米行</p></div></a>
						</li><li>
							<a href="http://www.gdeng.cn/yulin/business/shop/4020.html">
							<div class="onesImg" style="position:relative;">
							<img src="${CONTEXT}images/tuiguang0811/yulin_3.jpg"/>
							<div class="grey">
										<span class="zyfl">主营分类：</span>
										<span>海产</span>
							</div>
							</div>
							<div class="onesFont"><img src="${CONTEXT}images/tuiguang0811/hd_ones_font.png"/><p>玉林泰好冷冻食品经营部</p></div></a>
						</li><li>
							<a href="http://www.gdeng.cn/yulin/business/shop/24851.html">
							<div class="onesImg" style="position:relative;">
							<img src="${CONTEXT}images/tuiguang0811/yulin_4.jpg"/>
							<div class="grey">
										<span class="zyfl">主营分类：</span>
										<span>副食</span>
							</div>
							</div>
							<div class="onesFont"><img src="${CONTEXT}images/tuiguang0811/hd_ones_font.png"/><p>广西宏盟生态农业有限公司</p></div></a>
						</li>
					</ul>
					<div class="title">
						<img src="${CONTEXT}images/tuiguang0811/title.png"/>
						<p class="title-font02">礼品领取详细地址及工作人员联系方式</p>
					</div>
					<div class="addressDetail">
						<ul>
							<li>
								<div class="red-doc"><img src="${CONTEXT}images/tuiguang0811/redDoc.png"/></div>
								<div class="right">
									<p class="red-font">玉林办事处</p>
									<p>地址:广西壮族自治区玉林市二环北路1222号玉林宏进农副产品批发市场1区1栋1号（办公楼5楼）</p>
									<p>联系人:张诗强 18907939330&nbsp;李伍符 15977555593</p>
								</div>
							</li>
							<!--<li>
								<div class="red-doc"><img src="${CONTEXT}images/tuiguang0811/redDoc.png"/></div>
								<div class="right">
									<p class="red-font">洛阳办事处</p>
									<p>地址:洛阳市老城区邙山镇310国道与定鼎北路交叉口北300米洛阳宏进农产品批发市场招商中心2楼</p>
									<p>联系人:杨依勇13949121953&nbsp;吕伟15038532033</p>
								</div>
							</li>
							<li>
								<div class="red-doc"><img src="${CONTEXT}images/tuiguang0811/redDoc.png"/></div>
								<div class="right">
									<p class="red-font">濮阳办事处</p>
									<p>地址:濮阳市宏进农副产品国际物流中心南环路与濮水路交叉口（原王助菜市场）</p>
									<p>联系人:刘增启15139382833&nbsp;王岩15893272533</p>
								</div>
							</li>
							<li>
								<div class="red-doc"><img src="${CONTEXT}images/tuiguang0811/redDoc.png"/></div>
								<div class="right">
									<p class="red-font">武汉办事处</p>
									<p>地址：湖北省武汉市洪山区白沙洲大道张家湾特一号白沙洲农副产品大市场办公大楼二楼</p>
									<p>联系人:万婷 15871438600&nbsp;孟婕 15669260502</p>
								</div>
							</li>
							<li>
								<div class="red-doc"><img src="${CONTEXT}images/tuiguang0811/redDoc.png"/></div>
								<div class="right">
									<p class="red-font">恩施办事处</p>
									<p>地址:恩施市土桥坝马鞍山路41号华硒生态市场结算中心3楼</p>
									<p>联系人:李杨 13871174900</p>
								</div>
							</li>
							<li>
								<div class="red-doc"><img src="${CONTEXT}images/tuiguang0811/redDoc.png"/></div>
								<div class="right">
									<p class="red-font">开封办事处</p>
									<p>地址:开封市禹王台区310国道芦花岗转盘东2公里，开封宏进农副产品国际物流中心C区C14--24</p>
									<p>联系人:丁广信 13733838485&nbsp;刘举 15637808808</p>
								</div>
							</li>
							<li>
								<div class="red-doc"><img src="${CONTEXT}images/tuiguang0811/redDoc.png"/></div>
								<div class="right">
									<p class="red-font">钦州办事处</p>
									<p>地址:广西壮族自治区钦州市金海湾西大街1222号中国东盟农产品大市场A9-3-3楼</p>
									<p>联系人:彭瑛 13217730110&nbsp;唐国祥 15778761816</p>
								</div>
							</li>
							<li>
								<div class="red-doc"><img src="${CONTEXT}images/tuiguang0811/redDoc.png"/></div>
								<div class="right">
									<p class="red-font">玉林办事处</p>
									<p>地址:广西壮族自治区玉林市二环北路1222号玉林宏进农副产品批发市场1区1栋1号（办公楼5楼）</p>
									<p>联系人:张诗强 18907939330&nbsp;李伍符 15977555593</p>
								</div>
							</li>
							<li>
								<div class="red-doc"><img src="${CONTEXT}images/tuiguang0811/redDoc.png"/></div>
								<div class="right">
									<p class="red-font">徐州办事处</p>
									<p>地址:徐州农副产品市场结算中心二楼</p>
									<p>联系人:海帅 15862160126&nbsp;王海菊 13182321576</p>
								</div>
							</li>-->
						</ul>
					</div>
				</div>
			</div>
			<!--<img class="footerFont" src="${CONTEXT}images/tuiguang0811/footerFont.png"/>-->
			<div class="footerFont">
				<ul>
					<li>
						<p class="title"><img src="${CONTEXT}images/tuiguang0811/fffDoc.png"/>活动流程:</p>
						<ul>
							<li>1&nbsp;通过农商友APP在任意合作商铺内首次下单，并通过POS机刷卡或其他方式支付成功。</li>
							<li>2&nbsp;已注册用户可直接参与活动，未注册用户需下载并注册成为农商友会员再参与活动。</li>
							<li>3&nbsp;活动参与成功后，凭借首单成功依据即可在有效期内在礼品管理处领取礼品。</li>
						</ul>
					</li>
					
					<li>
						<p class="title"><img src="${CONTEXT}images/tuiguang0811/fffDoc.png"/>活动参与对象：</p>
						<p>所有农商友注册用户（老用户可直接参与、新用户需先下载并注册成为农商友会员）。</p>
					</li>
					
					<li>
						<p class="title"><img src="${CONTEXT}images/tuiguang0811/fffDoc.png"/>活动参与方式：</p>
						<p>通过农商友APP在合作商铺内，首次下单并付款成功，凭借交易凭证即可领取一份首单奖励礼品。</p>
					</li>
					
					<li>
						<p class="title"><img src="${CONTEXT}images/tuiguang0811/fffDoc.png"/>活动参与有效日期：</p>
						<p>8月18日——12月31日</p>
						<p class="title">活动礼品领取有效日期：</p>
						<p>8月18日——12月31日</p>
					</li>
					
					<li>
						<p class="title"><img src="${CONTEXT}images/tuiguang0811/fffDoc.png"/>礼品领取方式：</p>
						<p>POS 刷卡 ：凭借APP交易单号+POS机支付小票，到礼品管理处领取礼品。</p>
						<p>非POS刷卡：凭借APP交易单号+商户开给客户的收据的客户联，到礼品管理处领取礼品</p>
					</li>
					
					<li style="margin-left:-18px;">如有任何疑问，可以联系市场活动负责人，也可以拨打客服电话。</li>
				</ul>
			</div>
			<ul class="footerEnd">
			    <li class="sou-sou"><img src="${CONTEXT}images/tuiguang0811/weix-nsy.jpg"</li>
				<li>1.  本次活动的最终解释权归主办方深圳谷登科技有限公司所有。</li>
				<li>2.  对于任何通过不正当手段参加活动者，主办方有权在不事先通知的前提下取消其参加活动的资格。</li>
				<li>3.  如遇不可抗因素，主办方有权提前结束或终止本次活动。</li>
				<li>4.  每个用户限参与一次首单活动和分享活动，多次参加无效。</li>
			</ul>
			
		</div>
	<%@ include file="/WEB-INF/jsp/pub/baidu.inc" %>
</body>
	<script src="${CONTEXT}js/nsy-hd.js" type="text/javascript" charset="utf-8"></script>
</html>
