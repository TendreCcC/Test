$(function () {//加载函数相当于windows.load页面加载完毕导入头部
    $.get({       //异步的回调
        url: "header.html",//访问地址
        success: function (html) {
            $("#header").html(html);
        }
    });


    /**
     *  脚步网页
     */

    $.get({
        url:"footer.html",
        success:function (html) {
           $("#footer").html(html) ;  /*jqurey的参数获取根据id属性*/
        }
    });
})