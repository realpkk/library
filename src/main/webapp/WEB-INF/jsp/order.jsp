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

            <div class="page-content-area">

                <div class="row">
                    <div class="col-xs-12">
                        <!-- PAGE CONTENT BEGINS -->
                        <!-- /.row -->

                        <div class="row">
                            <div class="col-xs-12">

                                <div class="table-header">
                                    订单信息
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
                                            <td class="left col-lg-1">图书编码：</td>
                                            <td class="right"><input type="text" size="16"id="bookCode" name="bookCode__S_LIKE" value="${param.bookCode__S_LIKE}"/></td>
                                            <td class="left">订单情况：</td>
                                            <td class="right">
                                                <select id="paymentStatus" name="paymentStatus__I_EQ">
                                                    <option value="">全部</option>
                                                    <option value="0"<c:if test="${param.paymentStatus__I_EQ eq '0'}">selected="selected"</c:if>>未支付</option>
                                                    <option value="1"<c:if test="${param.paymentStatus__I_EQ eq '1'}">selected="selected"</c:if>>已支付</option>
                                                    <option value="2"<c:if test="${param.paymentStatus__I_EQ eq '2'}">selected="selected"</c:if>>订阅中</option>
                                                    <option value="3"<c:if test="${param.paymentStatus__I_EQ eq '3'}">selected="selected"</c:if>>已退订</option>
                                                    <option value="4"<c:if test="${param.paymentStatus__I_EQ eq '4'}">selected="selected"</c:if>>已到期</option>
                                                </select>
                                            </td>
                                            <td class="left">订单类型：</td>
                                            <td class="right">
                                                <select id="type" name="type__I_EQ">
                                                    <option value="">全部</option>
                                                    <option value="1"<c:if test="${param.type__I_EQ eq '1'}">selected="selected"</c:if>>期刊订阅</option>
                                                    <option value="2"<c:if test="${param.type__I_EQ eq '2'}">selected="selected"</c:if>>整书订购</option>
                                                </select>
                                            </td>
                                            <td class="left">
                                                订阅期限
                                            </td>
                                            <td class="right">
                                                <select id="orderPeriod" name="orderPeriod__I_EQ">
                                                    <option value="">全部</option>
                                                    <option value="1"<c:if test="${param.orderPeriod__I_EQ eq '1'}">selected="selected"</c:if>>个月</option>
                                                    <option value="2"<c:if test="${param.orderPeriod__I_EQ eq '1'}">selected="selected"</c:if>>一季度</option>
                                                    <option value="3"<c:if test="${param.orderPeriod__I_EQ eq '1'}">selected="selected"</c:if>>半年</option>
                                                    <option value="4"<c:if test="${param.orderPeriod__I_EQ eq '1'}">selected="selected"</c:if>>一年</option>
                                                </select>
                                            </td>
                                            <td class="right">
                                                <button class="btn btn-primary pull-left col-sm-12 tbl-search" data-dismiss="modal"
                                                        onclick="$.Page.Search('${searchUrlOrder}');return false;">
                                                    开始搜索
                                                    <i class="ace-icon fa fa-search"></i>
                                                </button>
                                            </td>
                                        </tr>
                                        <tr>
                                            <td class="left">
                                                <label>订购时间</label>
                                            </td>
                                            <td colspan="2">
                                                <div class="input-daterange input-group">
                                                    <input type="text" class=" form-control" id="stratTime" name="createTime__D_GTE" value="${param.createTime__D_GTE}"/>
                                                    <span class="input-group-addon"><i class="fa fa-exchange"></i></span>
                                                    <input type="text" class=" form-control"  id="endTime" name="createTime__D_LTE" value="${param.createTime__D_LTE}">
                                                </div>
                                            </td>
                                            <td class="left">
                                                <label>到期时间</label>
                                            </td>
                                            <td colspan="2">
                                                <div class="input-daterange input-group">
                                                    <input type="text" class=" form-control"  name="expireTime__D_GTE" value="${param.expireTime__D_GTE}"/>
                                                    <span class="input-group-addon"><i class="fa fa-exchange"></i></span>
                                                    <input type="text" class=" form-control"   name="expireTime__D_LTE" value="${param.expireTime__D_LTE}">
                                                </div>
                                            </td>
                                            <%--<td class="left">--%>
                                            <%--<shiro:hasPermission name="search:order:loginName">登录ID：</shiro:hasPermission>--%>
                                            <%--</td>--%>
                                            <%--<td class="right">--%>
                                            <%--<shiro:hasPermission name="search:order:loginName">--%>
                                            <%--<input type="text" size="16"id="loginName" value="${search.loginName}"/>--%>
                                            <%--</shiro:hasPermission>--%>
                                            <%--</td>--%>
                                            <%--<td class="left">--%>
                                            <%--<shiro:hasPermission name="search:order:username">订单号：</shiro:hasPermission>--%>
                                            <%--</td>--%>
                                            <%--<td class="right">--%>
                                            <%--<shiro:hasPermission name="search:order:ordercode">--%>
                                            <%--<input type="text" size="16"id="ordercode" value="${search.orderCode}"/>--%>
                                            <%--</shiro:hasPermission>--%>
                                            <%--</td>--%>
                                            <td class="left">
                                                登录ID：
                                            </td>
                                            <td class="right">
                                                <input type="text" size="16"id="orderLoginName" name="orderLoginName__S_EQ" value="${param.orderLoginName__S_EQ}"/>
                                            </td>
                                            <td class="left">
                                                订单号：
                                            </td>
                                            <td class="right">
                                                <input type="text" size="16"id="orderCode" name="orderCode__S_EQ" value="${param.orderCode__S_EQ}"/>
                                            </td>
                                            <td></td>
                                        </tr>
                                    </table>
                                </form>

                                <div class="hr hr-18 dotted hr-double"></div>

                                <table id="sample-table-2" class="table table-striped table-bordered table-hover" style="table-layout: fixed;word-break: break-all">
                                    <thead>
                                    <tr>
                                        <th width="50">序号</th>
                                        <th width="60%">订单单号</th>
                                        <th width="80">订单类型</th>
                                        <th width="150">图书编码</th>
                                        <th width="150">图书书名</th>
                                        <th width="50">订单数量</th>
                                        <th width="150">订单时间</th>
                                        <th width="80">订单期限</th>
                                        <th width="150">到期时间</th>
                                        <th width="80">订单状态</th>
                                        <th width="100">订单人(用户登录ID)</th>
                                        <th width="50%">操作</th>
                                    </tr>
                                    </thead>
                                    <c:if test="${page.totalPages eq 0}">
                                        <td colspan="11" style="text-align: center">无相关记录</td>
                                    </c:if>
                                    <tbody>
                                    <c:forEach items="${page.content}" var="order" varStatus="status">
                                        <tr>
                                            <td>${status.index+1}</td>
                                            <td>${order.orderCode}</td>
                                            <td>
                                                <c:if test="${order.type eq 1}"><span class="label label-sm label-success">期刊订购</span></c:if>
                                                <c:if test="${order.type eq 2}"><span class="label label-sm label-warning">整书购买</span></c:if>
                                            </td>
                                            <td>${order.bookCode}</td>
                                            <td>${order.bookName}</td>
                                            <td>${order.orderAmount}</td>
                                            <td><fmt:formatDate value="${order.createTime}" pattern="yyyy-MM-dd HH:mm:ss" /></td>
                                            <td>
                                                <span class="label label-sm label-default" style="width: 60px;"><c:if test="${order.orderPeriod eq 1}">一个月</c:if></span>
                                                <span class="label label-sm label-default" style="width: 60px;"><c:if test="${order.orderPeriod eq 2}">一季度</c:if></span>
                                                <span class="label label-sm label-default" style="width: 60px;"><c:if test="${order.orderPeriod eq 3}">半年</c:if></span>
                                                <span class="label label-sm label-default" style="width: 60px;"><c:if test="${order.orderPeriod eq 4}">一年</c:if></span>

                                            </td>
                                            <td><fmt:formatDate value="${order.expireTime}" pattern="yyyy-MM-dd HH:mm:ss" /></td>
                                            <td>
                                                <c:if test="${order.paymentStatus eq 0}"><span class="label label-sm label-warning">未支付</span></c:if>
                                                <c:if test="${order.paymentStatus eq 1}"><span class="label label-sm label-success">已支付</span></c:if>
                                                <c:if test="${order.paymentStatus eq 2}"><span class="label label-sm label-info">订阅中</span></c:if>
                                                <c:if test="${order.paymentStatus eq 3}"><span class="label label-sm label-inverse">已退订</span></c:if>
                                                <c:if test="${order.paymentStatus eq 4}"><span class="label label-sm label-danger">已到期</span></c:if>
                                            </td>
                                            <td>${order.orderLoginName}</td>
                                            <td>
                                                <div class="hidden-sm hidden-xs btn-group">
                                                    <c:if test="${order.paymentStatus eq 0}">
                                                        <button class="btn btn-xs btn-success" style="margin-right: 5px;margin-left: 5px"
                                                                onclick="$.dialog.pay('${order.orderCode}','${order.bookCode}','${order.bookName}','${order.orderAmount}','${order.createTime}','${order.expireTime}','${order.type}');">
                                                            <i class="ace-icon fa fa-check bigger-130">确认支付</i>
                                                        </button>
                                                        <button class="btn btn-xs btn-warning" style="margin-right: 5px;margin-left: 5px" onclick="$.dialog.cancel('${order.orderCode}');">
                                                            <i class="ace-icon fa fa-times bigger-130">取消订单</i>
                                                        </button>
                                                    </c:if>
                                                    <c:if test="${order.paymentStatus eq 2||order.paymentStatus eq 4}">
                                                        <button class="btn btn-xs btn-info" style="margin-right: 5px;margin-left: 5px" onclick="$.dialog.renew('${order.orderCode}','${order.bookName}');">
                                                            <i class="ace-icon fa fa-book bigger-130">续订</i>
                                                        </button>
                                                        <button class="btn btn-xs btn-warning" style="margin-right: 5px;margin-left: 5px"
                                                                onclick="$.dialog.unsubscribe('${order.orderCode}','${order.bookName}','${order.createTime}','${order.expireTime}');">
                                                            <i class="ace-icon fa fa-book bigger-130">退订</i>
                                                        </button>
                                                    </c:if>
                                                    <c:if test="${order.paymentStatus eq 1}">
                                                        <button class="btn btn-xs btn-danger" style="margin-right: 5px;margin-left: 5px"
                                                                onclick="$.dialog.refund('${order.orderCode}','${order.bookName}','${order.createTime}');">
                                                            <i class="ace-icon fa fa-times bigger-130">退款</i>
                                                        </button>
                                                    </c:if>
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
                                                <select id="pageSize" name="pageSize" onchange="$.Page.pageProcess('${pageUrlOrder}','${page.number}',$('#pageSize').val());">
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
                                                onclick="$.Page.pageProcess('${pageUrlOrder}',0,$('#pageSize').val());"</c:if>>
                                                <i class="ace-icon fa fa-angle-double-left"></i>
                                            </a>
                                        </li>
                                        <li <c:if test="${page.number eq 0}">class="prev disabled" </c:if>>
                                            <a href="javascript:;" <c:if test="${page.number ne 0}">
                                                onclick="$.Page.pageProcess('${pageUrlOrder}','${page.number-1}',$('#pageSize').val());"</c:if>>
                                                <i class="ace-icon fa fa-angle-left"></i>
                                            </a>
                                        </li>

                                        <li class="active">
                                            <a id="currentPage">${page.number+1} </a><a>of ${page.totalPages}</a>
                                        </li>
                                        <li <c:if test="${page.number+1 eq page.totalPages}">class="next disabled" </c:if>>
                                            <a href="javascript:;"<c:if test="${page.number+1 ne page.totalPages}">
                                                onclick="$.Page.pageProcess('${pageUrlOrder}','${page.number+1}',$('#pageSize').val());"></c:if>
                                            <i class="ace-icon fa fa-angle-right"></i>
                                            </a>
                                        </li>

                                        <li <c:if test="${page.number+1 eq page.totalPages}">class="next disabled" style="" </c:if>>
                                            <a href="javascript:;" <c:if test="${page.number+1 ne page.totalPages}">
                                                onclick="$.Page.pageProcess('${pageUrlOrder}','${page.totalPages-1}',$('#pageSize').val());"></c:if>
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
                                                            onclick="$.Page.pageProcess('${pageUrlOrder}',$('#targetPage').val(),$('#pageSize').val());">跳转</button>
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
<script src="../../static/js/custom/order/controller.js"></script>
<script src="../../static/js/custom/order/dialog.js"></script>
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
</body>
</html>
