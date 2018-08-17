$(function () {
    $.controller = function () {
        
    }
    $.extend($.controller,{
        pay:function (orderCode,orderAmount,bookCode) {
            var url = "/order/pay";
            var data = {"orderCode":orderCode,"orderAmount":orderAmount,"bookCode":bookCode};
            var json = JSON.stringify(data);
            $.common.refreshAjaxAction(url,json);
        },

        cancel:function (orderCode) {
            var url = "/order/cancel";
            var data = {"orderCode":orderCode};
            var json = JSON.stringify(data);
            $.common.refreshAjaxAction(url,json);
        },

        renewalcancel:function (orderCode) {
            var url = "/order/renewalCancel";
            var data = {"orderCode":orderCode};
            var json = JSON.stringify(data);
            $.common.historyAjaxAction(url,json);
        },

        renew:function (orderCode,orderPeriod) {
            var url = "/order/extend";
            var data = {"orderCode":orderCode,"orderPeriod":orderPeriod};
            var json = JSON.stringify(data);
            var redirectUrl = "/order/check?"+"&orderCode=";
            $.common.redirectAjaxAction(url,json,redirectUrl);
        },

        aftersale:function (orderCode,refundDescription,type) {
            var url = "/afterSale/create";
            var data = {"orderCode":orderCode,"applicationDescription":refundDescription,"type":type};
            var json = JSON.stringify(data);
            $.common.refreshAjaxAction(url,json);
        }
    })
})