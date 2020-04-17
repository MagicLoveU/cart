<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="java.util.*" isELIgnored="false"%>
 
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt"  prefix='fmt' %>  
 
<h1 align="center" >购物车</h1>
<c:if test="${!empty ois}">
		<tr>
			<td colspan="4" >
			<div style="text-align: center">
				<a href="/cart/createOrder">生成订单</a>
			</div>
			</td>
		</tr>
</c:if>	
<table align='center' border='1' cellspacing='0'>
    <tr>
        <td>商品名称</td>
        <td>单价</td>
        <td>数量</td>
        <td>小计</td>
        <td></td>
    </tr>
 
    <c:forEach items="${ois}" var="oi" varStatus="st">
        <tr>
            <td>${oi.product.name}</td>
            <td>${oi.product.price}</td>
            <td>${oi.num}</td>
            <td><fmt:formatNumber type="number" value="${oi.product.price*oi.num}" maxFractionDigits="2" /></td>
            <td><form action="deleteOrderItem" method="post">
            <input type="hidden" name="pid" value="${oi.product.id}">
            <input type="hidden" name="ois" value="${ois}">
            <input type="submit" value="删除">
            </form></td>
        </tr>
    </c:forEach>
</table>