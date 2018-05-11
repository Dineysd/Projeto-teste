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

function validarForm2() {

	var mensagem = "";

	if (!validarPreenchimento("logradouro")) {
		mensagem += "Preencha o campo do Logradouro  \n ";
	}

	if (!validarPreenchimento("numero")) {
		mensagem += "Preencha o campo do numero  \n ";
	}
	
	if (!validarPreenchimento("bairro")) {
		mensagem += "Preencha o campo do Bairro  \n ";
	}

	if (!validarPreenchimento("cep")) {
		mensagem += "Preencha o campo do Cep  \n ";
	}

	// se a mensagem for diferente de vazio mostrar alerta senão enviar o
	// formulário
	if (mensagem != "") {
		window.alert(mensagem);
	} else {
		$("form3").submit();
	}
}

window.onload = function() {
	$("enviar3").onclick = function() {
		validarForm2();
	}
}