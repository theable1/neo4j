$(document).ready(function () {
    $('label').on('click', function () {
        $('.event_year>li').removeClass('current');
        $(this).parent('li').addClass('current');
        var year = $(this).attr('for');
        $('#' + year).parent().prevAll('div').slideUp(800);
        $('#' + year).parent().slideDown(800).nextAll('div').slideDown(800);
    });

    var searchVO = {
        startTime: new Date(2019, 11 - 1, 13),
        endTime: new Date(2019, 12 - 1, 13),
        similarFeatureId: 5453
    };

    $.ajax({
        type: 'post',
        dataType: 'json',
        contentType: "application/json;charset=utf-8",
        url: '/neo4j/search',
        data: JSON.stringify(searchVO),
        success: function (data) {
            var years = [];
            for (var i = data.length - 1; i >= 0; i--) {
                var date = data[i].date;
                var year = date.split("-")[0];

                var flag = true;
                for (var j = 0; j < years.length; j++) {
                    if (years[j] == year) {
                        flag = false;
                        break;
                    }
                }
                if (flag) {
                    years.push(year);
                }
            }

            for (var i = 0; i < years.length; i++) {
                if (i === 0) {
                    $('.current').append('<label for="' + years[i] + '">' + years[i] + '</label>');
                } else {
                    $('.event_year').append('<li><label for="' + years[i] + '">' + years[i] + '</label></li>')
                }
                $('.event_list').append(
                    '<div>' +
                    '<h3 id="' + years[i] + '">' + years[i] + '</h3>' +
                    '</div>'
                );
            }

            for (var i = data.length - 1; i >= 0; i--) {
                var images = data[i].imageUrlList;
                var date = data[i].date;
                var year = date.split("-")[0];
                var month = date.split("-")[1];
                var day = date.split("-")[2];

                var div = $('#' + year).parent();
                div.append('<li id="' + year + month + day + '"><span>' + month + '月' + day + '日</span></li>');

                var el = $('#' + year + month + day);
                for (var j = 0; j < images.length; j++) {
                    el.append(
                        '<div>' +
                        '<img src="' + images[j] + '">'+
                        '</div>'
                    );
                }
            }

        },
        error: function () {
        }
    });

});
