<!DOCTYPE html>
<html>
<%@ page contentType="text/html;charset=UTF-8"%>
<%@include file="/WEB-INF/tag/taglib.jsp"%>
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
                    <a href="/menu">首页</a>
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
        <div class="page-content">

            <!-- /section:settings.box -->
            <div class="page-content-area">
                <div class="row">
                    <div class="col-sm-10 col-sm-offset-1">
                        <div class="widget-box transparent invoice-box">
                            <div class="widget-header widget-header-large">
                                <h3 class="grey lighter pull-left position-relative">
                                    <i class="icon-book green"></i>
                                    图书订单详情
                                </h3>

                                <div class="widget-toolbar no-border invoice-info">
                                    <span class="invoice-info-label"><i class="ace-icon fa fa-list-ol">订单号:</i></span>
                                    <span class="red">${order.orderCode}</span>

                                    <br />
                                    <span class="invoice-info-label"><i class="ace-icon fa fa-calendar">订单日期:</i></span>
                                    <span class="blue"><fmt:formatDate value="${order.createTime}" pattern="yyyy-MM-dd HH:mm:ss" /> </span>
                                </div>

                            </div>

                            <div class="widget-body">
                                <div class="widget-main padding-24">
                                    <div class="row">
                                        <div class="col-sm-6">
                                            <div class="row">
                                                <div class="col-xs-11 label label-lg label-info arrowed-in arrowed-right">
                                                    <b>图书信息</b>
                                                </div>
                                            </div>

                                            <div class="row">
                                                <ul class="list-unstyled spaced">
                                                    <li>
                                                        <i class="icon-caret-right blue"></i>
                                                        图书编码<i class="icon-arrow-right blue" style="margin: 2px"></i>${order.bookCode}
                                                    </li>

                                                    <li>
                                                        <i class="icon-caret-right blue"></i>
                                                        图书书名<i class="icon-arrow-right blue" style="margin: 2px"></i> ${order.bookName}
                                                    </li>

                                                    <li>
                                                        <i class="icon-caret-right blue"></i>
                                                        交易数量<i class="icon-arrow-right blue" style="margin: 2px"></i> ${order.orderAmount}
                                                    </li>

                                                    <li>
                                                        <i class="icon-caret-right blue"></i>
                                                        订单类型<i class="icon-arrow-right blue" style="margin: 2px"></i>
                                                        <c:if test="${order.type eq 1}"><span class="label label-sm label-success">期刊订购</span></c:if>
                                                        <c:if test="${order.type eq 2}"><span class="label label-sm label-warning">整书购买</span></c:if>
                                                    </li>

                                                    <li>
                                                        <i class="icon-caret-right blue"></i>
                                                        订单状态<i class="icon-arrow-right blue" style="margin: 2px"></i>
                                                        <c:if test="${order.paymentStatus eq 0}"><span class="label label-sm label-warning">未支付</span></c:if>
                                                        <c:if test="${order.paymentStatus eq 2}"><span class="label label-sm label-success">已支付</span></c:if>
                                                    </li>

                                                    <c:if test="${order.type eq 1}">
                                                        <li>
                                                            <i class="icon-caret-right blue"></i>
                                                            订购期限<i class="icon-arrow-right blue" style="margin: 2px"></i>
                                                            <c:if test="${order.orderPeriod eq 1}">一个月</c:if>
                                                            <c:if test="${order.orderPeriod eq 2}">一季度</c:if>
                                                            <c:if test="${order.orderPeriod eq 3}">半年</c:if>
                                                            <c:if test="${order.orderPeriod eq 4}">一年</c:if>
                                                        </li>
                                                        <li>
                                                            <i class="icon-caret-right blue"></i>
                                                            到期时间<i class="icon-arrow-right blue" style="margin: 2px"></i><fmt:formatDate value="${order.expireTime}" pattern="yyyy-MM-dd HH:mm:ss" />
                                                        </li>
                                                    </c:if>
                                                </ul>
                                            </div>
                                        </div><!-- /span -->

                                        <div class="col-sm-6">
                                            <div class="row">
                                                <div class="col-xs-11 label label-lg label-success arrowed-in arrowed-right">
                                                    <b>用户信息</b>
                                                </div>
                                            </div>

                                            <div>
                                                <ul class="list-unstyled  spaced">
                                                    <li>
                                                        <i class="icon-caret-right green"></i>
                                                        登录ID<i class="icon-arrow-right green" style="margin: 2px"></i>${order.orderLoginName}
                                                    </li>

                                                    <li>
                                                        <i class="icon-caret-right green"></i>
                                                        用户姓名<i class="icon-arrow-right green" style="margin: 2px"></i>${order.orderUsername}
                                                    </li>

                                                </ul>
                                            </div>
                                        </div><!-- /span -->
                                    </div><!-- row -->

                                    <div class="space"></div>

                                    <div class="modal-footer no-margin">
                                        <ul class="pagination pull-right no-margin">
                                            <li>
                                                <button class="btn btn-xs btn-info bigger-120"
                                                        onclick="$.controller.pay('${order.orderCode}');">确认支付</button>
                                                <button class="btn btn-xs btn-warning bigger-120"
                                                        onclick="$.controller.renewalcancel('${order.orderCode}');">取消订单</button>

                                            </li>
                                        </ul>
                                    </div>

                                    <div class="hr hr8 hr-double hr-dotted"></div>

                                </div>
                            </div>
                        </div>
                    </div>
                </div>
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
<script src="../../static/js/custom/order/controller.js"></script>
<script src="../../static/js/custom/order/dialog.js"></script>
<script>
    jQuery(function($) {

        $(".datepicker").datepicker({
            showOtherMonths: true,
            selectOtherMonths: false,
        });
    })
</script>
</body>
</html>
