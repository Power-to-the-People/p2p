<%@ tag
  import="nz.org.p2p.model.data.P2P"
  import="nz.org.p2p.model.data.HTML"
  import="nz.org.p2p.model.data.persistent.Member"
 %>
 <%@ attribute name="includes" fragment="true" %>
 
 <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
 <%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html>  
	<head> 
		<!--Power to the People.  Version: <%=P2P.version%> -->  
		<link rel='icon' type='image/png' href='/system/files/images/favicon.png'>
		<link rel='stylesheet' href='/system/files/css/jquery-ui-1.9.2.custom.min.css' />
		<link rel='stylesheet' href='/system/files/css/jquery.bxslider.css' />
		<link rel='stylesheet' href='/system/files/css/fileuploader.css' />
		<link rel='stylesheet' href='/system/files/css/p2p.css' />
		<script src='/system/files/js/jquery-1.9.0.min.js'></script>
		<script src='/system/files/js/jquery-ui-1.9.2.custom.min.js'></script>
		<script src='/system/files/js/fileuploader.js'></script>
		<script src='/system/files/js/jquery.autosize.min.js'></script>
		<script src='/system/files/js/jquery.bxslider.min.js'></script>
		<script src='/system/files/js/highcharts.js'></script>
		<script src='/system/files/js/p2p.js'></script>
		<c:if test="${not empty}">
		    <jsp:invoke fragment="${includes}"/>
		</c:if>	
		<p2p:googleAnalytics indent="2"/>
	</head>
	<body>
	<c:if test="${session.user.isAuthenticated}">
	</c:if>