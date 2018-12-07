<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<c:set var="contextPath" value="${pageContext.request.contextPath}"/>

<!DOCTYPE html PUBLIC '-//W3C//DTD HTML 4.01 Transitional//EN' 'http://www.w3.org/TR/html4/loose.dtd'>
<html>
<head>
<title>Merchant Checkout Page</title>
</head>
<body>
	<center><h1>Please do not refresh this page...</h1></center>
	<form method='post' action='https://securegw.paytm.in/theia/processTransaction' name='f1'>
	<input type='hidden' name='MID' value='${MID}'>
	<input type='hidden' name='ORDER_ID' value='${ORDER_ID}'>
	<input type='hidden' name='CHANNEL_ID' value='${CHANNEL_ID}'>
	<input type='hidden' name='CUST_ID' value='${CUST_ID}'>
	<input type='hidden' name='MOBILE_NO' value='${MOBILE_NO}'>
	<input type='hidden' name='EMAIL' value='${EMAIL}'>
	<input type='hidden' name='TXN_AMOUNT' value='${TXN_AMOUNT}'>
	<input type='hidden' name='WEBSITE' value='${WEBSITE}'>
	<input type='hidden' name='INDUSTRY_TYPE_ID' value='${INDUSTRY_TYPE_ID}'>
	<input type='hidden' name='CALLBACK_URL' value='${CALLBACK_URL}'>
	<input type='hidden' name='CHECKSUMHASH' value='${CHECKSUMHASH}'>
	</form>
	<script type='text/javascript'>
	document.f1.submit();
	</script>
</body>
