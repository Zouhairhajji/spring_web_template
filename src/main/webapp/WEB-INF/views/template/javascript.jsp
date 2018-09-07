<%-- 
    Document   : javascript
    Created on : 6 sept. 2018, 17:01:46
    Author     : fqlh0717
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!-- jQuery 3 -->
<script src="<c:url value="/resources/bower_components/jquery/dist/jquery.min.js"/>"></script>
<!-- Bootstrap 3.3.7 -->
<script src="<c:url value="/resources/bower_components/bootstrap/dist/js/bootstrap.min.js"/>"></script>
<!-- SlimScroll -->
<script src="<c:url value="/resources/bower_components/jquery-slimscroll/jquery.slimscroll.min.js"/>"></script>
<!-- FastClick -->
<script src="<c:url value="/resources/bower_components/fastclick/lib/fastclick.js"/>"></script>
<!-- AdminLTE App -->
<script src="<c:url value="/resources/dist/js/adminlte.min.js"/>"></script>
<!-- AdminLTE for demo purposes -->
<script src="<c:url value="/resources/dist/js/demo.js"/> "></script>
<script  src="<c:url value="/webjars/sockjs-client/1.0.2/sockjs.min.js" />"></script>
<script  src="<c:url value="/webjars/stomp-websocket/2.3.3/stomp.min.js" />" ></script>
<script>
    var stompClient = null;
    var socket = new SockJS('/ws');
    stompClient = Stomp.over(socket);
    stompClient.debug = () => {
    };
    stompClient.connect({}, onConnected, onError);


    function onError() {

    }



    function onConnected() {
    }
    
    // Subscribe to the Public Topic
    //stompClient.subscribe('/topic/public', function (message) {
    //    console.info(message)
    //});
    // Tell your username to the server
    //var param = {sender: 'username', type: 'JOIN'}
    //stompClient.send("/queue.sendMessage", {}, JSON.stringify(param))
</script>
