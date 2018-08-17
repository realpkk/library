$(function () {
    $.dialog = function () {

    };
    $.extend($.dialog,{

        pay:function (orderCode,bookCode,bookName,orderAmount,createTime,expireTime,type) {
            if(type == 2){
                bootbox.dialog({
                    message:"<div class='row'><div class='col-sm-12'>订单编号：<input type='text' width='250' value='"+orderCode+"'></div></div><hr />"+
                    "<div class='row'><div class='col-sm-12'>图书书名：<input type='text'value='"+bookName+"'></div></div><hr />"+
                    "<div class='row'><div class='col-sm-12'>订购数量：<input type='text'value='"+orderAmount+"'></div></div><hr />"+
                    "<div class='row'><div class='col-sm-12'>订购时间：<input type='text'value='"+createTime+"'></div></div>",
                    buttons:{
                        "success":{
                            "label":"<i class='ace-icon fa fa-check'></i>确认支付",
                            "className":"btn-sm btn-success",
                            "callback":function () {
                                $.controller.pay(orderCode,orderAmount,bookCode);
                            }
                        },
                        "click":{
                            "label":"<i class='ace-icon fa fa-times'/>取消",
                            "className":"btn-sm "
                        }
                    }
                })
            }else {
                bootbox.dialog({
                    message:"<div class='row'><div class='col-sm-12'>订单编号：<input type='text'value='"+orderCode+"'></div></div><hr />"+
                    "<div class='row'><div class='col-sm-12'>图书书名：<input type='text'value='"+bookName+"'></div></div><hr />"+
                    "<div class='row'><div class='col-sm-12'>订购数量：<input type='text'value='"+orderAmount+"'></div></div><hr />"+
                    "<div class='row'><div class='col-sm-12'>订购时间：<input type='text'value='"+createTime+"'></div></div><hr />"+
                    "<div class='row'><div class='col-sm-12'>到期时间：<input type='text'value='"+expireTime+"'></div></div><hr />",
                    buttons:{
                        "success":{
                            "label":"<i class='ace-icon fa fa-check'></i>确认支付",
                            "className":"btn-sm btn-success",
                            "callback":function () {
                                $.controller.pay(orderCode,orderAmount,bookCode);
                            }
                        },
                        "click":{
                            "label":"<i class='ace-icon fa fa-times'/>取消",
                            "className":"btn-sm "
                        }
                    }
                })
            }
        },

        cancel:function (orderCode) {
            bootbox.dialog({
                message: "<div class='row'><div class='col-sm-12'><span class='bigger-110'>是否删除该数据编码为"+orderCode+"图书记录</span></div></div>",
                buttons:{
                    "danger":{
                        "label":"<i class='ace-icon fa fa-trash-o'></i>取消订单",
                        "className":"btn-sm btn-danger",
                        "callback": function () {
                            $.controller.cancel(orderCode);
                        }
                    },
                    "click":{
                        "label":"<i class='ace-icon fa fa-times'/>取消",
                        "className":"btn-sm "
                    }
                }
            })
        },

        renew:function (orderCode,bookName) {
            bootbox.dialog({
                message:"<div class='row'><div class='col-sm-12'>订单编号：<input type='text' width='250' value='"+orderCode+"'></div></div><hr />"+
                "<div class='row'><div class='col-sm-12'>图书书名：<input type='text'value='"+bookName+"'></div></div><hr />"+
                "<div class='row'><div class='col-sm-12'>请选择续阅期限：" +
                "<select id='renewOrderPeriod'><option value='1'selected='selected'>一个月</option><option value='2'>一季度</option><option value='3'>半年</option><option value='4'>一年</option></select>" +
                "</div></div>",
                buttons:{
                    "success":{
                        "label":"<i class='ace-icon fa fa-check'></i>确认续借",
                        "className":"btn-sm btn-success",
                        "callback":function () {
                            var orderPeriod = $("#renewOrderPeriod").val();
                            $.controller.renew(orderCode,orderPeriod);
                        }
                    },
                    "click":{
                        "label":"<i class='ace-icon fa fa-times'/>取消",
                        "className":"btn-sm "
                    }
                }
            })
        },

        unsubscribe:function (orderCode,bookName,createTime,expireTime) {
            bootbox.dialog({
                message:"<div class='row'><div class='col-sm-12'>订单编号：<input type='text'value='"+orderCode+"'></div></div><hr />"+
                "<div class='row'><div class='col-sm-12'>图书书名：<input type='text'value='"+bookName+"'></div></div><hr />"+
                "<div class='row'><div class='col-sm-12'>订购时间：<input type='text'value='"+createTime+"'></div></div><hr />"+
                "<div class='row'><div class='col-sm-12'>到期时间：<input type='text'value='"+expireTime+"'></div></div>"+
                "<div class='row'><div class='col-sm-12'><textarea class='col-sm-12' id='refundDescription'></textarea></div></div>",
                buttons:{
                    "success":{
                        "label":"<i class='ace-icon fa fa-check'></i>确认退订",
                        "className":"btn-sm btn-warning",
                        "callback":function () {
                            var refundDescription = $("#refundDescription").val();
                            $.controller.aftersale(orderCode,refundDescription,2);
                        }
                    },
                    "click":{
                        "label":"<i class='ace-icon fa fa-times'/>取消",
                        "className":"btn-sm "
                    }
                }
            })
        },

        refund:function (orderCode,bookName,createTime) {
            bootbox.dialog({
                message:"<div class='row'><div class='col-sm-12'>订单编号：<input type='text'value='"+orderCode+"'></div></div><hr />"+
                "<div class='row'><div class='col-sm-12'>图书书名：<input type='text'value='"+bookName+"'></div></div><hr />"+
                "<div class='row'><div class='col-sm-12'>订购时间：<input type='text'value='"+createTime+"'></div></div><hr />"+
                "<div class='row'><div class='col-sm-12'><textarea class='col-sm-12' id='refundDescription'></textarea></div></div>",
                buttons:{
                    "danger":{
                        "label":"<i class='ace-icon fa fa-times-circle'></i>退款",
                        "className":"btn-sm btn-danger",
                        "callback": function () {
                            var refundDescription = $("#refundDescription").val();
                            $.controller.aftersale(orderCode,refundDescription,1);
                        }
                    },
                    "click":{
                        "label":"<i class='ace-icon fa fa-times'/>取消",
                        "className":"btn-sm "
                    }
                }
            })
        }
    });
})

