








<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix = "fmt" uri = "http://java.sun.com/jsp/jstl/fmt" %>
<%@ page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
    <head>



        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

        <meta charset="utf-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <title>Gentelella Alela! | </title>

        <link href="/resources/vendors/bootstrap/dist/css/bootstrap.min.css" rel="stylesheet">

        <link href="/resources/vendors/font-awesome/css/font-awesome.min.css" rel="stylesheet">




        <script src="https://cdn.jsdelivr.net/npm/jdenticon@2.2.0" async></script>


        <link href="/resources/vendors/datatables.net-bs/css/dataTables.bootstrap.min.css" rel="stylesheet">
        <link href="/resources/vendors/datatables.net-buttons-bs/css/buttons.bootstrap.min.css" rel="stylesheet">
        <link href="/resources/vendors/datatables.net-fixedheader-bs/css/fixedHeader.bootstrap.min.css" rel="stylesheet">
        <link href="/resources/vendors/datatables.net-responsive-bs/css/responsive.bootstrap.min.css" rel="stylesheet">
        <link href="/resources/vendors/datatables.net-scroller-bs/css/scroller.bootstrap.min.css" rel="stylesheet">

        <link href="/resources/vendors/nprogress/nprogress.css" rel="stylesheet">


        <link href="/resources/build/css/custom.min.css" rel="stylesheet">


        <style>
            .x_panel {
                width: 80%;
                padding: 10px 17px;

                height: 90%;  

                display: inline-block;
                margin-left: 10%;

                background: #fff;
                border: 1px solid #E6E9ED;
                -webkit-column-break-inside: avoid;
                -moz-column-break-inside: avoid;
                column-break-inside: avoid;
                opacity: 1;
                transition: all .2s ease;
            }


        </style>
    </head>
    <body >
        <div class="container body">
            <div class="main_container">
                <div class="right_col" role="main">


                    <div class="x_content">

                        <br />
                        <br />
                        <div class="x_panel center" style="" >
                            <div class="" role="tabpanel" data-example-id="togglable-tabs">



                                <div   class="tab-content">
                                    <div role="tabpanel" class="tab-pane fade active in" id="tab_login_form" aria-labelledby="home-tab">

                                        <form class="form-horizontal form-label-left" novalidate action="/login" method='POST'>
                                            <span class="section">Login form</span>

                                            <br />

                                            <c:if test="${not empty error}">
                                                <div class="alert alert-danger alert-dismissible">${error}</div>
                                            </c:if>
                                            <c:if test="${not empty msg}">
                                                <div class="alert alert-warning  alert-dismissible">${msg}</div>
                                            </c:if>

                                            <div class="item form-group">
                                                <label class="control-label col-md-3 col-sm-3 col-xs-12" for="name">Username<span class="required">*</span>
                                                </label>
                                                <div class="col-md-6 col-sm-6 col-xs-12">
                                                    <input type="email" autocomplete="off" class="form-control col-md-7 col-xs-12" data-validate-length-range="6" data-validate-words="2" name='username' placeholder="Username" required="required" >
                                                </div>
                                            </div>

                                            <div class="item form-group">
                                                <label for="password" class="control-label col-md-3">Password</label>
                                                <div class="col-md-6 col-sm-6 col-xs-12">
                                                    <input type="password" name="password" data-validate-length="3,20" class="form-control col-md-7 col-xs-12" name='password'  placeholder="Password" required="required">
                                                </div>
                                            </div>

                                            <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}" />


                                            <br />
                                            <br />
                                            <br />

                                            <div class="row">
                                                <div class="col-xs-6">
                                                    <button type="submit" class="btn btn-default btn-block btn-flat"> Login </button>
                                                </div>
                                                <div class="col-xs-6">
                                                    <a href="#tab_register_form" class="btn btn-block btn-primary" role="tab"  data-toggle="tab" aria-expanded="false">New to the site, create an account !</a>
                                                </div>
                                            </div>



                                        </form>


                                    </div>








                                    <div role="tabpanel" class="tab-pane fade" id="tab_register_form" aria-labelledby="profile-tab">

                                        <span class="section">Register form</span>

                                        <br />

                                        <form class="form-horizontal form-label-left" novalidate action="/register" method='POST'>


                                            <div class="item form-group">
                                                <label class="control-label col-md-3 col-sm-3 col-xs-12" for="email">Email <span class="required">*</span> </label>
                                                <div class="col-md-6 col-sm-6 col-xs-12">
                                                    <input type="email" id="email" name="email" required="required" class="form-control col-md-7 col-xs-12">
                                                </div>
                                            </div>

                                            <div class="item form-group">
                                                <label class="control-label col-md-3 col-sm-3 col-xs-12" for="number">Number phone <span class="required">*</span>
                                                </label>
                                                <div class="col-md-6 col-sm-6 col-xs-12">
                                                    <input type="number" id="number" name="number" required="required" data-validate-minmax="10,100" class="form-control col-md-7 col-xs-12">
                                                </div>
                                            </div>

                                            <div class="item form-group">
                                                <label for="password" class="control-label col-md-3">Password <span class="required">*</span></label>
                                                <div class="col-md-6 col-sm-6 col-xs-12">
                                                    <input id="password" type="password" name="password" data-validate-length="6,8" class="form-control col-md-7 col-xs-12" required="required">
                                                </div>
                                            </div>


                                            <div class="item form-group">
                                                <label for="password2" class="control-label col-md-3 col-sm-3 col-xs-12">Repeat Password <span class="required">*</span></label>
                                                <div class="col-md-6 col-sm-6 col-xs-12">
                                                    <input id="password2" type="password" name="password2" data-validate-linked="password" class="form-control col-md-7 col-xs-12" required="required">
                                                </div>
                                            </div>


                                            <div class="row">
                                                <div class="col-xs-6">
                                                    <button type="submit" class="btn btn-default btn-block btn-flat"> register </button>
                                                </div>
                                                <div class="col-xs-6">
                                                    <a href="#tab_login_form" class="btn btn-block btn-primary" role="tab"  data-toggle="tab" aria-expanded="false">Go back to the previous page</a>
                                                </div>
                                            </div>

                                        </form>


                                    </div>
                                </div>
                            </div>




                        </div>

                    </div>

                </div>
            </div>
        </div>

        <script src="/resources/vendors/jquery/dist/jquery.min.js" ></script>

        <script src="/resources/vendors/bootstrap/dist/js/bootstrap.min.js" ></script>

        <script src="/resources/vendors/fastclick/lib/fastclick.js" ></script>

        <script src="/resources/vendors/nprogress/nprogress.js" ></script>

        <script src="/resources/vendors/validator/validator.js"  ></script>

        <script src="/resources/build/js/custom.min.js" ></script>
    </body>
</html>
