$(function () {
    $.controller = function () {
        
    }
    $.extend($.controller,{
        applicationRemind:function (applicationCode) {
            var url = "/afterSale/remind";
            var data = {"applicationCode":applicationCode};
            var json = JSON.stringify(data);
            $.common.refreshAjaxAction(url,json);
        },

        cancel:function (applicationCode) {
            var url = "/afterSale/cancel";
            var data = {"applicationCode":applicationCode};
            var json = JSON.stringify(data);
            $.common.refreshAjaxAction(url,json);
        },

        pass:function (applicationCode) {
            var url = "/afterSale/pass";
            var data = {"applicationCode":applicationCode};
            var json = JSON.stringify(data);
            $.common.refreshAjaxAction(url,json);
        },

        reject:function (applicationCode,reply) {
            var url = "/afterSale/reject";
            var data = {"applicationCode":applicationCode,"reply":reply};
            var json = JSON.stringify(data);
            $.common.refreshAjaxAction(url,json);
        }
    })
})