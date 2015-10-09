function statusFormatter(value, row) {
	if (value) {
		return "Ativo"
	} else {
		return "Inativo"
	}
}

function operateFormatter(value, row, index) {
	return [
			'<a class="edit ml10" href="javascript:void(0)" title="editar">',
			'<i class="glyphicon glyphicon-edit"></i>',
			'</a>',
			'<a class="remove ml10" href="javascript:void(0)" title="remover">',
			'<i class="glyphicon glyphicon-remove"></i>', '</a>'

	].join('');
}

function operateFormatterPadrao(value, row, index) {
	return [
			'<a class="edit ml10" href="javascript:void(0)" title="Edit">',
			'<i class="glyphicon glyphicon-edit"></i>',
			'</a>',
			'<a class="remove ml10" href="javascript:void(0)" title="Remove" style="margin-left: 10px;">',
			'<i class="glyphicon glyphicon-remove"></i>', '</a>' ].join('');
}

function cpfCnpjFormatter(value, row) {
	return formataCPFOuCNPJ(value);
}
//
//function cpfFormatter(value, row) {
//	var cpf = value;
//	if (cpf != undefined) {
//		if (cpf.length == 11) {
//			return (cpf.substring(0, 3) + "." + cpf.substring(3, 6) + "."
//					+ cpf.substring(6, 9) + "-" + cpf.substring(9, 11));
//		} else
//			return cpf;
//	} else
//		return "";
//}

//function cnpjFormatter(value, row) {
//	var cnpj = value;
//	if (cnpj != undefined) {
//		if (cnpj.length == 14) {
//			return (cnpj.substring(0, 2) + "." + cnpj.substring(2, 5) + "."
//					+ cnpj.substring(5, 8) + "/" + cnpj.substring(8, 12) + "-" + cnpj
//					.substring(12, 14));
//		} else
//			return cnpj;
//	} else
//		return "";
//}

function dataFormatter(value, row) {
	return value.substring(0, 10).replace("-", "/").replace("-", "/");
}

function formataData(value) {
	var data = new Date(value);
	var dia = data.getDate();
	if (dia.toString().length == 1)
		dia = "0" + dia;
	var mes = data.getMonth() + 1;
	if (mes.toString().length == 1)
		mes = "0" + mes;
	var ano = data.getFullYear();
	return dia + "/" + mes + "/" + ano;
}

function formataCPFOuCNPJ(value) {
	if (value.length > 11) {
		var cnpj = value;
		if (cnpj != undefined) {
			if (cnpj.length == 14) {
				return (cnpj.substring(0, 2) + "." + cnpj.substring(2, 5) + "."
						+ cnpj.substring(5, 8) + "/" + cnpj.substring(8, 12)
						+ "-" + cnpj.substring(12, 14));
			} else
				return cnpj;
		} else
			return "";
	} else {
		var cpf = value;
		if (cpf != undefined) {
			if (cpf.length == 11) {
				return (cpf.substring(0, 3) + "." + cpf.substring(3, 6) + "."
						+ cpf.substring(6, 9) + "-" + cpf.substring(9, 11));
			} else
				return cpf;
		} else
			return "";
	}
}

function dataConverterFormatter(value, row) {
	return formataData(value);
}
function moneyFormatter(value, row) {
	return "R$" + moeda(value, 2, ',', '.');
}

function moeda(valor, casas, separdor_decimal, separador_milhar) {

	var valor_total = parseInt(valor * (Math.pow(10, casas)));
	var inteiros = parseInt(parseInt(valor * (Math.pow(10, casas)))
			/ parseFloat(Math.pow(10, casas)));
	var centavos = parseInt(parseInt(valor * (Math.pow(10, casas)))
			% parseFloat(Math.pow(10, casas)));

	if (centavos % 10 == 0 && centavos + "".length < 2) {
		centavos = centavos + "0";
	} else if (centavos < 10) {
		centavos = "0" + centavos;
	}

	var milhares = parseInt(inteiros / 1000);
	inteiros = inteiros % 1000;

	var retorno = "";

	if (milhares > 0) {
		retorno = milhares + "" + separador_milhar + "" + retorno
		if (inteiros == 0) {
			inteiros = "000";
		} else if (inteiros < 10) {
			inteiros = "00" + inteiros;
		} else if (inteiros < 100) {
			inteiros = "0" + inteiros;
		}
	}
	retorno += inteiros + "" + separdor_decimal + "" + centavos;

	return retorno;
}
