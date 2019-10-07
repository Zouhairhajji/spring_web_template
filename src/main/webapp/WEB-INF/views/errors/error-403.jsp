<%-- 
    Document   : error-500
    Created on : 25 sept. 2019, 16:06:20
    Author     : zouhairhajji
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html lang="en">
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

        <meta charset="utf-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <title>Page not found </title>

        <link href="/resources/vendors/bootstrap/dist/css/bootstrap.min.css" rel="stylesheet">

        <link href="/resources/vendors/font-awesome/css/font-awesome.min.css" rel="stylesheet">

        <link href="/resources/vendors/nprogress/nprogress.css" rel="stylesheet">

        <link href="/resources/build/css/custom.min.css" rel="stylesheet">
    </head>
    <body class="nav-md">
        <div class="container body">
            <div class="main_container">

                <div class="col-md-12">
                    <div class="col-middle">
                        <div class="text-center">
                            <h1 class="error-number">403</h1>
                            <h2>Access denied</h2>
                            <p>Full authentication is required to access this resource.

                                <jsp:include page="/WEB-INF/views/template/contactus.jsp" >
                                    <jsp:param name="a_text" value="Report this?" />
                                </jsp:include>
                            </p>
                        </div>
                    </div>
                </div>

            </div>
        </div>

        <script src="/resources/vendors/jquery/dist/jquery.min.js" type="e6a6cd7e881c6532f2c587f7-text/javascript"></script>

        <script src="/resources/vendors/bootstrap/dist/js/bootstrap.min.js" type="e6a6cd7e881c6532f2c587f7-text/javascript"></script>

        <script src="/resources/vendors/fastclick/lib/fastclick.js" type="e6a6cd7e881c6532f2c587f7-text/javascript"></script>

        <script src="/resources/vendors/nprogress/nprogress.js" type="e6a6cd7e881c6532f2c587f7-text/javascript"></script>

        <script src="/resources/build/js/custom.min.js" type="e6a6cd7e881c6532f2c587f7-text/javascript"></script>

</html>