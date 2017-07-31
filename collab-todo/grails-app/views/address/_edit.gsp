<%@ page import="collab.todo.Address"%>

<div id="edit-address" class="content scaffold-edit" role="main">
	
	<g:render template="message" />
	
	<div id="addressResponse"></div>
	
	<g:form action="save">
		<fieldset class="form">
			<g:render template="form" />
		</fieldset>
		<fieldset class="buttons">			
			<g:submitToRemote value="Update" url="[action: 'updateCurrent']" update="addressResponse" />
		</fieldset>
	</g:form>
	
</div>
