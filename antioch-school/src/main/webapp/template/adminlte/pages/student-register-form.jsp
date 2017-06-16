<!-- Content Wrapper. Contains page content -->
<div class="content-wrapper">
    <!-- Content Header (Page header) -->
    <section class="content-header">
        <h1>
            Student Register Form
            <small>Register or update student information</small>
        </h1>
        <ol class="breadcrumb">
            <li><a href="/home"><i class="fa fa-dashboard"></i> Home</a></li>
            <li><a href="/student/list"> Students</a></li>
            <li class="active"><%= request.getAttribute("action").equals("register") ? "Register" : "Update" %></li>
        </ol>
    </section>

    <!-- Main content -->
    <section class="content">
        <!-- /.row -->
        <div class="row">


            <div class="col-xs-12 col-md-8 col-md-offset-2">
                <div class="box box-info">
                    <div class="box-header with-border">
                        <h3 class="box-title"><%= request.getAttribute("action").equals("register") ? "New Student" : "Update Student" %></h3>
                    </div>
                    <!-- /.box-header -->
                    <!-- form start -->
                    <form class="form-horizontal" id="student_form" method="post" action="/student/save">

                        <input type="hidden" name="_a" value="" />

                        <div class="box-body">

                            <div class="form-group" id="fg_student_id">
                                <label for="student_id" class="col-sm-3 control-label">Student ID</label>
                                <div class="col-sm-9">
                                    <input type="text" class="form-control" id="student_id" name="student_id" placeholder="ID">
                                </div>
                            </div>

                            <div class="form-group" id="fg_khmer_name">
                                <label for="kh_name" class="col-sm-3 control-label">Khmer Name</label>
                                <div class="col-sm-9">
                                    <input type="text" class="form-control" id="kh_name" name="khmer_name" placeholder="Khmer Name">
                                </div>
                            </div>


                            <div class="form-group" id="fg_english_name">
                                <label for="en_name" class="col-sm-3 control-label">English Name</label>
                                <div class="col-sm-9">
                                    <input type="text" class="form-control" id="en_name" name="english_name" placeholder="English Name">
                                </div>
                            </div>



                            <div class="form-group" id="fg_gender">
                                <label for="kh_name" class="col-sm-3 control-label">Gender</label>

                                <div class="col-sm-9">
                                    <div class="input-group">
                                    <div class="radio">
                                        <label>
                                            <input type="radio" name="gender" id="gender_male" value="M" checked="">
                                            Male
                                        </label>
                                    </div>
                                    <div class="radio">
                                        <label>
                                            <input type="radio" name="gender" id="gender_female" value="F">
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
                                    <input type="text" id="birthdate" name="birthdate" class="form-control" data-inputmask="'alias': 'mm/dd/yyyy'" data-mask="">
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
                                    <input type="text" class="form-control" name="phone" id="phone" data-inputmask="&quot;mask&quot;: &quot;(999) 999-9999&quot;" data-mask="">
                                </div>
                                </div>
                                <!-- /.input group -->
                            </div>



                            <div class="form-group" id="fg_email">
                                <label for="email" class="col-sm-3 control-label">Email</label>

                                <div class="col-sm-9">
                                    <div class="input-group">
                                    <span class="input-group-addon"><i class="fa fa-envelope"></i></span>
                                    <input type="email" class="form-control" name="email" id="email" placeholder="Email">
                                    </div>
                                </div>
                            </div>


                            <div id="student-form-message" class="callout callout-success" style="display:none;">
                            </div>

                        </div>



                        <!-- /.box-body -->
                        <div class="box-footer">
                            <button type="submit" class="btn btn-info pull-right">Save</button>
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
        $('#student_form').ajaxForm({
            success: function(data) {
                $('#student-form-message').html('<p>' + data.message + '</p>');
            },
            error: function(xhr) {
                console.log(xhr.responseText);
                showError($.parseJSON(xhr.responseText));
            }
        });

</script>