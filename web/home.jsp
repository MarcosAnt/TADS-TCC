<%-- 
    Document   : teste
    Created on : 24/03/2018, 17:42:30
    Author     : onurb
--%>

<!-- Cabe�alho -->
<%@include file="head.jsp" %>
<c:if test="${(empty(user))}">
    <c:redirect url="index.jsp">
        <c:param name="msg" value="Fa�a login para acessar esta p�gina!"></c:param>
    </c:redirect>
</c:if>
<link href="assets/css/feed-style.css" rel="stylesheet">

<div class="col-3">
    <div class="menu-fixed-left">
        <div class="center">
            <img class="d-block img-fluid rounded-circle" src="https://lh4.googleusercontent.com/-MeKIl588D-U/AAAAAAAAAAI/AAAAAAAAP-g/t7W08EZcRuQ/s96-c/photo.jpg" alt="Third slide">
            <h4><strong style="color: gray"><c:out value="${user.getNome()}"/></strong></h4>
        </div>
        <div class="list-group">
            <a class="list-group-item" href="UserServlet?action=SEARCH">Editar Perfil</a>
            <a class="list-group-item" href="escolhaAnuncio.jsp">Realizar um Anuncio</a>
            <a class="list-group-item" href="escolhaPendente.jsp">Aprovar Anuncio<br><small>(s� vai aparecer para ADM)</small></a>
            <a class="list-group-item" href="comentario.jsp">Prot&oacute;tipo Mensagem</a>
            <a class="list-group-item list-group-item-danger" href="LoginServlet?action=LOGOUT">Logout</a>
        </div>
    </div>
</div>
<div class="col-6 menu-fixed-center">
    <div class="panel panel-body">
        <!-- Timeline -->
        <!--===================================================-->
        <div class="timeline">

            <!-- Timeline header -->
            <div class="timeline-header">
                <div class="timeline-header-title bg-dark">Now</div>
            </div>

            <div class="timeline-entry">
                <div class="timeline-stat">
                    <div class="timeline-icon"><img src="https://bootdey.com/img/Content/avatar/avatar1.png" alt="Profile picture">
                    </div>
                    <div class="timeline-time">30 Min ago</div>
                </div>
                <div class="timeline-label">
                    <p class="mar-no pad-btm"><a href="#" class="btn-link text-semibold">Maria J.</a> shared an image</p>
                    <div class="img-holder">
                        <img src="https://bootdey.com/img/Content/avatar/avatar1.png" alt="Image">
                    </div>
                </div>
            </div>
            <div class="timeline-entry">
                <div class="timeline-stat">
                    <div class="timeline-icon bg-danger"><i class="fa fa-building fa-lg"></i>
                    </div>
                    <div class="timeline-time">2 Hours ago</div>
                </div>
                <div class="timeline-label">
                    <h4 class="mar-no pad-btm"><a href="#" class="text-danger">Job Meeting</a></h4>
                    <p>Lorem ipsum dolor sit amet, consectetuer adipiscing elit, sed diam nonummy nibh euismod tincidunt.</p>
                </div>
            </div>
            <div class="timeline-entry">
                <div class="timeline-stat">
                    <div class="timeline-icon"><img src="https://bootdey.com/img/Content/avatar/avatar6.png" alt="Profile picture">
                    </div>
                    <div class="timeline-time">3 Hours ago</div>
                </div>
                <div class="timeline-label">
                    <p class="mar-no pad-btm"><a href="#" class="btn-link text-semibold">Lisa D.</a> commented on <a href="#">The Article</a>
                    </p>
                    <blockquote class="bq-sm bq-open">Lorem ipsum dolor sit amet, consectetuer adipiscing elit, sed diam nonummy nibh euismod tincidunt.</blockquote>
                </div>
            </div>
            <div class="timeline-entry">
                <div class="timeline-stat">
                    <div class="timeline-icon bg-purple"><i class="fa fa-check fa-lg"></i>
                    </div>
                    <div class="timeline-time">5 Hours ago</div>
                </div>
                <div class="timeline-label">
                    <img class="img-xs img-circle" src="https://bootdey.com/img/Content/avatar/avatar2.png" alt="Profile picture">
                    <a href="#" class="btn-link text-semibold">Bobby Marz</a> followed you.
                </div>
            </div>

            <!-- Timeline header -->
            <div class="timeline-header">
                <div class="timeline-header-title bg-dark">Yesterday</div>
            </div>

            <div class="timeline-entry">
                <div class="timeline-stat">
                    <div class="timeline-icon bg-info"><i class="fa fa-envelope fa-lg"></i>
                    </div>
                    <div class="timeline-time">15:45</div>
                </div>
                <div class="timeline-label">
                    <h4 class="text-info mar-no pad-btm">Lorem ipsum dolor sit amet</h4>
                    <p>Lorem ipsum dolor sit amet, consectetuer adipiscing elit, sed diam nonummy nibh euismod tincidunt.</p>
                </div>
            </div>
            <div class="timeline-entry">
                <div class="timeline-stat">
                    <div class="timeline-icon bg-success"><i class="fa fa-thumbs-up fa-lg"></i>
                    </div>
                    <div class="timeline-time">13:27</div>
                </div>
                <div class="timeline-label">
                    <img class="img-xs img-circle" src="https://bootdey.com/img/Content/avatar/avatar3.png" alt="Profile picture">
                    <a href="#" class="btn-link text-semibold">Michael Both</a> Like <a href="#">The Article</a>
                </div>
            </div>
            <div class="timeline-entry">
                <div class="timeline-stat">
                    <div class="timeline-icon"></div>
                    <div class="timeline-time">11:27</div>
                </div>
                <div class="timeline-label">
                    <<p>Lorem ipsum dolor sit amet, consectetuer adipiscing elit, sed diam nonummy nibh euismod tincidunt.</p>
                </div>
            </div>
        </div>
        <!--===================================================-->
        <!-- End Timeline -->
    </div>
</div> <!-- fim .col-lg-6 -->
<div class="col-3 panel panel-primary menu-fixed-right">
    <div class="panel-heading">
        <h4>Atualiza&ccedil;&otilde;es de Amigos</h4>
    </div>
    <div class="panel-body">
        <div class="well well-sm">
            <p>aqui fica amigo1.</p>
        </div>
        <div class="well well-sm">
            <p>aqui fica amigo2.</p>
        </div>
        <div class="well well-sm">
            <p>aqui fica amigo1.</p>
        </div>
    </div>
</div>

<!-- Rodap� -->
<%-- 
    Document   : footer
    Created on : 03/04/2018, 21:03:46
    Author     : Marcos
--%>

</div> <!-- ./row -->
</div> <!-- ./container -->

<!--footer class="py-5 bg-dark">
    <div class="container">
        <p id="copyright" class="m-0 text-center text-white">Copyright &COPY; [[ano]] Mercad&atilde;o do Aluno - SEPT - UFPR</p>
    </div>
</footer-->

<!-- Importando: 1-Bootstrap -->
<script src="assets/bootstrap/js/bootstrap.bundle.js" type="text/javascript"></script>
<script src="assets/js/comentario.js" type="text/javascript" charset="UTF-8"></script>

<script type="text/javascript">
    $(document).ready(function () {
        setCopyright();
    });
</script>
</body>
</html>


