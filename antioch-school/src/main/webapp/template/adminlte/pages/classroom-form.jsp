<!-- Content Wrapper. Contains page content -->
<div class="content-wrapper">
    <!-- Content Header (Page header) -->
    <section class="content-header">
        <h1>
            Classroom Form
            <small>Add or update classroom information</small>
        </h1>
        <ol class="breadcrumb">
            <li><a href="/home"><i class="fa fa-dashboard"></i> Home</a></li>
            <li><a href="/student/list"> Classroom</a></li>
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
                        <h3 class="box-title"><%= request.getAttribute("action").equals("add") ? "New Classroom" : "Update Classroom" %></h3>
                    </div>
                    <!-- /.box-header -->
                    <!-- form start -->
                    <form class="form-horizontal">
                        <div class="box-body">

                            <div class="form-group">
                                <label for="room_no" class="col-sm-3 control-label">Room No</label>
                                <div class="col-sm-9">
                                    <input type="text" class="form-control" id="room_no" placeholder="Room No">
                                </div>
                            </div>

                            <div class="form-group">
                                <label for="session" class="col-sm-3 control-label">Session</label>
                                <div class="col-sm-9">
                                    <input type="text" class="form-control" id="session" placeholder="Session">
                                </div>
                            </div>


                            <div class="form-group">
                                <label for="session" class="col-sm-3 control-label">Description</label>
                                <div class="col-sm-9">
                                <textarea class="form-control" id="description" rows="3" placeholder="Enter ..."></textarea>
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