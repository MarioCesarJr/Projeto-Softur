$(document).ready(function() {
	$(function() {
		$(".telefone").mask("(99) 9999-9999");
		$(".form\\:telefone").mask("(99) 9999-9999");
		$(".cep").mask("99999-999");
		$(".data").mask("99/99/9999");
		$(".cpf").mask("999.999.999-99");
		$(".cnpj").mask("99.999.999/9999-99");
		$(".hora").mask("99:99");
	});
});

$('.salario').priceFormat({
	prefix : ' ',
	centsSeparator : ',',
	thousandsSeparator : '.'
});