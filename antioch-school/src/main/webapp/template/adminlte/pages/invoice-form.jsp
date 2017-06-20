<%@ page import="java.text.SimpleDateFormat" %>
<%@ page import="com.camhub.antiochschool.domain.Invoice" %>
<%@ page import="com.camhub.antiochschool.domain.Student" %>
<%@ page import="com.camhub.antiochschool.service.ClassFacade" %>
<!-- Content Wrapper. Contains page content -->
<div class="content-wrapper">
    <!-- Content Header (Page header) -->
    <section class="content-header">
        <h1>
            Invoice Form
            <small>Add or update invoice information</small>
        </h1>
        <ol class="breadcrumb">
            <li><a href="/"><i class="fa fa-dashboard"></i> Home</a></li>
            <li><a href="/invoice/list"> Invoices</a></li>
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

                    <% Student student = (Student)request.getAttribute("student");%>
                    <% Invoice invoice = (Invoice)request.getAttribute("invoice");%>


                    <form id="payroll_form" class="form-horizontal" action="/invoice/save" method="post">
                        <input type="hidden" name="_a" value="" />
                        <input type="hidden" name="student_id" value="<%= student == null ? "" : student.getId() + "" %>" />
                        <input type="hidden" name="id" value="<%= invoice == null ? "" : invoice.getId() + "" %>" />

                        <div class="box-body">

                            <div class="with-border">
                                <div class="form-group">
                                    <label class="col-sm-3">Student ID</label>
                                    <div class="col-sm-9"><%= student.getStudentId() %></div>
                                </div>

                                <div class="form-group">
                                    <label class="col-sm-3">Student Name</label>
                                    <div class="col-sm-9"><%= student.getKhmerName() + " (" + student.getEnglishName() + ")" %></div>
                                </div>

                                <div class="form-group">
                                    <label class="col-sm-3">Current Class</label>
                                    <div class="col-sm-9"><%= student.getClassId() == null ? "" : ClassFacade.getInstance().getNameById(student.getClassId()) %></div>
                                </div>
                            </div>


                            <div class="form-group" id="fg_invoice_no">
                                <label for="invoice_no" class="col-sm-3 control-label">Invoice No</label>
                                <div class="col-sm-9">
                                    <input type="text" class="form-control" id="invoice_no" name="invoice_no" placeholder="Invoice No" value="<%=invoice == null ? "" : invoice.getInvoiceNo()%>">
                                </div>
                            </div>

                            <div class="form-group" id="fg_invoice_date">

                                <label for="invoice_date" class="col-sm-3 control-label">Invoice</label>

                                <div class="col-sm-9">
                                    <div class="input-group">
                                        <div class="input-group-addon">
                                            <i class="fa fa-calendar"></i>
                                        </div>
                                        <input type="text" id="invoice_date" name="invoice_date" class="form-control" data-inputmask="'alias': 'mm/dd/yyyy'" data-mask="" placeholder="mm/dd/yyyy" value="<%=invoice == null || invoice.getInvoiceDate() == null ? "" : new SimpleDateFormat("MM/dd/yyyy").format(invoice.getInvoiceDate())%>">
                                    </div>
                                </div>
                                <!-- /.input group -->
                            </div>

                            <div class="form-group" id="fg_start_end_date">
                                <label class="col-sm-3 control-label">Effective Date:</label>

                                <div class="col-sm-9">
                                    <div class="input-group">
                                        <div class="input-group-addon">
                                            <i class="fa fa-calendar"></i>
                                        </div>
                                        <input type="text" class="form-control" id="reservation" name="start_end_date" id="start_end_date">
                                    </div>
                                </div>
                                <!-- /.input group -->
                            </div>


                            <div class="form-group" id="fg_tuition_fee">
                                <label for="tuition_fee" class="col-sm-3 control-label">Tuition Fee</label>
                                <div class="col-sm-9">
                                    <div class="input-group">
                                        <div class="input-group-addon">
                                            <i class="fa fa-dollar"></i>
                                        </div>
                                        <input type="text" class="form-control pull-right" style="text-align:right;" id="tuition_fee" name="tuition_fee" placeholder="Tuition Fee" value="<%=invoice == null ? "" : invoice.getTuitionFee() + "" %>"/>
                                    </div>
                                </div>
                            </div>


                            <div class="form-group" id="fg_admin_fee">
                                <label for="admin_fee" class="col-sm-3 control-label">Administration Fee</label>
                                <div class="col-sm-9">
                                    <div class="input-group">
                                    <div class="input-group-addon">
                                        <i class="fa fa-dollar"></i>
                                    </div>
                                    <input type="text" id="admin_fee" name="admin_fee" style="text-align:right;" class="form-control pull-right" placeholder="Administration Fee" value="<%=invoice == null ? "" : invoice.getAdministrationFee() + "" %>">
                                    </div>
                                </div>
                                <!-- /.input group -->
                            </div>


                            <div class="form-group" id="fg_supply_fee">
                                <label for="supply_fee" class="col-sm-3 control-label">Supply Fee</label>
                                <div class="col-sm-9">
                                    <div class="input-group">
                                        <div class="input-group-addon">
                                            <i class="fa fa-dollar"></i>
                                        </div>
                                    <input type="text" class="form-control pull-right" style="text-align:right;" id="supply_fee" name="supply_fee" placeholder="Supply Fee" value="<%=invoice == null ? "" : invoice.getSupplyFee() + "" %>">
                                    </div>
                                </div>
                                <!-- /.input group -->
                            </div>

                            <div class="form-group" id="fg_total_discount">
                                <label for="total_discount" class="col-sm-3 control-label">Total Discount</label>
                                <div class="col-sm-9">
                                    <div class="input-group">
                                        <div class="input-group-addon">
                                            <i class="fa fa-dollar"></i>
                                        </div>
                                    <input type="text" style="text-align:right;" class="form-control pull-right" id="total_discount" name="total_discount" placeholder="Total Discount" value="<%=invoice == null ? "" : invoice.getTotalDiscount() + "0" %>">
                                    </div>
                                </div>
                                <!-- /.input group -->
                            </div>

                            <div id="invoice-form-message" class="callout callout-success" style="display:none;"></div>
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
</div><script>

    $(function() {

        //Date picker
        $('#invoice_date').datepicker({
            autoclose: true
        });


        //Date range picker
        $('#reservation').daterangepicker();




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

    });

</script>