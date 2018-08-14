<%--
  Created by IntelliJ IDEA.
  User: 41809
  Date: 2018/8/8
  Time: 13:50
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ include file="/WEB-INF/tag/taglib.jsp"%>

<ul class="nav nav-list">
    <li class="active">
        <a href="/homepage">
            <i class="menu-icon fa fa-tachometer"></i>
            <span class="menu-text"> 首页 </span>
        </a>

        <b class="arrow"></b>
    </li>
    <!--菜单实例-->
    <li class="">
        <a href="#" class="dropdown-toggle">
            <i class="menu-icon fa fa-desktop"></i>
            <span class="menu-text"> UI &amp; 元素 </span>

            <b class="arrow fa fa-angle-down"></b>
        </a>

        <b class="arrow"></b>

        <ul class="submenu">

            <li class="">
                <a href="/book">
                    <i class="menu-icon fa fa-caret-right"></i>
                    book
                </a>
                <a href="/order">
                    <i class="menu-icon fa fa-caret-right"></i>
                    order
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

<!-- #section:basics/sidebar.layout.minimize -->
<div class="sidebar-toggle sidebar-collapse" id="sidebar-collapse">
    <i class="ace-icon fa fa-angle-double-left" data-icon1="ace-icon fa fa-angle-double-left" data-icon2="ace-icon fa fa-angle-double-right"></i>
</div>