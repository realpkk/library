<!DOCTYPE html>
<html>
<%@ page contentType="text/html;charset=UTF-8"%>
<%@include file="/WEB-INF/tag/taglib.jsp"%>
<%
    response.setHeader("Pragma","no-cache");
    response.setHeader("Cache-Control","no-cache");
    response.setDateHeader("Expires", 0);
    response.setHeader("Cache-Control", "no-store");
%>
<head>
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1" />
    <meta charset="utf-8" />
    <title>BookInfo</title>
    <meta name="description" content="Restyling jQuery UI Widgets and Elements" />
    <meta name="viewport" content="width=device-width, initial-scale=1.0, maximum-scale=1.0" />
    <link rel="stylesheet" href="../../static/css/bootstrap.min.css" />
    <link rel="stylesheet" href="../../static/css/font-awesome.min.css" />
    <link rel="stylesheet" href="../../static/css/jquery-ui.custom.min.css">
    <!-- page specific plugin styles -->
    <link rel="stylesheet" href="../../static/css/jquery-ui.min.css" />
    <link rel="stylesheet" href="../../static/css/ui.jqgrid.css" />
    <link rel="stylesheet" href="../../static/css/ace-fonts.css" />
    <link rel="stylesheet" href="../../static/css/ace.min.css" id="main-ace-style" />
    <!-- date picker -->
    <link rel="stylesheet" href="../../static/css/datepicker.css">
    <link rel="stylesheet" href="../../static/css/daterangepicker.css">
    <link rel="stylesheet" href="../../static/css/bootstrap-datetimepicker.css">
    <link rel="stylesheet" href="../../static/css/bootstrap-timepicker.css">
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
<div id="navbar" class="navbar navbar-default">

    <div class="navbar-container" id="navbar-container">
        <button type="button" class="navbar-toggle menu-toggler pull-left" id="menu-toggler">
            <span class="icon-bar"></span>

            <span class="icon-bar"></span>

            <span class="icon-bar"></span>
        </button>

        <div class="navbar-header pull-left">
            <!-- #section:basics/navbar.layout.brand -->
            <a href="index.html" class="navbar-brand">
                <small>
                    <!--logo-->
                </small>
            </a>
        </div>

        <!-- #section:basics/navbar.dropdown -->
        <div class="navbar-buttons navbar-header pull-right" role="navigation">
            <ul class="nav ace-nav">

                <li class="green">
                    <a data-toggle="dropdown" class="dropdown-toggle" href="#">
                        <i class="ace-icon fa fa-envelope icon-animated-vertical"></i>
                        <span class="badge badge-success">5</span>
                    </a>

                    <ul class="dropdown-menu-right dropdown-navbar dropdown-menu dropdown-caret dropdown-close">
                        <li class="dropdown-header">
                            <i class="ace-icon fa fa-envelope-o"></i>
                            13条未读信息
                        </li>

                        <li class="dropdown-content">
                            <ul class="dropdown-menu dropdown-navbar">
                                <li>
                                    <a href="#">
                                        <%--<img src="../../static/avatars/avatar.png" class="msg-photo" alt="Alex's Avatar" />--%>
                                        <span class="msg-body">
													<span class="msg-title">
														<span class="blue">B2C:</span>
														系统产生20个错误，12个警告...
													</span>

													<span class="msg-time">
														<i class="ace-icon fa fa-clock-o"></i>
														<span>2014-12-15 18:00:00</span>
													</span>
												</span>
                                    </a>
                                </li>

                            </ul>
                        </li>

                        <li class="dropdown-footer">
                            <a href="inbox.html">
                                查看全部消息
                                <i class="ace-icon fa fa-arrow-right"></i>
                            </a>
                        </li>
                    </ul>
                </li>

                <!-- #section:basics/navbar.user_menu -->
                <li class="light-blue">
                    <a data-toggle="dropdown" href="#" class="dropdown-toggle">
                        <img class="nav-user-photo" src="../../static/imgs/user.jpg" alt="Jason's Photo" />
                        <span class="user-info">
									欢迎您<br />
									${user.username}
								</span>

                        <i class="ace-icon fa fa-caret-down"></i>
                    </a>

                    <ul class="user-menu dropdown-menu-right dropdown-menu dropdown-yellow dropdown-caret dropdown-close">
                        <li>
                            <a href="#">
                                <i class="ace-icon fa fa-cog"></i>
                                系统设置
                            </a>
                        </li>

                        <li>
                            <a href="profile.html">
                                <i class="ace-icon fa fa-user"></i>
                                个人信息设置
                            </a>
                        </li>

                        <li class="divider"></li>

                        <li>
                            <a href="/logout">
                                <i class="ace-icon fa fa-power-off"></i>
                                登出
                            </a>
                        </li>
                    </ul>
                </li>

                <!-- /section:basics/navbar.user_menu -->
            </ul>
        </div>

        <!-- /section:basics/navbar.dropdown -->
    </div><!-- /.navbar-container -->
</div>

<!-- /section:basics/navbar.layout -->
<div class="main-container" id="main-container">

    <!-- #section:basics/sidebar -->
    <div id="sidebar" class="sidebar responsive">

        <ul class="nav nav-list">
            <li class="active">
                <a href="/menu">
                    <i class="menu-icon fa fa-tachometer"></i>
                    <span class="menu-text"> 首页 </span>
                </a>

                <b class="arrow"></b>
            </li>
            <!--菜单实例-->
            <li class="active">
                <a href="#" class="dropdown-toggle">
                    <i class="menu-icon fa fa-desktop"></i>
                    <span class="menu-text"> UI &amp; 元素 </span>

                    <b class="arrow fa fa-angle-down"></b>
                </a>

                <b class="arrow"></b>

                <ul class="submenu">

                    <li class="active">
                        <a href="/book">
                            <i class="menu-icon fa fa-caret-right"></i>
                            book
                        </a>

                        <b class="arrow"></b>
                    </li>

                </ul>
            </li>

            <c:forEach items="${menuList}" var="menu">
                <li class="">
                    <a href="#" class="dropdown-toggle">
                        <i class="menu-icon fa fa-desktop"></i>
                        <span class="menu-text"> ${menu.menuName} </span>

                        <b class="arrow fa fa-angle-down"></b>
                    </a>

                    <b class="arrow"></b>
                    <ul class="submenu">
                        <c:forEach items="${menu.menuList}" var="childMenu">
                            <li class="">
                                <a href="#">
                                    <i class="menu-icon fa fa-caret-right"></i>
                                        ${childMenu.menuName}
                                </a>
                                <b class="arrow"></b>
                            </li>
                        </c:forEach>
                    </ul>

                </li>
            </c:forEach>

        </ul><!-- /.nav-list -->


        <div class="sidebar-toggle sidebar-collapse" id="sidebar-collapse">
            <i class="ace-icon fa fa-angle-double-left" data-icon1="ace-icon fa fa-angle-double-left" data-icon2="ace-icon fa fa-angle-double-right"></i>
        </div>

    </div>

    <!-- /section:basics/sidebar -->
    <div class="main-content">
        <div class="breadcrumbs" id="breadcrumbs">
            <ul class="breadcrumb">
                <li>
                    <i class="ace-icon fa fa-home home-icon"></i>
                    <a href="/homepage">首页</a>
                </li>
                <li>
                    <a href="javascript:void(0)">订单管理</a>
                </li>
                <li>
                    <a href="/afterSale">售后处理</a>
                </li>
            </ul><!-- /.breadcrumb -->

            <!-- #section:basics/content.searchbox -->
        </div>

        <!-- /section:basics/content.breadcrumbs -->
        <div class="page-content">

            <div class="page-content-area">

                <div class="row">
                    <div class="col-xs-12">
                        <!-- PAGE CONTENT BEGINS -->
                        <!-- /.row -->

                        <div class="row">
                            <div class="col-xs-12">

                                <div class="table-header">
                                    信息
                                </div>
                                <form id="search">
                                    <table width="100%" class="CSSearchTbl" cellpadding="0" cellspacing="0" id="searchTable">
                                        <tr>
                                            <td class="left">
                                                图书书名：
                                            </td>
                                            <td class="right">
                                                <input type="text" size="25"  name="bookName__S_LIKE" value="${param.bookName__S_LIKE}"/>
                                            </td>
                                            <td class="left col-lg-1">图书编码：</td>
                                            <td class="right"><input type="text" size="16" name="bookCode__S_LIKE" value="${param.bookCode__S_LIKE}"/></td>
                                            <td class="left">类型：</td>
                                            <td class="right">
                                                <select id="type" name="type__I_EQ">
                                                    <option value="">全部</option>
                                                    <option value="1"<c:if test="${param.type__I_EQ eq '1'}">selected="selected"</c:if>>退款</option>
                                                    <option value="2"<c:if test="${param.type__I_EQ eq '2'}">selected="selected"</c:if>>退订</option>
                                                </select>
                                            </td>
                                            <td class="left">
                                                处理进度
                                            </td>
                                            <td class="right">
                                                <select  name="approvalStatus__I_EQ">
                                                    <option value="">全部</option>
                                                    <option value="1"<c:if test="${param.approvalStatus__I_EQ eq '1'}">selected="selected"</c:if>>处理中</option>
                                                    <option value="2"<c:if test="${param.approvalStatus__I_EQ eq '2'}">selected="selected"</c:if>>已通过</option>
                                                    <option value="3"<c:if test="${param.approvalStatus__I_EQ eq '3'}">selected="selected"</c:if>>已驳回</option>
                                                </select>
                                            </td>
                                        </tr>
                                        <tr>
                                            <td class="left">
                                                <label>申请时间</label>
                                            </td>
                                            <td colspan="2">
                                                <div class="input-daterange input-group">
                                                    <input type="text" class=" form-control" id="startTime" name="createTime__D_GTE" value="${param.createTime__D_GTE}"/>
                                                    <span class="input-group-addon"><i class="fa fa-exchange"></i></span>
                                                    <input type="text" class=" form-control"  id="endTime" name="createTime__D_LTE" value="${param.createTime__D_LTE}">
                                                </div>
                                            </td>
                                            <td class="left">
                                            申请人：
                                            </td>
                                            <td class="right">
                                            <input type="text" size="16" name="applicationLauncher__S_EQ" value="${param.applicationLauncher__S_EQ}"/>
                                            </td>
                                            <td class="left">
                                            流水号：
                                            </td>
                                            <td class="right">
                                            <input type="text" size="16" name="applicationCode__S_EQ" value="${param.applicationCode__S_EQ}"/>
                                            </td>
                                            <td class="right">
                                                <button class="btn btn-primary pull-left col-sm-12 tbl-search" data-dismiss="modal"
                                                        onclick="$.Page.Search('${searchUrlAfterSale}');return false;">
                                                    开始搜索
                                                    <i class="ace-icon fa fa-search"></i>
                                                </button>
                                            </td>
                                        </tr>
                                    </table>
                                </form>

                                <div class="hr hr-18 dotted hr-double"></div>

                                <table id="sample-table-2" class="table table-striped table-bordered table-hover" style="table-layout: fixed;word-break: break-all">
                                    <thead>
                                    <tr>
                                        <th width="50">序号</th>
                                        <th width="60%">申请流水</th>
                                        <th width="80">类型</th>
                                        <th width="60%">订单号</th>
                                        <th width="40%">申请描述</th>
                                        <th width="150">图书编码</th>
                                        <th width="150">图书书名</th>
                                        <th width="150">订单时间</th>
                                        <th width="80">处理进度</th>
                                        <th width="100">申请人</th>
                                        <th width="50%">操作</th>
                                    </tr>
                                    </thead>
                                    <c:if test="${page.totalPages eq 0}">
                                        <td colspan="9" style="text-align: center">无相关记录</td>
                                    </c:if>
                                    <tbody>
                                    <c:forEach items="${page.content}" var="afterSale" varStatus="status">
                                        <tr>
                                            <td>${status.index+1}</td>
                                            <td>${afterSale.applicationCode}</td>
                                            <td>
                                                <c:if test="${afterSale.type eq 1}"><span class="label label-sm label-danger">退款</span></c:if>
                                                <c:if test="${afterSale.type eq 2}"><span class="label label-sm label-warning">退订</span></c:if>
                                            </td>
                                            <td>${afterSale.orderCode}</td>
                                            <td>${afterSale.applicationDescription}</td>
                                            <td>${afterSale.bookCode}</td>
                                            <td>${afterSale.bookName}</td>
                                            <td><fmt:formatDate value="${afterSale.createTime}" pattern="yyyy-MM-dd HH:mm:ss" /></td>
                                            <td>
                                                <c:if test="${afterSale.approvalStatus eq 1}"><span class="label label-sm label-info">受理中</span></c:if>
                                                <c:if test="${afterSale.approvalStatus eq 2}"><span class="label label-sm label-success">已通过</span></c:if>
                                                <c:if test="${afterSale.approvalStatus eq 3}"><span class="label label-sm label-danger">已驳回</span></c:if>
                                            </td>
                                            <td>${afterSale.applicationLauncher}</td>
                                            <td>
                                                <div class="hidden-sm hidden-xs btn-group">
                                                    <shiro:lacksPermission name="afterSale:approve"  >
                                                        <button class="btn btn-xs btn-warning" style="margin-right: 5px;margin-left: 5px"
                                                                onclick ="$.controller.applicationRemind('${afterSale.applicationCode}')">
                                                            <i class="ace-icon fa fa-exclamation bigger-130">提醒审批</i>
                                                        </button>
                                                        <button class="btn btn-xs btn-danger" style="margin-right: 5px;margin-left: 5px"
                                                                onclick="$.controller.cancel('${afterSale.applicationCode}')">
                                                            <i class="ace-icon fa fa-times-circle bigger-130">取消申请</i>
                                                        </button>
                                                    </shiro:lacksPermission>
                                                    <shiro:hasPermission name="afterSale:approve">
                                                        <button class="btn btn-xs btn-success" style="margin-right: 5px;margin-left: 5px"
                                                                onclick="$.controller.pass('${afterSale.applicationCode}')">
                                                            <i class="ace-icon fa fa-check bigger-130">申请通过</i>
                                                        </button>
                                                        <button class="btn btn-xs btn-danger" style="margin-right: 5px;margin-left: 5px"
                                                                onclick="$.dialog.reject('${afterSale.applicationCode}')">
                                                            <i class="ace-icon fa fa-times bigger-130">申请驳回</i>
                                                        </button>
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
                                                <select id="pageSize" name="pageSize" onchange="$.Page.pageProcess('${pageUrlAfterSale}','${page.number}',$('#pageSize').val());">
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
                                                onclick="$.Page.pageProcess('${pageUrlAfterSale}',0,$('#pageSize').val());"</c:if>>
                                                <i class="ace-icon fa fa-angle-double-left"></i>
                                            </a>
                                        </li>
                                        <li <c:if test="${page.number eq 0}">class="prev disabled" </c:if>>
                                            <a href="javascript:;" <c:if test="${page.number ne 0}">
                                                onclick="$.Page.pageProcess('${pageUrlAfterSale}','${page.number-1}',$('#pageSize').val());"</c:if>>
                                                <i class="ace-icon fa fa-angle-left"></i>
                                            </a>
                                        </li>

                                        <li class="active">
                                            <a id="currentPage">${page.number+1} </a><a>of ${page.totalPages}</a>
                                        </li>
                                        <li <c:if test="${page.number+1 eq page.totalPages}">class="next disabled" </c:if>>
                                            <a href="javascript:;"<c:if test="${page.number+1 ne page.totalPages}">
                                                onclick="$.Page.pageProcess('${pageUrlAfterSale}','${page.number+1}',$('#pageSize').val());"></c:if>
                                            <i class="ace-icon fa fa-angle-right"></i>
                                            </a>
                                        </li>

                                        <li <c:if test="${page.number+1 eq page.totalPages}">class="next disabled" style="" </c:if>>
                                            <a href="javascript:;" <c:if test="${page.number+1 ne page.totalPages}">
                                                onclick="$.Page.pageProcess('${pageUrlAfterSale}','${page.totalPages-1}',$('#pageSize').val());"></c:if>
                                            <i class="ace-icon fa fa-angle-double-right"></i>
                                            </a>
                                        </li>


                                    </ul>
                                    <c:if test="${page.totalPages ne 0}">
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
                                                            onclick="$.Page.pageProcess('${pageUrlAfterSale}',$('#targetPage').val(),$('#pageSize').val());">跳转</button>
                                                </a>
                                            </li>
                                        </ul>
                                    </c:if>

                                </div>

                                <div class="table-responsive"></div>
                            </div>
                        </div>

                        <!-- PAGE CONTENT ENDS -->
                        <!-- #section:plugins/misc.bootbox -->

                    </div><!-- /.col -->
                </div><!-- /.row -->
            </div><!-- /.page-content-area -->
        </div><!-- /.page-content -->
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

    <a href="#" id="btn-scroll-up" class="btn-scroll-up btn btn-sm btn-inverse">
        <i class="ace-icon fa fa-angle-double-up icon-only bigger-110"></i>
    </a>
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
<script src="../../static/js/jquery.jqGrid.min.js"></script>
<script src="../../static/js/grid.locale-en.js"></script>
<script src="../../static/js/bootbox.min.js"></script>
<script src="../../static/js/jquery-ui.min.js"></script>
<script src="../../static/js/jquery.ui.touch-punch.min.js"></script>

<!-- time -->
<script src="../../static/js/bootstrap-datepicker.min.js"></script>
<script src="../../static/js/bootstrap-timepicker.min.js"></script>
<script src="../../static/js/moment.min.js"></script>
<script src="../../static/js/daterangepicker.min.js"></script>
<script src="../../static/js/bootstrap-datetimepicker.min.js"></script>

<!-- ace scripts -->
<script src="../../static/js/ace-elements.min.js"></script>
<script src="../../static/js/ace.min.js"></script>

<!-- page -->
<script src="../../static/js/jquery.json.min.js"></script>
<script src="../../static/js/custom/common.js"></script>
<script src="../../static/js/custom/page.js"></script>
<script src="../../static/js/custom/aftersale/controller.js"></script>
<script src="../../static/js/custom/aftersale/dialog.js"></script>
<script>
    jQuery(function($) {

        //link
        $('.date-picker').datepicker({
            autoclose: true,
            todayHighlight: true
        })
        //show datepicker when clicking on the icon
            .next().on(ace.click_event, function(){
            $(this).prev().focus();
        });

        //or change it into a date range picker
        $('.input-daterange').datepicker({autoclose:true});


        //to translate the daterange picker, please copy the "examples/daterange-fr.js" contents here before initialization
        $('input[name=date-range-picker]').daterangepicker({
            'applyClass' : 'btn-sm btn-success',
            'cancelClass' : 'btn-sm btn-default',
            locale: {
                applyLabel: 'Apply',
                cancelLabel: 'Cancel',
            }
        })
            .prev().on(ace.click_event, function(){
            $(this).next().focus();
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
