<!-- Left side column. contains the logo and sidebar -->
<aside class="main-sidebar">
    <!-- sidebar: style can be found in sidebar.less -->
    <section class="sidebar">
        <!-- Sidebar user panel -->
        <div class="user-panel">
            <div class="pull-left image">
                <img src="/template/adminlte/dist/img/user2-160x160.jpg" class="img-circle" alt="User Image">
            </div>
            <div class="pull-left info">
                <p>Alexander Pierce</p>
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
        <ul class="sidebar-menu">
            <li class="header">MAIN NAVIGATION</li>
            <li class="treeview">
                <a href="#">
                    <i class="fa fa-users"></i> <span>Students</span>
                    <span class="pull-right-container">
              <i class="fa fa-angle-left pull-right"></i>
            </span>
                </a>
                <ul class="treeview-menu">
                    <li<%= request.getAttribute("page").equals("student-list") ? " class=\"active\"" : "" %>><a href="/student/list"><i class="fa fa-circle-o"></i> Student List</a></li>
                    <li<%= request.getAttribute("page").equals("student-register-form") ? " class=\"active\"" : "" %>><a href="/student/register"><i class="fa fa-circle-o"></i> Student Register</a></li>
                </ul>
            </li>
            <li class="treeview">
                <a href="#">
                    <i class="fa fa-suitcase"></i>
                    <span>Teachers</span>
                    <span class="pull-right-container">
              <i class="fa fa-angle-left pull-right"></i>
            </span>
                </a>
                <ul class="treeview-menu">
                    <li<%= request.getAttribute("page").equals("teacher-list") ? " class=\"active\"" : "" %>><a href="/teacher/list"><i class="fa fa-circle-o"></i> Teacher List</a></li>
                    <li<%= request.getAttribute("page").equals("teacher-form") ? " class=\"active\"" : "" %>><a href="/teacher/add"><i class="fa fa-circle-o"></i> Teacher Add</a></li>
                </ul>
            </li>

            <li class="treeview">
                <a href="#">
                    <i class="fa fa-pie-chart"></i>
                    <span>Classroom</span>
                    <span class="pull-right-container">
              <i class="fa fa-angle-left pull-right"></i>
            </span>
                </a>
                <ul class="treeview-menu">
                    <li<%= request.getAttribute("page").equals("classroom-list") ? " class=\"active\"" : "" %>><a href="/classroom/list"><i class="fa fa-circle-o"></i> Classroom List</a></li>
                    <li<%= request.getAttribute("page").equals("classroom-form") ? " class=\"active\"" : "" %>><a href="/classroom/add"><i class="fa fa-circle-o"></i> Classroom Add</a></li>
                </ul>
            </li>

            <li class="treeview">
                <a href="#">
                    <i class="fa fa-laptop"></i>
                    <span>Finance</span>
                    <span class="pull-right-container">
              <i class="fa fa-angle-left pull-right"></i>
            </span>
                </a>
                <ul class="treeview-menu">
                    <li<%= request.getAttribute("page").equals("payroll-list") ? " class=\"active\"" : "" %>><a href="/payroll/list"><i class="fa fa-circle-o"></i> Payroll List</a></li>
                    <li<%= request.getAttribute("page").equals("payroll-form") ? " class=\"active\"" : "" %>><a href="/payroll/add"><i class="fa fa-circle-o"></i> Payroll Add</a></li>
                </ul>
            </li>
            <li class="treeview active">
                <a href="#">
                    <i class="fa fa-edit"></i> <span>Intenvory</span>
                    <span class="pull-right-container">
              <i class="fa fa-angle-left pull-right"></i>
            </span>
                </a>

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






            <li class="header">LABELS</li>
            <li><a href="/about"><i class="fa fa-circle-o text-red"></i> <span>About</span></a></li>
            <li><a href="/contact"><i class="fa fa-circle-o text-yellow"></i> <span>Contact</span></a></li>
            <li><a href="/help"><i class="fa fa-circle-o text-aqua"></i> <span>Help</span></a></li>
        </ul>
    </section>
    <!-- /.sidebar -->
</aside>