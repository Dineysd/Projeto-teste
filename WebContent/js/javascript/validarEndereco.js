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
		contErro += 1;
	}

	if (!validarPreenchimento("numero")) {
		mensagem += "Preencha o campo do numero  \n ";
		contErro += 1;
	}

	if (!validarPreenchimento("bairro")) {
		mensagem += "Preencha o campo do Bairro  \n ";
		contErro += 1;
	}
	
	
	if (!validarPreenchimento("cidade")) {
		mensagem += "Preencha o campo da cidade  \n ";
		contErro += 1;
	}

	if (!validarPreenchimento("cep")) {
		mensagem += "Preencha o campo do CEP  \n ";
		contErro += 1;
	}
	// se a mensagem for diferente de vazio mostrar alerta senão enviar o
	// formulário
	if (mensagem != "" && contErro > 0) {
		window.alert(mensagem);

		return false;
	} else {
		$("form3").submit();
	}
}

window.onload = function() {
	$("enviar3").onclick = function() {
		validarForm3();
	}
}