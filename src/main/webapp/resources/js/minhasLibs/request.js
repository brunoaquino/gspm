function call(url, data) {
	return $.ajax({
		type : 'POST',
		url : url,
		data : data,
		dataType : 'json',
		async : false
	});
}

function trataMensagemDeErro(msg) {
	var mensagem;
	try{
		mensagem = JSON.parse(msg.responseText);
		
		if (msg.responseText != undefined) {
			alert(mensagem.mensagemDeErro);
			return;
		}
		
	}catch(err){
		if(msg.status==400){
			alert("Servidor não encontrado");
			return;
		}
		if(msg.status==200){
			return;
		}
	}
	
}
