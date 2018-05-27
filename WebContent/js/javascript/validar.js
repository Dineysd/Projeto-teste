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

function validarCpf_Cnpj(id) {
	if ($(id).value.length !== 11) {
		return false;
	} else {
		if ($(id).value.length !== 14) {
			return false;
		} else {
			return true;
		}
	}

}

// ///////////////////////////////////////////////////////////////////////////////////////
function getIdade(id, tamanho) {
	var hoje = new Date();

	var nascimento = new Date($(id).value);

	// Retorna a diferença entre hoje e a data de nascimento em anos.
	var ano = hoje.getFullYear() - nascimento.getFullYear();

	// Retorna a diferença de mês do mês de nascimento para o atual.
	var m = hoje.getMonth() - nascimento.getMonth();

	// Caso ainda não tenha ultrapassado o dia e o mês
	if (m < 0 || (m === 0 && hoje.getDate() < nascimento.getDate())) {
		ano--;
	}

	if (ano < tamanho) {
		return false;
	} else {
		return true;
	}

}

// //////////////////////////////////////////////////////////////////////////////////
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
		if (validarCpf_Cnpj("cpf")) {
			mensagem += "DIGITE NOVAMENTE!, CPF de 11 caracteres ou CNPJ de 14 caracteres \n ";
			contErro += 1;

		}
	}

	if (!validarPreenchimento("datanascimento")) {
		mensagem += "preencha o campo da Data de Nascimento \n ";
		contErro += 1;

	} else {
		if (!getIdade("datanascimento", 18)) {

			mensagem += " Maior de dezoito anos \n ";
			contErro += 1;

		}
	}

	if (!validarPreenchimento("dataemp")) {
		mensagem += "preencha o campo da Data da Empresa \n ";
		contErro += 1;

	} else {
		if (!getIdade("dataemp", 3)) {

			mensagem += " Empresa com mais de 3 anos \n ";
			contErro += 1;
		}
	}

	if (!validarPreenchimento("ddd")) {
		mensagem += "Preencha o campo do DDD  \n ";
		contErro++;
	}

	if (!validarPreenchimento("telefone")) {
		mensagem += "Preencha o campo do telefone  \n ";
		contErro++;
	}

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
		$("form").submit();
	}

}

window.onload = function() {
	$("enviar").onclick = function() {
		validarForm();
	}
}
