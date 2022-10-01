<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" href="${pageContext.request.contextPath}/static/bootstrap3/css/bootstrap.min.css">
<link rel="stylesheet" href="${pageContext.request.contextPath}/static/bootstrap3/css/bootstrap-theme.min.css">
<link rel="stylesheet" href="${pageContext.request.contextPath}/static/css/blog.css">
<script src="${pageContext.request.contextPath}/static/bootstrap3/js/jquery-1.11.2.min.js"></script>
<script src="${pageContext.request.contextPath}/static/bootstrap3/js/bootstrap.min.js"></script>
<title>HOME</title>
<style type="text/css">
	html {
	overflow-y: scroll;
	}
	body{
		padding-top: 2px;
		padding-bottom: 40px;
		background-color: #3F6371;
		overflow: hidden;
	}
</style>
</head>
<body>
<div class="container--fiuled"> <!-- container--fiuled 填充整个屏幕-->
	<div>
	
	<div class="row" style="background:url(${pageContext.request.contextPath}/static/images/background.jpg); ">
		<div class="col-md-4">
			<img alt="Blog" src="${pageContext.request.contextPath}/static/images/logo.png" style="height:150px;">
		</div>
		<div class="col-md-7" style="transform: translateY(50%);height: 50px;">
			<iframe style="float: right;" width="420" scrolling="no" height="60" frameborder="0" allowtransparency="true" src="http://i.tianqi.com/index.php?c=code&id=12&icon=1&num=5"></iframe>
		</div>
		<div class="col-md-1"></div>
	</div>
	<!-- 导航 -->
	<div class="row">
		<div class="col-md-12" style="padding-top: 5px;"><!-- navbar-fixed-top  固定在顶部 -->
			<nav class="navbar navbar-default " style="background:#211E1C;border: 1px solid #211E1C">
			  <div class="container-fluid">
			    <!-- Brand and toggle get grouped for better mobile display -->
			    <div class="navbar-header">
			      <a class="navbar-brand" href="#"><font color="#FFF"><strong>首页</strong></font></a>
			    </div>
			
			    <!-- Collect the nav links, forms, and other content for toggling -->
			    <div class="collapse navbar-collapse" id="bs-example-navbar-collapse-12">
			      <ul class="nav navbar-nav">
			        <li><a href="#"><font color="#FFF"><strong>关于博主</strong></font></a></li>
			        <li><a href="#"><font color="#FFF"><strong>本站源码下载</strong></font></a></li>
			      </ul>
			      <form class="navbar-form navbar-right" role="search">
			        <div class="form-group">
			          <input type="text" class="form-control" placeholder="请输入要查询的关键字...">
			        </div>
			        <button type="submit" class="btn btn-primary">搜索</button>
			      </form>
			    </div><!-- /.navbar-collapse -->
			  </div><!-- /.container-fluid -->
			  <div class="row no-gutters" style="height:80px; background-color: #665F5B;">
				<div class="col-md-12" >&nbsp;</div>
			</div>
			</nav>
		</div>
	</div>
	
	</div>
	<div class="row">
	<div class="col-md-1">&nbsp;</div>
	<div class="col-md-2">
	  		<div class="data_list">
				<div class="data_list_title">
					<img src="${pageContext.request.contextPath}/static/images/user_icon.png"/>
					Blogger
				</div>
				<div class="user_image">
					<img src="${pageContext.request.contextPath}/static/userImages/${blogger.imageName}" style="height:100%"/>
				</div>
				<div class="nickName">${blogger.nickName}</div>
				<div class="userSign">${blogger.sign} </div>
			</div>
	  	
	  		<div class="data_list">
				<div class="data_list_title">
					<img src="${pageContext.request.contextPath}/static/images/byType_icon.png"/>
					By Category
				</div>
				<div class="datas">
					<ul>
						<c:forEach var="blogTypeCount" items="${blogTypeCountList }">
							<li><span><a href="#">${blogTypeCount.typeName }(${blogTypeCount.blogCount })</a></span></li>
						</c:forEach>
					</ul>
				</div>
			</div>
	  		
	  		
	  		
			<div class="data_list">
				<div class="data_list_title">
					<img src="${pageContext.request.contextPath}/static/images/byDate_icon.png"/>
					By Date
				</div>
				<div class="datas">
					<ul>
							<li><span><a href="/index.html?releaseDateStr=2016年02月">2016年02月(11)</a></span></li>
						
					</ul>
				</div>
			</div>
			
			<div class="data_list">
				<div class="data_list_title">
					<img src="${pageContext.request.contextPath}/static/images/link_icon.png"/>
					Link's
				</div>
				<div class="datas">
					<ul>
						<c:forEach var="link" items="${linkList }">
							<li><span><a href="${link.linkUrl }" target="_blank">${link.linkName }</a></span></li>
						</c:forEach>
					</ul>
				</div>
			</div>
	  		
	  </div>
	  
	  <div class="col-md-8">
	  	<div class="data_list">
	  		<div class="data_list_title">
			<img src="${pageContext.request.contextPath}/static/images/list_icon.png"/>
			Latest</div>
	  		
	  		<div class="datas">
	  			<ul>
	  				<li style="margin-bottom: 30px">
	  					<span class="date"><a href="${pageContext.request.contextPath}/blog/articles/52.html">2016年02月15日</a></span>
					  	<span class="title"><a href="${pageContext.request.contextPath}/blog/articles/52.html">使用CXF开发WebService客户端</a></span>
					  	<span class="summary">摘要: 前面一讲开发了webservice服务器端接口，今天的话，我们来开发webservice客户端，让大家来体验下过程；首先建一个Maven项目，项目名字，WS_Client；然后我们要用CXF给我们提供的工具wsdl2java 来根据请求的url生成客户端代码；wsdl2java工具在CXF开发包里；开发下载地...</span>
					  	<span class="img">
					  		
						  		<a href="/blog/articles/52.html"><img src="${pageContext.request.contextPath}/static/userImages/a.jpg" alt="1455539511890048174.jpg"></a>
						  		&nbsp;&nbsp;
					  		
						  		<a href="/blog/articles/52.html"><img alt="5203213.jpg" src="${pageContext.request.contextPath}/static/userImages/b.jpg" title="1455539700734093102.jpg" width="667" height="264" style="width: 667px; height: 264px;"></a>
						  		&nbsp;&nbsp;
					  		
						  		<a href="/blog/articles/52.html"><img alt="215203317.jpg" src="${pageContext.request.contextPath}/static/userImages/c.jpg" title="1455539761187019902.jpg"></a>
						  		&nbsp;&nbsp;
					  		
					  	</span>
					  	<span class="info">发表于 2016-02-15 21:06 阅读(71) 评论(5) </span>
	  					
	  				</li>
	  				 <hr style="height:5px;border:none;border-top:1px dashed gray;padding-bottom:  10px;" />
	  				
	  				<li style="margin-bottom: 30px">
	  					<span class="date"><a href="${pageContext.request.contextPath}/blog/articles/52.html">2016年02月15日</a></span>
					  	<span class="title"><a href="${pageContext.request.contextPath}/blog/articles/52.html">使用CXF开发WebService客户端</a></span>
					  	<span class="summary">摘要: 前面一讲开发了webservice服务器端接口，今天的话，我们来开发webservice客户端，让大家来体验下过程；首先建一个Maven项目，项目名字，WS_Client；然后我们要用CXF给我们提供的工具wsdl2java 来根据请求的url生成客户端代码；wsdl2java工具在CXF开发包里；开发下载地...</span>
					  	<span class="img">
					  		
						  		<a href="/blog/articles/52.html"><img src="${pageContext.request.contextPath}/static/userImages/a.jpg" alt="1455539511890048174.jpg"></a>
						  		&nbsp;&nbsp;
					  		
						  		<a href="/blog/articles/52.html"><img alt="15203213.jpg" src="${pageContext.request.contextPath}/static/userImages/b.jpg" title="1455539700734093102.jpg" width="667" height="264" style="width: 667px; height: 264px;"></a>
						  		&nbsp;&nbsp;
					  		
						  		<a href="/blog/articles/52.html"><img alt="0215203317.jpg" src="${pageContext.request.contextPath}/static/userImages/c.jpg" title="1455539761187019902.jpg"></a>
						  		&nbsp;&nbsp;
					  		
					  	</span>
					  	<span class="info">发表于 2016-02-15 21:06 阅读(71) 评论(5) </span>
	  					
	  				</li>
	  				 <hr style="height:5px;border:none;border-top:1px dashed gray;padding-bottom:  10px;" />
	  				
	  				
	  				<li style="margin-bottom: 30px">
	  					<span class="date"><a href="${pageContext.request.contextPath}/blog/articles/52.html">2016年02月15日</a></span>
					  	<span class="title"><a href="${pageContext.request.contextPath}/blog/articles/52.html">使用CXF开发WebService客户端</a></span>
					  	<span class="summary">摘要: 前面一讲开发了webservice服务器端接口，今天的话，我们来开发webservice客户端，让大家来体验下过程；首先建一个Maven项目，项目名字，WS_Client；然后我们要用CXF给我们提供的工具wsdl2java 来根据请求的url生成客户端代码；wsdl2java工具在CXF开发包里；开发下载地...</span>
					  	<span class="img">
					  		
						  		<a href="/blog/articles/52.html"><img src="${pageContext.request.contextPath}/static/userImages/a.jpg" alt="1455539511890048174.jpg"></a>
						  		&nbsp;&nbsp;
					  		
						  		<a href="/blog/articles/52.html"><img alt="215203213.jpg" src="${pageContext.request.contextPath}/static/userImages/b.jpg" title="1455539700734093102.jpg" width="667" height="264" style="width: 667px; height: 264px;"></a>
						  		&nbsp;&nbsp;
					  		
						  		<a href="/blog/articles/52.html"><img alt="15203317.jpg" src="${pageContext.request.contextPath}/static/userImages/c.jpg" title="1455539761187019902.jpg"></a>
						  		&nbsp;&nbsp;
					  		
					  	</span>
					  	<span class="info">发表于 2016-02-15 21:06 阅读(71) 评论(5) </span>
	  					
	  				</li>
	  				 <hr style="height:5px;border:none;border-top:1px dashed gray;padding-bottom:  10px;" />
	  				
	  			</ul>
	  		</div>
	  	</div>
	  </div>
	  <div class="col-md-1">&nbsp;</div>
	</div>
	
	<div class="row">
		<div class="col-md-12" >
			<div align="center" style="padding-top: 200px;color: #FFF" >
				<span>Powered by <a  href="#" target="_blank">ETJAVA</a> V1.0&nbsp;&nbsp;&nbsp;&nbsp;</span><br/><br/>
				  Copyright © 2012-2026
			</div>
		</div>
	</div>
</div>
</body>
</html>