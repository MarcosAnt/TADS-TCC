<%-- 
    Document   : footer
    Created on : 03/04/2018, 21:03:46
    Author     : Marcos
--%>

            </div> <!-- ./row -->
        </div> <!-- ./container -->
  
        <footer class="py-5 bg-dark">
            <div class="container">
                <p id="copyright" class="m-0 text-center text-white">Copyright &COPY; [[ano]] Website</p>
            </div>
        </footer>

        <!-- Importando: 1-jQuery 2-Bootstrap -->
        <script src="assets/jquery/jquery.min.js" type="text/javascript"></script>
        <script src="assets/bootstrap/js/bootstrap.bundle.js" type="text/javascript"></script>
        
        <script type="text/javascript">
            $(document).ready(function(){ 
                var date = new Date();
                var element = $('#copyright');
                var str = element.html();
                element.html( str.replace('[[ano]]', date.getFullYear()) );
            });
        </script>
    </body>
</html>
