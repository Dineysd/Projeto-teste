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

function fctValidaData(obj) {
	var data = obj.value;
	var dia = data.substring(0, 2)
	var mes = data.substring(3, 5)
	var ano = data.substring(6, 10)

	// Criando um objeto Date usando os valores ano, mes e dia.
	var novaData = new Date(ano, (mes - 1), dia);

	var mesmoDia = parseInt(dia, 10) == parseInt(novaData.getDate());
	var mesmoMes = parseInt(mes, 10) == parseInt(novaData.getMonth()) + 1;
	var mesmoAno = parseInt(ano) == parseInt(novaData.getFullYear());

	if (!((mesmoDia) && (mesmoMes) && (mesmoAno))) {

		alert('Data informada é inválida!');
		obj.focus();
		return false;
	}
	return true;
}

// função de validação do formulário
function validarForm() {
	// declaração das variáveis de texto, radios do estado civil e
	// de verificação se o estado foi ou não selecionado
	var mensagem = "";
	var okEstado = false;
	var contErro = 0;

	// verificação de preenchimento e de valores mínimos e máximos do nome
	if (!validarPreenchimento("nome")) {
		mensagem = "O valor do nome e requerido \n ";
		contErro += 1;
	} else {
		if (!validarValorMin("nome", 10)) {
			mensagem += "O valor do nome deve ter no minimo 10 caracteres \n ";
			contErro += 1;

		} else if (!validarValorMax("nome", 80)) {
			mensagem += "O valor do nome deve ter no maximo 80 caracteres \n ";
			contErro += 1;

		}
	}

	if (!validarPreenchimento("cpf")) {
		mensagem += "O valor do CPF e requerido \n ";
		contErro += 1;

	} else {
		if (!validarcpf("cpf")) {
			mensagem += "O CPF deve ser valido \n ";
			contErro += 1;

		}
	}

	if (!validarPreenchimento("datanascimento")) {
		mensagem += "preencha o campo da Data de Nascimento \n ";
		contErro += 1;

	}

	if (!validarPreenchimento("nomemp")) {
		mensagem += "o campo empresa deve ser prenchido";
		contErro += 1;

	} else {
		if (!validarValorMin("nomemp", 10)) {
			mensagem += "O valor do nome deve ter no minimo 10 caracteres \n ";
			contErro += 1;

		} else if (!validarValorMax("nomemp", 50)) {
			mensagem += "O valor do nome deve ter no maximo 50 caracteres \n ";
			contErro += 1;

		}

	}

	if (!validarPreenchimento("cnpj")) {
		mensagem += "Preencha o campo do CNPJ  \n ";
		contErro += 1;

	}

	// se a mensagem for diferente de vazio mostrar alerta senão enviar o
	// formulário
	if (mensagem != "" && contErro > 0) {
		window.alert(mensagem);
		return false;

	} else {
		$("form").submit();
	}

}

window.onload = function() {
	$("enviar").onclick = function() {
		validarForm();
	}
}
