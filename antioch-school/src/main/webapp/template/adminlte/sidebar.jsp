<%@ page import="java.util.HashMap" %>
<%@ page import="java.util.Map" %>
<%@ page import="org.bayon.web.security.manager.AuthManager" %>
<!-- Left side column. contains the logo and sidebar -->
<aside class="main-sidebar">
    <!-- sidebar: style can be found in sidebar.less -->
    <section class="sidebar">
        <!-- Sidebar user panel -->
        <div class="user-panel">
            <div class="pull-left image">
                <img src="/template/adminlte/dist/img/avatar5.png" class="img-circle" alt="User Image">
            </div>
            <div class="pull-left info">
                <p><%= "Hi, " + request.getSession().getAttribute(AuthManager.AUTH) + "!"%></p>
                <a href="#"><i class="fa fa-circle text-success"></i> Online</a>
            </div>
        </div>
        <!-- search form -->
        <%--<form action="#" method="get" class="sidebar-form">--%>
            <%--<div class="input-group">--%>
                <%--<input type="text" name="q" class="form-control" placeholder="Search...">--%>
                <%--<span class="input-group-btn">--%>
                <%--<button type="submit" name="search" id="search-btn" class="btn btn-flat"><i class="fa fa-search"></i>--%>
                <%--</button>--%>
              <%--</span>--%>
            <%--</div>--%>
        <%--</form>--%>
        <!-- /.search form -->
        <!-- sidebar menu: : style can be found in sidebar.less -->
        <%
            String p = (String) request.getAttribute("page");
            HashMap<String, String> pages = new HashMap<String, String>();

            pages.put("student", p.equals("student-list") || p.equals("student-register-form") ? " active" : "");
            pages.put("student-list", p.equals("student-list") ? " class=\"active\"" : "");
            pages.put("student-register-form", p.equals("student-register-form") ? " class=\"active\"" : "");

            pages.put("teacher", p.equals("teacher-list") || p.equals("teacher-form") ? " active" : "");
            pages.put("teacher-list", p.equals("teacher-list") ? " class=\"active\"" : "");
            pages.put("teacher-form", p.equals("teacher-form") ? " class=\"active\"" : "");

            pages.put("classroom", p.equals("classroom-list") || p.equals("classroom-form") ? " active" : "");
            pages.put("classroom-list", p.equals("classroom-list") ? " class=\"active\"" : "");
            pages.put("classroom-form", p.equals("classroom-form") ? " class=\"active\"" : "");

            pages.put("invoice", p.equals("invoice-list") || p.equals("invoice-form") ? " active" : "");
            pages.put("invoice-list", p.equals("invoice-list") ? " class=\"active\"" : "");
            pages.put("invoice-form", p.equals("invoice-form") ? " class=\"active\"" : "");
        %>
        <ul class="sidebar-menu">
            <li class="header">MAIN NAVIGATION</li>
            <li class="treeview<%= pages.get("student") %>">
                <a href="#">
                    <i class="fa fa-users"></i> <span>Students</span>
                    <span class="pull-right-container">
              <i class="fa fa-angle-left pull-right"></i>
            </span>
                </a>
                <ul class="treeview-menu">
                    <li<%= pages.get("student-list") %>><a href="/student/list"><i class="fa fa-circle-o"></i> Students</a></li>
                    <li<%= pages.get("student-register-form") %>><a href="/student/register"><i class="fa fa-circle-o"></i> Student Registration</a></li>
                </ul>
            </li>
            <li class="treeview<%= pages.get("teacher") %>">
                <a href="#">
                    <i class="fa fa-suitcase"></i>
                    <span>Teachers</span>
                    <span class="pull-right-container">
              <i class="fa fa-angle-left pull-right"></i>
            </span>
                </a>
                <ul class="treeview-menu">
                    <li<%= pages.get("teacher-list") %>><a href="/teacher/list"><i class="fa fa-circle-o"></i> Teachers</a></li>
                    <li<%= pages.get("teacher-form") %>><a href="/teacher/add"><i class="fa fa-circle-o"></i> New Teacher</a></li>
                </ul>
            </li>

            <li class="treeview<%= pages.get("classroom") %>">
                <a href="#">
                    <i class="fa fa-pie-chart"></i>
                    <span>Classes</span>
                    <span class="pull-right-container">
              <i class="fa fa-angle-left pull-right"></i>
            </span>
                </a>
                <ul class="treeview-menu">
                    <li<%= pages.get("classroom-list") %>><a href="/classes"><i class="fa fa-circle-o"></i> Classes</a></li>
                    <li<%= pages.get("classroom-form") %>><a href="/classes/add"><i class="fa fa-circle-o"></i> New Class</a></li>
                </ul>
            </li>

            <li class="treeview<%= pages.get("invoice") %>">
                <a href="#">
                    <i class="fa fa-laptop"></i>
                    <span>Finance</span>
                    <span class="pull-right-container">
              <i class="fa fa-angle-left pull-right"></i>
            </span>
                </a>
                <ul class="treeview-menu">
                    <li<%= pages.get("invoice-list") %>><a href="/invoice/list"><i class="fa fa-circle-o"></i> Invoices</a></li>
                    <%--<li<%= pages.get("invoice-form") %>><a href="/invoice/add"><i class="fa fa-circle-o"></i> New Invoice</a></li>--%>
                </ul>
            </li>
            <li class="treeview">
                <a href="#">
                    <i class="fa fa-table"></i> <span>Reports</span>
                    <span class="pull-right-container">
              <i class="fa fa-angle-left pull-right"></i>
            </span>
                </a>
                <ul class="treeview-menu">
                    <li><a href="../tables/simple.html"><i class="fa fa-circle-o"></i> Simple tables</a></li>
                    <li><a href="../tables/data.html"><i class="fa fa-circle-o"></i> Data tables</a></li>
                </ul>
            </li>

            <li class="header">SUPPORTS</li>
            <li><a href="#"><i class="fa fa-circle-o text-yellow"></i> <span>Contact Developer</span></a></li>
            <li><a href="#"><i class="fa fa-circle-o text-aqua"></i> <span>Help</span></a></li>
        </ul>
    </section>
    <!-- /.sidebar -->
</aside>