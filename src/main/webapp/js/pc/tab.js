function doClick(o) {
    o.className = "nav_current";
    var j;
    var id;
    var e;
    for (var i = 1; i <= 4; i++) { //这里3 需要你修改 你多少条分类 就是多少
        id = "nav" + i;
        j = document.getElementById(id);
        e = document.getElementById("sub" + i);
        if (id != o.id) {
            j.className = "nav_link";
            e.style.display = "none";
        } else {
            e.style.display = "block";
        }
    }
}


function doClick1(o) {
    o.className = "tre_current";
    var j;
    var id;
    var e;
    for (var i = 1; i <= 2; i++) { //这里3 需要你修改 你多少条分类 就是多少
        id = "tre_nav" + i;
        j = document.getElementById(id);
        e = document.getElementById("tre_sub" + i);
        if (id != o.id) {
            j.className = "tre_link";
            e.style.display = "none";
        } else {
            e.style.display = "block";
        }
    }
}

function doClick2(o) {
    o.className = "show_current";
    var j;
    var id;
    var e;
    for (var i = 1; i <= 4; i++) { //这里3 需要你修改 你多少条分类 就是多少
        id = "show_nav" + i;
        j = document.getElementById(id);
        e = document.getElementById("show_sub" + i);
        if (id != o.id) {
            j.className = "show_link";
            e.style.display = "none";
        } else {
            e.style.display = "block";
        }
    }
}

function doClick3(o) {
    o.className = "login_current";
    var j;
    var id;
    var e;
    for (var i = 1; i <= 2; i++) { //这里3 需要你修改 你多少条分类 就是多少
        id = "login" + i;
        j = document.getElementById(id);
        e = document.getElementById("lsub" + i);
        if (id != o.id) {
            j.className = "login_link";
            e.style.display = "none";
        } else {
            e.style.display = "block";
        }
    }
}

function doClick4(o) {
    o.className = "tj_current";
    var j;
    var id;
    var e;
    for (var i = 1; i <= 6; i++) { //这里3 需要你修改 你多少条分类 就是多少
        id = "tj_nav" + i;
        j = document.getElementById(id);
        e = document.getElementById("tj_sub" + i);
        if (id != o.id) {
            j.className = "tj_link";
            e.style.display = "none";
        } else {
            e.style.display = "block";
        }
    }
}