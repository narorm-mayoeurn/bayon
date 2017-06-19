<%@ page import="org.bayon.ogm.datastore.query.Page" %>
<%@ page import="com.camhub.antiochschool.domain.Invoice" %>
<%@ page import="java.text.DecimalFormat" %>
<%@ page import="com.camhub.antiochschool.service.StudentFacade" %>
<%@ page import="java.text.SimpleDateFormat" %>
<!-- Content Wrapper. Contains page content -->
<div class="content-wrapper">
    <!-- Content Header (Page header) -->
    <section class="content-header">
        <h1>
            Payroll Information
            <small>List of all payrolls in the school</small>
        </h1>
        <ol class="breadcrumb">
            <li><a href="/"><i class="fa fa-dashboard"></i> Home</a></li>
            <li class="active">Payrolls</li>
        </ol>
    </section>

    <!-- Main content -->
    <section class="content">
        <!-- /.row -->
        <div class="row">
            <div class="col-xs-12">
                <div class="box">
                    <div class="box-header">
                        <h3 class="box-title">Payroll List</h3>

                        <div class="box-tools">
                            <div class="input-group input-group-sm" style="width: 150px;">
                                <input type="text" name="table_search" class="form-control pull-right"
                                       placeholder="Search">

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
                                <th>Invoice No</th>
                                <th>Invoice Date</th>
                                <th>End Date</th>
                                <th>Student Name</th>

                                <th>Tuition Fee</th>
                                <th>Administration Fee</th>
                                <th>Suppy Fee</th>
                                <th>Discount</th>
                                <th>Total</th>
                                <th></th>
                            </tr>

                            <%
                                Page<Invoice> p = (Page<Invoice>)request.getAttribute("payrolls");
                                for (Invoice invoice : p.getItems()) {
                            %>
                            <tr>
                                <td><%= invoice.getInvoiceNo() %></td>
                                <td><%= new SimpleDateFormat("MM/dd/yyyy").format(invoice.getInvoiceDate()) %></td>
                                <td><%= invoice.getEndDate() == null ? "" : new SimpleDateFormat("MM/dd/yyyy").format(invoice.getEndDate()) %></td>
                                <td><%= StudentFacade.getInstance().getNameById(invoice.getStudentId()) %></td>
                                <td class="text-right"><%= new DecimalFormat("0.00").format(invoice.getTuitionFee()) %></td>
                                <td class="text-right"><%= new DecimalFormat("0.00").format(invoice.getAdministrationFee()) %></td>
                                <td class="text-right"><%= new DecimalFormat("0.00").format(invoice.getSupplyFee()) %></td>
                                <td class="text-right"><%= new DecimalFormat("0.00").format(invoice.getTotalDiscount()) %></td>
                                <td class="text-right"><%= new DecimalFormat("0.00").format(invoice.getTuitionFee() + invoice.getAdministrationFee() + invoice.getSupplyFee() - invoice.getTotalDiscount()) %></td>
                                <td>

                                    <%--<a href="/invoice/update?id=<%=invoice.getId()%>"><i class="fa fa-fw fa-edit"></i></a>--%>
                                        <a href="/invoice/print?id=<%= invoice.getId() %>"><i class="fa fa-fw fa-print"></i></a>
                                    <a href="#" id="<%=invoice.getId()%>" data-toggle="modal" data-target="#delete-modal"><i class="fa fa-fw fa-remove"></i></a>
                                </td>
                            </tr>
                            <%
                                }
                            %>

                            <!--<tr>
                                <td>183</td>
                                <td>John Doe</td>
                                <td>11-7-2014</td>
                                <td><span class="label label-success">Approved</span></td>
                                <td>Bacon ipsum dolor sit amet salami venison chicken flank fatback doner.</td>
                            </tr>
                            <tr>
                                <td>219</td>
                                <td>Alexander Pierce</td>
                                <td>11-7-2014</td>
                                <td><span class="label label-warning">Pending</span></td>
                                <td>Bacon ipsum dolor sit amet salami venison chicken flank fatback doner.</td>
                            </tr>
                            <tr>
                                <td>657</td>
                                <td>Bob Doe</td>
                                <td>11-7-2014</td>
                                <td><span class="label label-primary">Approved</span></td>
                                <td>Bacon ipsum dolor sit amet salami venison chicken flank fatback doner.</td>
                            </tr>
                            <tr>
                                <td>175</td>
                                <td>Mike Doe</td>
                                <td>11-7-2014</td>
                                <td><span class="label label-danger">Denied</span></td>
                                <td>Bacon ipsum dolor sit amet salami venison chicken flank fatback doner.</td>
                            </tr>-->
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

    <!-- Button trigger modal -->
    <%--<button type="button" class="btn btn-primary btn-lg" data-toggle="modal" data-target="#delete-modal">--%>
    <%--Launch demo modal--%>
    <%--</button>--%>
    <!-- Modal -->
    <div class="modal fade" id="delete-modal" tabindex="-1" role="dialog" aria-labelledby="Delete Teacher" aria-hidden="true">
        <div class="modal-dialog">
            <div class="modal-content">
                <div class="modal-header">
                    <h4 class="modal-title" id="myModalLabel">Confirm Delete</h4>
                </div>
                <div class="modal-body">
                    <b>Are you sure you want to delete this invoice?</b>
                </div>
                <div class="modal-footer">
                    <button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
                    <button type="button" class="btn btn-primary" data-dismiss="modal" id="delete">Delete</button>
                </div>
            </div>
        </div>
    </div>
</div>

<script>

    var _id = null;

    // prepare all forms for ajax submission
    $('a i.fa-remove').click(function(){
        _id = $(this).parent().attr('id');
    });

    $('#delete').on('click', function() {
        $.ajax({
            method: "POST",
            url: "/invoice/delete",
            data: { id: _id }
        }).done(function( msg ) {
            window.location.reload();
        });
    });

</script>