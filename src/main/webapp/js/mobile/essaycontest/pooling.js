/**
 * Created by 张浩 on 2018/6/20.
 */
$(function () {
    initCur();
    initTree();
    resize();
    $(window).resize(function () {
        resize();
    })
})

function initCur() {
    $(".navigation_menu ul li a").on("click", function () {
        $(this).addClass("active").parent("li").siblings().find("a").removeClass("active");
    });
}

function initTree() {
    $("#navigation_menu .tit").each(function (i) {
        $(this).bind("click", function () {
            if ($(this).next().is(":hidden")) {
                $(this).parent().find("ul").hide();
                $(this).next().show();
            } else {
                $(this).next().hide();
            }
        });
    });
}

function resize() {
    var $windowH = window.innerHeight,
        $headH = $('#header').outerHeight(),
        $footH = $('#footer').height();
    var $menuW = $('.navigation_menu').width(),
        $bodyW = $('body').width();
    $('#navigation_menu').height(($windowH - $headH - $footH) + 'px');
    $('.main_content').width(($bodyW - 165) + 'px');
}