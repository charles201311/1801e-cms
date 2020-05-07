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

<style type="text/css">
ul {
	display: block;
	list-style-type: disc;
	margin-block-start: 1em;
	margin-block-end: 1em;
	margin-inline-start: 0px;
	margin-inline-end: 0px;
	padding-inline-start: 40px;
}
</style>


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

					<ul class="sub-list">
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
				<!-- 显示热点文章 和轮播图-->
				<c:if test="${article.channelId==null }">
					<!-- 广告-轮播图 -->
					<div id="carouselExampleCaptions" class="carousel slide"
						data-ride="carousel">
						<ol class="carousel-indicators">
							<c:forEach items="${slides}" var="slide" varStatus="i">
								<li data-target="#carouselExampleCaptions"
									data-slide-to="${i.index }" class="${i.index==0?'active':''}"></li>
							</c:forEach>

						</ol>
						<div class="carousel-inner">
							<c:forEach items="${slides}" var="slide" varStatus="i">
								<div class="carousel-item ${i.index==0?'active':''}">
									<img style="height: 350px" src="/pic/${slide.picture }"
										class="rounded d-block w-100" alt="...">
									<div class="carousel-caption d-none d-md-block">
										<h5>${slide.title }</h5>
									</div>
								</div>
							</c:forEach>
						</div>
						<a class="carousel-control-prev" href="#carouselExampleCaptions"
							role="button" data-slide="prev"> <span
							class="carousel-control-prev-icon" aria-hidden="true"></span> <span
							class="sr-only">Previous</span>
						</a> <a class="carousel-control-next" href="#carouselExampleCaptions"
							role="button" data-slide="next"> <span
							class="carousel-control-next-icon" aria-hidden="true"></span> <span
							class="sr-only">Next</span>
						</a>
					</div>




					<!-- 热点文章 -->
					<div>
						<ul class="list-unstyled">
							<c:forEach items="${info.list}" var="article">
								<li class="media"><img src="/pic/${article.picture}"
									class="mr-3 rounded" alt="..."
									style="height: 101.8px; width: 156px">
									<div class="media-body">
										<h5 class="mt-0 mb-1">
											<a href="/articleDetail?id=${article.id}" target="_blank">${article.title }</a>
										</h5>
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
										<h5 class="mt-0 mb-1">
											<a href="/articleDetail?id=${article.id}" target="_blank">${article.title }</a>
										</h5>
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
			<div class="col-md-3">
				<div class="card" style="width: 18rem;">
					<div class="card-header"><h5>24小时热文</h5>
					</div>
						<div class="card-body">
							<ul class="list-unstyled">
								<c:forEach items="${hot24Articles.list}" var="hot24Article">
								<li class="media"><img src="/pic/${hot24Article.picture}"
									class="mr-3" alt="..." style="width: 60px; height: 60px">
									<div class="media-body">
										<p>${hot24Article.title }</p>
									</div></li>
									<hr>
									</c:forEach>
							</ul>
						</div>
				</div>
			</div>
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
