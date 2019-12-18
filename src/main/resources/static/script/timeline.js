$(document).ready(function () {
    var searchVO = {
        startTime: new Date(2017, 11 - 1, 13),
        endTime: new Date(2019, 12 - 1, 13),
        similarFeatureId: 1575428623072495000
    };

    $.ajax({
        type: 'post',
        dataType: 'json',
        contentType: "application/json;charset=utf-8",
        url: '/neo4j/search',
        // data: JSON.stringify(searchVO),
        success: function (data) {
            layui.use('laypage', function () {
                var laypage = layui.laypage;
                //执行一个laypage实例
                laypage.render({
                    elem: 'test1' //注意，这里的 test1 是 ID，不用加 # 号
                    , count: data.length //数据总数，从服务端得到
                    , prev: '上一个人'
                    , next: '下一个人'
                    , jump: function (obj, first) {

                        //obj包含了当前分页的所有参数，比如：
                        var page = obj.curr;//得到当前页
                        var person = data[page - 1];

                        var years = [];
                        for (var i = person.length - 1; i >= 0; i--) {
                            var date = person[i].date;
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

                        for (var i = person.length - 1; i >= 0; i--) {
                            var images = person[i].imageUrlList;
                            var date = person[i].date;
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
                        });
                    }
                })
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

})
;
