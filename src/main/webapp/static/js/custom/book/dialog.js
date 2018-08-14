$(function () {
    $.dialog = function () {

    };
    $.extend($.dialog,{

        delete:function (value) {
            bootbox.dialog({
                message: "<div class='row'><div class='col-sm-12'><span class='bigger-110'>是否删除该数据编码为"+value+"图书记录</span></div></div>",
                buttons:{
                    "danger":{
                        "label":"<i class='ace-icon fa fa-trash-o'></i>删除",
                        "className":"btn-sm btn-danger",
                        "callback": function () {
                            $.controller.delete(value);
                        }
                    },
                    "click":{
                        "label":"<i class='ace-icon fa fa-times'/>取消",
                        "className":"btn-sm "
                    }
                }
            })
        },

        edit:function (bookName,bookCode,bookAmount,bookRemain,orderSupport) {
            if (orderSupport==1){
                bootbox.dialog({
                    message: "<div class='row'><div class='col-sm-12'>图书书名：<input type='text' id='editBookName' value='" +bookName+ "'></div></div><hr />" +
                    "<div class='row'><div class='col-sm-12'>图书编码：<input type='text' id='editBookCode'value='"+bookCode+"'disabled='disabled'></div></div><hr />"+
                    "<div class='row'><div class='col-sm-12'>图书总数：<input type='text' id='editBookAmount'value='"+bookAmount+"'></div></div><hr />" +
                    "<div class='row'><div class='col-sm-12'>图书库存：<input type='text' id='editBookRemain'value='"+bookRemain+"'></div></div><hr />" +
                    "<div class='row'><div class='col-sm-12'>订购支持：期刊订阅<input type='radio' id='editOrderSupport' name='orderSupport'value='0'>" +
                    "整书订购<input type='radio' id='editOrderSupport' name='orderSupport' value='1'checked='checked'> </div></div>",
                    buttons:{
                        "success":{
                            "label":"<i class='ace-icon fa fa-check'></i>确认",
                            "className":"btn-sm btn-success",
                            "callback": function () {
                                var editBookName = $("#editBookName").val();
                                var editBookAmount = $("#editBookAmount").val();
                                var editBookRemain = $("#editBookRemain").val();
                                var editOrderSupport = $("input[name='orderSupport']:checked").val();
                                if (editBookRemain > editBookAmount){alert("库存数量有误,库存小于0或大于图书总量!")}
                                else {$.controller.edit(editBookName,bookCode,editBookAmount,editBookRemain,editOrderSupport);}
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
                    message: "<div class='row'><div class='col-sm-12'>图书书名：<input type='text' id='editBookName' value='" +bookName+ "'></div></div><hr />" +
                    "<div class='row'><div class='col-sm-12'>图书编码：<input type='text' id='editBookCode'value='"+bookCode+"'disabled='disabled'></div></div><hr />"+
                    "<div class='row'><div class='col-sm-12'>图书总数：<input type='text' id='editBookAmount'value='"+bookAmount+"'></div></div><hr />" +
                    "<div class='row'><div class='col-sm-12'>图书库存：<input type='text' id='editBookRemain'value='"+bookRemain+"'></div></div><hr />" +
                    "<div class='row'><div class='col-sm-12'>订购支持：期刊订阅<input type='radio' id='editOrderSupport' name='orderSupport'value='0'checked='checked'>" +
                    "整书订购<input type='radio' id='editOrderSupport' name='orderSupport' value='1'> </div></div>",
                    buttons:{
                        "success":{
                            "label":"<i class='ace-icon fa fa-check'></i>确认",
                            "className":"btn-sm btn-success",
                            "callback": function () {
                                var bookName = $("#editBookName").val();
                                var bookAmount = $("#editBookAmount").val();
                                var editBookRemain = $("#editBookRemain").val();
                                var orderSupport = $("input[name='orderSupport']:checked").val();
                                $.controller.edit(bookName,bookCode,bookAmount,editBookRemain,orderSupport);
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

        order:function (bookCode,bookName,bookRemain,type) {
            if(type==2){
                bootbox.dialog({
                    message:"<div class='row'><div class='col-sm-12'>图书书名：<input type='text' value='" +bookName+ "'disabled='disabled'></div></div><hr />" +
                    "<div class='row'><div class='col-sm-12'>图书编码：<input type='text' value='"+bookCode+"'disabled='disabled'></div></div><hr />"+
                    "<div class='row'><div class='col-sm-12'>图书库存：<input type='text' value='"+bookRemain+"'disabled='disabled'></div></div><hr />"+
                    "<div class='row'><div class='col-sm-12'><span class='bigger-110'>请输入订购数量：</span><input type='text' id='orderAmount'/></div></div>",
                    buttons:{
                        "success":{
                            "label":"<i class='ace-icon fa fa-check'></i>确认",
                            "className":"btn-sm btn-success",
                            "callback": function () {
                                var orderAmount = $("#orderAmount").val();
                                $.controller.order(bookCode,type,orderAmount);
                            }
                        },
                        "click":{
                            "label":"<i class='ace-icon fa fa-times'/>取消",
                            "className":"btn-sm "
                        }
                    }
                })
            }
            else{
                bootbox.dialog({
                    message:"<div class='row'><div class='col-sm-12'>图书书名：<input type='text' value='" +bookName+ "'></div></div><hr />" +
                    "<div class='row'><div class='col-sm-12'>图书编码：<input type='text'value='"+bookCode+"'disabled='disabled'></div></div><hr />"+
                    "<div class='row'><div class='col-sm-12'>图书库存：<input type='text' value='"+bookRemain+"'disabled='disabled'></div></div><hr />"+
                    "<div class='row'><div class='col-sm-12'>请输入订购数量：<input type='text' id='orderAmount'/></div></div>"+
                    "<div class='row'><div class='col-sm-12'>请选择借阅期限：" +
                    "<select id='orderPeriod'><option value='1'selected='selected'>一个月</option><option value='2'>一季度</option><option value='3'>半年</option><option value='4'>一年</option></select>" +
                    "</div></div>",
                    buttons:{
                        "success":{
                            "label":"<i class='ace-icon fa fa-check'></i>确认",
                            "className":"btn-sm btn-success",
                            "callback": function () {
                                var orderPeriod = $("#orderPeriod").val();
                                var orderAmount = $("#orderAmount").val();
                                $.controller.subscribe(orderPeriod,bookCode,type,orderAmount);
                            }
                        },
                        "click":{
                            "label":"<i class='ace-icon fa fa-times'/>取消",
                            "className":"btn-sm "
                        }
                    }
                })
            }
        }
    });
})

