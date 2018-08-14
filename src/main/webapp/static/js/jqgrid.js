var subgrid_data =[{bookCode:"001-1",bookName:"first",orderUsername:"kk"}];
$(function () {
    pageInit();
});
function pageInit() {
//resize to fit page size
    $(window).on('resize.jqGrid', function () {
        $("#grid-table").jqGrid( 'setGridWidth', $(".page-content").width() );
    })
    //resize on sidebar collapse/expand
    var parent_column = $("#grid-table").closest('[class*="col-"]');
    $(document).on('settings.ace.jqGrid' , function(ev, event_name, collapsed) {
        if( event_name === 'sidebar_collapsed' || event_name === 'main_container_fixed' ) {
            //setTimeout is for webkit only to give time for DOM changes and then redraw!!!
            setTimeout(function() {
                $("#grid-table").jqGrid( 'setGridWidth', parent_column.width() );
            }, 0);
        }
    })

    jQuery("#grid-table").jqGrid({
        url:"/book/list",
        datatype:"json",
        height:"50%",
        width:1000,
        colNames:[ '书名','编码','总数', '库存','入库时间 ', '是否支持订购'],
        colModel:[
            {name:'bookName',index:'bookName', width:180, editable: true,editoptions:{size:"20",maxlength:"30"},align:"center"},
            {name:'bookCode',index:'bookCode',width:180, editable: true,editoptions:{size:"20",maxlength:"30"},align:"center"},
            {name:'bookAmount',index:'BookAmount', width:100,editable: true,editoptions:{size:"20",maxlength:"30"},align:"center"},
            {name:'bookRemain',index:'bookRemain', width:100, editable: true,editoptions:{size:"20",maxlength:"30"},align:"center"},
            {name:'createTime',index:'createTime', width:250, editable: false,editoptions:{size:"20",maxlength:"30"},align:"center"},
            {name:'orderSupport',index:'orderSupport', width:100, editable: true,edittype:"select",editoptions:{value:"0:只借阅;1:可订阅",size:"20",maxlength:"30"},align:"center",
            formatter:orderSuppportFmatter},
        ],
        rowNum:10,
        rowList:[10,20,30],
        viewrecords:true,
        rownumbers:true,
        rownummberWidth:40,
        pager:"#grid-pager",
        altRows:true,
        editurl:"/book/operation",
        loadComplete:function () {
            var table=this;
            setTimeout(function () {
                updatePagerIcons(table);
                enableTooltips(table)
            },0);
        },
        subGrid:true,
        subGridOptions : {
            plusicon : "ace-icon fa fa-plus center bigger-110 blue",
            minusicon  : "ace-icon fa fa-minus center bigger-110 blue",
            openicon : "ace-icon fa fa-chevron-right center orange"
        },
        subGridRowExpanded: function (subGridDivId, rowId) {
            var subGridTableId = subGridDivId + "_t";
            $("#" + subGridDivId).html("<table id='" + subGridTableId + "'></table>");
            $("#" + subGridTableId).jqGrid({
                url:"/book/detail?bookName="+getBookName(rowId),
                datatype: 'json',
                colNames: ['编码','借阅者'],
                colModel: [
                    { name: 'bookCode', width: 190 },
                    { name: 'orderUsername', width: 190 }
                ],
                jsonReader:{
                    root:"detailBooks",repeatitems:false
                }
            });
        },
        caption:"book info",
        jsonReader:{
            root:"books",total:"totalPages",records:"count",repeatitems:false
        }
    });
    $(window).triggerHandler('resize.jqGrid');//trigger window resize to make the grid get the correct size
    function orderSuppportFmatter(cellvalue,options,rowObject) {
        if(cellvalue == 1){cellvalue="只借阅";}
        if(cellvalue == 0){cellvalue="可订购";}
        return cellvalue;
    }
    function getBookName(rowId) {
        var rowData = $("#grid-table").jqGrid("getRowData",rowId);
        var bookName = rowData.bookName;
        return bookName;
    }
    //navButtons
    jQuery("#grid-table").jqGrid('navGrid',"#grid-pager",
        { 	//navbar options
            edit: true,
            editicon : 'ace-icon fa fa-pencil blue',
            add: true,
            addicon : 'ace-icon fa fa-plus-circle purple',
            del: true,
            delicon : 'ace-icon fa fa-trash-o red',
            search: true,
            searchicon : 'ace-icon fa fa-search orange',
            refresh: true,
            refreshicon : 'ace-icon fa fa-refresh green',
            view: true,
            viewicon : 'ace-icon fa fa-search-plus grey',
        },
        {
            //edit record form
            //closeAfterEdit: true,
            //width: 700,
            recreateForm: true,
            beforeShowForm : function(e) {
                var form = $(e[0]);
                form.closest('.ui-jqdialog').find('.ui-jqdialog-titlebar').wrapInner('<div class="widget-header" />');
                form.find("#bookCode").attr("readOnly",true);
                style_edit_form(form);
            }
        },
        {
            //new record form
            //width: 700,
            closeAfterAdd: true,
            recreateForm: true,
            viewPagerButtons: false,
            beforeShowForm : function(e) {
                var form = $(e[0]);
                form.closest('.ui-jqdialog').find('.ui-jqdialog-titlebar')
                    .wrapInner('<div class="widget-header" />')
                style_edit_form(form);
            }
        },
        {
            //delete record form
            recreateForm: true,
            beforeShowForm : function(e) {
                var form = $(e[0]);
                if(form.data('styled')) return false;

                form.closest('.ui-jqdialog').find('.ui-jqdialog-titlebar').wrapInner('<div class="widget-header" />')
                style_delete_form(form);

                form.data('styled', true);
            },
            onClick : function(e) {
                alert(1);
            }
        },
        {
            //search form
            recreateForm: true,
            afterShowSearch: function(e){
                var form = $(e[0]);
                form.closest('.ui-jqdialog').find('.ui-jqdialog-title').wrap('<div class="widget-header" />')
                style_search_form(form);
            },
            afterRedraw: function(){
                style_search_filters($(this));
            }
            ,
            multipleSearch: true,
            /**
             multipleGroup:true,
             showQuery: true
             */
        },
        {
            //view record form
            recreateForm: true,
            beforeShowForm: function(e){
                var form = $(e[0]);
                form.closest('.ui-jqdialog').find('.ui-jqdialog-title').wrap('<div class="widget-header" />')
            }
        }
        );
    //replace icons with FontAwesome icons like above
    function updatePagerIcons(table) {
        var replacement =
            {
                'ui-icon-seek-first' : 'ace-icon fa fa-angle-double-left bigger-140',
                'ui-icon-seek-prev' : 'ace-icon fa fa-angle-left bigger-140',
                'ui-icon-seek-next' : 'ace-icon fa fa-angle-right bigger-140',
                'ui-icon-seek-end' : 'ace-icon fa fa-angle-double-right bigger-140'
            };
        $('.ui-pg-table:not(.navtable) > tbody > tr > .ui-pg-button > .ui-icon').each(function(){
            var icon = $(this);
            var $class = $.trim(icon.attr('class').replace('ui-icon', ''));

            if($class in replacement) icon.attr('class', 'ui-icon '+replacement[$class]);
        })
    }
    function style_edit_form(form) {
        //enable datepicker on "sdate" field and switches for "stock" field
        form.find('input[name=sdate]').datepicker({format:'yyyy-mm-dd' , autoclose:true})
            .end().find('input[name=stock]')
            .addClass('ace ace-switch ace-switch-5').after('<span class="lbl"></span>');
        //don't wrap inside a label element, the checkbox value won't be submitted (POST'ed)
        //.addClass('ace ace-switch ace-switch-5').wrap('<label class="inline" />').after('<span class="lbl"></span>');

        //update buttons classes
        var buttons = form.next().find('.EditButton .fm-button');
        buttons.addClass('btn btn-sm').find('[class*="-icon"]').hide();//ui-icon, s-icon
        buttons.eq(0).addClass('btn-primary').prepend('<i class="ace-icon fa fa-check"></i>');
        buttons.eq(1).prepend('<i class="ace-icon fa fa-times"></i>')

        buttons = form.next().find('.navButton a');
        buttons.find('.ui-icon').hide();
        buttons.eq(0).append('<i class="ace-icon fa fa-chevron-left"></i>');
        buttons.eq(1).append('<i class="ace-icon fa fa-chevron-right"></i>');
    }

    function style_delete_form(form) {
        var buttons = form.next().find('.EditButton .fm-button');
        buttons.addClass('btn btn-sm btn-white btn-round').find('[class*="-icon"]').hide();//ui-icon, s-icon
        buttons.eq(0).addClass('btn-danger').prepend('<i class="ace-icon fa fa-trash-o"></i>');
        buttons.eq(1).addClass('btn-default').prepend('<i class="ace-icon fa fa-times"></i>')
    }

    function style_search_filters(form) {
        form.find('.delete-rule').val('X');
        form.find('.add-rule').addClass('btn btn-xs btn-primary');
        form.find('.add-group').addClass('btn btn-xs btn-success');
        form.find('.delete-group').addClass('btn btn-xs btn-danger');
    }
    function style_search_form(form) {
        var dialog = form.closest('.ui-jqdialog');
        var buttons = dialog.find('.EditTable');
        buttons.find('.EditButton a[id*="_reset"]').addClass('btn btn-sm btn-info').find('.ui-icon').attr('class', 'ace-icon fa fa-retweet');
        buttons.find('.EditButton a[id*="_query"]').addClass('btn btn-sm btn-inverse').find('.ui-icon').attr('class', 'ace-icon fa fa-comment-o');
        buttons.find('.EditButton a[id*="_search"]').addClass('btn btn-sm btn-purple').find('.ui-icon').attr('class', 'ace-icon fa fa-search');
    }
    function enableTooltips(table) {
        $('.navtable .ui-pg-button').tooltip({container:'body'});
        $(table).find('.ui-pg-div').tooltip({container:'body'});
    }

}