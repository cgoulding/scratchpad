<%@ page import="collab.todo.Address" %>



<div class="fieldcontain ${hasErrors(bean: addressInstance, field: 'addressLine1', 'error')} ">
	<label for="addressLine1">
		<g:message code="address.addressLine1.label" default="Address Line1" />
		
	</label>
	<g:textField name="addressLine1" value="${addressInstance?.addressLine1}"/>
</div>

<div class="fieldcontain ${hasErrors(bean: addressInstance, field: 'addressLine2', 'error')} ">
	<label for="addressLine2">
		<g:message code="address.addressLine2.label" default="Address Line2" />
		
	</label>
	<g:textField name="addressLine2" value="${addressInstance?.addressLine2}"/>
</div>

<div class="fieldcontain ${hasErrors(bean: addressInstance, field: 'county', 'error')} ">
	<label for="county">
		<g:message code="address.county.label" default="County" />
		
	</label>
	<g:textField name="county" value="${addressInstance?.county}"/>
</div>

<div class="fieldcontain ${hasErrors(bean: addressInstance, field: 'houseNumber', 'error')} required">
	<label for="houseNumber">
		<g:message code="address.houseNumber.label" default="House Number" />
		<span class="required-indicator">*</span>
	</label>
	<g:field name="houseNumber" type="number" value="${addressInstance.houseNumber}" required=""/>
</div>

<div class="fieldcontain ${hasErrors(bean: addressInstance, field: 'town', 'error')} ">
	<label for="town">
		<g:message code="address.town.label" default="Town" />
	</label>
	<g:textField name="town" value="${addressInstance?.town}"/>
</div>

<div class="fieldcontain ${hasErrors(bean: addressInstance, field: 'user', 'error')} required">
	<label for="user">
		<g:message code="address.user.label" default="User" />
		<span class="required-indicator">*</span>
	</label>
<%--	<g:select id="user" name="user.id" from="${collab.todo.User.list()}" optionKey="id" required="" value="${addressInstance?.user?.id}" class="many-to-one"/>--%>
</div>

