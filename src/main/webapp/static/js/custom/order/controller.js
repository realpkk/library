$(function () {
    $.controller = function () {
        
    }
    $.extend($.controller,{
        pay:function (orderCode) {
            var url = "/order/pay";
            var data = {"orderCode":orderCode};
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

        unsubscribe:function (orderCode) {
            var url = "/order/unsubscribe";
            var data = {"orderCode":orderCode};
            var json = JSON.stringify(data);
            $.common.refreshAjaxAction(url,json);
        },

        refund:function (orderCode) {
            var url = "/order/refund";
            var data = {"orderCode":orderCode};
            var json = JSON.stringify(data);
            $.common.refreshAjaxAction(url,json);
        }
    })
})