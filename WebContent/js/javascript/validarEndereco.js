function $(id) {
	return document.getElementById(id);
}

// verifica se o campo foi preenchido
function validarPreenchimento(id) {
	if ($(id).value == "") {
		return false;
	} else {
		return true;
	}
}

function validarForm3() {
	
	
	var mensagem = "";
	var contErro = 0;

	if (!validarPreenchimento("logradouro")) {
		mensagem += "Preencha o campo do Logradouro  \n ";
		contErro++;
	}

	if (!validarPreenchimento("numero")) {
		mensagem += "Preencha o campo do numero  \n ";
		contErro++;
	}
	
	if (!validarPreenchimento("bairro")) {
		mensagem += "Preencha o campo do Bairro  \n ";
		contErro++;
	}

	if (!validarPreenchimento("cep")) {
		mensagem += "Preencha o campo do Cep  \n ";
		contErro++;
	}

	// se a mensagem for diferente de vazio mostrar alerta senão enviar o
	// formulário
	if (mensagem != "" && contErro > 0) {
		window.alert(mensagem);
		return erro;
		
	} else {
		$("form3").submit();
	}
}

window.onload = function() {
	$("enviar3").onclick = function() {
		validarForm3();
	}
}