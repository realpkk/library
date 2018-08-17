<%--
  Created by IntelliJ IDEA.
  User: 41809
  Date: 2018/8/8
  Time: 13:49
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ include file="/WEB-INF/tag/taglib.jsp"%>
<div class="navbar-container" id="navbar-container">

    <button type="button" class="navbar-toggle menu-toggler pull-left" id="menu-toggler">
        <span class="sr-only">Toggle sidebar</span>

        <span class="icon-bar"></span>

        <span class="icon-bar"></span>

        <span class="icon-bar"></span>
    </button>

    <!-- /section:basics/sidebar.mobile.toggle -->
    <div class="navbar-header pull-left">
        <!-- #section:basics/navbar.layout.brand -->
        <a href="/homepage" class="navbar-brand">
            <small>
                <!--首页图片-->
            </small>
        </a>
    </div>

    <div class="navbar-buttons navbar-header pull-right" role="navigation">
        <ul class="nav ace-nav">
            <!--消息栏-->
            <li class="green">
                <a data-toggle="dropdown" class="dropdown-toggle" href="#">
                    <i class="ace-icon fa fa-envelope icon-animated-vertical"></i>
                    <span class="badge badge-success">${count}</span>
                </a>

                <ul class="dropdown-menu-right dropdown-navbar dropdown-menu dropdown-caret dropdown-close">
                    <li class="dropdown-header">
                        <i class="ace-icon fa fa-envelope-o"></i>
                        ${count}条未读信息
                    </li>
                    <c:if test="${user.id eq 1}">
                        <c:forEach items="${message.content}" var="message">
                            <li class="dropdown-content">
                                <ul class="dropdown-menu dropdown-navbar">
                                    <li>
                                        <a href="/afterSale">
                                   <span class="msg-body">
                                       <span class="msg-title">
                                           <span class="red2">
                                               <c:if test="${message.type eq 1}">退款</c:if>
                                               <c:if test="${message.type eq 2}">退订</c:if>
                                               <c:if test="${message.type eq 3}">申请提醒</c:if>
                                           </span>
                                           ${message.sender}售后处理，流水${message.applicationCode}
                                       </span>

                                       <span class="msg-time">
                                           <i class="ace-icon fa fa-clock-o"></i>
                                           <span><fmt:formatDate value="${message.createTime}" pattern="yyyy-MM-dd HH:mm:ss"/> </span>
                                       </span>
                                   </span>
                                        </a>
                                    </li>
                                </ul>
                            </li>
                        </c:forEach>
                    </c:if>



                    <li class="dropdown-footer">
                        <a href="inbox.html">
                            查看全部消息
                            <i class="ace-icon fa fa-arrow-right"></i>
                        </a>
                    </li>
                </ul>
            </li>

            <!-- #section:basics/navbar.user_menu -->
            <!--用户中心-->
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
