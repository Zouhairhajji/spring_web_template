<%-- 
    Document   : left_menu
    Created on : 28 sept. 2019, 10:31:45
    Author     : zouhairhajji
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix = "fmt" uri = "http://java.sun.com/jsp/jstl/fmt" %>

<div class="col-md-3 left_col">
    <div class="left_col scroll-view">
        <div class="navbar nav_title" style="border: 0;">
            <a href="/" class="site_title"><i class="fa fa-paw"></i> <span>Gentelella Alela!</span></a>
        </div>
        <div class="clearfix"></div>

        <div class="profile clearfix">
            <div class="profile_pic">
                <svg data-jdenticon-value="user127" width="30" height="60" class="img-circle profile_img">
                Fallback text or image for browsers not supporting inline svg.
                </svg>

            </div>
            <div class="profile_info">
                <span>Welcome,</span>
                <h2> <%= session.getAttribute("FULL_NAME") %> </h2>
            </div>
            <div class="clearfix"></div>
        </div>

        <br />

        <div id="sidebar-menu" class="main_menu_side hidden-print main_menu">
            <div class="menu_section">
                <h3>General</h3>
                <ul class="nav side-menu">
                    <li><a><i class="fa fa-edit"></i> Access Management <span class="fa fa-chevron-down"></span></a>
                        <ul class="nav child_menu">
                            <li><a href="/users/list_users">Users Management</a></li>
                        </ul>
                    </li>
                </ul>
                
                <h3>General</h3>
                <ul class="nav side-menu">
                    <li><a><i class="fa fa-edit"></i> Access Management <span class="fa fa-chevron-down"></span></a>
                        <ul class="nav child_menu">
                            <li><a href="/users/list_users">Users Management</a></li>
                            <li><a href="/users/list_users">Users Management</a></li>
                            <li><a href="/users/list_users">Users Management</a></li>
                            <li><a href="/users/list_users">Users Management</a></li>
                        </ul>
                    </li>
                </ul>
            </div>
        </div>



    </div>
</div>

