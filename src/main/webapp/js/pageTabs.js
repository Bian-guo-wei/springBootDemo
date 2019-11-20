function pageInit(total, page) {
    var pages = [];

    function createPage(index) {//单页码生成
        if (page == index) {
            pages.push('<li>[<span>' + page + '</span>]</li>');
        } else {
            pages.push('<li>[<span>' + index + '</span>]</li>');
        }
    }

    if (total <= 10) {
        for (var i = 1; i <= total; i++) {
            createPage(i);
        }
    } else {
        if (page <= 5) {//总页数大于10且当前页远离总页数(小于5)
            for (var i = 1; i <= 5; i++) {
                createPage(i);
            }
            pages.push(' … <li>[<span>' + total + '</span>]</li>');
        } else if (page >= total - 3) {//总页数大于10且当前页接近总页数(小于总页数-3)
            pages.push('<li>[<span>' + 1 + '</span>]</li> …');
            for (var i = total - 4; i <= total; i++) {
                createPage(i);
            }
        } else { //除开上面两个情况
            pages.push('<li>[<span>' + 1 + '</span>]</li> … ');
            for (var i = page - 2; i <= page + 2; i++) {
                createPage(i);
            }
            pages.push(' … <li>[<span>' + total + '</span>]</li>');
        }
    }
    $('#pages_list').find('li:first-child').addClass('active_li');
    $('#pages_list').html(pages.join(" "));
    var $li = $('.pages_list').find('li');
    $li.on('click', function () {
        var _text = $(this).find("span").text();
        $(this).addClass('active_li').siblings().removeClass('active_li');
        _nowIndex = _text;
        skippage(_nowIndex);
    });

}

function toPage(_total, _nowPage) {
    var $li = $('.pages_list').find('li');
    if (_nowPage <= 5) {
        $li.eq(_nowPage - 1).addClass('active_li').siblings().removeClass('active_li');
    } else if (_nowPage > 5 && _nowPage < (_total - 3)) {
        $li.eq(3).addClass('active_li').siblings().removeClass('active_li');
    } else if (_nowPage >= (_total - 3)) {
        $li.eq(5 - (_total - _nowPage)).addClass('active_li').siblings().removeClass('active_li');
    }
}