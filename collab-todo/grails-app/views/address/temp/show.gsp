
<%@ page import="collab.todo.Address" %>
<!DOCTYPE html>
<html>
	<head>
		<meta name="layout" content="main">
		<g:set var="entityName" value="${message(code: 'address.label', default: 'Address')}" />
		<title><g:message code="default.show.label" args="[entityName]" /></title>
	</head>
	<body>
		<a href="#show-address" class="skip" tabindex="-1"><g:message code="default.link.skip.label" default="Skip to content&hellip;"/></a>
		<div class="nav" role="navigation">
			<ul>
				<li><a class="home" href="${createLink(uri: '/')}"><g:message code="default.home.label"/></a></li>
				<li><g:link class="list" action="list"><g:message code="default.list.label" args="[entityName]" /></g:link></li>
				<li><g:link class="create" action="create"><g:message code="default.new.label" args="[entityName]" /></g:link></li>
			</ul>
		</div>
		<div id="show-address" class="content scaffold-show" role="main">
			<h1><g:message code="default.show.label" args="[entityName]" /></h1>
			<g:if test="${flash.message}">
			<div class="message" role="status">${flash.message}</div>
			</g:if>
			<ol class="property-list address">
			
				<g:if test="${addressInstance?.addressLine1}">
				<li class="fieldcontain">
					<span id="addressLine1-label" class="property-label"><g:message code="address.addressLine1.label" default="Address Line1" /></span>
					
						<span class="property-value" aria-labelledby="addressLine1-label"><g:fieldValue bean="${addressInstance}" field="addressLine1"/></span>
					
				</li>
				</g:if>
			
				<g:if test="${addressInstance?.addressLine2}">
				<li class="fieldcontain">
					<span id="addressLine2-label" class="property-label"><g:message code="address.addressLine2.label" default="Address Line2" /></span>
					
						<span class="property-value" aria-labelledby="addressLine2-label"><g:fieldValue bean="${addressInstance}" field="addressLine2"/></span>
					
				</li>
				</g:if>
			
				<g:if test="${addressInstance?.county}">
				<li class="fieldcontain">
					<span id="county-label" class="property-label"><g:message code="address.county.label" default="County" /></span>
					
						<span class="property-value" aria-labelledby="county-label"><g:fieldValue bean="${addressInstance}" field="county"/></span>
					
				</li>
				</g:if>
			
				<g:if test="${addressInstance?.houseNumber}">
				<li class="fieldcontain">
					<span id="houseNumber-label" class="property-label"><g:message code="address.houseNumber.label" default="House Number" /></span>
					
						<span class="property-value" aria-labelledby="houseNumber-label"><g:fieldValue bean="${addressInstance}" field="houseNumber"/></span>
					
				</li>
				</g:if>
			
				<g:if test="${addressInstance?.town}">
				<li class="fieldcontain">
					<span id="town-label" class="property-label"><g:message code="address.town.label" default="Town" /></span>
					
						<span class="property-value" aria-labelledby="town-label"><g:fieldValue bean="${addressInstance}" field="town"/></span>
					
				</li>
				</g:if>
			
				<g:if test="${addressInstance?.user}">
				<li class="fieldcontain">
					<span id="user-label" class="property-label"><g:message code="address.user.label" default="User" /></span>
					
						<span class="property-value" aria-labelledby="user-label"><g:link controller="user" action="show" id="${addressInstance?.user?.id}">${addressInstance?.user?.encodeAsHTML()}</g:link></span>
					
				</li>
				</g:if>
			
			</ol>
			<g:form>
				<fieldset class="buttons">
					<g:hiddenField name="id" value="${addressInstance?.id}" />
					<g:link class="edit" action="edit" id="${addressInstance?.id}"><g:message code="default.button.edit.label" default="Edit" /></g:link>
					<g:actionSubmit class="delete" action="delete" value="${message(code: 'default.button.delete.label', default: 'Delete')}" onclick="return confirm('${message(code: 'default.button.delete.confirm.message', default: 'Are you sure?')}');" />
				</fieldset>
			</g:form>
		</div>
	</body>
</html>
