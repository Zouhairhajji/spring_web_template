
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix = "fmt" uri = "http://java.sun.com/jsp/jstl/fmt" %>

<%@ page session = "true" %>

<!DOCTYPE html>
<html lang="en">
    <head>
        <%@include file="/WEB-INF/views/template/header.jsp" %>
    </head>
    <body class="nav-md">
        <div class="container body">
            <div class="main_container">

                <%@include file="/WEB-INF/views/template/left_menu.jsp" %>

                <%@include file="/WEB-INF/views/template/navbar.jsp" %>





                <div class="right_col" role="main">

                    <!-- Button trigger modal -->





                    <div class="x_content">


                        <div class="x_panel">

                            <div class="row x_title">
                                <div class="col-md-6">
                                    <h3>List of users </h3>
                                </div>
                                <div class="col-md-6 ">
                                    <a href="/users/create_user" class="btn btn-primary pull-right"> <i class="glyphicon glyphicon-calendar fa fa-plus"></i> </a>
                                </div>
                            </div>

                            <table id="datatable" class="table table-striped table-bordered ">
                                <thead>
                                    <tr>
                                        <th>Username</th>
                                        <th>Full Name</th>
                                        <th>Email</th>
                                        <th>Entity</th>
                                        <th>Roles</th>
                                        <th>Actions</th>
                                    </tr>
                                </thead>
                                <tbody>

                                    <c:forEach items="${users}" var="user">
                                        <tr>
                                            <td> ${user.username} </td>
                                            <td>${user.firstName}, ${user.lastName}</td>
                                            <td> ${user.email} </td>
                                            <td> ${user.entity} </td>
                                            <td style="width: 100px"> 
                                                <c:forEach items="${user.roles}" var="role">
                                                    ${role.label},   
                                                </c:forEach>
                                            </td>
                                            <td>
                                                <button data-toggle="modal" data-target="#modal_details_users" class="btn btn-primary btn-xs "><i class="fa fa-folder"></i> View </button>
                                                <a href="#" class="btn btn-info btn-xs"><i class="fa fa-pencil"></i> Edit </a>
                                                <a href="#" class="btn btn-danger btn-xs"><i class="fa fa-trash-o"></i> Delete </a>
                                            </td>
                                        </tr>
                                    </c:forEach>
                                </tbody>
                            </table>
                        </div>


                        <!-- Modal -->
                        <div class="modal fade" id="modal_details_users" tabindex="-1" role="dialog" aria-labelledby="modal_details_users_label" aria-hidden="true">
                            <div class="modal-dialog" role="document">
                                <div class="modal-content">
                                    <div class="modal-header">
                                        <h5 class="modal-title" >User details</h5>
                                    </div>
                                    <div class="modal-body">

                                        <form id="demo-form2" data-parsley-validate class="form-horizontal form-label-left">
                                            <div class="form-group">
                                                <label class="control-label col-md-3 col-sm-3 col-xs-12" for="first-name">First Name <span class="required">*</span>
                                                </label>
                                                <div class="col-md-6 col-sm-6 col-xs-12">
                                                    <input type="text" id="first-name" readonly="readonly" class="form-control col-md-7 col-xs-12">
                                                </div>
                                            </div>
                                            <div class="form-group">
                                                <label class="control-label col-md-3 col-sm-3 col-xs-12" for="last-name">Last Name <span class="required">*</span>
                                                </label>
                                                <div class="col-md-6 col-sm-6 col-xs-12">
                                                    <input type="text" id="last-name" name="last-name" readonly="readonly" class="form-control col-md-7 col-xs-12">
                                                </div>
                                            </div>
                                            <div class="form-group">
                                                <label for="middle-name" class="control-label col-md-3 col-sm-3 col-xs-12">Middle Name / Initial</label>
                                                <div class="col-md-6 col-sm-6 col-xs-12">
                                                    <input id="middle-name" class="form-control col-md-7 col-xs-12" type="text" name="middle-name">
                                                </div>
                                            </div>
                                        </form>

                                    </div>
                                </div>
                            </div>
                        </div>


                    </div>
                </div>


                <%@include file="/WEB-INF/views/template/footer.jsp" %>

            </div>
        </div>






        <%@include file="/WEB-INF/views/template/custom_js.jsp" %>
        <script>

            function init_datatable(id_str = 'datatable', search_index = []) {
                var table = $('#' + id_str)

                var add_footer = function () {
                    var tfoot = '<tfoot>' + table.find('thead').html() + '</tfoot>'
                    table.append(tfoot)
                }

                add_footer()
                
                table.dataTable({
                    dom: "Bfrtip",
                    keys:!0,
                    buttons: [
                        {extend: "copy", className: "btn-sm"},
                        {extend: "csv", className: "btn-sm"},
                        {extend: "print", className: "btn-sm"}
                    ],
                    initComplete: function () {
                        var count_length = this.api().columns()['0'].length


                        this.api().columns().every(function (e) {
                            var column = this;

                            if (!search_index.includes(e)) {
                                $('<a></a>').appendTo($(column.footer()).empty())
                                return
                            } else {
                                var default_value = '<select ><option value=""></option></select>'
                                var select = $(default_value)
                                        .appendTo($(column.footer()).empty())
                                        .on('change', function () {
                                            var val = $.fn.dataTable.util.escapeRegex($(this).val());

                                            column.search(val ? '^' + val + '$' : '', true, false).draw();
                                        });

                                column.data().unique().sort().each(function (d, j) {
                                    select.append('<option value="' + d + '">' + d + '</option>')
                                });
                                console.info(select)
                            }
                        })

                    }
                })



            }

            init_datatable("datatable", [, 3, 4])

        </script>
    </body>
</html>
