var Petal = {
    getPvLeave: function () {
    },
    getSubLeave: function () {
    },
    getDiscussLeave: function () {
    },
    getFriendsLeave: function () {
    },
    getNoteLeave: function () {
    },
    getXing: function () {
    }
}
/**
 * PV量
 */
Petal.getPvLeave = function (count) {
    if (count == 0) return 0;
    if (count >= 1 && count <= 1999) {
        return 1;
    }
    if (count >= 2000 && count <= 3999) {
        return 2;
    }
    if (count >= 4000 && count <= 5999) {
        return 3;
    }
    if (count >= 6000 && count <= 7999) {
        return 4;
    }
    if (count >= 8000 && count <= 9999) {
        return 5;
    }
    if (count >= 10000 && count <= 19999) {
        return 6;
    }
    if (count >= 20000 && count <= 39999) {
        return 7;
    }
    if (count >= 40000 && count <= 79999) {
        return 8;
    }
    if (count >= 80000) {
        return 9;
    }

}
/**
 * 订阅量
 */
Petal.getSubLeave = function (count) {
    if (count == 0) return 0;
    if (count >= 1 && count <= 19) {
        return 1;
    }
    if (count >= 20 && count <= 39) {
        return 2;
    }
    if (count >= 40 && count <= 59) {
        return 3;
    }
    if (count >= 60 && count <= 79) {
        return 4;
    }
    if (count >= 80 && count <= 99) {
        return 5;
    }
    if (count >= 100 && count <= 199) {
        return 6;
    }
    if (count >= 200 && count <= 399) {
        return 7;
    }
    if (count >= 400 && count <= 799) {
        return 8;
    }
    if (count >= 800) {
        return 9;
    }
}
/**
 * 讨论量
 */
Petal.getDiscussLeave = function (count) {
    if (count == 0) return 0;
    if (count >= 1 && count <= 9) {
        return 1;
    }
    if (count >= 10 && count <= 19) {
        return 2;
    }
    if (count >= 20 && count <= 29) {
        return 3;
    }
    if (count >= 30 && count <= 39) {
        return 4;
    }
    if (count >= 40 && count <= 49) {
        return 5;
    }
    if (count >= 50 && count <= 99) {
        return 6;
    }
    if (count >= 100 && count <= 199) {
        return 7;
    }
    if (count >= 200 && count <= 399) {
        return 8;
    }
    if (count >= 400) {
        return 9;
    }

}
/**
 * 好友数量
 */
Petal.getFriendsLeave = function (count) {
    if (count == 0) return 0;
    if (count >= 1 && count <= 9) {
        return 1;
    }
    if (count >= 10 && count <= 19) {
        return 2;
    }
    if (count >= 20 && count <= 29) {
        return 3;
    }
    if (count >= 30 && count <= 39) {
        return 4;
    }
    if (count >= 40 && count <= 49) {
        return 5;
    }
    if (count >= 50 && count <= 99) {
        return 6;
    }
    if (count >= 100 && count <= 199) {
        return 7;
    }
    if (count >= 200 && count <= 399) {
        return 8;
    }
    if (count >= 400) {
        return 9;
    }
}
/**
 * 笔记数量
 */
Petal.getNoteLeave = function (count) {
    if (count == 0) return 0;
    if (count >= 1 && count <= 9) {
        return 1;
    }
    if (count >= 10 && count <= 19) {
        return 2;
    }
    if (count >= 20 && count <= 29) {
        return 3;
    }
    if (count >= 30 && count <= 39) {
        return 4;
    }
    if (count >= 40 && count <= 49) {
        return 5;
    }
    if (count >= 50 && count <= 99) {
        return 6;
    }
    if (count >= 100 && count <= 199) {
        return 7;
    }
    if (count >= 200 && count <= 399) {
        return 8;
    }
    if (count >= 400) {
        return 9;
    }
}