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

// verifica a quantidade mínima de caracteres de um campo
function validarValorMin(id, tamanho) {
	if ($(id).value.length < tamanho) {
		return false;
	} else {
		return true;
	}
}

// verifica a quantidade máxima de caracteres de um campo
function validarValorMax(id, tamanho) {
	if ($(id).value.length > tamanho) {
		return false;
	} else {
		return true;
	}
}

function validarcpf(id) {
	if ($($(id)).length != 11 || $($(id)) == "00000000000" || $($(id)) == "11111111111"
			|| $(id) == "22222222222" || $(id) == "33333333333"
			|| $(id) == "44444444444" || $(id) == "55555555555"
			|| $(id) == "66666666666" || $(id) == "77777777777"
			|| $(id) == "88888888888" || $(id) == "99999999999")
		return false;
	add = 0;
	for (i = 0; i < 9; i++)
		add += parseInt($(id).charAt(i)) * (10 - i);
	rev = 11 - (add % 11);
	if (rev == 10 || rev == 11)
		rev = 0;
	if (rev != parseInt($(id).charAt(9)))
		return false;
	add = 0;
	for (i = 0; i < 10; i++)
		add += parseInt($(id).charAt(i)) * (11 - i);
	rev = 11 - (add % 11);
	if (rev == 10 || rev == 11)
		rev = 0;
	if (rev != parseInt($(id).charAt(10)))
		return false;
	else
		return true;
}

// função de validação do formulário
function validarForm() {
	// declaração das variáveis de texto, radios do estado civil e
	// de verificação se o estado foi ou não selecionado
	var mensagem = "";
	var okEstado = false;

	// verificação de preenchimento e de valores mínimos e máximos do nome
	if (!validarPreenchimento("nome")) {
		mensagem = "O valor do nome e requerido \n ";
	} else {
		if (!validarValorMin("nome", 10)) {
			mensagem += "O valor do nome deve ter no minimo 10 caracteres \n ";
		} else if (!validarValorMax("nome", 80)) {
			mensagem += "O valor do nome deve ter no maximo 80 caracteres \n ";
		}
	}

	if (!validarPreenchimento("cpf")) {
		mensagem += "O valor do CPF e requerido \n ";
	} else {
		if (!validarcpf("cpf")) {
			mensagem += "O CPF deve ser valido \n ";
		}
	}

	// se a mensagem for diferente de vazio mostrar alerta senão enviar o
	// formulário
	if (mensagem != "") {
		window.alert(mensagem);
	} else {
		$("form").submit();
	}
}

window.onload = function() {
	$("enviar").onclick = function() {
		validarForm();
	}
}