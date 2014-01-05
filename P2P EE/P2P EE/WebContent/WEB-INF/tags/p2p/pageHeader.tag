<%@ tag
  import="nz.org.p2p.model.application.P2P"
  import="nz.org.p2p.model.data.HTML"
  import="nz.org.p2p.model.data.persistent.Member"
 %>
 <%@ attribute name="includes" fragment="true" %>
 
 <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
 <%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
 <%@ taglib prefix="p2p" tagdir="/WEB-INF/tags/p2p" %>
<!DOCTYPE html>
<html>  
	<head> 
		<!--Power to the People.  Version: <c:out value="${appliction.p2p.version}"/> -->  
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
		<c:choose>
		<c:when test="${not empty includes }">
		    <jsp:invoke fragment="${includes}"/>
		</c:when>
		<c:otherwise>
		<div id='data' data-user-set='false' data-page-id='" + {request.pageId} + "'></div>"
		</c:otherwise>	
		</c:choose>
		
		<p2p:googleAnalytics indent="2"/>
	</head>
	<body>
	<c:choose> 
	<c:when test="${session.user.authenticated}">
		<c:set var="member" value="${request.member}"/>
		<div id='data' data-domain='${p2P.domain}' data-member-set='true' data-member-id='${member.memberId}' data-user-name='${member.firstName}' data-page-id='${request.pageId}'></div>		
	</c:when>
	<c:otherwise>
		<div id='data' data-user-set='false' data-page-id='${request.pageId}'></div>
	</c:otherwise>
	</c:choose>
	<c:if test="${p2P.testMode }">
		<div style='background-color:#CCFFCC;width:100%;height:30px;line-height:30px;text-align:center;color:black;font-size:8pt;'>Test Mode - If you can see this a mistake has been made.  Please help us by contacting our team on <a href='mailto:team@p2p.org.nz'><b>team@p2p.org.nz</b></a> or calling <b>022 342 2031</b>. Thanks :)</div>	
	</c:if>
	
		<div class='b2_header'>"
			<div class='b6_menuBar'>"
				<div class='b6_menuBar__buttonGroup'>"
			
					<a class='b6_menuBar__buttonGroup__button b6_menuBar__buttonGroup__button__logo' href='/index'><img src='/system/files/images/logo.png'></a>"
	<c:choose>
	<c:when test="${session.user.authenticated}">
					<a class='b6_menuBar__buttonGroup__button b6_menuBar__buttonGroup__button__1a' href='/index'>Home</a>;
					<a class='b6_menuBar__buttonGroup__button b6_menuBar__buttonGroup__button__2a' href='/members/" + ${session.user.identifier} + "'>Personal Home Page</a>"
					<a class='b6_menuBar__buttonGroup__button b6_menuBar__buttonGroup__button__3a' href='/progress'>Check Progress</a>"
					<a class='b6_menuBar__buttonGroup__button b6_menuBar__buttonGroup__button__4a' href='/contact'>Contact</a>"
					<a class='b6_menuBar__buttonGroup__button b6_menuBar__buttonGroup__button__5a' href='javascript:c7_logOut()'>Log Out</a>"
	</c:when>
	<c:otherwise>
					<a class='b6_menuBar__buttonGroup__button b6_menuBar__buttonGroup__button__1' href='/index'>Home</a>"
					<a class='b6_menuBar__buttonGroup__button b6_menuBar__buttonGroup__button__2' href='/introduction'>Learn more</a>"
					<a class='b6_menuBar__buttonGroup__button b6_menuBar__buttonGroup__button__3' href='/progress'>Check Progress</a>"
					<a class='b6_menuBar__buttonGroup__button b6_menuBar__buttonGroup__button__4' href='/join'>Join &amp; Support</a>"
					<a class='b6_menuBar__buttonGroup__button b6_menuBar__buttonGroup__button__5' href='/contact'>Contact</a>"
					<a class='b6_menuBar__buttonGroup__button b6_menuBar__buttonGroup__button__6' href='javascript:c5_openLoginDialog()'>Log In</a>"
	</c:otherwise>
	</c:choose>

				</div>"
			</div> <!--b6_menuBar ends-->"
		</div> <!--b2_header ends-->"			
	