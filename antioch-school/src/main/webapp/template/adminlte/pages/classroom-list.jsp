<%@ page import="java.util.Map" %>
<%@ page import="com.camhub.antiochschool.domain.Class" %>
<%@ page import="org.bayon.ogm.datastore.query.Page" %>
<!-- Content Wrapper. Contains page content -->
<div class="content-wrapper">
    <!-- Content Header (Page header) -->
    <section class="content-header">
        <h1>
            Class Management
            <small></small>
        </h1>
        <ol class="breadcrumb">
            <li><a href="/home"><i class="fa fa-dashboard"></i> Home</a></li>
            <li class="active">Class</li>
        </ol>
    </section>

    <!-- Main content -->
    <section class="content">
        <!-- /.row -->
        <div class="row">
            <div class="col-xs-12">
                <div class="box">
                    <div class="box-header">
                        <h3 class="box-title"></h3>

                        <div class="box-tools">
                            <div class="input-group input-group-sm" style="width: 150px;">
                                <input type="text" name="table_search" class="form-control pull-right" placeholder="Search">

                                <div class="input-group-btn">
                                    <button type="submit" class="btn btn-default"><i class="fa fa-search"></i></button>
                                </div>
                            </div>
                        </div>
                    </div>
                    <!-- /.box-header -->
                    <div class="box-body table-responsive no-padding">
                        <table class="table table-hover">
                            <tr>
                                <th>Class</th>
                                <th>Session</th>
                                <th>Teacher</th>
                                <th>Program</th>
                                <th></th>
                                <th></th>
                            </tr>

                            <%
                                Map<Long, String> teachers = (Map<Long, String>)request.getAttribute("teachers");
                                Map<Long, String> programs = (Map<Long, String>)request.getAttribute("programs");

                                Page<Class> p = (Page<Class>)request.getAttribute("classes");
                                for (Class clazz : p.getItems()) {
                            %>
                            <tr>
                                <td><%= clazz.getName()%></td>
                                <td><%= clazz.getSession()%></td>
                                <td><%= clazz.getTeacherId() == null ? "" : teachers.get(clazz.getTeacherId())%></td>
                                <td><%= clazz.getProgramId() == null ? "" : programs.get(clazz.getProgramId())%></td>
                                <td><a href="/classes/update?id=<%=clazz.getId()%>"><i class="fa fa-fw fa-edit"></i></a></td>
                                <td><a href="#" id="<%=clazz.getId()%>"><i class="fa fa-fw fa-remove"></i></a></td>
                            </tr>
                            <%
                                }
                            %>

                            <!--
                            <tr>
                                <td>183</td>
                                <td>John Doe</td>
                                <td>11-7-2014</td>
                            </tr>
                            <tr>
                                <td>219</td>
                                <td>Alexander Pierce</td>
                                <td>11-7-2014</td>
                            </tr>
                            <tr>
                                <td>657</td>
                                <td>Bob Doe</td>
                                <td>11-7-2014</td>
                            </tr>
                            <tr>
                                <td>175</td>
                                <td>Mike Doe</td>
                                <td>11-7-2014</td>
                            </tr>
                            -->
                        </table>
                    </div>
                    <!-- /.box-body -->

                    <div class="box-footer clearfix">
                        <ul class="pagination pagination-sm no-margin pull-right">
                            <% if (p.getPageIterator().hasPrevious()) { %>
                                <li><a href="?offset=<%= p.getPageIterator().previous()%>&limit=<%= p.getLimit()%>">«</a></li>
                            <% } %>
                                <!--
                                <li><a href="#">1</a></li>
                                <li><a href="#">2</a></li>
                                <li><a href="#">3</a></li>
                                -->
                            <% if (p.getPageIterator().hasNext()) { %>
                                <li><a href="?offset=<%= p.getPageIterator().next()%>&limit=<%= p.getLimit()%>">»</a></li>
                            <% } %>
                        </ul>
                    </div>

                </div>
                <!-- /.box -->
            </div>
        </div>
    </section>
    <!-- /.content -->
</div>

<script>
    // prepare all forms for ajax submission
    $('a i.fa-remove').click(function(){
        var _id = $(this).parent().attr('id');
        $.ajax({
            method: "POST",
            url: "/classes/delete",
            data: { id: _id }
        }).done(function( msg ) {
                window.location.reload();
            });
    });
</script>