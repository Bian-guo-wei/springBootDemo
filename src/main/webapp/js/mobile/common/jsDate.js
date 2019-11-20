/**
 * 将 java 的 timeStamp转换为js date构造函数的字符串
 * @param timeStamp
 * @returns {string}
 */
function javaTimeStamp2jsDateConstructStr(timeStamp) {
    var period = ".";
    var periodIndex;
    if ((periodIndex = timeStamp.indexOf(period)) > 0) {
        var result = timeStamp.substring(0, periodIndex);
        var comma = ",";
        result = result.toString().replace(/-/g, comma).replace(/\s+/g, comma).replace(/:/g, comma);
        console.info("timeStamp = " + timeStamp + ", js date = " + result);
        return result;
    }
}

/**
 *  java 时间戳转换为 js 的 date 类型
 *  @param timeStamp
 */
function javaTimeStamp2jsDate(timeStamp) {
    var dateStr = javaTimeStamp2jsDateConstructStr(timeStamp);
    var dateArr = dateStr.split(",");
    //FIXME:6个参数的构造函数中，月份会多出一个月
    return new Date(dateArr[0], dateArr[1] - 1 >= 1 ? dateArr[1] - 1 : 1, dateArr[2], dateArr[3], dateArr[4], dateArr[5]);
}

/**
 * 通过 java 时间戳类型获取 js 的时间戳
 * @param timeStamp
 */
function getJsTimeStampByJavaTimeStamp(timeStamp) {
    var jsDate = javaTimeStamp2jsDate(timeStamp);
    console.info("时间戳 = " + jsDate.getTime());
    return jsDate.getTime();
}