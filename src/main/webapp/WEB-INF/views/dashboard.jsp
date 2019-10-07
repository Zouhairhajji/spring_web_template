
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
                    <div class="">
                        <div class="page-title">
                            <div class="title_left">
                                <h3>Plain Pagffe</h3>
                                il y a ${fn:length(  session.getAttributeNames() )}
                                
                                <%= session.getAttribute("FULL_NAME") %>
                                <c:forEach items="${session.getAttributeNames()}" var="name">
                                    - ${nafme}
                                </c:forEach>
                                
                                
                            </div>
                        </div>
                        
                        <div class="clearfix"></div>
                        
                        <div class="row">
                            
                        </div>
                    </div>
                </div>


                <%@include file="/WEB-INF/views/template/footer.jsp" %>

            </div>
        </div>

        <script src="/resources/vendors/jquery/dist/jquery.min.js" ></script>

        <script src="/resources/vendors/bootstrap/dist/js/bootstrap.min.js" ></script>

        <script src="/resources/vendors/fastclick/lib/fastclick.js" ></script>

        <script src="/resources/vendors/nprogress/nprogress.js" ></script>

        <script src="/resources/build/js/custom.min.js" ></script>
    </body>
</html>
