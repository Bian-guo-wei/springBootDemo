/**
 * Created by 张浩 on 2018/7/3.
 */
$(function () {
    // var $book = $('.books_one'),
    //     $firstTitle = $('.first_title');
    // $book.on('click', function () {
    //     $('#primary_title').removeClass('active_tab');
    //     $(this).addClass('active_tab').siblings('.books_one').removeClass('active_tab');
    // });
    // $firstTitle.on('click', function () {
    //     $(this).addClass('active_tab').siblings('.first_title').removeClass('active_tab');
    // });
    // $('#primary_title').on('click', function () {
    //     $book.removeClass('active_tab');
    //     $('#donation').hide();
    //     $('#exchange').hide();
    //     $('#reading-thoughts').hide();
    //     $('#exchange-list').show();
    // });
    //
    // $('#reading-tab').on('click', function () {
    //     $('#reading-thoughts').show();
    //     $('#donation').hide();
    //     $('#exchange').hide();
    //     $('#exchange-list').hide();
    // });
    //
    // $('#donation-tab').on('click', function () {
    //     $('#donation').show();
    //     $('#exchange').hide();
    //     $('#reading-thoughts').hide();
    //     $('#exchange-list').hide();
    // });
    // $('#exchange-tab').on('click', function () {
    //     $('#donation').hide();
    //     $('#exchange').show();
    //     $('#reading-thoughts').hide();
    //     $('#exchange-list').hide();
    // });

    // $('#physical_book').on('click', function () {
    //     $('.tip').text('实体书交换地址:');
    //     $('#mail_address').text("交换地址")
    // });
    // $('#ele_book').on('click', function () {
    //     $('.tip').text('电子书交换邮箱:');
    //     $('#mail_address').text("交换邮箱")
    // });
//        阅读感悟弹框
    $('.look_over').each(function (i) {
        $(this).on('click', function () {
            $('.reading_hidden').eq(i).show();
            $('body').css('overflow', 'hidden');
        })
    })


    $('.back').each(function (i) {
        $(this).on('click', function () {
            $('.reading_hidden').eq(i).hide();
            $('body').css('overflow', 'auto');
        });
    })
})