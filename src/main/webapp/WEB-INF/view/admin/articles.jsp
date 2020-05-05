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
		<div class="form-inline">
			<div class="form-group">
				<label for="title">标题</label> <input class="form-control" id="title"
					type="text" name="title" value="${article.title}">
			</div>

			<div class="form-check">
				<input class="form-check-input" type="radio" name="status"
					id="status0" value="0" ${article.status==0?"checked":"" }> <label class="form-check-label"
					for="status0"> 待审 </label>
			</div>
			<div class="form-check">
				<input class="form-check-input" type="radio" name="status"
					id="status1" value="1" ${article.status==1?"checked":"" }> <label class="form-check-label"
					for="status1"> 已审 </label>
			</div>
			<div class="form-check">
				<input class="form-check-input" type="radio" name="status"
					id="status-1" value="-1" ${article.status==-1?"checked":"" }> <label class="form-check-label"
					for="status-1"> 驳回 </label>
			</div>
			<div>
				<button class="btn btn-info" type="button" onclick="query()">查询</button>
			</div>

		</div>
		<div class="mt-1">
			<table class="table table-hover table-bordered text-center">
				<tr>
					<td>序号</td>
					<td>标题</td>
					<td>栏目</td>
					<td>分类</td>
					<td>作者</td>
					<td>发布时间</td>
					<td>审核状态</td>
					<td>是否热门</td>
				</tr>

				<c:forEach items="${info.list}" var="article" varStatus="i">

					<tr>
						<td>${i.count }</td>
						<td width="350px">${article.title }</td>
						<td>${article.channel.name }</td>
						<td>${article.category.name }</td>
						<td>${article.user.username }</td>
						<td><fmt:formatDate value="${article.created}"
								pattern="yyyy-MM-dd HH:mm:ss" /></td>
						<td>${article.status==0?"待审":article.status==1?"已审":"驳回"}</td>
						<td><c:if test="${article.hot==0}">

								<button class="btn btn-info btn-sm">否</button>
							</c:if> <c:if test="${article.hot==1}">

								<button class="btn btn-danger btn-sm">是</button>
							</c:if></td>
					</tr>
				</c:forEach>
				<tr>
					<td colspan="10"><jsp:include
							page="/WEB-INF/view/common/pages.jsp"></jsp:include></td>
				</tr>
			</table>
		</div>
	</div>
</body>
<script type="text/javascript">
//条件查询
function query(){
	var title=$("[name='title']").val();
	var status=$("[name='status']:checked").val();
	$("#center").load("/admin/articles?title="+title+"&status="+status);
	
}

</script>
</html>
