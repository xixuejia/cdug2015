$(document).ready(function() {
	$('.carousel').bcSwipe({
		threshold : 50
	});

	var tabTemplate = '<li role="presentation" class="${active}"><a href="#${id}" aria-controls="${date}" role="tab" data-toggle="tab">${date}</a></li>';
	$.get('views/agendaTemplate.html', function(template) {

		$.get('data/agenda.json?' + new Date().getTime(), function(agendas) {
			$.each(agendas, function(index, agenda) {
				agenda.id = "agenda" + index;
                if (index === 0) {
                    agenda.itemClass = "item active";
                    agenda.active = "active";
                } else {
                    agenda.itemClass = "item";
                }
//				console.log("agenda:"+JSON.stringify(agenda));
				agenda.id = "agenda" + index;
				var page = $.tmpl(template, agenda);
				page.appendTo('.carousel-inner');
				$('#tabs').append($.tmpl(tabTemplate, agenda));
			});
		});
	});
});