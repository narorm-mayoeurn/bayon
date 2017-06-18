<%@ page import="java.text.SimpleDateFormat" %>
<%@ page import="com.camhub.antiochschool.domain.Invoice" %>
<!-- Content Wrapper. Contains page content -->
<div class="content-wrapper">
    <!-- Content Header (Page header) -->
    <section class="content-header">
        <h1>
            Payroll Form
            <small>Add or update invoice information</small>
        </h1>
        <ol class="breadcrumb">
            <li><a href="/home"><i class="fa fa-dashboard"></i> Home</a></li>
            <li><a href="/invoice/list"> Payrolls</a></li>
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
                        <h3 class="box-title"><%= request.getAttribute("action").equals("add") ? "New Invoice" : "Update Invoice" %></h3>
                    </div>
                    <!-- /.box-header -->
                    <!-- form start -->
                    <% Invoice invoice = (Invoice)request.getAttribute("invoice");%>
                    <form id="payroll_form" class="form-horizontal" action="/invoice/save" method="post">
                        <input type="hidden" name="_a" value="" />
                        <input type="hidden" name="id" value="<%= invoice == null ? "" : invoice.getId()%>" />

                        <div class="box-body">

                            <div class="form-group" id="fg_payroll_no">
                                <label for="payroll_no" class="col-sm-3 control-label">Payroll No</label>
                                <div class="col-sm-9">
                                    <input type="text" class="form-control" id="payroll_no" name="payroll_no" placeholder="Payroll No" value="<%=invoice == null ? "" : invoice.getPayrollNo()%>">
                                </div>
                            </div>


                            <div class="form-group" id="fg_tuition_fee">
                                <label for="tuition_fee" class="col-sm-3 control-label">Tuition Fee</label>
                                <div class="col-sm-9">
                                    <input type="text" class="form-control" id="tuition_fee" name="tuition_fee" placeholder="Tuition Fee" value="<%=invoice == null ? "" : invoice.getTuitionFee()%>"/>
                                </div>
                            </div>


                            <div class="form-group" id="fg_admin_fee">
                                <label for="admin_fee" class="col-sm-3 control-label">Administration Fee</label>
                                <div class="col-sm-9">
                                    <input type="text" id="admin_fee" name="admin_fee" class="form-control" placeholder="Administration Fee" value="<%=invoice == null ? "" : invoice.getAdministrationFee()%>">
                                </div>
                                <!-- /.input group -->
                            </div>


                            <div class="form-group" id="fg_supply_fee">
                                <label for="supply_fee" class="col-sm-3 control-label">Supply Fee</label>
                                <div class="col-sm-9">
                                    <input type="text" class="form-control" id="supply_fee" name="supply_fee" placeholder="Supply Fee" value="<%=invoice == null ? "" : invoice.getSupplyFee()%>">
                                </div>
                                <!-- /.input group -->
                            </div>

                            <div id="invoice-form-message" class="callout callout-success" style="display:none;"></div>
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

            formMessage('invoice-form-message', data.message);

        },
        error: function(xhr) {
            console.log(xhr.responseText);
            showError($.parseJSON(xhr.responseText));
        }
    });

</script>