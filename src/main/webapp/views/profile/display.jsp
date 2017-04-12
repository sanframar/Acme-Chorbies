<%@page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>

<%@taglib prefix="jstl"	uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@taglib prefix="security" uri="http://www.springframework.org/security/tags"%>
<%@taglib prefix="display" uri="http://displaytag.sf.net"%>
<%@taglib prefix="acme" tagdir="/WEB-INF/tags"%>

<div>
	<ul>
		<li>
			<b><spring:message code="profile.name"/>:</b>
			<jstl:out value="${profile.name}" />
		</li>
		
		<li>
			<b><spring:message code="profile.surname"/>:</b>
			<jstl:out value="${profile.surname}"/>
		</li>
		
		<li>
			<b><spring:message code="profile.email"/>:</b>
			<jstl:out value="${email}"/>
		</li>
		
		<li>
			<b><spring:message code="profile.phone" />:</b>
			<jstl:out value="${phone}" />
		</li>
		
		<jstl:if test="${isAdmin==false}">
		
		
		<li>
			<b><spring:message code="profile.picture" />:</b><br/>
			<img src="${profile.picture}" style = "max-width: 200 px; max-height: 200px;"/>
		</li>
			
		<li>
			<b><spring:message code="profile.description" />:</b>
			<jstl:out value="${description}" />
		</li>
		
		<li>	
			<b><spring:message code="profile.relationship" />:</b>
			<jstl:out value="${profile.relationship}" />
		</li>
		
		<%-- <li>	
			<b><spring:message code="profile.birthDate" />:</b>
			<jstl:out value="${profile.birthDate}" />
		</li> --%>
		
		<li>	
			<b><spring:message code="profile.genre" />:</b>
			<jstl:out value="${profile.genre}" />
		</li>
		
		<li>	
			<b><spring:message code="profile.coordinates" />:</b>
			<jstl:out value="${profile.coordinate.city}" />
			
			<jstl:out value="${profile.coordinate.country}" />
			
			<jstl:out value="${profile.coordinate.state}" />
			
			<jstl:out value="${profile.coordinate.province}" />
		</li>
			
		</jstl:if>
		
	</ul>
	
</div>

<security:authorize access="hasRole('CHORBI')">
	<jstl:if test="${sameActor==false}">
	<div>
		<acme:button code="chirp.create" url="chirp/chorbi/create.do?chorbieId=${profile.id}"/>
	</div>
	</jstl:if>
	<jstl:if test="${sameActor==true}">
		<jstl:if test="${profile.creditCard != null}">
			<acme:button code="profile.creditCard.display" url="creditCard/chorbi/display.do"/>
		</jstl:if>
		<jstl:if test="${profile.creditCard == null}">
			<acme:button code="profile.creditCard.create" url="creditCard/chorbi/create.do"/>
		</jstl:if>
	</jstl:if>
</security:authorize>
<%-- 
	<div>
		<a href="chirp/chorbi/forward.do?chirpId=${chirp.id}"><spring:message
				code="chirp.reply" /></a>
	</div>
 --%>

