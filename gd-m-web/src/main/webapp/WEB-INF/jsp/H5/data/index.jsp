<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/jsp/pub/constants.inc" %>
<%@ include file="/WEB-INF/jsp/pub/tags.inc" %>

<!doctype html>
<html>
<head> 
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<title>数据报表</title>
	<meta http-equiv="Content-Type" content="text/html">
    <meta name="viewport" content="width=device-width, initial-scale=1.0, minimum-scale=1.0, maximum-scale=1.0, user-scalable=no"/>
    <meta name="apple-touch-fullscreen" content="yes">
    <meta name="apple-mobile-web-app-capable" content="yes"/>
    <link rel="stylesheet" href="${CONTEXT }/v1.0/css/data/base.cy.min.css">
    <link rel="stylesheet" href="${CONTEXT }/v1.0/css/data/index.min.css">
    <script src="${CONTEXT }/v1.0/js/jquery-1.8.3.min.js"></script>
    <script src="${CONTEXT }/v1.0/js/mustache.js"></script>
</head>

<body>

	<div id="index">
		<!-- 数据显示 -->
		<div class="data-area">
			
		</div>
		<!-- 入口 -->
		<div class="menu-area">
			<table width="100%" border="0">
				<tr>
					<td class="icon-data"><a href="${CONTEXT }data/dealStat?memberId=${memberId }"><span></span><br/>交易数据</a></td>
					<td class="icon-ex-analyze"><a href="${CONTEXT }data/tradeAnalysis?memberId=${memberId }"><span></span><br/>交易分析</a></td>
				</tr>
				<tr>
					<td class="icon-goods-rank"><a href="${CONTEXT }goods/goodsRanking?memberId=${memberId }"><span></span><br/>商品排名</a></td>
					<td class="icon-goods-analyze"><a href="${CONTEXT }goods/goodList?memberId=${memberId }"><span></span><br/>商品分析</a></td>
				</tr>
			</table>
		</div>
	</div>
<%@ include file="/WEB-INF/jsp/pub/baidu.inc" %>
</body>
<script src="${CONTEXT }/v1.0/js/repeater-cy.js"></script>
<script src="${CONTEXT }/v1.0/js/common.js"></script>
<script src="${CONTEXT }/v1.0/js/data/indexController.js"></script>
<script type="text/javascript">
function getQueryString(name) {
    var result = location.search.match(new RegExp("[\?\&]" + name + "=([^\&]+)", "i"));
    if (result == null || result.length < 1) {
        return "";
    }
    return result[1];
};
var ids=getQueryString('memberId');
function todayClick(num){
	window.location.href="${CONTEXT }data/dealStat?memberId="+ids+"&type="+num;
}
</script>
</html>