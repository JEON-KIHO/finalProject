$(form).submit(function(e) {
		e.preventDefault();
		if($(form.name).val()=="") {
			alert("insert name");
			$(form.name).focus();
		} else if($(form.tel).val()=="") {
			alert("insert tel");
			$(form.tel).focus();
		} else if($(form.address).val()=="") {
			alert("insert address");
			$(form.address).focus();
		} else {
			if(!confirm("save?")) return;
			form.submit();
		}
	});