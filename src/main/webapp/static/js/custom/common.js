$(function () {
    $.common = function (config) {
        
    }
    $.extend($.common,{
        refreshAjaxAction:function (url,data) {
            $.ajax({
                type:"POST",
                url:url,
                contentType:"application/json",
                data:data,

                success:function (data) {
                    alert(data);
                    location.reload(true);
                }
            })
        },

        redirectAjaxAction:function (url,data,redirectUrl) {
            $.ajax({
                type:"POST",
                url:url,
                contentType:"application/json",
                data:data,

                success:function (data) {
                    location.href = redirectUrl+data.orderCode;
                }
            })
        },

        historyAjaxAction:function (url,data) {
            $.ajax({
                type:"POST",
                url:url,
                contentType:"application/json",
                data:data,

                success:function (data) {
                    alert(data);
                    history.back();
                }
            })
        }
    })
});