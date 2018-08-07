/* 
 * Requisições AJAX e recursos JS das mensagens
 */
$(document).ready(function(){
    buscarMensagens();
    
    $('#comentarioAjax').submit(function (event) {
        //Cacela comportamento padrão do formulário de recarregar a página
        event.preventDefault();

        //Pega os dados do formulário
        var dados = $(this).serialize();

        //Configura, faz e trata o retorno da requisão
        $.ajax({
            url: 'ComentarioServlet',
            data: dados,
            method: 'POST',
            dataType: 'html',
            success: function (resp) {
                buscarMensagens();
                console.log(resp);
                $('#respostaAjax ul li').append(resp);
            },
            error: function (resp) {
                console.log(resp);
                $('#respostaAjax').html('Erro na requisição. Verifique o console do navegador!');
            }
        });
        //Limpa os campos do formulário
        this.reset();
    });
    
    $('.like').on('click', function(){avaliarComentario('LIKE_COMENTARIO', this);});
    
    $('.unlike').on('click', function(){avaliarComentario('UNLIKE_COMENTARIO', this);});
    
    $('.reply').click(function(){
       $('input[name=ID_REPLY]').val($(this).data('comentario').val()); 
       $('#DS_MSG').attr('placeholder', 'Digite aqui sua resposta...');
       $('#DS_MSG').focus();
    });
    
});

function buscarMensagens() {
    var dados = {
        action: 'LIST',
        anuncio: $('input[name=ID_ANUNCIO]').val()
    };
    
    $.ajax({
        url: 'ComentarioServlet',
        data: dados,
        method: 'POST',
        dataType: 'html',
        success: function (resp) {
            $('#respostaAjax ul li').html(resp);
        },
        error: function (resp) {
            console.log(resp);
            $('#respostaAjax').html('Erro na requisição. Verifique o console do navegador!');
        }
    });
}

function avaliarComentario(avaliacao, elemento) {
    var dados = {
        action: avaliacao,
        comentario: $(elemento).data('comentario')
    };
    console.log(dados);
    $.ajax({
        url: 'ComentarioServlet',
        data: dados,
        method: 'POST',
        dataType: 'html',
        success: function(resp) {
            buscarMensagens();
        },
        error: function(resp) {
            console.log(resp);
        }
    });
}

function replyComentario(comentario){
    var idReply = $(comentario).data('comentario');
    $('input[name=ID_REPLY]').val(idReply); 
    $('#DS_MSG').attr('placeholder', 'Digite aqui sua resposta...');
    $(window).scrollTop($('#DS_MSG'));
    $('#DS_MSG').focus();
}