$('#confirmacaoExclusaoModal').on('show.bs.modal', function(event) {
	var button = $(event.relatedTarget);
	
	var idTitulo = button.data('id');
	var descripcionTitulo = button.data('descripcion');
	
	var modal = $(this);
	var form = modal.find('form');
	var action = form.data('url-base');
	if (!action.endsWith('/')) {
		action += '/';
	}
	form.attr('action', action + idTitulo);
	
	modal.find('.modal-body span').html('Esta seguro que desea eliminar el titulo <strong>' + descripcionTitulo + '</strong>?');
});

$(function() {
	$('[rel="tooltip"]').tooltip();
	
	$('.js-atualizar-status').on('click', function(event){
		event.preventDefault();
		var botonRecibir = $(event.currentTarget);
		var urlRecibir = botonRecibir.attr('href');
		
		var response = $.ajax({
			url: urlRecibir,
			type: 'PUT'
		});
		
		response.done(function(e){
			var idTitulo = botonRecibir.data('id');
			$('[data-role=' + idTitulo + ']').html('<span class="label label-success">' + e + '</span>');
			botonRecibir.hide();
		});
		
		response.fail(function(e){
			console.log(e);
			alert('Error al recibir la cobranza');
		});
	});
});



















