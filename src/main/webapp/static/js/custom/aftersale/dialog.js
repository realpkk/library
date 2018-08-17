$(function () {
    $.dialog = function () {

    };
    $.extend($.dialog,{

        reject:function (applicationCode) {
            bootbox.dialog({
                message:"<div class='row'><div class='col-sm-12'>流水号：<input type='text'value='"+applicationCode+"'></div></div><hr />"+
                "<div class='row'><div class='col-sm-12'><textarea class='col-sm-12' id='reply'></textarea></div></div>",
                buttons:{
                    "danger":{
                        "label":"<i class='ace-icon fa fa-times-circle'></i>驳回",
                        "className":"btn-sm btn-danger",
                        "callback": function () {
                            var reply = $("#reply").val();
                            $.controller.reject(applicationCode,reply);
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

