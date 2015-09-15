$('#loader').spin('large', '#337ab7');
$.ajaxSetup({ cache: false, timeout: 10000});
$(document).ready(function() {
    $('.carousel').bcSwipe({
        threshold: 50
    });
    /* 			$('#speaker1').load('views/speaker1.html');
    	 $('#speaker2').load('views/speaker2.html');
    	 $('#speaker3').load('views/speaker3.html'); */

   setTimeout(function(){$.get('views/speakerTemplate.html', function(template) {
        $.get('data/speakers.json', function(speakers) {
            $.each(speakers, function(index, speaker) {
                speaker.id = "speaker" + index;
                if (index === 0) {
                    speaker.itemClass = "item active";
                    $('.carousel-indicators').append('<li data-target="#carousel-speakers" data-slide-to="0" class="active"></li>');
                } else {
                    speaker.itemClass = "item";
                    $('.carousel-indicators').append('<li data-target="#carousel-speakers" data-slide-to="' + index + '"></li>');
                }
                /*console.log("value:" + JSON.stringify(value)); */
                var item = $.tmpl(template, speaker);
                item.appendTo('.carousel-inner');
            });
        }).fail(function() {
			alert("加载失败！");
		}).always(function() {
			$('#loader').spin(false);
		});
    }).fail(function() {
    	$('#loader').spin(false);
		alert("加载失败！");
	})},500);
});