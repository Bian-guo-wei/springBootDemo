$(document).ready(function () {
    var $windowH = window.innerHeight,
        $headH = $('#header').outerHeight(),
        $footH = $('#footer').height();
    var $menuW = $('.navigation_menu').width(),
        $bodyW = $('body').width();
    if ($('.main_content').height() < ($windowH - $headH - $footH)) {
        $('#navigation_menu').height(($windowH - $headH - $footH) + 'px');
    }

    $('.main_content').width(($bodyW - 165) + 'px');
//            $('.main_content').height(($windowH-$headH-$footH)+'px');
});