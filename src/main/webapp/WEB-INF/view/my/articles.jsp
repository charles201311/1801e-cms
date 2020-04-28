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

	<div class="container">

		<c:forEach items="${info.list}" var="article">

			<div class="media">
				<img src="/resource/images/1.jpg" class="mr-3" alt="..." width="50px" height="50px">
				<div class="media-body">
					<h5 class="mt-0">${article.title }</h5>
				</div>
			</div>
                 <hr>


		</c:forEach>

	</div>


</body>
</html>