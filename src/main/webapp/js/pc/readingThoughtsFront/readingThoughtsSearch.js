/**
 * Created by 张浩 on 2018/6/27.
 */
$(function () {

    $('.look_over').on('click', function () {
        $('#reading_hidden').show();
    });
    $('#back').on('click', function () {
        $('#reading_hidden').hide();
    });
    var $li = $('.pages_list').find('li');

})