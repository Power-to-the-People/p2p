<%@tag import="java.text.spi.DateFormatSymbolsProvider"%>
<%@tag import="java.text.DateFormatSymbols"%>
<%@tag import="java.util.Date"%>
<%@tag 
  import="nz.org.p2p.model.event.EventManager"
  import="nz.org.p2p.model.event.Event" 
  import="java.util.Calendar"
  import="java.text.DataFormatSymbols"
  import="java.text.DataFormatSymbolsProvider"
%>
<%@attribute name="events" type="nz.org.p2p.model.event.EventManager" %>
 <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
 <%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<c:choose>
	<c:when test="${empty request.parameters.year}">
		<jsp:useBean id="thisYear" type="java.lang.Integer"/>
		<jsp:useBean id="now" type="java.util.Calendar"/>
		<c:set var="now" value="<%=Calendar.getInstance() %>"/>
		<c:set var="thisYear" value="<%= now.get(java.util.Calendar.YEAR) %>"/>
		<c:set var="thisMonth" value="<%= now.get(java.util.Calendar.MONTH) %>"/>
		<c:set var="visibleEvents" value="${events.activeInYear(thisYear) }"/>
	</c:when>
	<c:otherwise> 
	    <c:set var="thisYear" value="<%=Integer.parseInt(request.getParameter("yr"))%>"/>
	    <c:set var="thisMonth" value="<%=Integer.parseInt(request.getParameter("mn"))%>"/>
		<c:set var="visibleEvents" value="${events.activeInMonth(request.year, request.month) }"/>
	</c:otherwise>
</c:choose>
		<div class='b82_tabs'>
<c:forEach begin="0" end="11" var="mon">
	<c:choose>
		<c:when test="${mon == thisMonth && thisYear == events.yearForMonth(mon) }">

	<c:set var="dateFmtSyms" value="<%= new DateFormatSymbols(request.getLocale()) %>"/>
			<a class='b82_tabs__tab m30_darkBlue' href='${"/events?yr=" + year +"&mn="+mon}'>${dateFmtSyms.months[mon]}</a>

		</c:when>
	</c:choose>
</c:forEach>
		</div>
<c:choose>
	<c:when test="events.empty">
<div class='b83_event__noEvents'>No events for this month <a href='/contact'>submit events</a>.</div>	
	</c:when>	
	<c:otherwise>
		<div>
		<c:forEach var="event" items="${events.eventsInMonth(year,month)}">

<div class='b83_event'>		
	<h3 class='b83_event__name'>${event.eventName}</h3>
	<span class='b83_event__date'>" + <fmt:formatDate value="${event.date }" pattern="d"/>, ${event.location}</span>
	<div class='b83_event__description'>" + ${events.getDescription(event)} }</div>
			<c:if test="${not empty event.link }">

	<div class='b83_event__links'>
		<a class='b83_event__links__link' href='${event.link}' target='blank'>${event.link}</a>
	</div>
			</c:if>
		
</div>	
		</c:forEach>
</div>		

	</c:otherwise>
</c:choose>