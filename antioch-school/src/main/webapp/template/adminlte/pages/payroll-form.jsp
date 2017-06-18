<%@ page import="java.text.SimpleDateFormat" %>
<%@ page import="com.camhub.antiochschool.domain.Payroll" %>
<!-- Content Wrapper. Contains page content -->
<div class="content-wrapper">
    <!-- Content Header (Page header) -->
    <section class="content-header">
        <h1>
            Payroll Form
            <small>Add or update payroll information</small>
        </h1>
        <ol class="breadcrumb">
            <li><a href="/home"><i class="fa fa-dashboard"></i> Home</a></li>
            <li><a href="/payroll/list"> Payrolls</a></li>
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
                        <h3 class="box-title"><%= request.getAttribute("action").equals("add") ? "New Payroll" : "Update Payroll" %></h3>
                    </div>
                    <!-- /.box-header -->
                    <!-- form start -->
                    <% Payroll payroll = (Payroll)request.getAttribute("payroll");%>
                    <form id="payroll_form" class="form-horizontal" action="/payroll/save" method="post">
                        <input type="hidden" name="_a" value="" />
                        <input type="hidden" name="id" value="<%= payroll == null ? "" : payroll.getId()%>" />

                        <div class="box-body">

                            <div class="form-group" id="fg_payroll_no">
                                <label for="payroll_no" class="col-sm-3 control-label">Payroll No</label>
                                <div class="col-sm-9">
                                    <input type="text" class="form-control" id="payroll_no" name="payroll_no" placeholder="Payroll No" value="<%=payroll == null ? "" : payroll.getPayrollNo()%>">
                                </div>
                            </div>


                            <div class="form-group" id="fg_tuition_fee">
                                <label for="tuition_fee" class="col-sm-3 control-label">Tuition Fee</label>
                                <div class="col-sm-9">
                                    <input type="text" class="form-control" id="tuition_fee" name="tuition_fee" placeholder="Tuition Fee" value="<%=payroll == null ? "" : payroll.getTuitionFee()%>"/>
                                </div>
                            </div>


                            <div class="form-group" id="fg_admin_fee">
                                <label for="admin_fee" class="col-sm-3 control-label">Administration Fee</label>
                                <div class="col-sm-9">
                                    <input type="text" id="admin_fee" name="admin_fee" class="form-control" placeholder="Administration Fee" value="<%=payroll == null ? "" : payroll.getAdministrationFee()%>">
                                </div>
                                <!-- /.input group -->
                            </div>


                            <div class="form-group" id="fg_supply_fee">
                                <label for="supply_fee" class="col-sm-3 control-label">Supply Fee</label>
                                <div class="col-sm-9">
                                    <input type="text" class="form-control" id="supply_fee" name="supply_fee" placeholder="Supply Fee" value="<%=payroll == null ? "" : payroll.getSupplyFee()%>">
                                </div>
                                <!-- /.input group -->
                            </div>

                            <div id="payroll-form-message" class="callout callout-success" style="display:none;"></div>
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
    $('#payroll_form').ajaxForm({
        success: function(data) {

            formMessage('payroll-form-message', data.message);

        },
        error: function(xhr) {
            console.log(xhr.responseText);
            showError($.parseJSON(xhr.responseText));
        }
    });

</script>