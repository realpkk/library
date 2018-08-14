<%@ page import="org.apache.coyote.Response" %>
<!DOCTYPE html>
<html>
<%@ page pageEncoding="UTF-8" contentType="text/html;charset=UTF-8"%>
<%@ include file="/WEB-INF/tag/taglib.jsp"%>
<%
    response.setHeader("Pragma","no-cache");
    response.setHeader("Cache-Control","no-cache");
    response.setDateHeader("Expires", 0);
    response.setHeader("Cache-Control", "no-store");
%>
<head>
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1" />
    <meta http-equiv="Content-Type" content="text/html;charset=UTF-8">
    <meta charset="utf-8" />
    <title>BookInfo</title>
    <meta name="description" content="Restyling jQuery UI Widgets and Elements" />
    <meta name="viewport" content="width=device-width, initial-scale=1.0, maximum-scale=1.0" />
    <link rel="stylesheet" href="../../static/css/bootstrap.min.css" />
    <link rel="stylesheet" href="../../static/css/font-awesome.min.css" />
    <link rel="stylesheet" href="../../static/css/jquery-ui.custom.min.css">
    <!-- page specific plugin styles -->
    <link rel="stylesheet" href="../../static/css/jquery-ui.min.css" />
    <link rel="stylesheet" href="../../static/css/datepicker.css" />
    <link rel="stylesheet" href="../../static/css/ui.jqgrid.css" />
    <link rel="stylesheet" href="../../static/css/ace-fonts.css" />
    <link rel="stylesheet" href="../../static/css/ace.min.css" id="main-ace-style" />
    <!--[if lte IE 9]>
    <link rel="stylesheet" href="../../static/css/ace-part2.min.css"/>
    <![endif]-->
    <!--[if lte IE 9]>
    <link rel="stylesheet" href="../../static/css/ace-ie.min.css"/>
    <![endif]-->
    <script src="../../static/js/ace-extra.min.js"></script>
    <!--[if lte IE 8]>
    <script src="../../static/js/html5shiv.min.js"></script>
    <script src="../../static/js/respond.min.js"></script>
    <![endif]-->
    <style type="text/css">
        .CSSearchTbl{ border:1px #008CD4 solid;}
        .CSSearchTbl thead{}
        .CSSearchTbl thead tr{}
        .CSSearchTbl thead tr th{  text-align:left; padding-left:10px;}
        .CSSearchTbl tbody{}
        .CSSearchTbl tbody tr{}
        .CSSearchTbl tbody tr td{  padding: 10px;}
        .CSSearchTbl tbody tr td.right{ text-align: left;}
        .CSSearchTbl tbody tr td.left{ text-align: right;}
        .table-responsive{ display: none;}
    </style>
</head>

<body class="no-skin">

<!-- #section:basics/navbar.layout -->
<div id="navbar" class="navbar navbar-default"></div>

<!-- /section:basics/navbar.layout -->
<div class="main-container" id="main-container">

    <!-- #section:basics/sidebar -->
    <div id="sidebar" class="sidebar responsive"></div>

    <!-- /section:basics/sidebar -->
    <div class="main-content">
        <div class="breadcrumbs" id="breadcrumbs">
            <ul class="breadcrumb">
                <li>
                    <i class="ace-icon fa fa-home home-icon"></i>
                    <a href="/homepage">首页</a>
                </li>
                <li>
                    <a href="javascript:void(0)">表格</a>
                </li>
                <li>
                    <a href="elements.html">图书信息</a>
                </li>
            </ul><!-- /.breadcrumb -->

            <!-- #section:basics/content.searchbox -->
        </div>

        <!-- /section:basics/content.breadcrumbs -->
        <div class="page-content" id="page-content">
            <div class="page-content-area">

                <div class="row">
                    <div class="col-xs-12">
                        <!-- PAGE CONTENT BEGINS -->
                        <!-- /.row -->

                        <div class="row">
                            <div class="col-xs-12">

                                <div class="table-header">
                                    图书信息
                                </div>
                                <form id="search">
                                    <table width="100%" class="CSSearchTbl" cellpadding="0" cellspacing="0" id="searchTable">
                                        <tr>
                                            <td class="left">
                                                图书书名：
                                            </td>
                                            <td class="right">
                                                <input type="text" size="25" id="bookName" name="bookName__S_LIKE" value="${param.bookName__S_LIKE}"/>
                                            </td>
                                            <td class="left">图书编码：</td>
                                            <td class="right"><input type="text" size="16" id="bookCode" name="bookCode__S_EQ" value="${param.bookCode__S_EQ}"/></td>
                                            <td class="left">库存情况：</td>
                                            <td class="right">
                                                <select id="inventoryStatus" name="inventoryStatus__I_EQ">
                                                    <option value="">全部</option>
                                                    <option value="0"<c:if test="${param.inventoryStatus__I_EQ eq '0'}">selected="selected"</c:if>>无库存</option>
                                                    <option value="1"<c:if test="${param.inventoryStatus__I_EQ eq '1'}">selected="selected"</c:if>>有库存</option>
                                                </select>
                                            </td>
                                            <td class="left">订购支持：</td>
                                            <td class="right">
                                                <select id="orderSupport" name="orderSupport__I_EQ">
                                                    <option value="">全部</option>
                                                    <option value="0"<c:if test="${param.orderSupport__I_EQ eq '0'}">selected="selected"</c:if>>期刊订阅</option>
                                                    <option value="1"<c:if test="${param.orderSupport__I_EQ eq '1'}">selected="selected"</c:if>>整书购买</option>
                                                </select>
                                            </td>
                                            <td class="right" colspan="2">
                                                <button type="button" class="btn btn-primary pull-left col-sm-12 tbl-search" data-dismiss="modal"
                                                        onclick="$.Page.Search('${searchUrlBook}',$('#pageSize').val());return false;">
                                                    开始搜索
                                                    <i class="ace-icon fa fa-search"></i>
                                                </button>
                                            </td>
                                        </tr>
                                    </table>
                                </form>


                                <div class="hr hr-18 dotted hr-double"></div>

                                <table id="content" class="table table-striped table-bordered table-hover">
                                    <thead>
                                    <tr>
                                        <th>序号</th>
                                        <th>图书书名</th>
                                        <th>图书编码</th>
                                        <th>图书总数</th>
                                        <th>图书库存</th>
                                        <th>入库时间</th>
                                        <th>订购支持</th>
                                        <th>操作</th>
                                    </tr>
                                    </thead>

                                    <tbody>
                                    <c:forEach items="${page.content}" var="book" varStatus="status">
                                        <tr>
                                            <td>${status.index+1}</td>
                                            <td>${book.bookName}</td>
                                            <td>${book.bookCode}</td>
                                            <td>${book.bookAmount}</td>
                                            <td>
                                                <c:if test="${book.bookRemain eq 0}">
                                                    <span class="label label-sm label-danger">无库存</span>
                                                </c:if>
                                                <c:if test="${ book.bookRemain ne 0}">
                                                    ${book.bookRemain}
                                                </c:if>
                                            </td>
                                            <td>${book.createTime}</td>
                                            <td>
                                                <c:if test="${book.orderSupport eq 0}">
                                                    <span class="label label-sm label-warning">期刊订阅</span>
                                                </c:if>
                                                <c:if test="${book.orderSupport eq 1}">
                                                    <span class="label label-sm label-success">整书购买</span>
                                                </c:if>
                                            </td>
                                            <td>
                                                <div class="hidden-sm hidden-xs btn-group">
                                                    <button class="btn btn-xs btn-info" style="margin-right: 5px;margin-left: 5px"
                                                            onclick="$.dialog.edit('${book.bookName}','${book.bookCode}','${book.bookAmount}','${book.bookRemain}','${book.orderSupport}');">
                                                        <i class="ace-icon fa fa-pencil bigger-130">编辑</i>
                                                    </button>
                                                    <button class="btn btn-xs btn-danger" style="margin-left: 5px;margin-right: 5px"
                                                            onclick="$.dialog.delete('${book.bookCode}');">
                                                        <i class="ace-icon fa fa-trash-o bigger-130">删除</i>
                                                    </button>
                                                    <c:if test="${book.bookRemain ne 0}">
                                                        <c:if test="${book.orderSupport eq 0}">
                                                            <button class="btn btn-xs btn-warning" style="margin-left: 5px;margin-right: 5px"
                                                                    onclick="$.dialog.order('${book.bookCode}','${book.bookName}','${book.bookRemain}',1)">
                                                                <i class="ace-icon fa fa-book bigger-130">期刊订阅</i>
                                                            </button>
                                                        </c:if>
                                                        <c:if test="${book.orderSupport eq 1}">
                                                            <button class="btn btn-xs btn-success" style="margin-left: 5px;margin-right: 5px"
                                                                    onclick="$.dialog.order('${book.bookCode}','${book.bookName}','${book.bookRemain}',2,'${user.loginName}');">
                                                                <i class="ace-icon fa fa-shopping-cart bigger-130">整书购买</i>
                                                            </button>
                                                        </c:if>
                                                    </c:if>
                                                    <shiro:hasPermission name="info:book:order">

                                                    </shiro:hasPermission>
                                                    <shiro:hasPermission name="info:book:edit">

                                                    </shiro:hasPermission>
                                                    <shiro:hasPermission name="info:book:delete">

                                                    </shiro:hasPermission>
                                                </div>
                                            </td>
                                        </tr>

                                    </c:forEach>
                                    </tbody>
                                </table>

                                <div class="modal-footer no-margin-top">

                                    <ul class="pagination col-xs-5 no-margin">
                                        <li>
                                            <a>
                                                页面大小：
                                                <select id="pageSize" name="pageSize" onchange="$.Page.pageProcess('${pageUrlBook}','${page.number}',$('#pageSize').val());">
                                                    <option value="10" <c:if test="${page.size eq 10}"> selected="selected"</c:if>>10</option>
                                                    <option value="20" <c:if test="${page.size eq 20}"> selected="selected"</c:if>>20</option>
                                                    <option value="50" <c:if test="${page.size eq 50}"> selected="selected"</c:if>>50</option>
                                                </select>
                                            </a>
                                        </li>
                                    </ul>
                                    <ul class="pagination col-xs-4 no-margin">
                                        <li <c:if test="${page.number eq 0}">class="prev disabled" </c:if>>
                                            <a href="javascript:;" <c:if test="${page.number ne 0}">
                                                onclick="$.Page.pageProcess('${pageUrlBook}',0,$('#pageSize').val());"</c:if>>
                                                <i class="ace-icon fa fa-angle-double-left"></i>
                                            </a>
                                        </li>
                                        <li <c:if test="${page.number eq 0}">class="prev disabled" </c:if>>
                                            <a href="javascript:;" <c:if test="${page.number ne 0}">
                                                onclick="$.Page.pageProcess('${pageUrlBook}','${page.number-1}',$('#pageSize').val());"</c:if>>
                                                <i class="ace-icon fa fa-angle-left"></i>
                                            </a>
                                        </li>

                                        <li class="active">
                                            <a id="currentPage">${page.number+1} </a><a>of ${page.totalPages}</a>
                                        </li>
                                        <li <c:if test="${page.number+1 eq page.totalPages}">class="next disabled" </c:if>>
                                            <a href="javascript:;"<c:if test="${page.number+1 ne page.totalPages}">
                                                onclick="$.Page.pageProcess('${pageUrlBook}','${page.number+1}',$('#pageSize').val());"></c:if>
                                            <i class="ace-icon fa fa-angle-right"></i>
                                            </a>
                                        </li>
                                        <li <c:if test="${page.number+1 eq page.totalPages}">class="next disabled" style="" </c:if>>
                                            <a href="javascript:;" <c:if test="${page.number+1 ne page.totalPages}">
                                                onclick="$.Page.pageProcess('${pageUrlBook}','${page.totalPages-1}',$('#pageSize').val());"></c:if>
                                            <i class="ace-icon fa fa-angle-double-right"></i>
                                            </a>
                                        </li>


                                    </ul>
                                    <ul class="pagination col-xs no-margin">
                                        <li>
                                            <a>
                                                跳转：
                                                <select style="height: 30px" id="targetPage">
                                                    <c:forEach var="i" begin="1" end="${page.totalPages}" step="1">
                                                        <option <c:if test="${i eq page.number+1}"> selected="selected"</c:if> value="${i-1}">${i}</option>
                                                    </c:forEach>
                                                </select>
                                            </a>
                                            <a>
                                                <button class="label label-lg label-info arrowed-in-right arrowed"
                                                        onclick="$.Page.pageProcess('${pageUrlBook}',$('#targetPage').val(),$('#pageSize').val());">跳转</button>
                                            </a>
                                        </li>
                                    </ul>
                                </div>

                            </div>
                        </div>

                        <!-- PAGE CONTENT ENDS -->
                        <!-- #section:plugins/misc.bootbox -->
                    </div><!-- /.col -->
                </div><!-- /.row -->
            </div>
        </div>
        <!-- /.page-content -->
    </div><!-- /.main-content -->
    <div class="footer">
        <div class="footer-inner">
            <!-- #section:basics/footer -->
            <div class="footer-content">
						<span class="bigger-120">
							 图书管理系统 &copy; 2018
						</span>
            </div>

            <!-- /section:basics/footer -->
        </div>
    </div>

</div><!-- /.main-container -->

<!-- basic scripts -->

<!--[if !IE]> -->
<script type="text/javascript">
    window.jQuery || document.write("<script src='../../static/js/jquery.min.js'>"+"<"+"/script>");
</script>

<!-- <![endif]-->

<!--[if IE]>
<script type="text/javascript">
    window.jQuery || document.write("<script src='static/js/jquery1x.min.js'>"+"<"+"/script>");
</script>
<![endif]-->
<script type="text/javascript">
    if('ontouchstart' in document.documentElement) document.write("<script src='../../static/js/jquery.mobile.custom.min.js'>"+"<"+"/script>");
</script>
<script src="../../static/js/bootstrap.min.js"></script>

<!-- page specific plugin scripts -->
<script src="../../static/js/bootstrap-datepicker.min.js"></script>
<script src="../../static/js/jquery.jqGrid.min.js"></script>
<script src="../../static/js/grid.locale-en.js"></script>
<script src="../../static/js/bootbox.min.js"></script>
<script src="../../static/js/jquery-ui.min.js"></script>
<script src="../../static/js/jquery.ui.touch-punch.min.js"></script>

<!-- ace scripts -->
<script src="../../static/js/ace-elements.min.js"></script>
<script src="../../static/js/ace.min.js"></script>

<!-- page -->
<script src="../../static/js/jquery.json.min.js"></script>
<script src="../../static/js/custom/common.js"></script>
<script src="../../static/js/custom/page.js"></script>
<script src="../../static/js/custom/book/controller.js"></script>
<script src="../../static/js/custom/book/dialog.js"></script>
<script>
    jQuery(function($) {

        $(".datepicker").datepicker({
            showOtherMonths: true,
            selectOtherMonths: false,
        });
    })
</script>
<script>
    $("#navbar").load("/index/navbar",function () {
    });
    $("#sidebar").load("/index/sidebar",function () {
    });
</script>
</body>
</html>
