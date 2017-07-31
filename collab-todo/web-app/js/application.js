if (typeof jQuery !== 'undefined') {
	(function($) {
		$('#spinner').ajaxStart(function() {
			$(this).fadeIn();
		}).ajaxStop(function() {
			$(this).fadeOut();
		});
	})(jQuery);
}

$(document).ready(function() {
	$("#userAddress").on("click", function() {
		var controller = $(this).attr('metaController');
		var action = $(this).attr('metaAction');
		var divName = "userAddressPlaceholder";
		$.ajax({
	        url:'/collab-todo/' + controller + '/' + action,
	        success: function(data){
	        	var div = $("#" + divName);
	        	div.dialog({
	                height: 800,
	                width: 800,
	                modal: true,
	                title: 'Address'
	            });
	        	div.html(data);
	            div.dialog("open");
	            div.dialog("moveToTop");
	        }
	    });
	});
});