var toFirstPage = "first";
var toPreviousPage = "previous";
var toNextPage = "next";
var toLastPage = "last";
var changePageSize = "change";
var goToPage = "jump";
var refreshPage = "refresh";

$(function () {
    $.Page = function (elem,config) {

    }
    $.extend($.Page,{
        pageProcess:function (baseUrl,pageNumber,pageSize) {
            var url = baseUrl+$.Page.getSearchConditionUrl()+"&@pageNumber="+pageNumber+"&@pageSize="+pageSize;
            location.href=url;
        },

        // toFirstPage:function (baseUrl,pageSize) {
        //     var url = baseUrl+$.Page.getSearchConditionUrl()+"&pageSize="+pageSize+"&operation="+toFirstPage;
        //     location.href=url;
        // },
        //
        // toPreviousPage:function (baseUrl,pageSize,currentPage) {
        //     var url = baseUrl+$.Page.getSearchConditionUrl()+"&pageSize="+pageSize+"&operation=" +toPreviousPage
        //         +"&currentPage="+currentPage;
        //     location.href=url;
        // },
        //
        // toNextPage:function (baseUrl,pageSize,currentPage) {
        //     var url = baseUrl+$.Page.getSearchConditionUrl()+"&pageSize="+pageSize+"&operation=" +toNextPage
        //         +"&currentPage="+currentPage;
        //     location.href=url;
        // },
        //
        // toLastPage:function (baseUrl,pageSize,totalPages) {
        //     var url = baseUrl+$.Page.getSearchConditionUrl()+"&pageSize="+pageSize+"&operation=" +toLastPage
        //         +"&totalPages="+totalPages;
        //     location.href=url;
        // },
        //
        // goToPage:function (baseUrl,targetPage,pageSize) {
        //     var url = baseUrl+$.Page.getSearchConditionUrl()+"&pageSize="+pageSize+"&targetPage="+targetPage+"&operation=" +goToPage;
        //     location.href=url;
        // },
        //
        // changePageSize:function (baseUrl,pageSize,currentPage) {
        //     var url = baseUrl+$.Page.getSearchConditionUrl()+"&pageSize="+pageSize+"&operation=" +changePageSize
        //         + "&currentPage="+currentPage;
        //     location.href=url;
        // },

        Search:function (baseUrl,pageSize) {

            var url = baseUrl+$.Page.getSearchConditionUrl();
            location.href=url;
        },

        getSearchConditionUrl:function () {
            var condition = $("#search").serialize();
            var url = decodeURIComponent(condition,true);
            return url;
        },

        test:function () {
            var bookName = $('#bookName').val();
            var bookCode = $('#bookCode').val();
            var data={"bookName":bookName,"bookCode":bookCode};
            var url = "/book/test";
            var json =$.toJSON(data);
            $.common.ajaxAction(url,json);
        },
        alert:function (data) {
            $.Page.getSearchConditionUrl(data)
        }
    })
});