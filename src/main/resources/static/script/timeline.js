$(document).ready(function () {
    $('label').on('click',function () {
        $('.event_year>li').removeClass('current');
        $(this).parent('li').addClass('current');
        var year = $(this).attr('for');
        $('#' + year).parent().prevAll('div').slideUp(800);
        $('#' + year).parent().slideDown(800).nextAll('div').slideDown(800);
    });

    var searchVO = {
        startTime: 2019-11-12,
        endTime: 2019-12-13
    };

    $.ajax({
        type: 'post',
        dataType: 'json',
        contentType: "application/json;charset=utf-8",
        url: '/neo4j/search',
        data: JSON.stringify(searchVO),
        success: function (data) {
            console.log(data);
        },
        error: function () {
        }
    });

});
