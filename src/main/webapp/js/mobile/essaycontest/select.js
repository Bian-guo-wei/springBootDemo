/**
 * Created by 张浩 on 2018/7/24.
 */

$(function () {
    $('.select_one').on('click', function () {
        $(this).find('img').attr('src', '../../../images/essaycontest/check_active.png');
        $(this).siblings().find('img').attr('src', '../../../images/essaycontest/check.png');
    })
})