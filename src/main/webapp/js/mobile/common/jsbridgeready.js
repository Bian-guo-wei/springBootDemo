function dayaKidHeaderButtonJump(show, icon, menu, option) {
    jsBridge.postNotification('CLIENT_CUSTOM_MENU', {
        show: show,
        icon: icon,
        menu: menu,
        option: option
    });
}