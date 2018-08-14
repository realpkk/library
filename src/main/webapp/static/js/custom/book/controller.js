$(function () {
    $.controller = function () {
        
    }
    $.extend($.controller,{
        delete:function (keyValue) {
            var url = "/book/delete";
            var data = {"bookCode":keyValue};
            var json = $.toJSON(data);
            $.common.refreshAjaxAction(url,json);
        },
        
        edit:function (bookName,bookCode,bookAmount,bookRemain,orderSupport) {
            var url = "/book/edit";
            var data = {"bookName":bookName,"bookCode":bookCode,"bookAmount":bookAmount,"bookRemain":bookRemain,"orderSupport":orderSupport};
            var json = JSON.stringify(data);
            $.common.refreshAjaxAction(url,json);

        },
        
        order:function (bookCode,type,orderAmount) {
            var data = {"bookCode":bookCode,"type":type,"orderAmount":orderAmount};
            var json = JSON.stringify(data);
            var url = "/order/check?"+"&orderCode=";
            $.common.redirectAjaxAction("/order/save",json,url);
        },
        
        subscribe:function (orderPeriod,bookCode,type,orderAmount) {
            var data = {"orderPeriod":orderPeriod,"bookCode":bookCode,"type":type,"orderAmount":orderAmount};
            var json = JSON.stringify(data);
            var url = "/order/check?"+"&orderCode=";
            $.common.redirectAjaxAction("/order/save",json,url);
        }
    })
})