$(document).ready(function() {
	var tabTemplate = '<li role="presentation" class="${active}"><a href="#${id}" aria-controls="${date}" role="tab" data-toggle="tab">${date}</a></li>';
	$.get('views/agendaTemplate.html', function(template) {
		$.get('data/agenda.json?' + new Date().getTime(), function(agendas) {
			$.each(agendas, function(index, agenda) {
				agenda.id = "agenda" + index;
                if (index === 0) {
                    agenda.active = "active";
                }
//				console.log("agenda:"+JSON.stringify(agenda));
				var page = $.tmpl(template, agenda);
				page.appendTo('#agenda');
				$('#tabs').append($.tmpl(tabTemplate, agenda));
			});

			$('a[data-toggle="tab"]').on('shown.bs.tab', function (e) {
				//The window will scroll to top after user switch to a new tab
				$(window).scrollTop(0);
			});
		}).fail(function() {
			alert("加载失败！");
		}).always(function() {
			$('.ui.loader.active').removeClass('active');
		});
	}).fail(function() {
		$('ui.loader.active').removeClass('active');
		alert("加载失败！");
	});
});