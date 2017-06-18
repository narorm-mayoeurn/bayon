<%@ page import="java.util.Map" %>
<%@ page import="java.util.Map.Entry" %>
<%@ page import="com.camhub.antiochschool.domain.Class" %>
<!-- Content Wrapper. Contains page content -->
<div class="content-wrapper">
    <!-- Content Header (Page header) -->
    <section class="content-header">
        <h1>
            Class Form
            <small>Add or update class information</small>
        </h1>
        <ol class="breadcrumb">
            <li><a href="/home"><i class="fa fa-dashboard"></i> Home</a></li>
            <li><a href="/classes"> Classes</a></li>
            <li class="active"><%= request.getAttribute("action").equals("add") ? "Add" : "Update" %></li>
        </ol>
    </section>

    <!-- Main content -->
    <section class="content">
        <!-- /.row -->
        <div class="row">

            <div class="col-xs-12 col-md-8 col-md-offset-2">
                <div class="box box-info">
                    <div class="box-header with-border">
                        <h3 class="box-title"><%= request.getAttribute("action").equals("add") ? "New Class" : "Update Class" %></h3>
                    </div>
                    <!-- /.box-header -->
                    <!-- form start -->
                    <% Class clazz = (Class)request.getAttribute("clazz");%>
                    <form class="form-horizontal" id="class_form" action="/classes/save" method="post">
                        <input type="hidden" name="_a" />
                        <input type="hidden" name="id" value="<%= clazz == null ? "" : clazz.getId()%>" />
                        <div class="box-body">

                            <div class="form-group" id="fg_name">
                                <label for="name" class="col-sm-3 control-label">Class Name</label>
                                <div class="col-sm-9">
                                    <input type="text" class="form-control" id="name" name="name" placeholder="Class Name" value="<%= clazz == null ? "" : clazz.getName()%>">
                                </div>
                            </div>

                            <div class="form-group" id="fg_session">
                                <label for="session" class="col-sm-3 control-label">Session</label>
                                <div class="col-sm-9">
                                    <select type="text" class="form-control" id="session" name="session">
                                        <option value="Morning" <%= clazz != null && "Morning".equalsIgnoreCase(clazz.getSession()) ? "selected" : "" %>>Morning</option>
                                        <option value="Afternoon" <%= clazz != null && "Afternoon".equalsIgnoreCase(clazz.getSession()) ? "selected" : "" %>>Afternoon</option>
                                        <option value="Evening" <%= clazz != null && "Evening".equalsIgnoreCase(clazz.getSession()) ? "selected" : "" %>>Evening</option>
                                    </select>
                                </div>
                            </div>

                            <div class="form-group" id="fg_description">
                                <label for="description" class="col-sm-3 control-label">Description</label>
                                <div class="col-sm-9">
                                <textarea class="form-control" id="description" placeholder="Description" rows="3" name="description"><%= clazz == null ? "" : clazz.getDescription()%></textarea>
                                </div>
                            </div>

                            <div class="form-group" id="fg_programId">
                                <label for="programId" class="col-sm-3 control-label">Program</label>
                                <div class="col-sm-9">
                                <select class="form-control" id="programId" rows="3" name="programId" placeholder="Select ...">
                                    <%
                                        Map<Long, String> programs = (Map<Long, String>) request.getAttribute("programs");
                                        for (Map.Entry<Long, String> program : programs.entrySet()) {
                                    %>
                                        <option value="<%=program.getKey()%>" <%= clazz != null && program.getKey().equals(clazz.getProgramId()) ? "selected" : "" %>><%=program.getValue()%></option>
                                    <%
                                        }
                                    %>
                                </select>
                                </div>
                            </div>

                            <div class="form-group" id="fg_teacherId">
                                <label for="teacherId" class="col-sm-3 control-label">Teacher</label>
                                <div class="col-sm-9">
                                <select class="form-control" id="teacherId" rows="3" name="teacherId" placeholder="Select ...">
                                    <%
                                        Map<Long, String> teachers = (Map<Long, String>) request.getAttribute("teachers");
                                        for (Map.Entry<Long, String> teacher : teachers.entrySet()) {
                                    %>
                                        <option value="<%=teacher.getKey()%>" <%= clazz != null && teacher.getKey().equals(clazz.getTeacherId()) ? "selected" : "" %>><%=teacher.getValue()%></option>
                                    <%
                                        }
                                    %>
                                </select>
                                </div>
                            </div>

                            <div id="classroom-form-message" class="callout callout-success" style="display:none;"></div>
                        </div>
                        <!-- /.box-body -->
                        <div class="box-footer">
                            <button type="submit" class="btn btn-info pull-right"><%= request.getAttribute("action").equals("add") ? "Save" : "Update" %></button>
                        </div>
                        <!-- /.box-footer -->
                    </form>
                </div>
            </div>

        </div>
    </section>
    <!-- /.content -->
</div>
<script>

    // prepare all forms for ajax submission
    $('#class_form').ajaxForm({
        success: function(data) {

            formMessage('classroom-form-message', data.message);

        },
        error: function(xhr) {
            console.log(xhr.responseText);
            showError($.parseJSON(xhr.responseText));
        }
    });

</script>