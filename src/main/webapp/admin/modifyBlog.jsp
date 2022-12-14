<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>修改博客</title>
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/static/jquery-easyui-1.3.3/themes/default/easyui.css">
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/static/jquery-easyui-1.3.3/themes/icon.css">
<script type="text/javascript" src="${pageContext.request.contextPath}/static/jquery-easyui-1.3.3/jquery.min.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/static/jquery-easyui-1.3.3/jquery.easyui.min.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/static/jquery-easyui-1.3.3/locale/easyui-lang-zh_CN.js"></script>

<script type="text/javascript" charset="gbk" src="${pageContext.request.contextPath}/static/ueditor/ueditor.config.js"></script>
<script type="text/javascript" charset="gbk" src="${pageContext.request.contextPath}/static/ueditor/ueditor.all.min.js"> </script>
<!--建议手动加在语言，避免在ie下有时因为加载语言失败导致编辑器加载失败-->
<!--这里加载的语言文件会覆盖你在配置项目里添加的语言类型，比如你在配置项目里配置的是英文，这里加载的中文，那最后就是中文-->
<script type="text/javascript" charset="gbk" src="${pageContext.request.contextPath}/static/ueditor/lang/zh-cn/zh-cn.js"></script>

<script type="text/javascript">

//解决工具栏错位问题 ，在需要的地方引入即可 或修改ueditor.config.js
var ue = UE.getEditor('editor',{
	autoFloatEnabled:false//是否保持toolbar位置不动
});
	
	function submitData(){
		var title=$("#title").val();
		var blogTypeId=$("#blogTypeId").combobox("getValue")
		var content=UE.getEditor('editor').getContent()
		var keyWord=$("#keyWord").val();
		
		if(title==null || title==''){
			alert("请输入标题！");
		}else if(blogTypeId==null || blogTypeId==''){
			alert("请选择博客类别！");
		}else if(content==null || content==''){
			alert("请填写内容！");
		}else{
			$.post("${pageContext.request.contextPath}/admin/blog/save.html",{'id':'${param.id}','title':title,'blogType.id':blogTypeId,
				'contentNoTag':UE.getEditor('editor').getContentTxt(),
				'content':content,'summary':UE.getEditor('editor').getContentTxt().substr(0,155),'keyWord':keyWord},function(result){
				if(result.success){
					alert("博客修改成功！");
					// 修改完成后关闭当tab页面
					window.parent.$('#tabs').tabs('close', '修改博客');
				}else{
					alert("博客修改失败！");
				}
			},"json");
			
		}
	}
	

</script>
</head>
<body style="margin: 10px">

<div id="p" class="easyui-panel" title="修改博客" style="padding: 10px">
	<table cellspacing="20px">
		<tr>
			<td width="80px">博客标题：</td>
			<td>
				<input type="text" id="title" name="title" style="width: 400px"/>
			</td>
		</tr>
		<tr>
			<td>所属类别：</td>
			<td>
				<select class="easyui-combobox" style="width: 154px" id="blogTypeId" name="blogType.id" editable="false" panelHeight="auto">
					<option value="">请选择博客类别...</option>
					<c:forEach var="blogType" items="${blogTypeList }">
						<option value="${blogType.id }">${blogType.typeName }</option>
					</c:forEach>
				</select>
			</td>
		</tr>
		<tr>
			<td valign="top">博客内容：</td>
			<td>
				<script id="editor" name="content" type="text/plain" style="width:100%;height:500px;"></script>
			</td>
		</tr>
		<tr>
			<td>关键字：</td>
			<td>
				<input type="text" id="keyWord" name="keyWord" style="width: 400px"/>&nbsp;(多个关键字中间用空格隔开)
			</td>
		</tr>
		<tr>
			<td></td>
			<td>
				<a href="javascript:submitData()" class="easyui-linkbutton" data-options="iconCls:'icon-submit'">发布博客</a>
			</td>
		</tr>
	</table>
</div>

<!-- 实例化编辑器 -->
<script type="text/javascript">
    var ue = UE.getEditor('editor');
    
    // ueditor 监听  - 页面加载时 请求后台获取数据
    ue.addListener("ready",function(){
    	// 通过ajax请求数据 - 只能是ueditor封装的ajax才可以
    	UE.ajax.request("${pageContext.request.contextPath}/admin/blog/findById.html",
    			{
    				method:"post",
    				async:false, // 默认异步，必须带async 否则请求不到后台
    				data:{"id":"${param.id}"},
    				onsuccess:function(result){
    					result=eval("("+result.responseText+")");
    					$("#title").val(result.title);
    					$("#keyWord").val(result.keyword);
    					$("#blogTypeId").combobox("setValue",result.blogType.id);
    					UE.getEditor('editor').setContent(result.content);
    				}
   			});
    });
</script>



</body>
</html>