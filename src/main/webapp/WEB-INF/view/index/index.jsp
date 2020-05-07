<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<!-- 视窗 -->
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>今日头条</title>
<link href="/resource/css/bootstrap.min.css" rel="stylesheet">
<link href="/resource/css/index.css" rel="stylesheet">
<script type="text/javascript" src="/resource/js/jquery-3.2.1.js"></script>
<script type="text/javascript" src="/resource/js/bootstrap.min.js"></script>




</head>
<body>
	<div class="container-fluid">
		<!--  head -->
		<div class="row" style="height: 34px">

			<div class="col-md-12 bg-dark">
				<button class="btn btn-link btn-sm">
					<font color="white">下载APP</font>
				</button>
				<button class="btn btn-link btn-sm">
					<font color="white">注册头条号</font>
				</button>
				<div class="float-right">

					<button class="btn btn-link btn-sm">
						<font color="white">侵权投诉</font>
					</button>
					<button class="btn btn-link btn-sm">
						<font color="white">头条产品</font>
					</button>
				</div>
			</div>

		</div>
		<!-- body -->
		<div class="row ml-5 mr-5 mt-2">
			<!-- 左侧菜单 -->
			<div class="col-md-2">
				<div class="channel">

					<ul>
						<li class="mb-2"><a><img alt=""
								src="/resource/images/logo-index.png"
								style="height: 27px; width: 108px"></a></li>
						<li><a href="/"
							class="channel-item ${article.channelId==null?'active':"" }">热点</a></li>
						<!-- 遍历所有栏目 -->
						<c:forEach items="${channels}" var="channel">
							<li><a href="/?channelId=${channel.id}"
								class="channel-item ${article.channelId==channel.id?'active':"" }">${channel.name}</a></li>
						</c:forEach>

					</ul>

				</div>

			</div>
			<!-- 中间内容 -->
			<div class="col-md-7">
			  <!-- 显示热点文章 -->
			  <c:if test="${article.channelId==null }">
			      <div>
						<ul class="list-unstyled">
							<c:forEach items="${info.list}" var="article">
								<li class="media"><img src="/pic/${article.picture}"
									class="mr-3 rounded" alt="..."
									style="height: 101.8px; width: 156px">
									<div class="media-body">
										<h5 class="mt-0 mb-1">${article.title }</h5>
										<p class="mt-4">${article.user.username}·
											0评论 ·
											<fmt:formatDate value="${article.created}"
												pattern="yyyy-MM-dd HH:mm:ss" />
										</p>

									</div></li>
								<hr>
							</c:forEach>

						</ul>
						<jsp:include page="/WEB-INF/view/common/pages.jsp" />
					</div>
			   
			  
			  
			  </c:if>
			
			
			 <!-- 如果栏目不为空则显示栏目及分类下的文章 -->
				<c:if test="${article.channelId!=null }">
					<!-- 显示栏目下的分类 -->
					<div class="subchannel">
						<ul class="sub-list">
							<li class="sub-item ${article.categoryId==null?"sub-selected":"" }"><a
								href="/?channelId=${article.channelId}">全部</a></li>
							<c:forEach items="${categorys}" var="category">
								<li class="sub-item ${article.categoryId==category.id?"sub-selected":"" }""><a
									href="/?channelId=${article.channelId}&categoryId=${category.id}">${category.name }</a></li>
							</c:forEach>

						</ul>
					</div>
					<!-- 显示分类文章 -->
					<div>
						<ul class="list-unstyled">
							<c:forEach items="${info.list}" var="article">
								<li class="media"><img src="/pic/${article.picture}"
									class="mr-3 rounded" alt="..."
									style="height: 101.8px; width: 156px">
									<div class="media-body">
										<h5 class="mt-0 mb-1">${article.title }</h5>
										<p class="mt-4">${article.user.username}·
											0评论 ·
											<fmt:formatDate value="${article.created}"
												pattern="yyyy-MM-dd HH:mm:ss" />
										</p>

									</div></li>
								<hr>
							</c:forEach>

						</ul>
						<jsp:include page="/WEB-INF/view/common/pages.jsp" />
					</div>
				</c:if>


			</div>
			<!-- 右侧边栏 -->
			<div class="col-md-3">右侧边栏</div>
		</div>


	</div>

</body>
<script type="text/javascript">
	function goPage(pageNum) {
		var channelId = '${article.channelId}';//栏目id
		var categoryId = '${article.categoryId}';//分类id
		var url = "/?pageNum=" + pageNum;
		if (channelId > 0)//如果栏目为不空则拼接url
			url += "&channelId=" + channelId;
		if (categoryId > 0)//如果分类为不空则拼接url
			url += "&categoryId=" + categoryId;
		location.href = url;
	}
</script>
</html>
