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
<title></title>
<link href="/resource/css/bootstrap.min.css" rel="stylesheet">
<script type="text/javascript" src="/resource/js/jquery-3.2.1.js"></script>
<script type="text/javascript" src="/resource/js/bootstrap.min.js"></script>
</head>
<body>
	<div class="container-fluid">

		<!-- head -->
		<div class="row">
			<div class="col-md-12"
				style="background-color: #563D7C; height: 50px">
				<img alt="" src="/resource/images/logo-my.png" width="50px"
					height="50px"> <font color="white">个人中心</font>
			</div>

		</div>
		<div class="row mt-1">
			<div class="col-md-2 bg-light" style="height: 550px">

				<div class="list-group">
					<a href="#" data="/articles" class="list-group-item list-group-item-action active">
						我的文章 </a> <a href="#" class="list-group-item list-group-item-action">
						发布文章</a> <a href="#" class="list-group-item list-group-item-action">我的收藏</a>
					<a href="#" class="list-group-item list-group-item-action">
						我的评论</a> <a href="#"
						class="list-group-item list-group-item-action disabled"
						tabindex="-1" aria-disabled="true">我的设置</a>
				</div>

			</div>
			 <!-- 中间内容区域 -->
			<div class="col-md-10" id="center"></div>
		</div>
	</div>



</body>
<script type="text/javascript">
//文档就绪函数
 $(function(){
	//1.为左侧菜单添加点击事件
	$("a").click(function(){
		//2/获取A标签的data
		var url =$(this).attr("data");
		//alert(url)
		//3 在中间区域加载url
		$("#center").load(url);
	})
 })


</script>
</html>
