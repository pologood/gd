<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/jsp/pub/constants.inc" %>
<%@ include file="/WEB-INF/jsp/pub/tags.inc" %>

<!doctype html>
<html>
<head> 
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<title></title>
	<meta http-equiv="Content-Type" content="text/html">
    <meta name="viewport" content="width=device-width, initial-scale=1.0, minimum-scale=1.0, maximum-scale=1.0, user-scalable=no"/>
    <meta name="apple-touch-fullscreen" content="yes">
    <meta name="apple-mobile-web-app-capable" content="yes"/>
    <link rel="stylesheet" href="${CONTEXT }/v1.0/css/data/base.cy.min.css">
    <link rel="stylesheet" href="${CONTEXT }/v1.0/css/data/index.min.css">
    <link rel="stylesheet" href="${CONTEXT }/v1.0/js/plugs/mobiscroll/mobiscroll.custom.css">
    <script src="${CONTEXT }/v1.0/js/jquery-1.8.3.min.js"></script>
    <script src="${CONTEXT }/v1.0/js/plugs/mobiscroll/mobiscroll.custom.min.js"></script>
    <script src="${CONTEXT }/v1.0/js/mustache.js"></script>
</head>

<body>
	<div id="good-list">
		<div class="list-opt ui-box">
			<div class="sort-way active ui-f1 ui-box ui-hc ui-vc">交易额</div>
			<div class="sort-way ui-f1 ui-box  ui-hc ui-vc">浏览量</div>
			<div class="sort-way ui-f1 ui-box  ui-hc ui-vc" id="time">2016-01</div>
			<div class="sort-layer">
				<ul class="sum-deal">
					<li class="active" data-sort = "0">交易额从高到低</li>
					<li data-sort = "1">交易额从低到高</li>
				</ul>
				<ul class="sum-browse">
					<li class="active" data-sort = "2">浏览量从高到低</li>
					<li data-sort = "3">浏览量从低到高</li>
				</ul>
				<span></span>
				<div class="sort-layer-bg"></div>
			</div>
		</div>
		<div class="list-wrap trade-highlight">
			
		</div>
	</div>
	
	
</body>
<script type="text/javascript">
var CONTEXT = "${CONTEXT}";
var imgHost="${imgHostUrl}";
</script>
<script src="${CONTEXT }/v1.0/js/repeater-cy.js"></script>
<script src="${CONTEXT }/v1.0/js/common.js"></script>
<script src="${CONTEXT }/v1.0/js/data/goodListController.js"></script>

</html>
