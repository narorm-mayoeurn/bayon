<%@ page import="com.camhub.antiochschool.domain.Teacher" %>
<%@ page import="java.text.SimpleDateFormat" %>
<!-- Content Wrapper. Contains page content -->
<div class="content-wrapper">
    <!-- Content Header (Page header) -->
    <section class="content-header">
        <h1>
            Teacher Form
            <small>Add or update teacher information</small>
        </h1>
        <ol class="breadcrumb">
            <li><a href="/"><i class="fa fa-dashboard"></i> Home</a></li>
            <li><a href="/teacher/list"> Teachers</a></li>
            <li class="active"><%= request.getAttribute("action").equals("add") ? "New" : "Update" %></li>
        </ol>
    </section>

    <!-- Main content -->
    <section class="content">
        <!-- /.row -->
        <div class="row">


            <div class="col-xs-12 col-md-8 col-md-offset-2">
                <div class="box box-info">
                    <div class="box-header with-border">
                        <h3 class="box-title"><%= request.getAttribute("action").equals("add") ? "New Teacher" : "Update Teacher" %></h3>
                    </div>
                    <!-- /.box-header -->
                    <!-- form start -->
                    <% Teacher teacher = (Teacher)request.getAttribute("teacher");%>
                    <form id="teacher_form" class="form-horizontal" action="/teacher/save" method="post">
                        <input type="hidden" name="_a" value="" />
                        <input type="hidden" name="id" value="<%= teacher == null ? "" : teacher.getId()%>" />

                        <div class="box-body">

                            <div class="form-group" id="fg_kh_name">
                                <label for="kh_name" class="col-sm-3 control-label">Khmer Name</label>
                                <div class="col-sm-9">
                                    <input type="text" class="form-control" id="kh_name" name="kh_name" placeholder="Khmer Name" value="<%=teacher == null ? "" : teacher.getKhmerName()%>">
                                </div>
                            </div>

                            <div class="form-group" id="fg_en_name">
                                <label for="en_name" class="col-sm-3 control-label">English Name</label>
                                <div class="col-sm-9">
                                    <input type="text" class="form-control" id="en_name" name="en_name" placeholder="English Name" value="<%=teacher == null ? "" : teacher.getEnglishName()%>"/>
                                </div>
                            </div>



                            <div class="form-group" id="fg_gender">
                                <label for="kh_name" class="col-sm-3 control-label">Gender</label>

                                <div class="col-sm-9">
                                    <div class="input-group">
                                        <div class="radio">
                                            <label>
                                                <input type="radio" name="gender" id="sex_male" value="M" <%= teacher == null || "M".equals(teacher.getGender()) ? "checked=\"\"" : ""%>>
                                                Male
                                            </label>
                                        </div>
                                        <div class="radio">
                                            <label>
                                                <input type="radio" name="gender" id="sex_female" value="F" <%= teacher != null && "F".equals(teacher.getGender()) ? "checked=\"\"" : ""%>>
                                                Female
                                            </label>
                                        </div>
                                    </div>
                                </div>
                            </div>


                            <div class="form-group" id="fg_birthdate">

                                <label for="phone" class="col-sm-3 control-label">Date of Birth</label>

                                <div class="col-sm-9">
                                    <div class="input-group">
                                        <div class="input-group-addon">
                                            <i class="fa fa-calendar"></i>
                                        </div>
                                        <input type="text" id="birthdate" name="birthdate" class="form-control" data-inputmask="'alias': 'mm/dd/yyyy'" data-mask="" placeholder="MM/dd/yyyy" value="<%=teacher == null || teacher.getBirthdate() == null ? "" : new SimpleDateFormat("MM/dd/yyyy").format(teacher.getBirthdate())%>">
                                    </div>
                                </div>
                                <!-- /.input group -->
                            </div>


                            <div class="form-group" id="fg_phone">
                                <label for="phone" class="col-sm-3 control-label">Phone Number</label>

                                <div class="col-sm-9">
                                    <div class="input-group">
                                        <div class="input-group-addon">
                                            <i class="fa fa-phone"></i>
                                        </div>
                                        <input type="text" class="form-control" id="phone" name="phone" data-inputmask="&quot;mask&quot;: &quot;(999) 999-9999&quot;" data-mask="" placeholder="Phone Number" value="<%=teacher == null ? "" : teacher.getPhone()%>">
                                    </div>
                                </div>
                                <!-- /.input group -->
                            </div>



                            <div class="form-group" id="fg_email">
                                <label for="email" class="col-sm-3 control-label">Email</label>

                                <div class="col-sm-9">
                                    <div class="input-group">
                                        <span class="input-group-addon"><i class="fa fa-envelope"></i></span>
                                        <input type="email" class="form-control" id="email" name="email" placeholder="Email" value="<%=teacher == null ? "" : teacher.getEmail()%>">
                                    </div>
                                </div>
                            </div>

                            <div id="teacher-form-message" class="callout callout-success" style="display:none;"></div>

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
</div><script>

    // prepare all forms for ajax submission
    $('#teacher_form').ajaxForm({
        success: function(data) {

            formMessage('teacher-form-message', data.message);

        },
        error: function(xhr) {
            console.log(xhr.responseText);
            showError($.parseJSON(xhr.responseText));
        }
    });

</script>