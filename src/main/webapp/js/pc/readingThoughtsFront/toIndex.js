function toIndex() {
    var appCurUrl = getAppCurUrl();
    var app_title = '';
    var url;
    url = appCurUrl + '/publicController/toReadingPlatformIndex';
    return unifiedSkip(app_title, 1, url);
}

