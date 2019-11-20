/*!
 * 人个花瓣
 * Version 1.0
 * author:shihuan
 * @Date:2016-05-20 15:28:11
 * Demo:
 * --------------------------------------------
 * 定义花瓣显示的位置<span class="petalNew_123"></span><span class="star_123"></span>
 * var petalInfo = {count:{"friendsCount": 105,"myStarCount":1.1,"noteCount": 22,"note_topic_count": 140,"opendNoteCount": 12,"pv": 36612,"readDuration": 161,"subCount": 89,"topicCount": 118},userInfo:{uid:123456,name:''}};
 * $.getFlower(petalInfo, id); // id = '123'
 * --------------------------------------------
 */
(function ($, B) {
    $.extend({
        flowerConfigVs0: [{
            "evalue": 1999,
            "flowerType": 1,
            "id": 82,
            "percentage": 16,
            "petals": 1,
            "stage": 1,
            "svalue": 1
        }, {
            "evalue": 3999,
            "flowerType": 1,
            "id": 83,
            "percentage": 26,
            "petals": 1,
            "stage": 2,
            "svalue": 2000
        }, {
            "evalue": 5999,
            "flowerType": 1,
            "id": 84,
            "percentage": 36,
            "petals": 1,
            "stage": 3,
            "svalue": 4000
        }, {
            "evalue": 7999,
            "flowerType": 1,
            "id": 85,
            "percentage": 46,
            "petals": 1,
            "stage": 4,
            "svalue": 6000
        }, {
            "evalue": 9999,
            "flowerType": 1,
            "id": 86,
            "percentage": 56,
            "petals": 1,
            "stage": 5,
            "svalue": 8000
        }, {
            "evalue": 2147483647,
            "flowerType": 1,
            "id": 87,
            "percentage": 66,
            "petals": 1,
            "stage": 6,
            "svalue": 10000
        }, {
            "evalue": 19,
            "flowerType": 1,
            "id": 88,
            "percentage": 16,
            "petals": 2,
            "stage": 1,
            "svalue": 1
        }, {
            "evalue": 39,
            "flowerType": 1,
            "id": 89,
            "percentage": 26,
            "petals": 2,
            "stage": 2,
            "svalue": 20
        }, {
            "evalue": 59,
            "flowerType": 1,
            "id": 90,
            "percentage": 36,
            "petals": 2,
            "stage": 3,
            "svalue": 40
        }, {
            "evalue": 79,
            "flowerType": 1,
            "id": 91,
            "percentage": 46,
            "petals": 2,
            "stage": 4,
            "svalue": 60
        }, {
            "evalue": 99,
            "flowerType": 1,
            "id": 92,
            "percentage": 56,
            "petals": 2,
            "stage": 5,
            "svalue": 80
        }, {
            "evalue": 2147483647,
            "flowerType": 1,
            "id": 93,
            "percentage": 66,
            "petals": 2,
            "stage": 6,
            "svalue": 100
        }, {
            "evalue": 9,
            "flowerType": 1,
            "id": 94,
            "percentage": 16,
            "petals": 3,
            "stage": 1,
            "svalue": 1
        }, {
            "evalue": 19,
            "flowerType": 1,
            "id": 95,
            "percentage": 26,
            "petals": 3,
            "stage": 2,
            "svalue": 10
        }, {
            "evalue": 29,
            "flowerType": 1,
            "id": 96,
            "percentage": 36,
            "petals": 3,
            "stage": 3,
            "svalue": 20
        }, {
            "evalue": 39,
            "flowerType": 1,
            "id": 97,
            "percentage": 46,
            "petals": 3,
            "stage": 4,
            "svalue": 30
        }, {
            "evalue": 49,
            "flowerType": 1,
            "id": 98,
            "percentage": 56,
            "petals": 3,
            "stage": 5,
            "svalue": 40
        }, {
            "evalue": 2147483647,
            "flowerType": 1,
            "id": 99,
            "percentage": 66,
            "petals": 3,
            "stage": 6,
            "svalue": 50
        }, {
            "evalue": 9,
            "flowerType": 1,
            "id": 100,
            "percentage": 16,
            "petals": 4,
            "stage": 1,
            "svalue": 1
        }, {
            "evalue": 19,
            "flowerType": 1,
            "id": 101,
            "percentage": 26,
            "petals": 4,
            "stage": 2,
            "svalue": 10
        }, {
            "evalue": 29,
            "flowerType": 1,
            "id": 102,
            "percentage": 36,
            "petals": 4,
            "stage": 3,
            "svalue": 20
        }, {
            "evalue": 39,
            "flowerType": 1,
            "id": 103,
            "percentage": 46,
            "petals": 4,
            "stage": 4,
            "svalue": 30
        }, {
            "evalue": 49,
            "flowerType": 1,
            "id": 104,
            "percentage": 56,
            "petals": 4,
            "stage": 5,
            "svalue": 40
        }, {
            "evalue": 2147483647,
            "flowerType": 1,
            "id": 105,
            "percentage": 66,
            "petals": 4,
            "stage": 6,
            "svalue": 50
        }, {
            "evalue": 9,
            "flowerType": 1,
            "id": 106,
            "percentage": 16,
            "petals": 5,
            "stage": 1,
            "svalue": 1
        }, {
            "evalue": 19,
            "flowerType": 1,
            "id": 107,
            "percentage": 26,
            "petals": 5,
            "stage": 2,
            "svalue": 10
        }, {
            "evalue": 29,
            "flowerType": 1,
            "id": 108,
            "percentage": 36,
            "petals": 5,
            "stage": 3,
            "svalue": 20
        }, {
            "evalue": 39,
            "flowerType": 1,
            "id": 109,
            "percentage": 46,
            "petals": 5,
            "stage": 4,
            "svalue": 30
        }, {
            "evalue": 49,
            "flowerType": 1,
            "id": 110,
            "percentage": 56,
            "petals": 5,
            "stage": 5,
            "svalue": 40
        }, {"evalue": 2147483647, "flowerType": 1, "id": 111, "percentage": 66, "petals": 5, "stage": 6, "svalue": 50}],
        flowerConfigVs1: [{"evalue": 1999, "percentage": 16, "petals": 1, "stage": 1, "svalue": 1}, {
            "evalue": 3999,
            "percentage": 26,
            "petals": 1,
            "stage": 2,
            "svalue": 2000
        }, {"evalue": 5999, "percentage": 36, "petals": 1, "stage": 3, "svalue": 4000}, {
            "evalue": 7999,
            "percentage": 46,
            "petals": 1,
            "stage": 4,
            "svalue": 6000
        }, {"evalue": 9999, "percentage": 56, "petals": 1, "stage": 5, "svalue": 8000}, {
            "evalue": 19999,
            "percentage": 66,
            "petals": 1,
            "stage": 6,
            "svalue": 10000
        }, {"evalue": 39999, "percentage": 66, "petals": 1, "stage": 7, "svalue": 20000}, {
            "evalue": 79999,
            "percentage": 66,
            "petals": 1,
            "stage": 8,
            "svalue": 40000
        }, {"evalue": 2147483647, "percentage": 66, "petals": 1, "stage": 9, "svalue": 80000}, {
            "evalue": 19,
            "percentage": 16,
            "petals": 2,
            "stage": 1,
            "svalue": 1
        }, {"evalue": 39, "percentage": 26, "petals": 2, "stage": 2, "svalue": 20}, {
            "evalue": 59,
            "percentage": 36,
            "petals": 2,
            "stage": 3,
            "svalue": 40
        }, {"evalue": 79, "percentage": 46, "petals": 2, "stage": 4, "svalue": 60}, {
            "evalue": 99,
            "percentage": 56,
            "petals": 2,
            "stage": 5,
            "svalue": 80
        }, {"evalue": 199, "percentage": 66, "petals": 2, "stage": 6, "svalue": 100}, {
            "evalue": 399,
            "percentage": 66,
            "petals": 2,
            "stage": 7,
            "svalue": 200
        }, {"evalue": 799, "percentage": 66, "petals": 2, "stage": 8, "svalue": 400}, {
            "evalue": 2147483647,
            "percentage": 66,
            "petals": 2,
            "stage": 9,
            "svalue": 800
        }, {"evalue": 9, "percentage": 16, "petals": 3, "stage": 1, "svalue": 1}, {
            "evalue": 19,
            "percentage": 26,
            "petals": 3,
            "stage": 2,
            "svalue": 10
        }, {"evalue": 29, "percentage": 36, "petals": 3, "stage": 3, "svalue": 20}, {
            "evalue": 39,
            "percentage": 46,
            "petals": 3,
            "stage": 4,
            "svalue": 30
        }, {"evalue": 49, "percentage": 56, "petals": 3, "stage": 5, "svalue": 40}, {
            "evalue": 99,
            "percentage": 66,
            "petals": 3,
            "stage": 6,
            "svalue": 50
        }, {"evalue": 199, "percentage": 66, "petals": 3, "stage": 7, "svalue": 100}, {
            "evalue": 399,
            "percentage": 66,
            "petals": 3,
            "stage": 8,
            "svalue": 200
        }, {"evalue": 2147483647, "percentage": 66, "petals": 3, "stage": 9, "svalue": 400}, {
            "evalue": 9,
            "percentage": 16,
            "petals": 4,
            "stage": 1,
            "svalue": 1
        }, {"evalue": 19, "percentage": 26, "petals": 4, "stage": 2, "svalue": 10}, {
            "evalue": 29,
            "percentage": 36,
            "petals": 4,
            "stage": 3,
            "svalue": 20
        }, {"evalue": 39, "percentage": 46, "petals": 4, "stage": 4, "svalue": 30}, {
            "evalue": 49,
            "percentage": 56,
            "petals": 4,
            "stage": 5,
            "svalue": 40
        }, {"evalue": 99, "percentage": 66, "petals": 4, "stage": 6, "svalue": 50}, {
            "evalue": 199,
            "percentage": 66,
            "petals": 4,
            "stage": 7,
            "svalue": 100
        }, {"evalue": 399, "percentage": 66, "petals": 4, "stage": 8, "svalue": 200}, {
            "evalue": 2147483647,
            "percentage": 66,
            "petals": 4,
            "stage": 9,
            "svalue": 400
        }, {"evalue": 9, "percentage": 16, "petals": 5, "stage": 1, "svalue": 1}, {
            "evalue": 19,
            "percentage": 26,
            "petals": 5,
            "stage": 2,
            "svalue": 10
        }, {"evalue": 29, "percentage": 36, "petals": 5, "stage": 3, "svalue": 20}, {
            "evalue": 39,
            "percentage": 46,
            "petals": 5,
            "stage": 4,
            "svalue": 30
        }, {"evalue": 49, "percentage": 56, "petals": 5, "stage": 5, "svalue": 40}, {
            "evalue": 99,
            "percentage": 66,
            "petals": 5,
            "stage": 6,
            "svalue": 50
        }, {"evalue": 199, "percentage": 66, "petals": 5, "stage": 7, "svalue": 100}, {
            "evalue": 399,
            "percentage": 66,
            "petals": 5,
            "stage": 8,
            "svalue": 200
        }, {"evalue": 2147483647, "percentage": 66, "petals": 5, "stage": 9, "svalue": 400}],
        flowerConfigVs2: [{
            "evalue": 1999,
            "flowerType": 1,
            "id": 209,
            "percentage": 16,
            "petals": 1,
            "stage": 1,
            "svalue": 1
        }, {
            "evalue": 3999,
            "flowerType": 1,
            "id": 210,
            "percentage": 26,
            "petals": 1,
            "stage": 2,
            "svalue": 2000
        }, {
            "evalue": 5999,
            "flowerType": 1,
            "id": 211,
            "percentage": 36,
            "petals": 1,
            "stage": 3,
            "svalue": 4000
        }, {
            "evalue": 7999,
            "flowerType": 1,
            "id": 212,
            "percentage": 46,
            "petals": 1,
            "stage": 4,
            "svalue": 6000
        }, {
            "evalue": 9999,
            "flowerType": 1,
            "id": 213,
            "percentage": 56,
            "petals": 1,
            "stage": 5,
            "svalue": 8000
        }, {
            "evalue": 19999,
            "flowerType": 1,
            "id": 214,
            "percentage": 66,
            "petals": 1,
            "stage": 6,
            "svalue": 10000
        }, {
            "evalue": 49999,
            "flowerType": 1,
            "id": 215,
            "percentage": 66,
            "petals": 1,
            "stage": 7,
            "svalue": 20000
        }, {
            "evalue": 99999,
            "flowerType": 1,
            "id": 216,
            "percentage": 66,
            "petals": 1,
            "stage": 8,
            "svalue": 50000
        }, {
            "evalue": 2147483647,
            "flowerType": 1,
            "id": 217,
            "percentage": 66,
            "petals": 1,
            "stage": 9,
            "svalue": 100000
        }, {
            "evalue": 12,
            "flowerType": 1,
            "id": 218,
            "percentage": 16,
            "petals": 2,
            "stage": 1,
            "svalue": 1
        }, {
            "evalue": 25,
            "flowerType": 1,
            "id": 219,
            "percentage": 26,
            "petals": 2,
            "stage": 2,
            "svalue": 13
        }, {
            "evalue": 38,
            "flowerType": 1,
            "id": 220,
            "percentage": 36,
            "petals": 2,
            "stage": 3,
            "svalue": 26
        }, {
            "evalue": 51,
            "flowerType": 1,
            "id": 221,
            "percentage": 46,
            "petals": 2,
            "stage": 4,
            "svalue": 39
        }, {
            "evalue": 64,
            "flowerType": 1,
            "id": 222,
            "percentage": 56,
            "petals": 2,
            "stage": 5,
            "svalue": 52
        }, {
            "evalue": 124,
            "flowerType": 1,
            "id": 223,
            "percentage": 66,
            "petals": 2,
            "stage": 6,
            "svalue": 65
        }, {
            "evalue": 249,
            "flowerType": 1,
            "id": 224,
            "percentage": 66,
            "petals": 2,
            "stage": 7,
            "svalue": 125
        }, {
            "evalue": 499,
            "flowerType": 1,
            "id": 225,
            "percentage": 66,
            "petals": 2,
            "stage": 8,
            "svalue": 250
        }, {
            "evalue": 2147483647,
            "flowerType": 1,
            "id": 226,
            "percentage": 66,
            "petals": 2,
            "stage": 9,
            "svalue": 500
        }, {
            "evalue": 12,
            "flowerType": 1,
            "id": 227,
            "percentage": 16,
            "petals": 3,
            "stage": 1,
            "svalue": 1
        }, {
            "evalue": 25,
            "flowerType": 1,
            "id": 228,
            "percentage": 26,
            "petals": 3,
            "stage": 2,
            "svalue": 13
        }, {
            "evalue": 38,
            "flowerType": 1,
            "id": 229,
            "percentage": 36,
            "petals": 3,
            "stage": 3,
            "svalue": 26
        }, {
            "evalue": 51,
            "flowerType": 1,
            "id": 230,
            "percentage": 46,
            "petals": 3,
            "stage": 4,
            "svalue": 39
        }, {
            "evalue": 64,
            "flowerType": 1,
            "id": 231,
            "percentage": 56,
            "petals": 3,
            "stage": 5,
            "svalue": 52
        }, {
            "evalue": 124,
            "flowerType": 1,
            "id": 232,
            "percentage": 66,
            "petals": 3,
            "stage": 6,
            "svalue": 65
        }, {
            "evalue": 249,
            "flowerType": 1,
            "id": 233,
            "percentage": 66,
            "petals": 3,
            "stage": 7,
            "svalue": 125
        }, {
            "evalue": 499,
            "flowerType": 1,
            "id": 234,
            "percentage": 66,
            "petals": 3,
            "stage": 8,
            "svalue": 250
        }, {
            "evalue": 2147483647,
            "flowerType": 1,
            "id": 235,
            "percentage": 66,
            "petals": 3,
            "stage": 9,
            "svalue": 500
        }, {
            "evalue": 12,
            "flowerType": 1,
            "id": 236,
            "percentage": 16,
            "petals": 4,
            "stage": 1,
            "svalue": 1
        }, {
            "evalue": 25,
            "flowerType": 1,
            "id": 237,
            "percentage": 26,
            "petals": 4,
            "stage": 2,
            "svalue": 13
        }, {
            "evalue": 38,
            "flowerType": 1,
            "id": 238,
            "percentage": 36,
            "petals": 4,
            "stage": 3,
            "svalue": 26
        }, {
            "evalue": 51,
            "flowerType": 1,
            "id": 239,
            "percentage": 46,
            "petals": 4,
            "stage": 4,
            "svalue": 39
        }, {
            "evalue": 64,
            "flowerType": 1,
            "id": 240,
            "percentage": 56,
            "petals": 4,
            "stage": 5,
            "svalue": 52
        }, {
            "evalue": 124,
            "flowerType": 1,
            "id": 241,
            "percentage": 66,
            "petals": 4,
            "stage": 6,
            "svalue": 65
        }, {
            "evalue": 249,
            "flowerType": 1,
            "id": 242,
            "percentage": 66,
            "petals": 4,
            "stage": 7,
            "svalue": 125
        }, {
            "evalue": 499,
            "flowerType": 1,
            "id": 243,
            "percentage": 66,
            "petals": 4,
            "stage": 8,
            "svalue": 250
        }, {
            "evalue": 2147483647,
            "flowerType": 1,
            "id": 244,
            "percentage": 66,
            "petals": 4,
            "stage": 9,
            "svalue": 500
        }, {
            "evalue": 1,
            "flowerType": 1,
            "id": 245,
            "percentage": 16,
            "petals": 5,
            "stage": 1,
            "svalue": 1
        }, {
            "evalue": 2,
            "flowerType": 1,
            "id": 246,
            "percentage": 26,
            "petals": 5,
            "stage": 2,
            "svalue": 2
        }, {
            "evalue": 3,
            "flowerType": 1,
            "id": 247,
            "percentage": 36,
            "petals": 5,
            "stage": 3,
            "svalue": 3
        }, {
            "evalue": 4,
            "flowerType": 1,
            "id": 248,
            "percentage": 46,
            "petals": 5,
            "stage": 4,
            "svalue": 4
        }, {
            "evalue": 5,
            "flowerType": 1,
            "id": 249,
            "percentage": 56,
            "petals": 5,
            "stage": 5,
            "svalue": 5
        }, {
            "evalue": 6,
            "flowerType": 1,
            "id": 250,
            "percentage": 66,
            "petals": 5,
            "stage": 6,
            "svalue": 6
        }, {
            "evalue": 24,
            "flowerType": 1,
            "id": 251,
            "percentage": 66,
            "petals": 5,
            "stage": 7,
            "svalue": 7
        }, {
            "evalue": 49,
            "flowerType": 1,
            "id": 252,
            "percentage": 66,
            "petals": 5,
            "stage": 8,
            "svalue": 25
        }, {"evalue": 2147483647, "flowerType": 1, "id": 253, "percentage": 66, "petals": 5, "stage": 9, "svalue": 50}],
        flowerConfigVs3: [{
            "evalue": 1999,
            "flowerType": 1,
            "id": 209,
            "percentage": 16,
            "petals": 1,
            "stage": 1,
            "svalue": 1
        }, {
            "evalue": 3999,
            "flowerType": 1,
            "id": 210,
            "percentage": 26,
            "petals": 1,
            "stage": 2,
            "svalue": 2000
        }, {
            "evalue": 5999,
            "flowerType": 1,
            "id": 211,
            "percentage": 36,
            "petals": 1,
            "stage": 3,
            "svalue": 4000
        }, {
            "evalue": 7999,
            "flowerType": 1,
            "id": 212,
            "percentage": 46,
            "petals": 1,
            "stage": 4,
            "svalue": 6000
        }, {
            "evalue": 9999,
            "flowerType": 1,
            "id": 213,
            "percentage": 56,
            "petals": 1,
            "stage": 5,
            "svalue": 8000
        }, {
            "evalue": 19999,
            "flowerType": 1,
            "id": 214,
            "percentage": 66,
            "petals": 1,
            "stage": 6,
            "svalue": 10000
        }, {
            "evalue": 49999,
            "flowerType": 1,
            "id": 215,
            "percentage": 66,
            "petals": 1,
            "stage": 7,
            "svalue": 20000
        }, {
            "evalue": 99999,
            "flowerType": 1,
            "id": 216,
            "percentage": 66,
            "petals": 1,
            "stage": 8,
            "svalue": 50000
        }, {
            "evalue": 2147483647,
            "flowerType": 1,
            "id": 217,
            "percentage": 66,
            "petals": 1,
            "stage": 9,
            "svalue": 100000
        }, {
            "evalue": 12,
            "flowerType": 1,
            "id": 218,
            "percentage": 16,
            "petals": 2,
            "stage": 1,
            "svalue": 1
        }, {
            "evalue": 25,
            "flowerType": 1,
            "id": 219,
            "percentage": 26,
            "petals": 2,
            "stage": 2,
            "svalue": 13
        }, {
            "evalue": 38,
            "flowerType": 1,
            "id": 220,
            "percentage": 36,
            "petals": 2,
            "stage": 3,
            "svalue": 26
        }, {
            "evalue": 51,
            "flowerType": 1,
            "id": 221,
            "percentage": 46,
            "petals": 2,
            "stage": 4,
            "svalue": 39
        }, {
            "evalue": 64,
            "flowerType": 1,
            "id": 222,
            "percentage": 56,
            "petals": 2,
            "stage": 5,
            "svalue": 52
        }, {
            "evalue": 124,
            "flowerType": 1,
            "id": 223,
            "percentage": 66,
            "petals": 2,
            "stage": 6,
            "svalue": 65
        }, {
            "evalue": 249,
            "flowerType": 1,
            "id": 224,
            "percentage": 66,
            "petals": 2,
            "stage": 7,
            "svalue": 125
        }, {
            "evalue": 499,
            "flowerType": 1,
            "id": 225,
            "percentage": 66,
            "petals": 2,
            "stage": 8,
            "svalue": 250
        }, {
            "evalue": 2147483647,
            "flowerType": 1,
            "id": 226,
            "percentage": 66,
            "petals": 2,
            "stage": 9,
            "svalue": 500
        }, {
            "evalue": 12,
            "flowerType": 1,
            "id": 227,
            "percentage": 16,
            "petals": 3,
            "stage": 1,
            "svalue": 1
        }, {
            "evalue": 25,
            "flowerType": 1,
            "id": 228,
            "percentage": 26,
            "petals": 3,
            "stage": 2,
            "svalue": 13
        }, {
            "evalue": 38,
            "flowerType": 1,
            "id": 229,
            "percentage": 36,
            "petals": 3,
            "stage": 3,
            "svalue": 26
        }, {
            "evalue": 51,
            "flowerType": 1,
            "id": 230,
            "percentage": 46,
            "petals": 3,
            "stage": 4,
            "svalue": 39
        }, {
            "evalue": 64,
            "flowerType": 1,
            "id": 231,
            "percentage": 56,
            "petals": 3,
            "stage": 5,
            "svalue": 52
        }, {
            "evalue": 124,
            "flowerType": 1,
            "id": 232,
            "percentage": 66,
            "petals": 3,
            "stage": 6,
            "svalue": 65
        }, {
            "evalue": 249,
            "flowerType": 1,
            "id": 233,
            "percentage": 66,
            "petals": 3,
            "stage": 7,
            "svalue": 125
        }, {
            "evalue": 499,
            "flowerType": 1,
            "id": 234,
            "percentage": 66,
            "petals": 3,
            "stage": 8,
            "svalue": 250
        }, {
            "evalue": 2147483647,
            "flowerType": 1,
            "id": 235,
            "percentage": 66,
            "petals": 3,
            "stage": 9,
            "svalue": 500
        }, {
            "evalue": 12,
            "flowerType": 1,
            "id": 236,
            "percentage": 16,
            "petals": 4,
            "stage": 1,
            "svalue": 1
        }, {
            "evalue": 25,
            "flowerType": 1,
            "id": 237,
            "percentage": 26,
            "petals": 4,
            "stage": 2,
            "svalue": 13
        }, {
            "evalue": 38,
            "flowerType": 1,
            "id": 238,
            "percentage": 36,
            "petals": 4,
            "stage": 3,
            "svalue": 26
        }, {
            "evalue": 51,
            "flowerType": 1,
            "id": 239,
            "percentage": 46,
            "petals": 4,
            "stage": 4,
            "svalue": 39
        }, {
            "evalue": 64,
            "flowerType": 1,
            "id": 240,
            "percentage": 56,
            "petals": 4,
            "stage": 5,
            "svalue": 52
        }, {
            "evalue": 124,
            "flowerType": 1,
            "id": 241,
            "percentage": 66,
            "petals": 4,
            "stage": 6,
            "svalue": 65
        }, {
            "evalue": 249,
            "flowerType": 1,
            "id": 242,
            "percentage": 66,
            "petals": 4,
            "stage": 7,
            "svalue": 125
        }, {
            "evalue": 499,
            "flowerType": 1,
            "id": 243,
            "percentage": 66,
            "petals": 4,
            "stage": 8,
            "svalue": 250
        }, {"evalue": 2147483647, "flowerType": 1, "id": 244, "percentage": 66, "petals": 4, "stage": 9, "svalue": 500},
            {"evalue": 1, "flowerType": 1, "id": 245, "percentage": 16, "petals": 5, "stage": 1, "svalue": 0},
            {"evalue": 2, "flowerType": 1, "id": 246, "percentage": 26, "petals": 5, "stage": 2, "svalue": 1},
            {"evalue": 3, "flowerType": 1, "id": 247, "percentage": 36, "petals": 5, "stage": 3, "svalue": 2},
            {"evalue": 4, "flowerType": 1, "id": 248, "percentage": 46, "petals": 5, "stage": 4, "svalue": 3},
            {"evalue": 5, "flowerType": 1, "id": 249, "percentage": 56, "petals": 5, "stage": 5, "svalue": 4},
            {"evalue": 6, "flowerType": 1, "id": 250, "percentage": 66, "petals": 5, "stage": 6, "svalue": 5},
            {"evalue": 24, "flowerType": 1, "id": 251, "percentage": 66, "petals": 5, "stage": 7, "svalue": 6},
            {"evalue": 50, "flowerType": 1, "id": 252, "percentage": 66, "petals": 5, "stage": 8, "svalue": 24},
            {
                "evalue": 2147483647,
                "flowerType": 1,
                "id": 253,
                "percentage": 66,
                "petals": 5,
                "stage": 9,
                "svalue": 50
            }],
        getStar: function (count) {
            var starMap = new Map();
            var myStarCount = new String(count.myStarCount);
            var star = '';
            // 星星数量（不算最后一个星星）
            var starNum = 0;
            // 最后一个星星的大小
            var lastStar = "0";
            if (myStarCount && myStarCount != "0") {
                if (myStarCount.indexOf(".") > 0) {
                    var starArray = myStarCount.split(".");
                    if (starArray.length >= 2) {
                        starNum = starArray[0];
                        lastStar = starArray[1];
                        if (lastStar.length >= 3) {
                            lastStar = lastStar.substring(0, 2) + "." + lastStar.substring(2, lastStar.length);
                        }
                        if (lastStar.length == 1) {
                            lastStar += "0";
                        }
                    } else if (starArray.length > 0) {
                        starNum = starArray[0];
                    }
                }

            }
            starMap.put("starNum", starNum);
            starMap.put("lastStar", lastStar);
            return starMap;
        },
        getCurFlowerConfig: function (vs, count) {
            var petalMap = new Map();  // 需要引用 map.js
            if (vs == 0) {
                $.getFlowerVs0(count, petalMap);
            } else if (vs == 1) {
                $.getFlowerVs1(count, petalMap);
            } else if (vs == 2) {
                $.getFlowerVs2(count, petalMap);
            } else if (vs == 3) {
                $.getFlowerVs3(count, petalMap);
            }
            return petalMap;
        },
        getFlowerVs0: function (count, petalMap) {
            var pvPetal = [];
            var subPetal = [];
            var topicPetal = [];
            var friendsPetal = [];
            var notePetal = [];
            for (var i = 0; i < $.flowerConfigVs0.length; i++) {
                var petal = $.flowerConfigVs0[i];
                if (i < 6) {
                    pvPetal.push(petal);
                    continue;
                } else if (i < 12) {
                    subPetal.push(petal);
                    continue;
                } else if (i < 18) {
                    topicPetal.push(petal);
                    continue;
                } else if (i < 24) {
                    friendsPetal.push(petal);
                    continue;
                } else if (i < 30) {
                    notePetal.push(petal);
                    continue;
                }
            }
            for (var i1 = 0; i1 < pvPetal.length; i1++) {
                var pCount = count.pv;
                var petal = pvPetal[i1];
                svalue = petal.svalue;
                evalue = petal.evalue;
                if (svalue <= pCount && evalue >= pCount) {
                    petalMap.put("petal1", petal.stage);
                    break;
                }
            }
            for (var i5 = 0; i5 < notePetal.length; i5++) {
                var pCount = count.noteCount;
                var petal = notePetal[i5];
                svalue = petal.svalue;
                evalue = petal.evalue;
                if (svalue <= pCount && evalue >= pCount) {
                    petalMap.put("petal5", petal.stage);
                    break;
                }
            }
            for (var i3 = 0; i3 < topicPetal.length; i3++) {
                var pCount = count.topicCount;
                var petal = topicPetal[i3];
                svalue = petal.svalue;
                evalue = petal.evalue;
                if (svalue <= pCount && evalue >= pCount) {
                    petalMap.put("petal3", petal.stage);
                    break;
                }
            }
            for (var i4 = 0; i4 < friendsPetal.length; i4++) {
                var pCount = count.friendsCount;
                var petal = friendsPetal[i4];
                svalue = petal.svalue;
                evalue = petal.evalue;
                if (svalue <= pCount && evalue >= pCount) {
                    petalMap.put("petal4", petal.stage);
                    break;
                }
            }
            for (var i2 = 0; i2 < subPetal.length; i2++) {
                var pCount = count.subCount;
                var petal = friendsPetal[i2];
                svalue = petal.svalue;
                evalue = petal.evalue;
                if (svalue <= pCount && evalue >= pCount) {
                    petalMap.put("petal2", petal.stage);
                    break;
                }
            }
        },
        getFlowerVs1: function (count, petalMap) {
            var pvPetal = [];
            var subPetal = [];
            var topicPetal = [];
            var friendsPetal = [];
            var notePetal = [];
            for (var i = 0; i < $.flowerConfigVs1.length; i++) {
                var petal = $.flowerConfigVs1[i];
                if (i < 9) {
                    pvPetal.push(petal);
                    continue;
                } else if (i < 18) {
                    subPetal.push(petal);
                    continue;
                } else if (i < 27) {
                    topicPetal.push(petal);
                    continue;
                } else if (i < 36) {
                    friendsPetal.push(petal);
                    continue;
                } else if (i < 45) {
                    notePetal.push(petal);
                    continue;
                }
            }
            for (var i1 = 0; i1 < pvPetal.length; i1++) {
                var pCount = count.pv;
                var petal = pvPetal[i1];
                svalue = petal.svalue;
                evalue = petal.evalue;
                if (svalue <= pCount && evalue >= pCount) {
                    petalMap.put("petal1", petal.stage);
                    break;
                }
            }
            for (var i2 = 0; i2 < notePetal.length; i2++) {
                var pCount = count.noteCount;
                var petal = notePetal[i2];
                svalue = petal.svalue;
                evalue = petal.evalue;
                if (svalue <= pCount && evalue >= pCount) {
                    petalMap.put("petal2", petal.stage);
                    break;
                }
            }
            for (var i3 = 0; i3 < topicPetal.length; i3++) {
                var pCount = count.topicCount;
                var petal = topicPetal[i3];
                svalue = petal.svalue;
                evalue = petal.evalue;
                if (svalue <= pCount && evalue >= pCount) {
                    petalMap.put("petal3", petal.stage);
                    break;
                }
            }
            for (var i4 = 0; i4 < friendsPetal.length; i4++) {
                var pCount = count.friendsCount;
                var petal = friendsPetal[i4];
                svalue = petal.svalue;
                evalue = petal.evalue;
                if (svalue <= pCount && evalue >= pCount) {
                    petalMap.put("petal4", petal.stage);
                    break;
                }
            }
            for (var i5 = 0; i5 < subPetal.length; i5++) {
                var pCount = count.subCount;
                var petal = friendsPetal[i5];
                svalue = petal.svalue;
                evalue = petal.evalue;
                if (svalue <= pCount && evalue >= pCount) {
                    petalMap.put("petal5", petal.stage);
                    break;
                }
            }
        },
        getFlowerVs2: function (count, petalMap) {
            var pvPetal = [];
            var noteTopicPetal = [];
            var friendsPetal = [];
            var subPetal = [];
            var readDurationPetal = [];
            for (var i = 0; i < $.flowerConfigVs2.length; i++) {
                var petal = $.flowerConfigVs2[i];
                if (i < 9) {
                    pvPetal.push(petal);
                    continue;
                } else if (i < 18) {
                    noteTopicPetal.push(petal);
                    continue;
                } else if (i < 27) {
                    friendsPetal.push(petal);
                    continue;
                } else if (i < 36) {
                    subPetal.push(petal);
                    continue;
                } else if (i < 45) {
                    readDurationPetal.push(petal);
                    continue;
                }
            }
            for (var i1 = 0; i1 < pvPetal.length; i1++) {
                var pCount = count.pv;
                var petal = pvPetal[i1];
                svalue = petal.svalue;
                evalue = petal.evalue;
                if (svalue <= pCount && evalue >= pCount) {
                    petalMap.put("petal1", petal.stage);
                    break;
                }
            }
            for (var i2 = 0; i2 < noteTopicPetal.length; i2++) {
                var pCount = count.note_topic_count;
                var petal = noteTopicPetal[i2];
                svalue = petal.svalue;
                evalue = petal.evalue;
                if (svalue <= pCount && evalue >= pCount) {
                    petalMap.put("petal2", petal.stage);
                    break;
                }
            }
            for (var i3 = 0; i3 < friendsPetal.length; i3++) {
                var pCount = count.friendsCount;
                var petal = friendsPetal[i3];
                svalue = petal.svalue;
                evalue = petal.evalue;
                if (svalue <= pCount && evalue >= pCount) {
                    petalMap.put("petal3", petal.stage);
                    break;
                }
            }
            for (var i4 = 0; i4 < subPetal.length; i4++) {
                var pCount = count.subCount;
                var petal = subPetal[i4];
                svalue = petal.svalue;
                evalue = petal.evalue;
                if (svalue <= pCount && evalue >= pCount) {
                    petalMap.put("petal4", petal.stage);
                    break;
                }
            }
            for (var i5 = 0; i5 < readDurationPetal.length; i5++) {
                var pCount = count.readDuration;
                var petal = readDurationPetal[i5];
                var petalNum = petal.petals;
                svalue = petal.svalue;
                evalue = petal.evalue;
                if (svalue <= (parseInt(pCount / 60)) && evalue >= (parseInt(pCount / 60))) {
                    petalMap.put("petal5", petal.stage);
                    break;
                }
            }
        },
        getFlowerVs3: function (count, petalMap) {
            var pvPetal = [];
            var noteTopicPetal = [];
            var friendsPetal = [];
            var subPetal = [];
            var readDurationPetal = [];
            for (var i = 0; i < $.flowerConfigVs3.length; i++) {
                var petal = $.flowerConfigVs3[i];
                if (i < 9) {
                    pvPetal.push(petal);
                    continue;
                } else if (i < 18) {
                    noteTopicPetal.push(petal);
                    continue;
                } else if (i < 27) {
                    friendsPetal.push(petal);
                    continue;
                } else if (i < 36) {
                    subPetal.push(petal);
                    continue;
                } else if (i < 45) {
                    readDurationPetal.push(petal);
                    continue;
                }
            }
            for (var i1 = 0; i1 < pvPetal.length; i1++) {
                var pCount = count.pv;
                var petal = pvPetal[i1];
                svalue = petal.svalue;
                evalue = petal.evalue;
                if (svalue <= pCount && evalue >= pCount) {
                    petalMap.put("petal1", petal.stage);
                    break;
                }
            }
            for (var i2 = 0; i2 < noteTopicPetal.length; i2++) {
                var pCount = count.note_topic_count;
                var petal = noteTopicPetal[i2];
                svalue = petal.svalue;
                evalue = petal.evalue;
                if (svalue <= pCount && evalue >= pCount) {
                    petalMap.put("petal2", petal.stage);
                    break;
                }
            }
            for (var i3 = 0; i3 < friendsPetal.length; i3++) {
                var pCount = count.friendsCount;
                var petal = friendsPetal[i3];
                svalue = petal.svalue;
                evalue = petal.evalue;
                if (svalue <= pCount && evalue >= pCount) {
                    petalMap.put("petal3", petal.stage);
                    break;
                }
            }
            for (var i4 = 0; i4 < subPetal.length; i4++) {
                var pCount = count.subCount;
                var petal = subPetal[i4];
                svalue = petal.svalue;
                evalue = petal.evalue;
                if (svalue <= pCount && evalue >= pCount) {
                    petalMap.put("petal4", petal.stage);
                    break;
                }
            }
            for (var i5 = 0; i5 < readDurationPetal.length; i5++) {
                var pCount = count.readDuration;
                var petal = readDurationPetal[i5];
                var petalNum = petal.petals;
                svalue = petal.svalue;
                evalue = petal.evalue;
                if (svalue < (pCount / 60) && evalue >= (pCount / 60)) {
                    petalMap.put("petal5", petal.stage);
                    break;
                }
            }
        },
        showFlower: function (THIS) {
            var petalInfo = $(THIS).attr("petalInfo") || '';
            if (petalInfo != '') {
                try {
                    petalInfo = JSON.parse(petalInfo);
                } catch (e) {
                    return;
                }
            }
            var opt = {type: 1, petalInfo: petalInfo};
            B.postNotification('CLIENT_SHOW_PETAL', opt);
            window.event ? window.event.cancelBubble = true : evt.stopPropagation();
        },
        getFlower: function (petalInfo, id) {
            var isWriteCss = $("#flowerCss").attr("flag");
            if (undefined == isWriteCss) {
                $(document.body).before("<link rel='stylesheet' id='flowerCss' flag=false href='http://learn.chaoxing.com/res/css/common/flower/flower.css'>");
            }
            if (undefined == petalInfo) return;
            if (typeof(petalInfo) == 'string') {
                return;
            }
            var vs = 0;
            if (navigator.userAgent.indexOf("ChaoXingStudy") > -1) {
                var ua = navigator.userAgent;
                ua = ua.substring(ua.indexOf("_") + 1);
                ua = ua.substring(ua.indexOf("_") + 1);
                ua = ua.substring(0, ua.indexOf("_"));
                var version = ua;
                if (version >= '1.3.0.5') {
                    vs = 1;
                }
                if (version >= '1.3.3.1') {
                    vs = 2;
                }
                if (version >= '1.3.3.6') {
                    vs = 3;
                }
            }
            var uid = petalInfo.userInfo.uid;
            var petalMap = $.getCurFlowerConfig(vs, petalInfo.count);
            var flower = '';
            if (vs == 0) {
                flower = '<ul class="petalNew" petalInfo=\'' + JSON.stringify(petalInfo) + '\' onclick="$.showFlower(this)" >'
                    + '<b class="iconTL iconTL' + (petalMap.get("petal1") ? petalMap.get("petal1") : 0)
                    + '"></b><b class="iconTR iconTR' + (petalMap.get("petal2") ? petalMap.get("petal2") : 0)
                    + '"></b><b class="iconTM iconTM' + (petalMap.get("petal3") ? petalMap.get("petal3") : 0)
                    + '"></b><b class="iconBR iconBR' + (petalMap.get("petal4") ? petalMap.get("petal4") : 0)
                    + '"></b><b class="iconBL iconBL' + (petalMap.get("petal5") ? petalMap.get("petal5") : 0)
                    + '"></b></ul>';
            } else {
                flower = '<ul class="petalNew" petalInfo=\'' + JSON.stringify(petalInfo) + '\' onclick="$.showFlower(this)">'
                    + '<b class="iconNewTL iconNewTL' + (petalMap.get("petal1") ? petalMap.get("petal1") : 0)
                    + '"></b><b class="iconNewTR iconNewTR' + (petalMap.get("petal2") ? petalMap.get("petal2") : 0)
                    + '"></b><b class="iconNewTM iconNewTM' + (petalMap.get("petal3") ? petalMap.get("petal3") : 0)
                    + '"></b><b class="iconNewBR iconNewBR' + (petalMap.get("petal4") ? petalMap.get("petal4") : 0)
                    + '"></b><b class="iconNewBL iconNewBL' + (petalMap.get("petal5") ? petalMap.get("petal5") : 0)
                    + '"></b></ul>';
            }
            $(".petalNew_" + id).html(flower);
            if (vs > 0) {
                var starMap = $.getStar(petalInfo.count);
                var star = '';
                var startNum = starMap.get("starNum");
                var lastStar = starMap.get("lastStar");
                star += '<span class="starBox clearfix" petalInfo=\'' + JSON.stringify(petalInfo) + '\' onclick="$.showFlower(this)" >';
                for (var i = 0; i < startNum; i++) {
                    star += '<span class="starLi"><b style="width:100%"></b></span>';
                }
                if (lastStar != '0') {
                    star += '<span class="starLi"><b style="width:' + lastStar + '%"></b></span>';
                }
                star += '</span>';
                $(".star_" + id).html(star);
            }
        }
    });
})(jQuery, jsBridge);
