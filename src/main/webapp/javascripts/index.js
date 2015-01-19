$(document).ready(function() {
    
    function sendAjax() {
        var htmlStr = "";
		console.log("Trying to send ajax request!!!");
		var date = $("#date").val();
		console.log("date: " + date);
		var protocolHost =  window.location.protocol + "//" + window.location.host;
		$.ajax({
	        type : 'GET',
			url : protocolHost+"/SpringMVC/rest/movies/"+ date,
			dataType : 'json',
			async : true,
			success : function(results) {
			    $('#movies').text("");
				$.each(results, function(index,movie) {
			        htmlStr += movie.id + ' '+ movie.name + ' '+ movie.producer+ '<br />';
					$("#movies").html(htmlStr);
				});
			},
			error : function(jqXHR, textStatus,errorThrown) {
			    alert("Ouch we have error while sending ajax");
			}
		});
    }

    $("#button").click(function() {
    	var htmlStr = "";
        var date = $("#date").val();
		var regex = /^\d{4}[\/\-](0?[1-9]|1[012])[\/\-](0?[1-9]|[12][0-9]|3[01])$/;
		if (date.match(regex) && date.indexOf("/") > -1 == false) {
			sendAjax();
		} else {
			htmlStr += "Date format is not correct!";
			$("#movies").html(htmlStr);
	    }
	});

});