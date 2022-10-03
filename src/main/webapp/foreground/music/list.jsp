<script type="text/javascript" src="${pageContext.request.contextPath}/static/ueditor/third-party/SyntaxHighlighter/shCore.js"></script>
<link rel="stylesheet" href="${pageContext.request.contextPath}/static/ueditor/third-party/SyntaxHighlighter/shCoreDefault.css">
<script type="text/javascript" src="${pageContext.request.contextPath}/static/js/alt.js"></script>
<script type="text/javascript">
    SyntaxHighlighter.all();
    function showOtherComment(){
    	$(".otherComment").show();// 显示更多评论内容
    }
    
    function loadimage(){
		document.getElementById("randImage").src="${pageContext.request.contextPath}/image.jsp?"+Math.random();
	}
    
    
    function submitData(){
    	var content=$("#content").val();
    	var imageCode=$("#imageCode").val();
    	if(content==null || content==""){
    		commonUtil.message("请输入评论内容！","danger");
    	}else if(imageCode==null || imageCode==""){
    		commonUtil.message("请填写验证码！","danger");
    	}else{
    		$.post("${pageContext.request.contextPath}/comment/save.html",{"content":content,'imageCode':imageCode,'blog.id':'${blog.id}'},function(result){
    			if(result.success){
    				commonUtil.message("评论已提成成功，审核通过后显示！","success");
    			}else{
    				alert(result.errorInfo);
    			}
    		},"json");
    	}
    }
    
    
    
    
</script>

<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<style>
<!--

.data_list .blog_title{
	margin-top:20px;
	text-align: center;
}

.data_list .blog_info{
	text-align: center;
}

.data_list .blog_content{
	margin-top:20px;
	padding-bottom: 30px;
	padding-left:50px;
	
	word-break:break-all; 
	width:100%;
}

.data_list .blog_share{
	padding-left: 330px;
	padding-bottom: 20px;
	padding-top: 10px
}

.data_list .blog_keyword{
	margin-top:20px;
	padding-bottom: 30px;
	padding-left: 30px;
}

.data_list .blog_keyword a{
	color: black;
	font-style: italic;
}

.data_list .blog_lastAndNextPage{
	border-top:1px dotted black;
	padding: 10px;
}
-->
</style>

<div class="col-md-8">
<div class="data_list">
	<div class="data_list_title">
		<img src="/static/images/music.png"/>
		Music
	</div>
	<div>
		<div class="blog_title"><h3><strong>XXXXX</strong></h3></div>
		<div class="blog_content">
		<table class="table">
		  <tr align="center">
		  	<th>#</th>
		  	<th>name</th>
		  	<th>author</th>
		  	<th>Date</th>
		  	<th>Play back</th>
		  </tr>
		  <c:choose>
		  	<c:when test="${musicList.size()==0 }">暂无信息</c:when>
		  	<c:otherwise>
		  		<c:forEach var="music" items="${musicList }" varStatus="status">
		  			<tr >
					  	<td>${status.index+1 }</td>
					  	<td>${music.musicName }</td>
					  	<td>${music.author }</td>
					  	<td>
					  	<fmt:formatDate value="${music.createDate}" type="date" pattern="yyyy-MM-dd"/>
					  	</td>
					  	<td>
					  		<a href="javascript:;" target="_black">
					  			<img alt="Player" src="${pageContext.request.contextPath}/static/images/player.png">
					  		</a>
					  		<input type="hidden" name="id" id="id" value="${music.id }"/>
					  	</td>
					  </tr>
		  		</c:forEach>
		  	</c:otherwise>
		  </c:choose>
		</table>
		</div>
		<div class="blog_lastAndNextPage">
			<%-- ${pageCode } --%>
		</div>
	</div>
</div>

</div>