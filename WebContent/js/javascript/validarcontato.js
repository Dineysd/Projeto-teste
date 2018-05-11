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

	if (!validarPreenchimento("ddd")) {
		mensagem += "Preencha o campo do DDD  \n ";
	}

	if (!validarPreenchimento("telefone")) {
		mensagem += "Preencha o campo do telefone  \n ";
	}

	// se a mensagem for diferente de vazio mostrar alerta senão enviar o
	// formulário
	if (mensagem != "") {
		window.alert(mensagem);
	} else {
		$("form2").submit();
	}
}

window.onload = function() {
	$("enviar2").onclick = function() {
		validarForm2();
	}
}