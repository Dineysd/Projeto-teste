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
	var contErro = 0;

	if (!validarPreenchimento("ddd")) {
		mensagem += "Preencha o campo do DDD  \n ";
		contErro++;
	}

	if (!validarPreenchimento("telefone")) {
		mensagem += "Preencha o campo do telefone  \n ";
		contErro++;
	}

	// se a mensagem for diferente de vazio mostrar alerta senão enviar o
	// formulário
	if (mensagem != "" && contErro > 0) {
		window.alert(mensagem);
	
		return false; 
	} else {
		$("form2").submit();
	}
}

window.onload = function() {
	$("enviar2").onclick = function() {
		validarForm2();
	}
}