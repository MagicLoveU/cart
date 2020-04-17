<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" import="java.util.*" isELIgnored="false"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<c:if test="${!empty user}">
	<div align="center">当前用户: ${user.name}</div>
</c:if>

<table align='center' border='1' cellspacing='0'>
	<tr>
		<td>id</td>
		<td>名称</td>
		<td>价格</td>
		<td>购买</td>
		<td></td>
	</tr>
	<c:forEach items="${products}" var="product" varStatus="st">
		<tr>
			<td>${product.id}</td>
			<td>${product.name}</td>
			<td>${product.price}</td>
			<td>数量 <input pid="${product.id}" type="text" value="1"
				name="num" class="number"></td>
			<td><input type="submit" value="加入购物车" class="cart"
				pid="${product.id}"></td>
		</tr>
	</c:forEach>
</table>

<div style="text-align: center">
	<a href="/cart/listOrderItem">点击进入购物车</a>
</div>
<script src="https://how2j.cn/study/jquery.min.js"></script>
<script>
	$(function() {
		$(".cart").click(function() {
			var pid = $(this).attr("pid");
			var num = $("input.number[pid=" + pid + "]").val();
			$.ajax({
				url : '/cart/addOrderItem',
				type : 'post',
				data : {
					"pid" : pid,
					"num" : num
				},
				success : function() {
					alert("加入购物车成功");
				}
			});
		})
	})
</script>