/**
 * 依赖 jsDate.js
 */


function startEssay(timeStamp, status, essayId) {
    var essayTime = getJsTimeStampByJavaTimeStamp(timeStamp);
    var curtime = new Date().getTime();
    if (status !== 1 && essayTime > curtime) {
        var url = getAppCurUrl() + "/publicController/startEssay";
        $.ajax({
            url: url,
            type: "POST",
            dataType: 'json',
            data: {
                essayId: essayId
            }, success: function (data) {
                //do nothing
            }
        });
    }
}

function closeEssay(timeStamp, status, essayId) {
    var essayTime = getJsTimeStampByJavaTimeStamp(timeStamp);
    var curtime = new Date().getTime();
    if (status === 1 && curtime > essayTime) {
        var url = getAppCurUrl() + "/publicController/closeEssay";
        $.ajax({
            url: url,
            type: "POST",
            dataType: 'json',
            data: {
                essayId: essayId
            }, success: function (data) {
                //do nothing
            }
        });
    }
}