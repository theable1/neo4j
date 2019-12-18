$(document).ready(function () {
    var searchVO = {
        startTime: new Date(2017, 11 - 1, 13),
        endTime: new Date(2019, 12 - 1, 13),
        similarFeatureId: 49879
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

            for (var i = years.length - 1; i >= 0; i--) {
                if (i === years.length - 1) {
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
                div.append(
                    '<li>' +
                    '<span>' + month + '月' + day + '日</span>' +
                    '<div>' +
                    '<div class="swiper-container" style="width: 950px;height: 210px">' +
                    '<div class="swiper-wrapper" id="' + year + month + day + '" style="height: 208px">' +
                    '</div>' +
                    // '<div class="swiper-pagination"></div>' +
                    '<div class="swiper-button-prev"></div>' +
                    '<div class="swiper-button-next"></div>' +
                    // '<div class="swiper-scrollbar"></div>'+
                    '</div>' +
                    '</div>' +
                    '</li>'
                );

                var carouselItem = $('#' + year + month + day);
                for (var j = 0; j < images.length; j++) {
                    carouselItem.append(
                        '<div class="swiper-slide">' +
                        '<img src="' + images[j] + '">' +
                        '</div>'
                    );
                }
            }
            var mySwiper = new Swiper('.swiper-container', {
                direction: 'horizontal', // 垂直切换选项
                loop: false, // 循环模式选项
                slidesPerView: 5,
                // slidesPerViewFit: true,
                // 如果需要前进后退按钮
                navigation: {
                    nextEl: '.swiper-button-next',
                    prevEl: '.swiper-button-prev',
                },
            })
        },
        error: function () {
        }
    });

    $('.event_year').on('click', 'label', function () {
        $('.event_year>li').removeClass('current');
        $(this).parent('li').addClass('current');
        var year = $(this).attr('for');
        $('#' + year).parent().prevAll('div').slideUp(800);
        $('#' + year).parent().slideDown(800).nextAll('div').slideDown(800);
    });

});
