<%-- 
    Document   : footer
    Created on : 03/04/2018, 21:03:46
    Author     : Marcos
--%>

        <footer class="py-5 bg-dark">
            <div class="container">
                <p id="copyright" class="m-0 text-center text-white">Copyright %%ano%% Website</p>
            </div>
        </footer>

        <script src="assets/bootstrap/js/bootstrap.bundle.js" type="text/javascript"></script>
        <script src="assets/bootstrap/js/bootstrap.bundle.js.map" type="text/javascript"></script>
        <script src="assets/bootstrap/js/bootstrap.bundle.min.js" type="text/javascript"></script>
        <script src="assets/bootstrap/js/bootstrap.bundle.min.js.map" type="text/javascript"></script>
        <script src="assets/bootstrap/js/bootstrap.js" type="text/javascript"></script>
        <script src="assets/bootstrap/js/bootstrap.js.map" type="text/javascript"></script>
        <script src="assets/bootstrap/js/bootstrap.min.js" type="text/javascript"></script>
        <script src="assets/jquery/jquery.js" type="text/javascript"></script>
        <script src="assets/jquery/jquery.min.js" type="text/javascript"></script>
        <script src="assets/jquery/jquery.min.map" type="text/javascript"></script>
        <script src="assets/jquery/jquery.slim.js" type="text/javascript"></script>
        <script src="assets/jquery/jquery.slim.min.js" type="text/javascript"></script>
        <script src="assets/jquery/jquery.slim.min.map" type="text/javascript"></script>
        <script type="text/javascript">
            $(document).ready(function(){
                var date = new Date();
                var str = $("#copyright").text();
                $("#copyright").text(str.replaceWith("%%ano%%"), date.getFullYear());
            });
        </script>
    </body>
</html>
