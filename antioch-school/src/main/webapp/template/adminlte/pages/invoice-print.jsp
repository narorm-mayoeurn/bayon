<%@ page import="com.camhub.antiochschool.domain.Invoice" %>
<%@ page import="com.camhub.antiochschool.domain.Student" %>
<%@ page import="java.text.SimpleDateFormat" %>
<%@ page import="java.util.Date" %>
<%@ page import="java.text.DecimalFormat" %>
<!-- Content Wrapper. Contains page content -->


<%
    Invoice invoice = (Invoice) request.getAttribute("invoice");
    Student student = (Student) request.getAttribute("student");
%>

<div class="content-wrapper">
    <!-- Content Header (Page header) -->
    <section class="content-header">
        <h1>
            Invoice
            <small>#<%= invoice.getInvoiceNo() %></small>
        </h1>
        <ol class="breadcrumb">
            <li><a href="/student/list"><i class="fa fa-dashboard"></i> Home</a></li>
            <li><a href="/invoice/list">Invoices</a></li>
            <li class="active">Print</li>
        </ol>
    </section>



    <!-- Main content -->
    <section class="invoice">

        <!-- title row -->
        <div class="row">
            <div class="col-xs-8 col-xs-offset-2">
                <h2 class="page-header">
                    <i class="fa fa-globe"></i> Antioch School
                    <small class="pull-right">Print Date: <%= new SimpleDateFormat("MM/dd/yyyy").format(new Date()) %></small>
                </h2>
            </div>
            <!-- /.col -->
        </div>
        <!-- info row -->
        <div class="row">

            <div class="col-xs-8 col-sm-offset-2">
            <div class="col-xs-6 pull-left">
                From
                <address>
                    <strong>Antioch School</strong><br>
                    Chamkar Doung Street (217), <br>
                    Phnom Penh, Cambodia<br>
                    Phone: +855 23 6404946 / 68 687673<br>
                    Email: antioch_inform@yahoo.com
                </address>
            </div>
            <!-- /.col -->
            <div class="col-xs-6 pull-left">
                <b>Invoice #<%= invoice.getInvoiceNo() %></b><br>
                <br>
                <b>Invoice Date:</b> <%= new SimpleDateFormat("MM/dd/yyyy").format(invoice.getInvoiceDate()) %><br>
                <b>Student ID:</b> <%= student.getStudentId() %><br>
                <b>Student Name: </b> <%= student.getKhmerName() %>
            </div>
            </div>
            <!-- /.col -->
        </div>
        <!-- /.row -->

        <!-- Table row -->
        <div class="row">
            <div class="col-xs-8 col-xs-offset-2 table-responsive">
                <table class="table table-striped">
                    <thead>
                    <tr>
                        <th>No.</th>
                        <th>Fee Type</th>
                        <th></th>
                        <th>Amount</th>
                    </tr>
                    </thead>
                    <tbody>
                    <tr>
                        <td>1</td>
                        <td>Tuition Fee</td>
                        <td></td>
                        <td class="text-right">$<%= new DecimalFormat("0.00").format(invoice.getTuitionFee()) %></td>
                    </tr>
                    <tr>
                        <td>2</td>
                        <td>Adminstration Fee</td>
                        <td></td>
                        <td class="text-right">$<%= new DecimalFormat("0.00").format(invoice.getAdministrationFee()) %></td>
                    </tr>
                    <tr>
                        <td>3</td>
                        <td>Supply Fee</td>
                        <td></td>
                        <td class="text-right">$<%= new DecimalFormat("0.00").format(invoice.getSupplyFee()) %></td>
                    </tr>

                    <tr>
                        <td></td>
                        <td></td>
                        <td><strong>Total</strong></td>
                        <td class="text-right">$<%= new DecimalFormat("0.00").format(invoice.getTuitionFee() + invoice.getAdministrationFee() + invoice.getSupplyFee()) %></td>
                    </tr>

                    <tr>
                        <td></td>
                        <td></td>
                        <td><strong>Discount</strong></td>
                        <td class="text-right">$<%= new DecimalFormat("0.00").format(invoice.getTotalDiscount()) %></td>
                    </tr>

                    <tr>
                        <td></td>
                        <td></td>
                        <td><strong>Grand Total</strong></td>
                        <td class="text-right">$<%= new DecimalFormat("0.00").format(invoice.getTuitionFee() + invoice.getAdministrationFee() + invoice.getSupplyFee() - invoice.getTotalDiscount()) %></td>
                    </tr>

                    </tbody>
                </table>
            </div>
            <!-- /.col -->
        </div>
        <!-- /.row -->

        <%--<div class="row">--%>
            <%--<!-- accepted payments column -->--%>
            <%--<div class="col-xs-6">--%>
                <%--<p class="lead">Payment Methods:</p>--%>
                <%--<img src="../../dist/img/credit/visa.png" alt="Visa">--%>
                <%--<img src="../../dist/img/credit/mastercard.png" alt="Mastercard">--%>
                <%--<img src="../../dist/img/credit/american-express.png" alt="American Express">--%>
                <%--<img src="../../dist/img/credit/paypal2.png" alt="Paypal">--%>

                <%--<p class="text-muted well well-sm no-shadow" style="margin-top: 10px;">--%>
                    <%--Etsy doostang zoodles disqus groupon greplin oooj voxy zoodles, weebly ning heekya handango imeem plugg--%>
                    <%--dopplr jibjab, movity jajah plickers sifteo edmodo ifttt zimbra.--%>
                <%--</p>--%>
            <%--</div>--%>
            <%--<!-- /.col -->--%>
            <%--<div class="col-xs-6">--%>
                <%--<p class="lead">Amount Due 2/22/2014</p>--%>

                <%--<div class="table-responsive">--%>
                    <%--<table class="table">--%>
                        <%--<tr>--%>
                            <%--<th style="width:50%">Subtotal:</th>--%>
                            <%--<td>$250.30</td>--%>
                        <%--</tr>--%>
                        <%--<tr>--%>
                            <%--<th>Tax (9.3%)</th>--%>
                            <%--<td>$10.34</td>--%>
                        <%--</tr>--%>
                        <%--<tr>--%>
                            <%--<th>Shipping:</th>--%>
                            <%--<td>$5.80</td>--%>
                        <%--</tr>--%>
                        <%--<tr>--%>
                            <%--<th>Total:</th>--%>
                            <%--<td>$265.24</td>--%>
                        <%--</tr>--%>
                    <%--</table>--%>
                <%--</div>--%>
            <%--</div>--%>
            <%--<!-- /.col -->--%>
        <%--</div>--%>
        <!-- /.row -->

        <!-- this row will not appear when printing -->
        <div class="row no-print">
            <div class="col-xs-8 col-xs-offset-2">
                <button type="button" class="btn btn-success pull-right" id="print-invoice"><i class="fa fa-print"></i> Print</button>
                <button type="button" class="btn btn-primary pull-right" style="margin-right: 5px;"><i class="fa fa-download"></i> PDF</button>
            </div>
        </div>
    </section>
    <!-- /.content -->
    <div class="clearfix"></div>
</div>
<!-- /.content-wrapper -->

<script>
    $(function() {
        $('#print-invoice').click(function() {
            window.print();
        });
    });
</script>