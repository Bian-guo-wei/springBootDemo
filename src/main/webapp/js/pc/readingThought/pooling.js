/**
 * Created by 张浩 on 2018/6/20.
 */
$(function () {
    initCur();
    initTree();
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