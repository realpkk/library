$.ajaxSetup({
    contentType:"application/x-www-form-urlencoded; charset=utf-8"
});
var DataDeal = {
    formToJson:function (data) {
        data=data.replace(/&/g,"\",\"");
        data=data.replace(/=/g,"\":\"");
        data="{\""+data+"\"}";
        return data;
    },
}