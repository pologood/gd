<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ include file="../pub/constants.inc"%>
<%-- <%@ include file="../pub/head.inc" %> --%>
<%@ include file="../pub/tags.inc"%>
<style type="text/css">
.mleft {
	font-size: 16px;
	text-align: right;
	valign: middle;
	width: 150px;
}

.mright {
	font-size: 16px;
	align: left;
	valign: middle;
}
</style>

<form id="viewForm" method="post" action="friendslinks/view">
	<div>
		<input type="hidden" id="id" name="id" value="${dto.id}" />
		<table>
			<tr>
				<td class="mleft"><span style="color: red;"></span>链接栏目:</td>
				<td class="mright"><select name="linkCate" id="linkCate"  disabled="disabled">
							<option value="1" <c:if test="${dto.linkCate==1 }">selected</c:if>>友情链接</option>
							<option value="2" <c:if test="${dto.linkCate==2 }">selected</c:if>>合作媒体</option>
					  </select></td>
			</tr>
			<tr>
				<td class="mleft"><span style="color: red;"></span>链接类型:</td>
				<td class="mright"><select name="linkType" id="linkType"  disabled="disabled">
							<option value="1" <c:if test="${dto.linkType==1 }">selected</c:if>>文字</option>
							<option value="2" <c:if test="${dto.linkType==2 }">selected</c:if>>图片</option>
							<option value="3" <c:if test="${dto.linkType==3 }">selected</c:if>>文字加图片</option>
					  </select></td>
			</tr>
			<tr>
				<td class="mleft"><span style="color: red;"></span>链接URL:</td>
				<td><input type="text" id="linkUrl" name="linkUrl" maxlength="20" class="easyui-validatebox" style="width: 150px" value="${dto.linkUrl}" disabled="disabled"></td>
			</tr>
			<tr>
				<td class="mleft"><span style="color: red;"></span>说明:</td>
				<td><textarea rows="3" cols="30" style="width:100%;font-size:14px;" 
					name="description" disabled="disabled">${dto.description}</textarea></td>
			</tr>
			
			<c:if test="${dto.linkType==1 }">
			<tr>
				<td class="mleft"><span style="color: red;"></span>链接文字:</td>
				<td class="mright"><input type="text" id="linkName" name="linkName" maxlength="20" class="easyui-validatebox" style="width: 150px" value="${dto.linkName}" disabled="disabled"></td>
			</tr>
			
			</c:if>
			
			<c:if test="${dto.linkType==2 }">
				<tr>
				<td class="mleft"><span style="color: red;"></span>链接图片:</td>
				<td><a href="${imgHostUrl}${dto.linkImage}" target="_blank"><img src="${imgHostUrl}${dto.linkImage}" width="100" height="100"></a></td>
			</tr>
			</c:if>
			
			<c:if test="${dto.linkType==3 }">
				<tr>
				<td class="mleft"><span style="color: red;"></span>链接文字:</td>
				<td class="mright"><input type="text" id="linkName" name="linkName" maxlength="20" class="easyui-validatebox" style="width: 150px" value="${dto.linkName}" disabled="disabled"></td>
			</tr>
			<tr>
				<td class="mleft"><span style="color: red;"></span>链接图片:</td>
				<td><a href="${imgHostUrl}${dto.linkImage}" target="_blank"><img src="${imgHostUrl}${dto.linkImage}" width="100" height="100"></a></td>
			</tr>
			</c:if>
			
			<c:if test="${dto.status==2 }">
			<tr>
				<td class="mleft"><span style="color: red;"></span>状态:</td>
				<td><select name="status" id="status">
							<option value="0" <c:if test="${dto.status==0 }">selected</c:if>>停用</option>
							<option value="1" <c:if test="${dto.status==1 }">selected</c:if>>启用</option>
							<option value="2" <c:if test="${dto.status==2 }">selected</c:if>>待审核</option>
							<option value="3" <c:if test="${dto.status==3 }">selected</c:if>>审核不通过</option>
					  </select></td>
			</tr>
			</c:if>
		</table>
	</div>
</form>

<script type="text/javascript" >
var appUrl = CONTEXT+'friendslinks/uploadProductPic';

initUploadModule("upload_btn_link",appUrl, "picture_queen_link", "J_Urls_Link",1,'',1);

	function check(){
		if ( $.trim($("input[name='linkPicture']").val()) == ""){
			warningMessage("必须上传链接图片");
			return false;
		}
	}
	
	function add() {		
		//if (!check()) return false;
		var url=CONTEXT+"friendslinks/add";
	 	jQuery.post(url, $('#addForm').serialize(), function (data) {
			if (data == "success") {
				slideMessage("操作成功！");
				
				//刷新父页面列表
				$("#friendslinksdg").datagrid('reload');
				$('#addDialog').dialog('close');
			} else {
				warningMessage(data.message);
				$('#addDialog').dialog('close');
				return;
			}
		}); 
	}
	
	/**单图上传**/
	function initUploadModule(uploadBtn, uploadUrl, queueId, JUrls, pictureCountLimit, filesStr, certification){
	var config_mutiple = {
	        galleryUrl : CONTEXT+"js/uploader/",//控件静态地址
	        uploadBtn : uploadBtn,//初始的button
	        queueId : queueId,//图片装载容器id
	        JUrls : JUrls,//成功后返回url参数写入id
	        action : uploadUrl ,//上传地址
	        max : pictureCountLimit,//允许上传个数
	        type :"ajax",//上传类型
	        imgUrlPrefix : '${imgHostUrl}',
	        filesStr : filesStr,//此处是附加参数，已经上传需要第二次修的图片参数
	        certification : certification//此处是附加参数，已经上传需要第二次修，是否可以修改
	};
	gdKissySingleUploader.init(config_mutiple ,function(uploader){
	     var filesStr = config_mutiple.filesStr;
	     var certification = config_mutiple.certification;
	     if(filesStr != ''&&filesStr!=undefined){
	        var fileList = eval("("+  filesStr + ")");
	        
	        gdKissySingleUploader.addFiles(fileList,uploader);
	        
	        if(certification == 0){
	                $("#"+JUrls).parent().find(".file-input").attr("disabled","disabled");
	        }else{
	        	/**可以修改时注册删除事件**/
	        	$(".form-context").delegate(".imageUploader_del","click",function(){
	        		$("#J_Urls").val("");
				    $(this).parents("li").get(0).remove();
				    var originalUrl = $(this).parent().siblings().find("a img").attr("data-original-url");
				    $("input[name*='"+JUrls+"']").each(function(){
				        if($(this).val()==originalUrl){
				            $(this).val("");
				        }
				    });
				});
	        }
	     }
	},function(url){
 	    
	});
}
	
	var dtostatus='${dto.status}';
	if(dtostatus != '2' ){
		$("#dlg-buttonsView").hide();
	}
</script>
