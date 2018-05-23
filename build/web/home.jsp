<%-- 
    Document   : teste
    Created on : 24/03/2018, 17:42:30
    Author     : onurb
--%>

<!-- Cabeçalho -->
<%@include file="head.jsp" %>
<c:if test="${(empty(user))}">
    <c:redirect url="index.jsp">
        <c:param name="msg" value="Faça login para acessar esta página!"></c:param>
    </c:redirect>
</c:if>
<link href="assets/css/feed-style.css" rel="stylesheet">

<div class="col-lg-3">
    <div class="list-group">
        <a class="list-group-item" href="UserServlet?action=SEARCH">Editar Perfil</a>
        <a class="list-group-item" href="escolhaAnuncio.jsp">Realizar um Anuncio</a>
        <a class="list-group-item" href="escolhaPendente.jsp">Aprovar Anuncio<br><small>(só vai aparecer para ADM)</small></a>
        <a class="list-group-item" href="mensagem.jsp">Prot&oacute;tipo Mensagem</a>
        <a class="list-group-item list-group-item-danger" href="LoginServlet?action=LOGOUT">Logout</a>
    </div>
</div>
<div class="col-lg-9">
    <!--div class="panel">
        <div class="panel-body">
            <textarea class="form-control" rows="2" placeholder="What are you thinking?"></textarea>
            <div class="mar-top clearfix">
                <button class="btn btn-sm btn-primary pull-right" type="submit"><i class="fa fa-pencil fa-fw"></i> Share</button>
                <a class="btn btn-trans btn-icon fa fa-video-camera add-tooltip" href="#" data-original-title="Add Video" data-toggle="tooltip"></a>
                <a class="btn btn-trans btn-icon fa fa-camera add-tooltip" href="#" data-original-title="Add Photo" data-toggle="tooltip"></a>
                <a class="btn btn-trans btn-icon fa fa-file add-tooltip" href="#" data-original-title="Add File" data-toggle="tooltip"></a>
            </div>
        </div>
    </div-->
    <div class="panel panel-body">
        <!-- Timeline -->
        <!--===================================================-->
        <div class="timeline">

            <!-- Timeline header -->
            <div class="timeline-header">
                <div class="timeline-header-title bg-success">Now</div>
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
                    <p>Lorem ipsum dolor sit amet, consectetuer adipiscing elit, sed diam nonummy nibh euismod tincidunt.</p>
                </div>
            </div>
        </div>
        <!--===================================================-->
        <!-- End Timeline -->
    </div>
</div> <!-- fim .col-lg-9 -->

<!-- Rodapé -->
<%@include file="footer.jsp" %>

