<%--
  Created by IntelliJ IDEA.
  User: 41809
  Date: 2018/7/25
  Time: 22:13
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8"%>
<%@include file="/WEB-INF/tag/taglib.jsp"%>
<!DOCTYPE html>
<html>

<head>
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1" />
    <meta charset="utf-8" />
    <title>Menu</title>

    <meta name="description" content="This is page-header (.page-header &gt; h1)" />
    <meta name="viewport" content="width=device-width, initial-scale=1.0, maximum-scale=1.0" />

    <link rel="stylesheet" href="../../static/css/bootstrap.min.css" />
    <link rel="stylesheet" href="../../static/css/font-awesome.min.css" />
    <link rel="stylesheet" href="../../static/css/ace.min.css" id="main-ace-style" />
    <!--[if lte IE 9]>
    <link rel="stylesheet" href="../../static/css/ace-part2.min.css"/>
    <![endif]-->
    <link rel="stylesheet" href="../../static/css/ace-skins.min.css" />
    <link rel="stylesheet" href="../../static/css/ace-rtl.min.css" />
    <!--[if lte IE 9]>
    <link rel="stylesheet" href="../../static/css/ace-ie.min.css"/>
    <![endif]-->
    <!--[if lte IE 8]>
    <script src="../../static/js/html5shiv.min.js"></script>
    <script src="../../static/js/respond.min.js"></script>
    <![endif]-->
</head>

<body class="no-skin">
<div id="navbar" class="navbar navbar-default"></div>

<!-- /section:basics/navbar.layout -->
<div class="main-container" id="main-container">

    <!-- #section:basics/sidebar -->
    <div id="sidebar" class="sidebar responsive"></div>

    <!-- /section:basics/sidebar -->
    <div class="main-content">
        <!-- #section:basics/content.breadcrumbs -->
        <div class="breadcrumbs" id="breadcrumbs">
            <ul class="breadcrumb">
                <li>
                    <i class="ace-icon fa fa-home home-icon"></i>
                    <a href="/menu">首页</a>
                </li>
            </ul><!-- /.breadcrumb -->

            <!-- /section:basics/content.searchbox -->
        </div>

        <div class="page-content">
            <!-- /section:settings.box -->
            <div class="page-content-area">

                <div class="row">
                    <div class="col-xs-12">
                        <!-- PAGE CONTENT BEGINS -->
                        <!--通告-->
                        <div class="alert alert-block alert-info">
                            <button type="button" class="close" data-dismiss="alert">
                                <i class="ace-icon fa fa-times"></i>
                            </button>

                            <i class="ace-icon fa fa-check green"></i>

                            <strong class="green">最新公告：</strong>
                            南航开通华中首条直达美国航线，广州-武汉-旧金山首航，为中部崛起注入创新活力
                        </div>
                        <div class="row center">
                            <!--首页图片-->
                        </div><!-- /.row -->

                        <!-- PAGE CONTENT ENDS -->
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


</div><!-- /.main-container -->

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
<!--[if lte IE 8]>
<script src="../../static/js/excanvas.min.js"></script>
<![endif]-->
<script src="../../static/js/jquery-ui.custom.min.js"></script>
<script src="../../static/js/jquery.ui.touch-punch.min.js"></script>
<script src="../../static/js/ace-elements.min.js"></script>
<script src="../../static/js/ace.min.js"></script>
<script>
    $("#navbar").load("/index/navbar",function () {
    });
    $("#sidebar").load("/index/sidebar",function () {
    });
</script>
</body>

</html>



