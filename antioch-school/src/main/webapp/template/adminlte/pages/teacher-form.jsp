<!-- Content Wrapper. Contains page content -->
<div class="content-wrapper">
    <!-- Content Header (Page header) -->
    <section class="content-header">
        <h1>
            Teacher Form
            <small>Add or update teacher information</small>
        </h1>
        <ol class="breadcrumb">
            <li><a href="/home"><i class="fa fa-dashboard"></i> Home</a></li>
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
                    <form class="form-horizontal">
                        <div class="box-body">

                            <div class="form-group">
                                <label for="student_id" class="col-sm-3 control-label">Student ID</label>
                                <div class="col-sm-9">
                                    <input type="text" class="form-control" id="student_id" placeholder="ID">
                                </div>
                            </div>

                            <div class="form-group">
                                <label for="kh_name" class="col-sm-3 control-label">Khmer Name</label>
                                <div class="col-sm-9">
                                    <input type="text" class="form-control" id="kh_name" placeholder="Khmer Name">
                                </div>
                            </div>

                            <div class="form-group">
                                <label for="en_name" class="col-sm-3 control-label">English Name</label>
                                <div class="col-sm-9">
                                    <input type="text" class="form-control" id="en_name" placeholder="English Name">
                                </div>
                            </div>



                            <div class="form-group">
                                <label for="kh_name" class="col-sm-3 control-label">Gender</label>

                                <div class="col-sm-9">
                                    <div class="input-group">
                                        <div class="radio">
                                            <label>
                                                <input type="radio" name="optionsRadios" id="sex_male" value="M" checked="">
                                                Male
                                            </label>
                                        </div>
                                        <div class="radio">
                                            <label>
                                                <input type="radio" name="optionsRadios" id="sex_female" value="F">
                                                Female
                                            </label>
                                        </div>
                                    </div>
                                </div>
                            </div>


                            <div class="form-group">

                                <label for="phone" class="col-sm-3 control-label">Date of Birth</label>

                                <div class="col-sm-9">
                                    <div class="input-group">
                                        <div class="input-group-addon">
                                            <i class="fa fa-calendar"></i>
                                        </div>
                                        <input type="text" id="birthdate" class="form-control" data-inputmask="'alias': 'mm/dd/yyyy'" data-mask="">
                                    </div>
                                </div>
                                <!-- /.input group -->
                            </div>


                            <div class="form-group">
                                <label for="phone" class="col-sm-3 control-label">Phone Number</label>

                                <div class="col-sm-9">
                                    <div class="input-group">
                                        <div class="input-group-addon">
                                            <i class="fa fa-phone"></i>
                                        </div>
                                        <input type="text" class="form-control" id="phone" data-inputmask="&quot;mask&quot;: &quot;(999) 999-9999&quot;" data-mask="">
                                    </div>
                                </div>
                                <!-- /.input group -->
                            </div>



                            <div class="form-group">
                                <label for="email" class="col-sm-3 control-label">Email</label>

                                <div class="col-sm-9">
                                    <div class="input-group">
                                        <span class="input-group-addon"><i class="fa fa-envelope"></i></span>
                                        <input type="email" class="form-control" id="email" placeholder="Email">
                                    </div>
                                </div>
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