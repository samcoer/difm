<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<table align="center" width="100%" cellspacing="0" cellpadding="0">
		<tr>
			<td width="90%">
				<table width="100%" cellpadding="0" cellspacing="0">
					<tr>
						<td>
							<table align="right">
								<tr>
									<td>
										<a href="<%=request.getContextPath()%>/opp/showSearchHome.htm" style="color: white;">
											<font size="2" color="white">
												<b>Search</b>
											</font>
										</a>
									</td>
								</tr>
								<!-- 
								<tr>
									<td bgcolor="#FFE683"><a href="./vsrSearch.htm?id=100070">VSR Push</a>
									</td>
								</tr>
								 -->
							</table>
						</td>
					</tr>
					<tr>
						<td><c:choose>
								<c:when test="${oppFormBean != null}">
									<c:set var="contextForm" value="${oppFormBean}"/>
								</c:when>
								<c:when test="${prodFormBean != null}">
									<c:set var="contextForm" value="${prodFormBean}"/>
								</c:when>
							</c:choose>
							<table width="100%" bgcolor="#FFE683">
								<tr>
									<td><b>PADO ID :</b>&nbsp;${contextForm.opportunity.id}<form:hidden
											path="opportunity.id" /></td>
									<td><b>Customer Name :</b>&nbsp;${contextForm.opportunity.customerName}</td>
									<td><b>Account # :</b>&nbsp;${contextForm.opportunity.account.id}</td>
									<td><b>Description :</b>&nbsp;${contextForm.opportunity.description}</td>
								</tr>
							</table>
						</td>
					</tr>
				</table></td>
		</tr>
	</table>
</body>
</html>